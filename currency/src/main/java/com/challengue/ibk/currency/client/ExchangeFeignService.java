package com.challengue.ibk.currency.client;

import com.challengue.ibk.currency.configuration.FeignConfiguration;
import com.challengue.ibk.currency.entity.ExchangeResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "exchange-ibk", url = "${feign.endpoint.url}"
,configuration = FeignConfiguration.class)
public interface ExchangeFeignService {

    @GetMapping("{base_code}")
    ExchangeResponse searchChange(@PathVariable String base_code);

}
