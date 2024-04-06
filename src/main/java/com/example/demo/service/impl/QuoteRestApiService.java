package com.example.demo.service.impl;

import com.example.demo.model.QuoteDto;
import com.example.demo.service.IQuoteService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Implements the quites interface by using external REST API
 *
 * @author Vasil
 * @date 2024/04/06
 */
@Service
public class QuoteRestApiService implements IQuoteService {

    private final OkHttpClient client = new OkHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();

    String url = "https://api.api-ninjas.com/v1/quotes";
    String apiKey = "iXOT4oDYMKsnkmGfZNJWBQ==dOyAepD5rCesLQpc";

    private static final Logger log = LoggerFactory.getLogger(QuoteRestApiService.class);

    public String getQuote() {
        log.debug("Will load quote.");
        String quote = "No quotes today, sorry :(";

        Request request = new Request.Builder().url(url).addHeader("X-Api-Key", apiKey).build();

        try (Response response = client.newCall(request).execute()) {
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            if (response.isSuccessful()) {
                ResponseBody responseBody = response.body();
                if(responseBody != null) {
                    QuoteDto[] quoteDto = objectMapper.readValue(responseBody.string(), QuoteDto[].class);
                    quote = quoteDto[0].quote();
                }
            } else {
                log.error("Error: {} {}", response.code(), response.message());
            }
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        log.debug("Loaded quote: {}", quote);
        return quote;
    }
}
