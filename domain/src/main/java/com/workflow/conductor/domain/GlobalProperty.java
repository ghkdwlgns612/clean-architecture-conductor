package com.workflow.conductor.domain;

public class GlobalProperty {

    private Long id;

    private String name;

    private String value;

    public GlobalProperty(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public GlobalProperty(Long id, String name, String value) {
        this.id = id;
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
}
