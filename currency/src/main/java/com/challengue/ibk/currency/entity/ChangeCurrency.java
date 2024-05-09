package com.challengue.ibk.currency.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Setter
public class ChangeCurrency {

    @Id
    private Long id;

    private BigDecimal amount;

    private BigDecimal changeAmount;

    private String currencyOrigin;

    private String fateCurrency;

    private BigDecimal exchangeRateM;

}
