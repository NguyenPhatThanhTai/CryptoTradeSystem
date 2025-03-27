package com.aquariux.cryptotradesystem.service.impl;

import com.aquariux.cryptotradesystem.client.BinanceClient;
import com.aquariux.cryptotradesystem.dto.BinancePriceResponse;
import com.aquariux.cryptotradesystem.model.Price;
import com.aquariux.cryptotradesystem.service.CryptoPriceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class BinancePriceServiceImpl implements CryptoPriceService {

    private final BinanceClient binanceClient;

    @Override
    public Optional<Price> fetchPrice(String symbol) {
        try {
            List<BinancePriceResponse> prices = binanceClient.getAllBookTickers();
            return prices.stream()
                    .filter(p -> p.getSymbol().equalsIgnoreCase(symbol))
                    .findFirst()
                    .map(p -> Price.builder()
                            .symbol(symbol)
                            .bidPrice(Double.parseDouble(p.getBidPrice()))
                            .askPrice(Double.parseDouble(p.getAskPrice()))
                            .updatedAt(LocalDateTime.now())
                            .build());
        } catch (Exception e) {
            log.error("Binance fetch error", e);
            return Optional.empty();
        }
    }
}
