package com.challengue.ibk.currency.service;

import com.challengue.ibk.currency.entity.ChangeCurrency;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

public interface ChallengueService {

    Mono<ChangeCurrency> searchChange(String base_code, String target_code, String amount);

    Flux<ChangeCurrency> listChangeCurrency();
}
