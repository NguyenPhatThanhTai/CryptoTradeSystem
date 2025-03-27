package com.aquariux.cryptotradesystem.service;

import com.aquariux.cryptotradesystem.model.Price;
import com.aquariux.cryptotradesystem.repository.PriceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PriceAggregatorService {

    private final List<CryptoPriceService> priceServices;
    private final PriceRepository priceRepository;

    private static final List<String> SUPPORTED_SYMBOLS = List.of("BTCUSDT", "ETHUSDT");

    @Scheduled(fixedRate = 10000)
    public void aggregatePrices() {
        for (String symbol : SUPPORTED_SYMBOLS) {
            Price bestPrice = null;

            for (CryptoPriceService service : priceServices) {
                Optional<Price> optionalPrice = service.fetchPrice(symbol);
                if (optionalPrice.isPresent()) {
                    Price price = optionalPrice.get();
                    if (bestPrice == null
                            || price.getBidPrice() > bestPrice.getBidPrice()
                            || price.getAskPrice() < bestPrice.getAskPrice()) {
                        bestPrice = price;
                    }
                }
            }

            if (bestPrice != null) {
                priceRepository.save(bestPrice);
                log.info("Best price for {} saved: {}", symbol, bestPrice);
            }
        }
    }

    public Optional<Price> getLatestPrice(String symbol) {
        return priceRepository.findTopBySymbolOrderByUpdatedAtDesc(symbol);
    }
}
