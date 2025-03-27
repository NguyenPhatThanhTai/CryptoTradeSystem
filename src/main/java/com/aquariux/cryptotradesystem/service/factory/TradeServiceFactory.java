package com.aquariux.cryptotradesystem.service.factory;

import com.aquariux.cryptotradesystem.service.TradeService;
import com.aquariux.cryptotradesystem.service.impl.BitcoinTradeService;
import com.aquariux.cryptotradesystem.service.impl.EthereumTradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TradeServiceFactory {
    private final BitcoinTradeService bitcoinTradeService;
    private final EthereumTradeService ethereumTradeService;

    public TradeService getService(String symbol) {
        if (symbol == null) throw new IllegalArgumentException("Symbol cannot be null");

        return switch (symbol.toUpperCase()) {
            case "BTCUSDT" -> bitcoinTradeService;
            case "ETHUSDT" -> ethereumTradeService;
            default -> throw new IllegalArgumentException("Unsupported symbol: " + symbol);
        };
    }
}
