package com.aquariux.cryptotradesystem.dto;

import lombok.Data;

@Data
public class BinancePriceResponse {
    private String symbol;
    private String bidPrice;
    private String askPrice;
}

