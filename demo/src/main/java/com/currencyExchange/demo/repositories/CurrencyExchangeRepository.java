package com.currencyExchange.demo.repositories;

import com.currencyExchange.demo.entities.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange,Long> {
    CurrencyExchange findByFromCurrencyAndToCurrency(String fromCurrency, String toCurrency);

    CurrencyExchange findByFromCurrencyAndToCurrencyAndQuantity(String fromCurrency, String toCurrency, BigDecimal quantity);

}
