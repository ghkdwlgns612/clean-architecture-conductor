package com.workflow.conductor.workflow;

import com.workflow.conductor.domain.JobProperty;
import com.workflow.conductor.domain.Workflow;
import com.workflow.conductor.usecase.jobprop.FindJobProperty;
import com.workflow.conductor.usecase.workflow.CreateWorkflow;
import com.workflow.conductor.usecase.workflow.DeleteWorkflow;
import com.workflow.conductor.usecase.workflow.FindWorkflow;
import com.workflow.conductor.usecase.workflow.UpdateWorkflow;
import com.workflow.conductor.workflow.request.CreateWorkflowCommand;
import com.workflow.conductor.workflow.request.UpdateWorkflowCommand;
import com.workflow.conductor.workflow.response.WorkflowResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.workflow.conductor.RequestMappingConstants.WORKFLOW;

@RestController
@RequestMapping(WORKFLOW)
class WorkflowController {

    private final FindWorkflow findWorkflow;
    private final FindJobProperty findJobProperty;
    private final CreateWorkflow createWorkflow;
    private final UpdateWorkflow updateWorkflow;
    private final DeleteWorkflow deleteWorkflow;

    @Autowired
    public WorkflowController(FindWorkflow findWorkflow, FindJobProperty findJobProperty, CreateWorkflow createWorkflow, UpdateWorkflow updateWorkflow, DeleteWorkflow deleteWorkflow) {
        this.findWorkflow = findWorkflow;
        this.findJobProperty = findJobProperty;
        this.createWorkflow = createWorkflow;
        this.updateWorkflow = updateWorkflow;
        this.deleteWorkflow = deleteWorkflow;
    }

    @GetMapping("{id}")
    WorkflowResponse getWorkflow(@PathVariable("id") long workflowId) {
        Workflow workflow = findWorkflow.getWorkflow(workflowId);
        List<JobProperty> jobProperties = findJobProperty.getJobPropertiesInWorkflow(workflowId);
        return WorkflowResponse.from(workflow, jobProperties);
    }

    @GetMapping("project/{id}")
    List<WorkflowResponse> getWorkflowInProject(@PathVariable("id") long projectId) {
        List<Workflow> workflows = findWorkflow.getWorkflowsInProject(projectId);
        return workflows.stream()
                .map(workflow -> {
                    List<JobProperty> jobPropertiesInWorkflow = findJobProperty.getJobPropertiesInWorkflow(workflow.getId());
                    return WorkflowResponse.from(workflow, jobPropertiesInWorkflow);
                }).toList();
    }

    @PostMapping
    long createWorkflow(@RequestBody CreateWorkflowCommand command) {
        return createWorkflow.createWorkflow(command.toDomain());
    }

    @PutMapping
    long updateWorkflow(@RequestBody UpdateWorkflowCommand command) {
        return updateWorkflow.updateWorkflow(command.toDomain());
    }

    @DeleteMapping("{id}")
    void deleteWorkflow(@PathVariable("id") long id) {
        deleteWorkflow.deleteWorkflow(id);
    }
}
