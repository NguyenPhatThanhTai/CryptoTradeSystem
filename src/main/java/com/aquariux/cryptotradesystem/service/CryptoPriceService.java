package com.aquariux.cryptotradesystem.service;

import com.aquariux.cryptotradesystem.model.Price;

import java.util.Optional;

public interface CryptoPriceService {
    Optional<Price> fetchPrice(String symbol);
}
