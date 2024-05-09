package com.challengue.ibk.currency.repository;

import com.challengue.ibk.currency.entity.ChangeCurrency;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface ChallengueRepository extends R2dbcRepository<ChangeCurrency, Long> {

}
