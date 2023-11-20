package com.currencyExchange.demo.service.impl;

import com.currencyExchange.demo.entities.CurrencyExchange;
import com.currencyExchange.demo.repositories.CurrencyExchangeRepository;
import com.currencyExchange.demo.service.CurrencyExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CurrencyExchangeServiceImpl implements CurrencyExchangeService {

    @Autowired
    private CurrencyExchangeRepository exchangeRepository;

    @Override
    public CurrencyExchange getExchangeRate(String fromCurrency, String toCurrency) {
        return exchangeRepository.findByFromCurrencyAndToCurrency(fromCurrency, toCurrency);
    }

    @Override
    public CurrencyExchange getExchangeRateWithQuantity(String fromCurrency, String toCurrency, BigDecimal quantity) {
        CurrencyExchange currencyExchange = exchangeRepository.findByFromCurrencyAndToCurrency(fromCurrency, toCurrency);

        if (currencyExchange != null) {
            // Update the exchange rate based on quantity
            BigDecimal updatedExchangeRate = currencyExchange.getExchangeRate().multiply(quantity);
            currencyExchange.setExchangeRate(updatedExchangeRate);

            // Set the quantity in the response
            currencyExchange.setQuantity(quantity);
        }

        return currencyExchange;
    }

    @Override
    public List<CurrencyExchange> getAllConversions() {
        // Retrieve all conversions from the repository
        return exchangeRepository.findAll();
    }


}
