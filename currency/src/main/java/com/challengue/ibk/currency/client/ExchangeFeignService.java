package com.challengue.ibk.currency.client;

import com.challengue.ibk.currency.entity.ChangeCurrency;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import reactor.core.publisher.Mono;

@FeignClient(name = "exchange-ibk", url = "https://v6.exchangerate-api.com")
public interface ExchangeFeignService {

    @GetMapping("/v6/01909f8373ef7b743f6e396d/enriched/{base_code}/{target_code}")
    Mono<ChangeCurrency> searchChange(@PathVariable String base_code, @PathVariable String target_code);

}
