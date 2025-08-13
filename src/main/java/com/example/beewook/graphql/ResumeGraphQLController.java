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
    public boolean deleteResume(@Argument Long id) {
        return resumeService.deleteResumeById(id);
    }

    @MutationMapping
    public ResumeDTO createResume(
            @Argument String name,
            @Argument String description,
            @Argument String region,
            @Argument List<String> stack,
            @Argument String race,
            @Argument String contacts,
            @Argument Long userId
    ) {
        ResumeDTO dto = new ResumeDTO(null, name, description, region, stack, race, contacts, userId);
        return resumeService.createResume(dto);
    }

    @MutationMapping
    public ResumeDTO updateResume(
            @Argument Long id,
            @Argument String name,
            @Argument String description,
            @Argument String region,
            @Argument List<String> stack,
            @Argument String race,
            @Argument String contacts
    ) {
        ResumeDTO dto = new ResumeDTO(id, name, description, region, stack, race, contacts, null);
        return resumeService.updateResume(dto);
    }

}
