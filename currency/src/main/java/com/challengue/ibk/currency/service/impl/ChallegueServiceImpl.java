package com.challengue.ibk.currency.service.impl;

import com.challengue.ibk.currency.caller.ExchangeCaller;
import com.challengue.ibk.currency.entity.ChangeCurrency;
import com.challengue.ibk.currency.repository.ChallengueRepository;
import com.challengue.ibk.currency.service.ChallengueService;
import com.challengue.ibk.currency.util.handler.exceptions.BadRequestException;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static com.challengue.ibk.currency.util.JsonUtils.convertJsonStringToJsonNode;
import static com.challengue.ibk.currency.util.JsonUtils.convertObjectToJsonString;

@Service
@AllArgsConstructor
public class ChallegueServiceImpl implements ChallengueService {

    private final ChallengueRepository challengueRepository;

    private final ExchangeCaller exchangeCaller;


    @Override
    public Mono<ChangeCurrency> searchChange(String base_code, String target_code, String amount) {
        return exchangeCaller.searchChange(base_code)
                .flatMap(exr-> {
                    String exchangeRate = null;
                    try {
                        exchangeRate = convertJsonStringToJsonNode(convertObjectToJsonString(exr.getConversion_rates())).get(target_code).asText();
                    } catch (Exception e) {
                        throw new BadRequestException(
                                "ERROR",
                                "Ha ocurrido un error al obtener moneda destino",
                                "Moneda no soportada",
                                getClass(),
                                "searchChange.onErrorResume"
                        );
                    }
                    ChangeCurrency changeCurrency = ChangeCurrency.builder().amount(new BigDecimal(amount))
                            .change_amount(new BigDecimal(amount)
                                    .multiply(new BigDecimal(exchangeRate)))
                            .currency_origin(base_code)
                            .fate_currency(target_code)
                            .exchange_rate(new BigDecimal(exchangeRate))
                            .rate_date(exr.getTime_last_update_utc())
                            .process_date(LocalDateTime.now())
                            .build();
                    return challengueRepository.save(changeCurrency);
                })
                .doOnError(alm -> Mono.error(new BadRequestException(
                        "ERROR",
                        "Ha ocurrido un error al guardar el save",
                        alm.getMessage(),
                        getClass(),
                        "saveChangeCurrency.onErrorResume"
                ))).cast(ChangeCurrency.class);
    }

    @Override
    public Flux<ChangeCurrency> listChangeCurrency() {
        return challengueRepository.findAll()
                .doOnError(alm -> Flux.error(new BadRequestException(
                        "ERROR",
                        "Ha ocurrido un error al consultar los tipos de cambio",
                        alm.getMessage(),
                        getClass(),
                        "listChangeCurrency.onErrorResume"
                ))).cast(ChangeCurrency.class);
    }
}
