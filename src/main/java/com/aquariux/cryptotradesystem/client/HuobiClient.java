package com.aquariux.cryptotradesystem.client;

import com.aquariux.cryptotradesystem.dto.HuobiPriceResponses;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "huobiClient", url = "https://api.huobi.pro")
public interface HuobiClient {

    @GetMapping("/market/tickers")
    HuobiPriceResponses getAllTickers();
}
