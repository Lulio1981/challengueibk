package com.challengue.ibk.currency.repository;

import com.challengue.ibk.currency.entity.ChangeCurrency;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;


public interface ChallengueRepository extends ReactiveCrudRepository<ChangeCurrency, Long> {

}
