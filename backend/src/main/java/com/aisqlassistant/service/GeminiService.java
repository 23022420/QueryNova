package com.aisqlassistant.service;

import com.aisqlassistant.dto.gemini.GeminiRequest;
import com.aisqlassistant.dto.gemini.GeminiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GeminiService {

    private final WebClient webClient;

    @Value("${ai.api-key}")
    private String apiKey;

    @Value("${ai.model}")
    private String model;

    public String askGemini(String prompt) {

        GeminiRequest.Part part =
                new GeminiRequest.Part(prompt);

        GeminiRequest.Content content =
                new GeminiRequest.Content(List.of(part));

        GeminiRequest request =
                new GeminiRequest(List.of(content));

        GeminiResponse response = webClient.post()
                .uri("https://generativelanguage.googleapis.com/v1beta/models/"
                        + model
                        + ":generateContent?key="
                        + apiKey)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(request)
                .retrieve()
                .bodyToMono(GeminiResponse.class)
                .block();

        if (response == null
                || response.getCandidates() == null
                || response.getCandidates().isEmpty()) {

            return "No response from Gemini.";

        }

        return response.getCandidates()
                .get(0)
                .getContent()
                .getParts()
                .get(0)
                .getText();

    }

}