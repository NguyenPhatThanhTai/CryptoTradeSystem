package com.aquariux.cryptotradesystem.dto;

import lombok.Data;

import java.util.List;

@Data
public class HuobiPriceResponses {
    private List<HuobiPriceResponse> data;
}
