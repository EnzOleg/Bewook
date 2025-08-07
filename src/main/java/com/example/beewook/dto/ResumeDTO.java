package com.example.beewook.dto;

import com.example.beewook.model.Resume;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ResumeDTO {
    private Long id;
    private String name;
    private String region;
    private List<String> stack;
    private String race;
    private String contacts;
    private Long userId;


    public ResumeDTO(Long id, String name, String region, List<String> stack, String race, String contacts, Long userId) {
        this.id = id;
        this.name = name;
        this.region = region;
        this.stack = stack;
        this.race = race;
        this.contacts = contacts;
        this.userId = userId;
    }

    public ResumeDTO(Resume resume) {
        this(resume.getId(), resume.getName(), resume.getRegion(), resume.getStack(), resume.getRace(), resume.getContacts(),  resume.getUserId());
    }

}
