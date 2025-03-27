package com.aquariux.cryptotradesystem.controller;

import com.aquariux.cryptotradesystem.dto.ApiResponse;
import com.aquariux.cryptotradesystem.model.Price;
import com.aquariux.cryptotradesystem.service.PriceAggregatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/prices")
@RequiredArgsConstructor
public class PriceController {
    private final PriceAggregatorService priceAggregatorService;

    @GetMapping("/{symbol}")
    public ResponseEntity<?> getLatestPrice(@PathVariable String symbol) {
        Optional<Price> price = priceAggregatorService.getLatestPrice(symbol.toUpperCase());

        return price.map(p ->
                        ResponseEntity.ok(ApiResponse.success(p)))
                .orElseGet(() ->
                        ResponseEntity.status(HttpStatus.NOT_FOUND)
                                .body(ApiResponse.error(404, "No price data for symbol: " + symbol)));
    }
}
