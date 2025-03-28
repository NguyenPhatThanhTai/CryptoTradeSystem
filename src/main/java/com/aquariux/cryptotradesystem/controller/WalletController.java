package com.aquariux.cryptotradesystem.controller;

import com.aquariux.cryptotradesystem.dto.ApiResponse;
import com.aquariux.cryptotradesystem.model.Wallet;
import com.aquariux.cryptotradesystem.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/wallet")
@RequiredArgsConstructor
public class WalletController {
    private final WalletService walletService;

    @GetMapping("/{userId}")
    public ResponseEntity<?> getWallet(@PathVariable Long userId) {
        return walletService.getWallet(userId)
                .map(wallet -> ResponseEntity.ok(
                        ApiResponse.success(wallet)))
                .orElseGet(() -> ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body(ApiResponse.error(404, "Wallet not found for userId: " + userId)));
    }
}
