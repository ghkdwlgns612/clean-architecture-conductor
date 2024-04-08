package com.workflow.conductor.mysql;

import com.workflow.conductor.domain.Project;
import com.workflow.conductor.usecase.project.port.ProjectRepository;

import java.util.List;
import java.util.Optional;

public class MysqlProjectPropertyRepository implements ProjectRepository {

    @Override
    public Optional<Project> findById(long id) {
        return Optional.empty();
    }

    @Override
    public List<Project> findAll() {
        return null;
    }

    @Override
    public long save(Project project) {
        return 0;
    }

    @Override
    public long update(Project project) {
        return 0;
    }

    @Override
    public void deleteById(long id) {

    }
}
