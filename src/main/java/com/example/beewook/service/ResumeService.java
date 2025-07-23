package com.example.beewook.service;

import com.example.beewook.dto.ResumeDTO;
import com.example.beewook.model.Resume;
import com.example.beewook.repository.ResumeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ResumeService {
    private final ResumeRepository resumeRepository;

    public ResumeService(ResumeRepository resumeRepository) {
        this.resumeRepository = resumeRepository;
    }

    public ResumeDTO createResume(ResumeDTO dto) {
        Resume resume = new Resume(dto);
        return new ResumeDTO(resumeRepository.save(resume));
    }

    public List<ResumeDTO> getAll() {
        return resumeRepository.findAll().stream().map(ResumeDTO::new).collect(Collectors.toList());
    }

    public List<ResumeDTO> getResumes(int count) {
        return resumeRepository.findRandomResumes(count).stream()
                .map(ResumeDTO::new)
                .collect(Collectors.toList());
    }

    public List<ResumeDTO> getByUserId(Long userId) {
        return resumeRepository.findByUserId(userId).stream()
                .map(ResumeDTO::new)
                .collect(Collectors.toList());
    }

    public Optional<ResumeDTO> getById(Long id) {
        return resumeRepository.findById(id).map(ResumeDTO::new);
    }
}