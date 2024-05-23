package br.com.challenge.model;

import com.google.gson.JsonObject;

public class ConverterModel {

    private JsonObject exchangeRates;

    public ConverterModel(JsonObject exchangeRates) {
        this.exchangeRates = exchangeRates;
    }

    public String convertCurrency(String originCurrency, String currencyDestiny, double amount) {

        originCurrency = originCurrency.toUpperCase();
        currencyDestiny = currencyDestiny.toUpperCase();

        if (exchangeRates.has(originCurrency) && exchangeRates.has(currencyDestiny)) {
            double rateOriginToDestination = exchangeRates.get(currencyDestiny).getAsDouble();
            double rateDestinationToOrigin = exchangeRates.get(originCurrency).getAsDouble();
            double amountConverted = (amount * rateOriginToDestination) / rateDestinationToOrigin;
            return String.format("%.2f", amountConverted);
        } else {
            return "Currency not recognized in exchange rates.";
        }

    }
}
