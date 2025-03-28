package com.aquariux.cryptotradesystem.repository;

import com.aquariux.cryptotradesystem.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PriceRepository extends JpaRepository<Price, Long> {
    Optional<Price> findTopBySymbolOrderByUpdatedAtDesc(String symbol);
}
