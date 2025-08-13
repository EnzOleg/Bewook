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

    public boolean deleteResumeById(Long id) {
        if (resumeRepository.existsById(id)) {
            resumeRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public ResumeDTO updateResume(ResumeDTO dto) {
        Resume resume = resumeRepository.findById(dto.getId())
                .orElseThrow(() -> new RuntimeException("Resume not found"));

        if (dto.getName() != null) resume.setName(dto.getName());
        if (dto.getDescription() != null) resume.setDescription(dto.getDescription());
        if (dto.getRegion() != null) resume.setRegion(dto.getRegion());
        if (dto.getStack() != null) resume.setStack(dto.getStack());
        if (dto.getRace() != null) resume.setRace(dto.getRace());
        if (dto.getContacts() != null) resume.setContacts(dto.getContacts());

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