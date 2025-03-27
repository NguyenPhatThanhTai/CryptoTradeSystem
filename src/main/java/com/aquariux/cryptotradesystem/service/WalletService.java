package com.aquariux.cryptotradesystem.service;

public interface WalletService {
    boolean updateBalance(Long userId, double usdtChange, String symbol, double cryptoChange);
}
