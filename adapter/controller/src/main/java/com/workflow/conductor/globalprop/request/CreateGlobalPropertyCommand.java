package com.workflow.conductor.globalprop.request;

public class CreateGlobalPropertyCommand {
    private final String name;
    private final String value;

    public CreateGlobalPropertyCommand(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }
}
