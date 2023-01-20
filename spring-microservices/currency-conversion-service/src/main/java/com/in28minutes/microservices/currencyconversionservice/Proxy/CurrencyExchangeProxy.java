package com.in28minutes.microservices.currencyconversionservice.Proxy;

import com.in28minutes.microservices.currencyconversionservice.Entity.CurrencyConversion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// Create a Proxy so the calls to the CurrencyExchange Service are easier
// We need to annotate @EnableFeignClients on the main class for this to work
// It needs to have the same name as the CurrencyExchange service defined on properties

// Now we have Eureka server, so we delete the URL and the Eureka Server will do the load balancing for us
// @FeignClient(name = "currency-exchange", url = "localhost:8000")
@FeignClient(name = "currency-exchange")
public interface CurrencyExchangeProxy {

    // Because CurrencyExchange and CurrencyConversion structure matches it passes the values automatically
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyConversion getExchangeValue(@PathVariable String from, @PathVariable String to);

}
