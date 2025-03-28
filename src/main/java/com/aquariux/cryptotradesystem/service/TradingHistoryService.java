package com.aquariux.cryptotradesystem.service;

import com.aquariux.cryptotradesystem.model.TradingHistory;

import java.util.List;

public interface TradingHistoryService {
    List<TradingHistory> getUserTrades(Long userId);
}
