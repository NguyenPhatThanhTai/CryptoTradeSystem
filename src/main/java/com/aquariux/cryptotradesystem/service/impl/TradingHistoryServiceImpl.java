package com.aquariux.cryptotradesystem.service.impl;

import com.aquariux.cryptotradesystem.model.TradingHistory;
import com.aquariux.cryptotradesystem.repository.TradingHistoryRepository;
import com.aquariux.cryptotradesystem.service.TradingHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TradingHistoryServiceImpl implements TradingHistoryService {
    private final TradingHistoryRepository tradingHistoryRepository;

    @Override
    public List<TradingHistory> getUserTrades(Long userId) {
        return tradingHistoryRepository.findByUserIdOrderByTimeDesc(userId);
    }
}
