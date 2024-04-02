package com.workflow.conductor.persistence.entity;

import com.nexr.ndap.workflow.common.NodeType;
import com.nexr.ndap.workflow.common.WorkflowNodeStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;

/**
 * Workflow 실행 된 Instance 노드 정보 entity.
 */
@Entity
@Table(name = "workflow_instance_node")
public class WorkflowInstanceNodeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "node_type")
    private NodeType nodeType;

    @Column(name = "name")
    private String name;

    @Lob
    @Column(name = "json_definition", columnDefinition = "LONGTEXT")
    private String jsonDefinition;

    @ManyToOne
    @JoinColumn(name = "workflow_instance_id")
    private WorkflowInstanceEntity workflowInstance;

    @Column(name = "engine_task_instance_id")
    private String engineTaskInstanceId;

    @Column(name = "workflow_node_status")
    private WorkflowNodeStatus workflowNodeStatus;

    @Column(name = "create_time")
    private LocalDateTime createTime;

    @Column(name = "start_time")
    private LocalDateTime startTime;

    @Column(name = "end_time")
    private LocalDateTime endTime;

    @Column(name = "modified_time")
    private LocalDateTime modifiedTime;

    protected WorkflowInstanceNodeEntity() {
    }

    /**
     * For create workflowInstanceNode
     */
    public WorkflowInstanceNodeEntity(
            NodeType nodeType,
            String name,
            String jsonDefinition,
            WorkflowInstanceEntity workflowInstance,
            String engineTaskInstanceId,
            WorkflowNodeStatus workflowNodeStatus,
            LocalDateTime createTime,
            LocalDateTime startTime,
            LocalDateTime endTime,
            LocalDateTime modifiedTime) {
        this.nodeType = nodeType;
        this.name = name;
        this.jsonDefinition = jsonDefinition;
        this.workflowInstance = workflowInstance;
        this.engineTaskInstanceId = engineTaskInstanceId;
        this.workflowNodeStatus = workflowNodeStatus;
        this.createTime = createTime;
        this.startTime = startTime;
        this.endTime = endTime;
        this.modifiedTime = modifiedTime;
    }
}
