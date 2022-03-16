package com.pauloapp.apificar.abc.services;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service("serviceRestTemplate")
public class ApificarServiceImpl implements ApificarService {

    private final RestTemplate clienteRest;

    public ApificarServiceImpl(RestTemplate clienteRest) {
        this.clienteRest = clienteRest;
    }

    @Override
    public String findByStr(String text) {

        if (text == null || text.isBlank()) {
            throw new RuntimeException("Error - The server dit not respond OK");
        }

        Map<String, String> pathVariables = new HashMap<>();
        pathVariables.put("text", text);
        String url = "https://www.abc.com.py/buscar/".concat(text);

        try {
            var response = clienteRest.getForEntity(url, String.class, pathVariables);
            if (response.getStatusCode() == HttpStatus.OK) {
                return response.getBody();
            }
        } catch (HttpClientErrorException httpex) {
            return "Response code is not similar to 200. The server has responded: " + httpex.getStatusCode() + " - " + httpex.getResponseBodyAsString();
        } catch (RestClientException restex) {
            return "The server has not responded: " + restex.getMessage();
        }

        return null;
    }
}
