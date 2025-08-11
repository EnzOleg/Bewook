package com.example.beewook.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Map;

@Service
public class AiService {

    private final WebClient webClient;

    public AiService(@Value("${openai.api.key}") String apiKey) {
        this.webClient = WebClient.builder()
                .baseUrl("https://api.openai.com/v1")
                .defaultHeader("Authorization", "Bearer " + apiKey)
                .defaultHeader("Content-Type", "application/json")
                .build();
    }

    public String generateMagicalResponse(String prompt) {
        List<Map<String, String>> messages = List.of(
                Map.of("role", "system", "content",
                        "Ты — древний мудрый маг, говорящий с метафорами, загадками и волшебным стилем. Преобразуй любые сообщения в мистическую речь."),
                Map.of("role", "user", "content", prompt)
        );

        Map<String, Object> requestBody = Map.of(
                "model", "gpt-4", // Можно заменить на "gpt-3.5-turbo"
                "messages", messages
        );

        try {
            Map response = webClient.post()
                    .uri("/chat/completions")
                    .bodyValue(requestBody)
                    .retrieve()
                    .bodyToMono(Map.class)
                    .block();

            List choices = (List) response.get("choices");
            Map firstChoice = (Map) choices.get(0);
            Map message = (Map) firstChoice.get("message");

            return (String) message.get("content");

        } catch (Exception e) {
            e.printStackTrace();
            return "⚠️ Магия дала сбой: " + e.getMessage();
        }
    }
}
