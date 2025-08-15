package com.example.beewook.graphql;

import com.example.beewook.service.AiService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class AiGraphQLController {

    private final AiService aiService;

    public AiGraphQLController(AiService aiService) {
        this.aiService = aiService;
    }

    @QueryMapping
    public String askAiMagically(@Argument String prompt, @Argument String race) {
        return aiService.generateMagicalResponse(prompt, race);
    }
}
