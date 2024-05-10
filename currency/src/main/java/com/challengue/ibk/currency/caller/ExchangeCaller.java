package com.challengue.ibk.currency.caller;

import com.challengue.ibk.currency.client.ExchangeFeignService;
import com.challengue.ibk.currency.entity.ExchangeResponse;
import com.challengue.ibk.currency.util.handler.exceptions.BadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class ExchangeCaller {

    private final ExchangeFeignService exchangeFeignService;

    public Mono<ExchangeResponse> searchChange(String base_code) {
        ExchangeResponse exchangeResponse = exchangeFeignService.searchChange(base_code);
        return Mono.just(exchangeResponse)
                .doOnError(alm -> Mono.error(new BadRequestException(
                "ERROR",
                "Ha ocurrido un error al buscar searchChange",
                alm.getMessage(),
                getClass(),
                "searchChange.onErrorResume"
        ))).cast(ExchangeResponse.class);

    }

}
