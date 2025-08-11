package com.example.beewook.graphql;

import com.example.beewook.dto.StartupDTO;
import com.example.beewook.repository.StartupRepository;
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
    private final StartupRepository startupRepository;

    public StartupGraphQLController(StartupService startupService, StartupRepository startupRepository) {
        this.startupService = startupService;
        this.startupRepository = startupRepository;
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
    public boolean deleteStartup(@Argument Long id) {
        return startupService.deleteStartupById(id);
    }

    @MutationMapping
    public StartupDTO createStartup(
            @Argument String name,
            @Argument String description,
            @Argument List<String> stack,
            @Argument String region,
            @Argument String contacts,
            @Argument Long userId
    ) {
        StartupDTO dto = new StartupDTO();
        dto.setName(name);
        dto.setDescription(description);
        dto.setStack(stack);
        dto.setRegion(region);
        dto.setContacts(contacts);
        dto.setUserId(userId);

        return startupService.createStartup(dto);
    }
}
