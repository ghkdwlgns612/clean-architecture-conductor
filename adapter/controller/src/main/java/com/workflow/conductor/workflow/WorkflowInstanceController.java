package com.workflow.conductor.workflow;

import com.workflow.conductor.usecase.workflow.RunWorkflow;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.workflow.conductor.RequestMappingConstants.WORKFLOW_INSTANCE;

@RestController
@RequestMapping(WORKFLOW_INSTANCE)
class WorkflowInstanceController {

    private final RunWorkflow RunWorkflow;

    public WorkflowInstanceController(RunWorkflow runWorkflow) {
        RunWorkflow = runWorkflow;
    }

    @PostMapping("{workflowId}")
    long runWorkflow(@PathVariable("workflowId") long workflowId) {
        return runWorkflowUseCase.runWorkflow(workflowId);
    }
}
