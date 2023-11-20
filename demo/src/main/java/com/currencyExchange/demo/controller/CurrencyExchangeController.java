package com.currencyExchange.demo.controller;

import com.currencyExchange.demo.entities.CurrencyExchange;
import com.currencyExchange.demo.service.CurrencyExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/exchange")
public class CurrencyExchangeController {
    @Autowired
    private CurrencyExchangeService exchangeService;

    @GetMapping("/{fromCurrency}/{toCurrency}")
    public CurrencyExchange getExchangeRate(@PathVariable String fromCurrency,
                                            @PathVariable String toCurrency) {
        return exchangeService.getExchangeRate(fromCurrency, toCurrency);
      }

    @GetMapping("/{fromCurrency}/{toCurrency}/{quantity}")
    public CurrencyExchange getExchangeRateWithQuantity(
            @PathVariable String fromCurrency,
            @PathVariable String toCurrency,
            @PathVariable BigDecimal quantity) {
        // Implement logic to handle quantity in your service
        return exchangeService.getExchangeRateWithQuantity(fromCurrency, toCurrency, quantity);

        // enter the url http://localhost:8081/api/exchange/USD/INR to get the data but before you can control h2 console
        //with localhost:8081/h2-console and connect the database

    }

    @GetMapping("/all")
    public List<CurrencyExchange> getAllConversions() {
        return exchangeService.getAllConversions();
    }
}