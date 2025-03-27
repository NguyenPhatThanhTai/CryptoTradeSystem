package com.aquariux.cryptotradesystem.service;

import com.aquariux.cryptotradesystem.dto.ApiResponse;
import com.aquariux.cryptotradesystem.dto.TradeRequest;

public interface TradeService {
    ApiResponse<?> executeTrade(TradeRequest request);
}
