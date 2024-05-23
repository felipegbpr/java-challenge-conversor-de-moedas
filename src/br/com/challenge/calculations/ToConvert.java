package br.com.challenge.calculations;

import java.util.Map;

public class ToConvert {

    private Map<String, Double> exchangeRates;

    public ToConvert(Map<String, Double> exchangeRates) {
        this.exchangeRates = exchangeRates;
    }

    public double convertCurrency(double amount, String fromCurrency, String toCurrency) {

        double fromRate = exchangeRates.getOrDefault(fromCurrency, 1.0);
        double toRate = exchangeRates.getOrDefault(toCurrency, 1.0);

        // Executa o cálculo de conversão
        return amount * (toRate / fromRate);
    }
}
