package com.workflow.conductor.persistence.entity;

import jakarta.persistence.*;

/**
 * Workflow 상위 개념인 project 를 나타내는 entity.
 */
@Entity
@Table(name = "project")
public class ProjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    protected ProjectEntity() {
    }

    /**
     * For create project
     */
    public ProjectEntity(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void update(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
