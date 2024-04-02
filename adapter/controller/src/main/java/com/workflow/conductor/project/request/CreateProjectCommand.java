package com.workflow.conductor.project.request;

public class CreateProjectCommand {
    private final String name;
    private final String description;

    public CreateProjectCommand(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
