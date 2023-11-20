package com.currencyExchange.demo.service;

import com.currencyExchange.demo.entities.CurrencyExchange;

import java.math.BigDecimal;
import java.util.List;

public interface CurrencyExchangeService {
    CurrencyExchange getExchangeRate(String fromCurrency, String toCurrency);

    CurrencyExchange getExchangeRateWithQuantity(String fromCurrency, String toCurrency, BigDecimal quantity);

    List<CurrencyExchange> getAllConversions();
}
