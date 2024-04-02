package com.workflow.conductor.globalprop.request;

public class UpdateGlobalPropertyCommand {
    private final long id;
    private final String name;
    private final String value;

    public UpdateGlobalPropertyCommand(long id, String name, String value) {
        this.id = id;
        this.name = name;
        this.value = value;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }
}
