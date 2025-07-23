package com.example.beewook.graphql;

import com.example.beewook.dto.ResumeDTO;
import com.example.beewook.repository.ResumeRepository;
import com.example.beewook.repository.UserRepository;
import com.example.beewook.service.ResumeService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class ResumeGraphQLController {

    private final ResumeRepository resumeRepository;
    private final UserRepository userRepository;

    private final ResumeService resumeService;


    public ResumeGraphQLController(ResumeService resumeService, ResumeRepository resumeRepository, UserRepository userRepository) {
        this.resumeService = resumeService;
        this.resumeRepository = resumeRepository;
        this.userRepository = userRepository;
    }

    @QueryMapping
    public List<ResumeDTO> resumes(@Argument int count) {
        return resumeService.getResumes(count);
    }

    @QueryMapping
    public Optional<ResumeDTO> resume(@Argument Long id) {
        return resumeService.getById(id);
    }

    @QueryMapping
    public List<ResumeDTO> resumesByUser(@Argument Long userId) {
        return resumeService.getByUserId(userId);
    }


    @MutationMapping
    public ResumeDTO createResume(
            @Argument String first_name,
            @Argument String last_name,
            @Argument String city,
            @Argument List<String> stack,
            @Argument String contacts,
            @Argument Long userId // добавлен
    ) {
        ResumeDTO dto = new ResumeDTO(null, first_name, last_name, city, stack, contacts, userId); // поправлен
        return resumeService.createResume(dto);
    }
}
