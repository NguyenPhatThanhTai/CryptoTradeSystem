package com.aquariux.cryptotradesystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Wallet {
    @Id
    private Long userId;

    private double usdtBalance;

    private double btcBalance;

    private double ethBalance;
}
