package com.in28minutes.microservices.currencyexchangeservice.Repository;

import com.in28minutes.microservices.currencyexchangeservice.Entity.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {
    CurrencyExchange findByFromAndTo(String to, String from);
}
