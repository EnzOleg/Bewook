package com.example.beewook.dto;

import com.example.beewook.model.Startup;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StartupDTO {
    private Long id;
    private String name;
    private String description;
    private List<String> stack;
    private String contacts;
    private String region;
    private Long userId;

    public StartupDTO() {}

    public StartupDTO(Long id, String name, String description, List<String> stack, String contacts, String region, Long userId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.stack = stack;
        this.contacts = contacts;
        this.region = region;
        this.userId = userId;
    }

    public StartupDTO(Startup startup) {
        this.id = startup.getId();
        this.name = startup.getName();
        this.description = startup.getDescription();
        this.stack = startup.getStack();
        this.region = startup.getRegion();
        this.contacts = startup.getContacts();
        this.userId = startup.getUserId();
    }

}
