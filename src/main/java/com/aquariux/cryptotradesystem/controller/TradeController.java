package com.aquariux.cryptotradesystem.controller;

import com.aquariux.cryptotradesystem.dto.ApiResponse;
import com.aquariux.cryptotradesystem.dto.TradeRequest;
import com.aquariux.cryptotradesystem.service.TradeService;
import com.aquariux.cryptotradesystem.service.factory.TradeServiceFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/trade")
@RequiredArgsConstructor
public class TradeController {
    private final TradeServiceFactory tradeServiceFactory;

    @PostMapping
    public ResponseEntity<ApiResponse<?>> trade(@RequestBody TradeRequest request) {
        ApiResponse<?> response = tradeServiceFactory
                .getService(request.getSymbol())
                .executeTrade(request);
        return ResponseEntity.status(response.getStatus()).body(response);
    }
}
