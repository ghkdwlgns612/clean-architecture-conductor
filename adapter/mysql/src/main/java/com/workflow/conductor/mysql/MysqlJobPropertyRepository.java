package com.workflow.conductor.mysql;

import com.workflow.conductor.domain.JobProperty;
import com.workflow.conductor.usecase.jobprop.port.JobPropertyRepository;

import java.util.List;

public class MysqlJobPropertyRepository implements JobPropertyRepository {

    @Override
    public List<JobProperty> findAllByWorkflowId(long workflowId) {
        return null;
    }

    @Override
    public void save(JobProperty jobProperty) {

    }

    @Override
    public void saveAll(List<JobProperty> jobProperties) {

    }

    @Override
    public void update(JobProperty jobProperty) {

    }

    @Override
    public void deleteById(long id) {

    }

    @Override
    public void deleteByWorkflowId(long workflowId) {

    }
}
