package com.workflow.conductor.mysql;

import com.workflow.conductor.domain.Workflow;
import com.workflow.conductor.usecase.workflow.port.WorkflowRepository;

import java.util.List;
import java.util.Optional;

public class MysqlWorkflowRepository implements WorkflowRepository {

    @Override
    public Optional<Workflow> findById(long workflowId) {
        return Optional.empty();
    }

    @Override
    public List<Workflow> findAllByProjectId(long projectId) {
        return null;
    }

    @Override
    public long save(Workflow workflow) {
        return 0;
    }

    @Override
    public long update(Workflow workflow) {
        return 0;
    }

    @Override
    public void deleteById(long workflowId) {

    }
}
