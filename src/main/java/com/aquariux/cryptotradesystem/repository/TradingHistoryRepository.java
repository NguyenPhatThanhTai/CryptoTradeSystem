package com.aquariux.cryptotradesystem.repository;

import com.aquariux.cryptotradesystem.model.TradingHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TradingHistoryRepository extends JpaRepository<TradingHistory, Long> {
    List<TradingHistory> findByUserIdOrderByTimeDesc(Long userId);
}
