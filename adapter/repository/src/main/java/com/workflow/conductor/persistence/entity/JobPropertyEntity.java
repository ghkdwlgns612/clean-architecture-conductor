package com.workflow.conductor.persistence.entity;

import jakarta.persistence.*;

/**
 * Workflow 의 argument 설정을 저장하는 entity.
 */
@Entity
@Table(name = "job_property")
public class JobPropertyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "value")
    private String value;

    @ManyToOne
    @JoinColumn(name = "workflow_id")
    private WorkflowEntity workflow;

    protected JobPropertyEntity() {
    }

    /**
     * For create jobProperty
     */
    public JobPropertyEntity(String name, String value, WorkflowEntity workflow) {
        this.name = name;
        this.value = value;
        this.workflow = workflow;
    }
}
