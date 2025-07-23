package com.example.beewook.graphql;

import com.example.beewook.dto.StartupDTO;
import com.example.beewook.service.StartupService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class StartupGraphQLController {

    private final StartupService startupService;

    public StartupGraphQLController(StartupService startupService) {
        this.startupService = startupService;
    }

    @QueryMapping(name = "allStartups")
    public List<StartupDTO> getAllStartups() {
        return startupService.getAll();
    }

    @QueryMapping(name = "startups")
    public List<StartupDTO> getStartups(@Argument int count) {
        return startupService.getStartups(count);
    }

    @QueryMapping(name = "startup")
    public Optional<StartupDTO> getStartup(@Argument Long id) {
        return startupService.getById(id);
    }

    @QueryMapping(name = "startupsByUser")
    public List<StartupDTO> getStartupsByUser(@Argument Long userId) {
        return startupService.getByUserId(userId);
    }

    @MutationMapping
    public StartupDTO createStartup(
            @Argument String name,
            @Argument String idea,
            @Argument String description,
            @Argument List<String> stack,
            @Argument String contacts,
            @Argument Long userId
    ) {
        StartupDTO dto = new StartupDTO();
        dto.setName(name);
        dto.setIdea(idea);
        dto.setDescription(description);
        dto.setStack(stack);
        dto.setContacts(contacts);
        dto.setUserId(userId);

        return startupService.createStartup(dto);
    }
}
