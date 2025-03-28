package com.aquariux.cryptotradesystem.service.impl;

import com.aquariux.cryptotradesystem.client.HuobiClient;
import com.aquariux.cryptotradesystem.dto.HuobiPriceResponses;
import com.aquariux.cryptotradesystem.model.Price;
import com.aquariux.cryptotradesystem.service.CryptoPriceService;
import com.aquariux.cryptotradesystem.util.Constraint;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class HuobiPriceServiceImpl implements CryptoPriceService {

    private final HuobiClient huobiClient;

    @Override
    public Optional<Price> fetchPrice(String symbol) {
        try {
            HuobiPriceResponses wrapper = huobiClient.getAllTickers();
            return wrapper.getData().stream()
                    .filter(p -> (Constraint.BTCUSDT.equalsIgnoreCase(symbol) && Constraint.BTCUSDT.equalsIgnoreCase( p.getSymbol()))
                            || (Constraint.ETHUSDT.equalsIgnoreCase(symbol) && Constraint.ETHUSDT.equalsIgnoreCase(p.getSymbol())))
                    .findFirst()
                    .map(p -> Price.builder()
                            .symbol(symbol)
                            .bidPrice(p.getBid())
                            .askPrice(p.getAsk())
                            .updatedAt(LocalDateTime.now())
                            .build());
        } catch (Exception e) {
            log.error("Huobi fetch error", e);
            return Optional.empty();
        }
    }
}
