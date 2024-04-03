package com.workflow.conductor.domain;

public class JobProperty {

    private Long id;

    private Long workflowId;

    private String name;

    private String value;

    public JobProperty(String name, String value) {
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
