package com.aquariux.cryptotradesystem.repository;

import com.aquariux.cryptotradesystem.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet, Long> {
}
