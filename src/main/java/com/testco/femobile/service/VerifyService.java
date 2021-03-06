package com.testco.femobile.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URI;
import java.net.URISyntaxException;

@Service
public class VerifyService {

    final static Logger LOGGER = LoggerFactory.getLogger(VerifyService.class);

    private final WebClient webclient;

    @Value("${api.backend.verify}")
    String backEndLink;

    public VerifyService(WebClient webclient) {
        this.webclient = webclient;
    }

    public void verify() {
        LOGGER.info("Verifying access.");
        URI uri;
        try {
            uri = new URI(backEndLink);
        } catch (URISyntaxException e) {
            throw new VerificationException("Unable to create URI. {}", e);
        }

        try {
            webclient
                    .get()
                    .uri(uri)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
        } catch (Exception e) {
            LOGGER.error("Verification failed.");
            throw new VerificationException("Error occurred calling back-end URI.", e);
        }
    }
}
