package com.challengue.ibk.currency.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ExchangeResponse {

    private String result;

    private String documentation;

    private String terms_of_use;

    private String time_last_update_unix;

    private String time_last_update_utc;

    private String time_next_update_unix;

    private String time_next_update_utc;

    private String base_code;

    private String target_code;

    private ConversionRate conversion_rates;


}
