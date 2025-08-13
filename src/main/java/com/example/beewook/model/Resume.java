package com.example.beewook.model;

import com.example.beewook.dto.ResumeDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "resumes")
@Getter
@Setter
public class Resume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String name;

    @Column(length = 255)
    private String description;

    private String region;

    @ElementCollection
    @CollectionTable(name = "resume_stack", joinColumns = @JoinColumn(name = "resume_id"))
    @Column(name = "stack_item")
    @Size(max = 50)
    private List<String> stack;

    private String race;

    private String contacts;

    @Column(name = "user_id", nullable = false)
    private Long userId;


    public Resume() {}

    public Resume(ResumeDTO dto) {
        this(dto.getId(), dto.getName(), dto.getDescription(), dto.getRegion(), dto.getStack(), dto.getRace(), dto.getContacts(), dto.getUserId());
    }

    public Resume(Long id, String name, String description, String region, List<String> stack, String race, String contacts, Long userId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.region = region;
        this.stack = stack;
        this.race = race;
        this.contacts = contacts;
        this.userId = userId;
    }
}
