package com.workflow.conductor;

import com.workflow.conductor.globalprop.GlobalPropertyController;
import com.workflow.conductor.jobprop.JobPropertyController;
import com.workflow.conductor.mysql.MysqlGlobalPropertyRepository;
import com.workflow.conductor.mysql.MysqlJobPropertyRepository;
import com.workflow.conductor.mysql.MysqlProjectPropertyRepository;
import com.workflow.conductor.mysql.MysqlWorkflowRepository;
import com.workflow.conductor.project.ProjectController;
import com.workflow.conductor.usecase.globalprop.CreateGlobalProperty;
import com.workflow.conductor.usecase.globalprop.DeleteGlobalProperty;
import com.workflow.conductor.usecase.globalprop.FindGlobalProperty;
import com.workflow.conductor.usecase.globalprop.UpdateGlobalProperty;
import com.workflow.conductor.usecase.globalprop.port.GlobalPropertyRepository;
import com.workflow.conductor.usecase.jobprop.CreateJobProperty;
import com.workflow.conductor.usecase.jobprop.DeleteJobProperty;
import com.workflow.conductor.usecase.jobprop.FindJobProperty;
import com.workflow.conductor.usecase.jobprop.UpdateJobProperty;
import com.workflow.conductor.usecase.jobprop.port.JobPropertyRepository;
import com.workflow.conductor.usecase.project.CreateProject;
import com.workflow.conductor.usecase.project.DeleteProject;
import com.workflow.conductor.usecase.project.FindProject;
import com.workflow.conductor.usecase.project.UpdateProject;
import com.workflow.conductor.usecase.project.port.ProjectRepository;
import com.workflow.conductor.usecase.workflow.*;
import com.workflow.conductor.usecase.workflow.port.WorkflowRepository;
import com.workflow.conductor.workflow.WorkflowController;
import com.workflow.conductor.workflow.WorkflowInstanceController;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(value = "adapter.out.repository.type", havingValue = "MYSQL")
public class MysqlConfiguration {

    private final GlobalPropertyRepository globalPropertyRepository = new MysqlGlobalPropertyRepository();
    private final ProjectRepository projectRepository = new MysqlProjectPropertyRepository();
    private final JobPropertyRepository jobPropertyRepository = new MysqlJobPropertyRepository();
    private final WorkflowRepository workflowRepository = new MysqlWorkflowRepository();

    /**
     * Controller Bean
     */
    @Bean
    GlobalPropertyController globalPropertyController() {
        return new GlobalPropertyController(findGlobalProperty(), createGlobalProperty(), updateGlobalProperty(), deleteGlobalProperty());
    }

    @Bean
    ProjectController projectController() {
        return new ProjectController(findProject(), createProject(), updateProject(), deleteProject());
    }

    @Bean
    JobPropertyController jobPropertyController() {
        return new JobPropertyController(findJobProperty(), createJobProperty(), updateJobProperty(), deleteJobProperty());
    }

    @Bean
    WorkflowController workflowController() {
        return new WorkflowController(findWorkflow(), findJobProperty(), createWorkflow(), updateWorkflow(), deleteWorkflow());
    }

    @Bean
    WorkflowInstanceController workflowInstanceController() {
        return new WorkflowInstanceController(runWorkflow());
    }

    /**
     * Outgoing-Port Bean
     */
    @Bean
    FindGlobalProperty findGlobalProperty() {
        return new FindGlobalProperty(globalPropertyRepository);
    }

    @Bean
    CreateGlobalProperty createGlobalProperty() {
        return new CreateGlobalProperty(globalPropertyRepository);
    }

    @Bean
    UpdateGlobalProperty updateGlobalProperty() {
        return new UpdateGlobalProperty(globalPropertyRepository);
    }

    @Bean
    DeleteGlobalProperty deleteGlobalProperty() {
        return new DeleteGlobalProperty(globalPropertyRepository);
    }

    @Bean
    FindProject findProject() {
        return new FindProject(projectRepository);
    }

    @Bean
    CreateProject createProject() {
        return new CreateProject(projectRepository);
    }

    @Bean
    UpdateProject updateProject() {
        return new UpdateProject(projectRepository);
    }

    @Bean
    DeleteProject deleteProject() {
        return new DeleteProject(projectRepository);
    }

    @Bean
    FindJobProperty findJobProperty() {
        return new FindJobProperty(jobPropertyRepository);
    }

    @Bean
    CreateJobProperty createJobProperty() {
        return new CreateJobProperty(jobPropertyRepository);
    }

    @Bean
    UpdateJobProperty updateJobProperty() {
        return new UpdateJobProperty(jobPropertyRepository);
    }

    @Bean
    DeleteJobProperty deleteJobProperty() {
        return new DeleteJobProperty(jobPropertyRepository);
    }

    @Bean
    FindWorkflow findWorkflow() {
        return new FindWorkflow(workflowRepository);
    }

    @Bean
    CreateWorkflow createWorkflow() {
        return new CreateWorkflow(workflowRepository);
    }

    @Bean
    UpdateWorkflow updateWorkflow() {
        return new UpdateWorkflow(workflowRepository);
    }

    @Bean
    DeleteWorkflow deleteWorkflow() {
        return new DeleteWorkflow(jobPropertyRepository, workflowRepository);
    }

    @Bean
    RunWorkflow runWorkflow() {
        return new RunWorkflow();
    }
}