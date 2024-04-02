package com.workflow.conductor.globalprop.response;

public class GlobalPropertyResponse {
    private final long id;
    private final String name;
    private final String value;

    public GlobalPropertyResponse(long id, String name, String value) {
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
