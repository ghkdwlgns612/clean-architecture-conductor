package com.workflow.conductor.persistence.entity;

import com.nexr.ndap.workflow.common.WorkflowStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;

/**
 * Workflow 실행될 때 생성되는 Instance
 */
@Entity
@Table(name = "workflow_instance")
public class WorkflowInstanceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "workflow_id")
    private com.nexr.ndap.workflow.adapter.out.persistence.entity.WorkflowEntity workflow;

    @Lob
    @Column(name = "json_definition", columnDefinition = "LONGTEXT")
    private String jsonDefinition;

    @Column(name = "engine_workflow_instance_id")
    private String engineWorkflowInstanceId;

    @Enumerated(EnumType.STRING)
    @Column(name = "workflow_status")
    private WorkflowStatus workflowStatus;

    @Column(name = "create_time")
    private LocalDateTime createTime;

    @Column(name = "start_time")
    private LocalDateTime startTime;

    @Column(name = "end_time")
    private LocalDateTime endTime;

    @Column(name = "modified_time")
    private LocalDateTime modifiedTime;

    protected WorkflowInstanceEntity() {
    }

    /**
     * For create workflowInstance
     */
    public WorkflowInstanceEntity(
            com.nexr.ndap.workflow.adapter.out.persistence.entity.WorkflowEntity workflow,
            String jsonDefinition,
            String engineWorkflowInstanceId,
            WorkflowStatus workflowStatus,
            LocalDateTime createTime,
            LocalDateTime startTime,
            LocalDateTime endTime,
            LocalDateTime modifiedTime) {
        this.workflow = workflow;
        this.jsonDefinition = jsonDefinition;
        this.engineWorkflowInstanceId = engineWorkflowInstanceId;
        this.workflowStatus = workflowStatus;
        this.createTime = createTime;
        this.startTime = startTime;
        this.endTime = endTime;
        this.modifiedTime = modifiedTime;
    }

    public Long getId() {
        return id;
    }

    public com.nexr.ndap.workflow.adapter.out.persistence.entity.WorkflowEntity getWorkflow() {
        return workflow;
    }

    public String getJsonDefinition() {
        return jsonDefinition;
    }

    public String getEngineWorkflowInstanceId() {
        return engineWorkflowInstanceId;
    }

    public WorkflowStatus getWorkflowStatus() {
        return workflowStatus;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public LocalDateTime getModifiedTime() {
        return modifiedTime;
    }
}
