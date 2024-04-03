package com.workflow.conductor.usecase.jobprop.port;

import com.workflow.conductor.domain.JobProperty;

import java.util.List;

public interface JobPropertyRepository {
    List<JobProperty> findAllByWorkflowId(long workflowId);

    void save(JobProperty globalProperty);

    void saveAll(List<JobProperty> globalProperties);

    void update(JobProperty globalProperty);

    void deleteById(long id);

    void deleteByWorkflowId(long workflowId);
}
