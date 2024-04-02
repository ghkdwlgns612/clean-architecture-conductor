package com.workflow.conductor.persistence.entity;

import jakarta.persistence.*;

/**
 * 모든 Workflow 에서 사용할 수 있는 전역 변수 설정.
 */
@Entity
@Table(name = "global_property")
public class GlobalPropertyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "value")
    private String value;

    protected GlobalPropertyEntity() {
    }

    /**
     * For create globalProperty
     */
    public GlobalPropertyEntity(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public void update(String name, String value) {
        this.name = name;
        this.value = value;
    }
}
