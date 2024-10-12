package logic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.http.HttpResponse;

public class CurrencyConvert {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private static HttpResponse<String> response;

    public String currencyConver(Integer option, Double money) {
        switch (option) {
            case 1:
                return currencyConver("ARS", "USD", money);
            case 2:
                return currencyConver("USD", "ARS", money);
            case 3:
                return currencyConver("EUR", "ARS", money);
            case 4:
                return currencyConver("ARS", "EUR", money);
            case 5:
                return currencyConver("COP", "ARS", money);
            case 6:
                return currencyConver("ARS", "COP", money);
            case 7:
                return currencyConver("ARS", "MXN", money);
            case 8:
                return currencyConver("MXN", "ARS", money);
            case 9:
                return currencyConver("BRL", "ARS", money);
            case 10:
                return currencyConver("ARS", "BRL", money);
            default:
                return "Error with character entered";
        }
    }

    public String currencyConver(String currency1, String currency2, Double money) {

        if (money == null || money <= 0) {
            return "Error: The amount of money must be greater than 0.";
        }

        Connection.changeUrl("/latest/" + currency1);
        String jsonResponse = Connection.responseBody();

        if (jsonResponse == null || jsonResponse.isEmpty()) {
            return "Error: Could not get response from server";
        }

        try {
            DAOCurrency exchangeRateResponse = OBJECT_MAPPER.readValue(jsonResponse, DAOCurrency.class);

            // Verificar si conversion_rates es null
            if (exchangeRateResponse.conversion_rates() == null) {
                System.out.println("The field conversion_rates is null.");
                return "Error: conversion_rates is not mapping.";
            }

            Double conversionRate = exchangeRateResponse.conversion_rates().get(currency2);
            System.out.println("Conversion Rate for " + currency2 + ": " + conversionRate);

            if (conversionRate != null) {
                double convertedAmount = money * conversionRate;
                return String.format("Total Conversion: %.2f %s", convertedAmount, currency2);
            } else {
                return "Conversion rate was not found for:  " + currency2;
            }
        } catch (JsonMappingException e) {
            e.printStackTrace();
            return "Error mapping JSON.";
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "Error process JSON.";
        }
    }
}
