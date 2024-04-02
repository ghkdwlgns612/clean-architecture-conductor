package com.workflow.conductor.project.request;

public class UpdateProjectCommand {
    private final long id;
    private final String name;
    private final String description;

    public UpdateProjectCommand(long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
