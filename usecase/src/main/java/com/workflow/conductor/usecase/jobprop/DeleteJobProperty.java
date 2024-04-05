package com.workflow.conductor.usecase.jobprop;

import com.workflow.conductor.usecase.jobprop.port.JobPropertyRepository;

import java.util.Map;

public class DeleteJobProperty {

    private final JobPropertyRepository jobPropertyRepository;

    public DeleteJobProperty(JobPropertyRepository jobPropertyRepository) {
        this.jobPropertyRepository = jobPropertyRepository;
    }

    public void deleteJobProperty(long workflowId, Map<String, Object> jobProperties) {

    }
}
