package com.challengue.ibk.currency.controller;


import com.challengue.ibk.currency.entity.ChangeCurrency;
import com.challengue.ibk.currency.service.ChallengueService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("currency")
@RequiredArgsConstructor
public class ChallengueController {

    private final ChallengueService challengueService;

    @GetMapping("/{base_code}/{target_code}/{amount}")
    public Mono<ChangeCurrency> searchChange(@PathVariable String base_code,
                                                   @PathVariable String target_code,
                                                   @PathVariable String amount){
        return  challengueService.searchChange(base_code.toUpperCase(),target_code.toUpperCase(),amount);
    }

    @GetMapping("/all")
    public Flux<ChangeCurrency> listChangeCurrency(){
        return  challengueService.listChangeCurrency();
    }

}
