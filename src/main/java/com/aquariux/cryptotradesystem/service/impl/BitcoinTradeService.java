package com.aquariux.cryptotradesystem.service.impl;

import com.aquariux.cryptotradesystem.dto.ApiResponse;
import com.aquariux.cryptotradesystem.dto.TradeRequest;
import com.aquariux.cryptotradesystem.model.Price;
import com.aquariux.cryptotradesystem.service.PriceAggregatorService;
import com.aquariux.cryptotradesystem.service.TradeService;
import com.aquariux.cryptotradesystem.service.TradingHistoryService;
import com.aquariux.cryptotradesystem.service.WalletService;
import com.aquariux.cryptotradesystem.util.TradeType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BitcoinTradeService implements TradeService {

    private final WalletService walletService;
    private final PriceAggregatorService priceAggregatorService;

    @Override
    public ApiResponse<?> executeTrade(TradeRequest request) {
        return processTrade(request, "BTCUSDT");
    }

    private ApiResponse<?> processTrade(TradeRequest request, String symbol) {
        Optional<Price> priceOpt = priceAggregatorService.getLatestPrice(symbol);
        if (priceOpt.isEmpty()) {
            return ApiResponse.error(400, "No available price for " + symbol);
        }

        Price latestPrice = priceOpt.get();
        double tradePrice = request.getType() == TradeType.BUY
                ? latestPrice.getAskPrice()
                : latestPrice.getBidPrice();

        double totalUsdt = tradePrice * request.getQuantity();
        double usdtChange = request.getType() == TradeType.BUY ? -totalUsdt : totalUsdt;
        double cryptoChange = request.getType() == TradeType.BUY ? request.getQuantity() : -request.getQuantity();

        boolean updated = walletService.updateBalance(request.getUserId(), usdtChange, symbol, cryptoChange);
        if (!updated) {
            return ApiResponse.error(400, "Insufficient balance");
        }

        return ApiResponse.success("Trade executed successfully for " + symbol);
    }
}
