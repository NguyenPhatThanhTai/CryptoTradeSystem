package com.aquariux.cryptotradesystem.service.impl;

import com.aquariux.cryptotradesystem.model.Wallet;
import com.aquariux.cryptotradesystem.repository.WalletRepository;
import com.aquariux.cryptotradesystem.service.WalletService;
import com.aquariux.cryptotradesystem.util.Constraint;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WalletServiceImpl implements WalletService {
    private final WalletRepository walletRepository;

    @Override
    public boolean updateBalance(Long userId, double usdtChange, String symbol, double cryptoChange) {
        Wallet wallet = walletRepository.findById(userId).orElse(null);
        if (wallet == null) return false;

        double newUsdt = wallet.getUsdtBalance() + usdtChange;
        double newCrypto;

        if (Constraint.BTCUSDT.equalsIgnoreCase(symbol)) {
            newCrypto = wallet.getBtcBalance() + cryptoChange;
            if (newUsdt < 0 || newCrypto < 0) return false;
            wallet.setUsdtBalance(newUsdt);
            wallet.setBtcBalance(newCrypto);
        } else if (Constraint.ETHUSDT.equalsIgnoreCase(symbol)) {
            newCrypto = wallet.getEthBalance() + cryptoChange;
            if (newUsdt < 0 || newCrypto < 0) return false;
            wallet.setUsdtBalance(newUsdt);
            wallet.setEthBalance(newCrypto);
        } else {
            return false;
        }

        walletRepository.save(wallet);
        return true;
    }

    @Override
    public Optional<Wallet> getWallet(Long userId) {
        Wallet wallet = walletRepository.findById(userId).orElse(null);
        return Optional.ofNullable(wallet);
    }
}
