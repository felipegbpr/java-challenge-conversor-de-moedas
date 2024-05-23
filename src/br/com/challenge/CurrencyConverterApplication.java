package br.com.challenge;



import br.com.challenge.model.ApiConnectionModel;
import br.com.challenge.model.ConverterModel;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.util.Scanner;
import java.util.Set;

public class CurrencyConverterApplication {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            boolean toContinue = true;

            while(toContinue) {

                System.out.println("Insira a moeda base desejada (exemplo: USD):");
                String coreCurrency = scanner.nextLine();
                coreCurrency = coreCurrency.toUpperCase();

                JsonObject ratesObject = ApiConnectionModel.getExchangeRates(coreCurrency); // Chama um método para obter as taxas de câmbio
                JsonObject conversionRates = ratesObject.getAsJsonObject("conversion_rates"); // Extrai o objeto conversion_rates

                // Imprime as moedas disponíveis
                System.out.println("Moedas Disponíveis:");
                Set<String> currencies = conversionRates.keySet();
                int count = 0;
                for (String currency : currencies) {
                    System.out.printf("%-10s", currency);
                    count++;
                    if (count % 10 == 0) {
                        System.out.println();
                    }
                }
                System.out.println("\n");

                System.out.println("Insira a segunda moeda (exemplo: BRL):");
                String secondCurrency = scanner.nextLine();
                secondCurrency = secondCurrency.toUpperCase();
                System.out.println("Insira a quantidade de " + coreCurrency + " que deseja converter para " + secondCurrency + ":");
                double amountToConvert = scanner.nextDouble();
                scanner.nextLine(); // Consome o caractere de nova linha no buffer

                ConverterModel converter = new ConverterModel(conversionRates); // Cria uma instância do conversor

                String convertedAmount = converter.convertCurrency(coreCurrency, secondCurrency, amountToConvert);
                System.out.println(coreCurrency + " para " + secondCurrency + " = " + convertedAmount);

                System.out.println("Deseja realizar outra conversão? (s/n) ");
                String keepConversion = scanner.nextLine();

                if (!keepConversion.equalsIgnoreCase("s")) {
                    toContinue = false;
                }
            }
        } catch(IOException e) {
            System.err.println("[Error]: Não foi possível obter as taxas de câmbio." + e.getMessage());
        } finally {
            scanner.close();
        }


    }
}

