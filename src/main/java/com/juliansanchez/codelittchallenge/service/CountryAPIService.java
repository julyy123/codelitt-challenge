package com.juliansanchez.codelittchallenge.service;


import com.fasterxml.jackson.databind.JsonNode;
import com.juliansanchez.codelittchallenge.exception.CurrencyNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CountryAPIService {
    private static final String CURRENCY_FILTER = "?fields=currencies";
    private final RestTemplate countryApiRestTemplate;
    private final String baseUrl;

    public CountryAPIService(final RestTemplate countryApiRestTemplate, @Value("${api.country-url}") final String baseUrl) {
        this.countryApiRestTemplate = countryApiRestTemplate;
        this.baseUrl = baseUrl;
    }

    public String getCountryCurrency(final String countryName) {
        try {
            final JsonNode jsonNode = countryApiRestTemplate
                    .getForObject(baseUrl + countryName + CURRENCY_FILTER, JsonNode.class)
                    .get(0);

            return jsonNode
                    .get("currencies")
                    .fieldNames()
                    .next();
        } catch (final Exception e) {
            throw new CurrencyNotFoundException();
        }
    }
}
