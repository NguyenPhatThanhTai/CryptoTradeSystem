package com.aquariux.cryptotradesystem.dto;

import lombok.Data;

import java.util.List;

@Data
public class HuobiPriceResponse {
    private String symbol;
    private double bid;
    private double ask;
}
