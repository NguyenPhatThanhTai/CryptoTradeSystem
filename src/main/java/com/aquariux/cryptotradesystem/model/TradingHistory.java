package com.aquariux.cryptotradesystem.model;

import com.aquariux.cryptotradesystem.util.TradeType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TradingHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private String symbol; // BTCUSDT or ETHUSDT

    @Enumerated(EnumType.STRING)
    private TradeType type; // BUY or SELL

    private double price;     // executed price
    private double quantity;  // amount of crypto traded

    private LocalDateTime time;
}
