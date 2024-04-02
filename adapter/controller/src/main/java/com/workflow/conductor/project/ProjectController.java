package com.workflow.conductor.project;

import com.nexr.ndap.workflow.application.port.in.project.request.CreateProjectCommand;
import com.nexr.ndap.workflow.application.port.in.project.request.UpdateProjectCommand;
import com.workflow.conductor.project.response.ProjectResponse;
import com.workflow.conductor.usecase.project.CreateProject;
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
        return projectQuery.getProject(id);
    }

    @GetMapping
    List<ProjectResponse> getAllProjects() {
        return projectQuery.getAllProjects();
    }

    @PostMapping
    long createProject(@RequestBody CreateProjectCommand command) {
        return cudProjectUseCase.createProject(command);
    }

    @PutMapping
    long updateProject(@RequestBody UpdateProjectCommand command) {
        return cudProjectUseCase.updateProject(command);
    }

    @DeleteMapping("{id}")
    void deleteProject(@PathVariable("id") long id) {
        cudProjectUseCase.deleteProject(id);
    }
}
