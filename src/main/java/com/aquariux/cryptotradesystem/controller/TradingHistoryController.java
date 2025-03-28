package com.aquariux.cryptotradesystem.controller;

import com.aquariux.cryptotradesystem.dto.ApiResponse;
import com.aquariux.cryptotradesystem.model.TradingHistory;
import com.aquariux.cryptotradesystem.service.TradingHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/trade/history")
@RequiredArgsConstructor
public class TradingHistoryController {
    private final TradingHistoryService tradingHistoryService;

    @GetMapping("/{userId}")
    public ResponseEntity<ApiResponse<?>> getUserTrades(@PathVariable Long userId) {
        List<TradingHistory> history = tradingHistoryService.getUserTrades(userId);
        return ResponseEntity.ok(ApiResponse.success(history));
    }
}
