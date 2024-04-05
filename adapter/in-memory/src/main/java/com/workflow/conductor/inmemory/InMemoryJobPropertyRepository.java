package com.workflow.conductor.inmemory;

import com.workflow.conductor.domain.JobProperty;
import com.workflow.conductor.usecase.jobprop.port.JobPropertyRepository;

import java.util.List;

public class InMemoryJobPropertyRepository implements JobPropertyRepository {

    @Override
    public List<JobProperty> findAllByWorkflowId(long workflowId) {
        return null;
    }

    @Override
    public void save(JobProperty globalProperty) {

    }

    @Override
    public void saveAll(List<JobProperty> globalProperties) {

    }

    @Override
    public void update(JobProperty globalProperty) {

    }

    @Override
    public void deleteById(long id) {

    }

    @Override
    public void deleteByWorkflowId(long workflowId) {

    }
}
