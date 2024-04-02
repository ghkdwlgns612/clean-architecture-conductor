package com.workflow.conductor.workflow;

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
    private final CreateWorkflow createWorkflow;
    private final UpdateWorkflow updateWorkflow;
    private final DeleteWorkflow deleteWorkflow;

    @Autowired
    public WorkflowController(FindWorkflow findWorkflow, CreateWorkflow createWorkflow, UpdateWorkflow updateWorkflow, DeleteWorkflow deleteWorkflow) {
        this.findWorkflow = findWorkflow;
        this.createWorkflow = createWorkflow;
        this.updateWorkflow = updateWorkflow;
        this.deleteWorkflow = deleteWorkflow;
    }

    @GetMapping("{id}")
    WorkflowResponse getWorkflow(@PathVariable("id") long id) {
        return getWorkflowQuery.getWorkflow(id);
    }

    @GetMapping("project/{id}")
    List<WorkflowResponse> getWorkflowInProject(@PathVariable long id) {
        return getWorkflowQuery.getWorkflowsInProject(id);
    }

    @PostMapping
    long createWorkflow(@RequestBody CreateWorkflowCommand command) {
        return cudWorkflowUseCase.createWorkflow(command);
    }

    @PutMapping
    void updateWorkflow(@RequestBody UpdateWorkflowCommand command) {
        cudWorkflowUseCase.updateWorkflow(command);
    }

    @DeleteMapping("{id}")
    void deleteWorkflow(@PathVariable("id") Long id) {
        cudWorkflowUseCase.deleteWorkflow(id);
    }
}
