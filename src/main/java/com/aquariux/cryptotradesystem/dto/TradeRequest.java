package com.aquariux.cryptotradesystem.dto;

import com.aquariux.cryptotradesystem.util.TradeType;
import lombok.Data;

@Data
public class TradeRequest {
    private Long userId;
    private String symbol;
    private TradeType type;
    private double quantity;
}
