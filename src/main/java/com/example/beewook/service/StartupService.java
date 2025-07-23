package com.example.beewook.service;

import com.example.beewook.dto.StartupDTO;
import com.example.beewook.model.Startup;
import com.example.beewook.repository.StartupRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StartupService {
    private final StartupRepository startupRepository;

    public StartupService(StartupRepository startupRepository) {
        this.startupRepository = startupRepository;
    }

    public StartupDTO createStartup(StartupDTO dto) {
        Startup startup = new Startup(dto);
        return new StartupDTO(startupRepository.save(startup));
    }

    public List<StartupDTO> getAll() {
        return  startupRepository.findAll().stream().map(StartupDTO::new).collect(Collectors.toList());
    }

    public List<StartupDTO> getStartups(int count) {
        return startupRepository.findRandomStartups(count).stream()
                .map(StartupDTO::new)
                .collect(Collectors.toList());
    }


    public List<StartupDTO> getByUserId(Long userId) {
        return startupRepository.findByUserId(userId).stream()
                .map(StartupDTO::new)
                .collect(Collectors.toList());
    }

    public Optional<StartupDTO> getById(Long id) {
        return startupRepository.findById(id).map(StartupDTO::new);
    }
}
