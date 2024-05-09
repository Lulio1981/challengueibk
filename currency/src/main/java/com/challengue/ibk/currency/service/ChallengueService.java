package com.challengue.ibk.currency.service;

import com.challengue.ibk.currency.entity.ChangeCurrency;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ChallengueService {

    public Mono<ChangeCurrency> saveChangeCurrency(ChangeCurrency changeCurrency);

    public Flux<ChangeCurrency> listChangeCurrency();
}
