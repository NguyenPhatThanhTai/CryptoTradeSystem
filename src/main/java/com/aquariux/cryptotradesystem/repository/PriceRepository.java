package com.aquariux.cryptotradesystem.repository;

import com.aquariux.cryptotradesystem.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository extends JpaRepository<Price, Long> {
}
