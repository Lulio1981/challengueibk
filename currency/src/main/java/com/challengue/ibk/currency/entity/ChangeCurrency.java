package com.challengue.ibk.currency.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "change_currency")
public class ChangeCurrency {

    @Id
    private Long id;

    private BigDecimal amount;

    private BigDecimal change_amount;

    private String currency_origin;

    private String fate_currency;

    private BigDecimal exchange_rate;

    private String rate_date;

    private LocalDateTime process_date;

}
