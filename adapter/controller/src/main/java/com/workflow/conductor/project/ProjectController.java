package com.workflow.conductor.project;

import com.workflow.conductor.domain.Project;
import com.workflow.conductor.project.request.CreateProjectCommand;
import com.workflow.conductor.project.request.UpdateProjectCommand;
import com.workflow.conductor.project.response.ProjectResponse;
import com.workflow.conductor.usecase.project.CreateProject;
import com.workflow.conductor.usecase.project.DeleteProject;
import com.workflow.conductor.usecase.project.FindProject;
import com.workflow.conductor.usecase.project.UpdateProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.workflow.conductor.RequestMappingConstants.PROJECT;

@RestController
@RequestMapping(PROJECT)
class ProjectController {

    private final FindProject findProject;
    private final CreateProject createProject;
    private final UpdateProject updateProject;
    private final DeleteProject deleteProject;

    @Autowired
    public ProjectController(FindProject findProject, CreateProject createProject, UpdateProject updateProject, DeleteProject deleteProject) {
        this.findProject = findProject;
        this.createProject = createProject;
        this.updateProject = updateProject;
        this.deleteProject = deleteProject;
    }

    @GetMapping("{id}")
    ProjectResponse getProject(@PathVariable long id) {
        Project project = findProject.getProject(id);
        return ProjectResponse.from(project);
    }

    @GetMapping
    List<ProjectResponse> getAllProjects() {
        List<Project> projects = findProject.getAllProjects();
        return projects.stream()
                .map(ProjectResponse::from)
                .toList();
    }

    @PostMapping
    long createProject(@RequestBody CreateProjectCommand command) {
        return createProject.createProject(command.toDomain());
    }

    @PutMapping
    long updateProject(@RequestBody UpdateProjectCommand command) {
        return updateProject.updateProject(command.toDomain());
    }

    @DeleteMapping("{id}")
    void deleteProject(@PathVariable("id") long id) {
        deleteProject.deleteProject(id);
    }
}
