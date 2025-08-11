package com.example.beewook.model;

import com.example.beewook.dto.StartupDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="startups")
@Getter
@Setter
public class Startup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String name;

    private String description;

    @ElementCollection
    @CollectionTable(name = "startup_stack", joinColumns = @JoinColumn(name = "startup_id"))
    @Column(name = "stack_item")
    @Size(max = 50)
    private List<String> stack;

    private String region;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    private String contacts;

    public Startup(StartupDTO dto) {
        this.name = dto.getName();
        this.description = dto.getDescription();
        this.stack = dto.getStack();
        this.region = dto.getRegion();
        this.userId = dto.getUserId();
        this.contacts = dto.getContacts();
    }


    public Startup(Long id, String name, String description, List<String> stack, Long userId, String contacts) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.stack = stack;
        this.contacts = contacts;
        this.userId = userId;
    }

    public Startup() {

    }

}
