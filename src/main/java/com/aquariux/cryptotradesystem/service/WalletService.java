package com.aquariux.cryptotradesystem.service;

import com.aquariux.cryptotradesystem.model.Wallet;

import java.util.Optional;

public interface WalletService {
    boolean updateBalance(Long userId, double usdtChange, String symbol, double cryptoChange);
    Optional<Wallet> getWallet(Long userId);
}
