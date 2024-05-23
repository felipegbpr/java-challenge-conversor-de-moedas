package br.com.challenge.model;


import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ApiConnectionModel {

    private static final String API_KEY = "bedeacb50f0fb2d29220b6d2"; // Sua chave da API
    private static final String API_BASE_URL = "https://v6.exchangerate-api.com/v6/";

    public static JsonObject getExchangeRates(String coreCurrency) throws IOException {

        String apiUrl = API_BASE_URL + API_KEY + "/latest/" + coreCurrency;
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        // Verifica se o código de resposta foi bem-sucedido (200)
        if (connection.getResponseCode() == 200) {
            // Realiza da leitura do corpo da resposta
            Scanner scanner = new Scanner(connection.getInputStream());
            StringBuilder responseBody = new StringBuilder();

            while (scanner.hasNextLine()) {
                responseBody.append(scanner.nextLine());
            }

            scanner.close();
            connection.disconnect();

            // Converte a string de resposta em um JsonObject
            JsonParser parser = new JsonParser();
            return parser.parse(responseBody.toString()).getAsJsonObject();
        } else {
            throw new IOException("[Error]: Failed to fetch exchange rates. Response code: " + connection.getResponseCode());
        }
    }
}
