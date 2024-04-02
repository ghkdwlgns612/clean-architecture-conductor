package com.workflow.conductor.persistence.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

/**
 * Workflow 를 나타내는 entity.
 */
@Entity
@Table(name = "workflow")
public class WorkflowEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private com.nexr.ndap.workflow.adapter.out.persistence.entity.ProjectEntity project;

    @Column(name = "name")
    private String name;

    @Lob
    @Column(name = "description", columnDefinition = "LONGTEXT")
    private String description;

    @Lob
    @Column(name = "json_definition", columnDefinition = "LONGTEXT")
    private String jsonDefinition;

    @Column(name = "owner_mail")
    private String ownerMail;

    @Column(name = "timeout_seconds")
    private long timeoutSeconds;

    @Column(name = "create_time")
    private LocalDateTime createTime;

    @Column(name = "modified_time")
    private LocalDateTime modifiedTime;

    protected WorkflowEntity() {
    }

    /**
     * For create workflow
     */
    public WorkflowEntity(
            com.nexr.ndap.workflow.adapter.out.persistence.entity.ProjectEntity project,
            String name,
            String description,
            String jsonDefinition,
            String ownerMail,
            long timeoutSeconds,
            LocalDateTime createTime,
            LocalDateTime modifiedTime) {
        this.project = project;
        this.name = name;
        this.description = description;
        this.jsonDefinition = jsonDefinition;
        this.ownerMail = ownerMail;
        this.timeoutSeconds = timeoutSeconds;
        this.createTime = createTime;
        this.modifiedTime = modifiedTime;
    }

    public Long getId() {
        return id;
    }

    public com.nexr.ndap.workflow.adapter.out.persistence.entity.ProjectEntity getProject() {
        return project;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getJsonDefinition() {
        return jsonDefinition;
    }

    public String getOwnerMail() {
        return ownerMail;
    }

    public long getTimeoutSeconds() {
        return timeoutSeconds;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public LocalDateTime getModifiedTime() {
        return modifiedTime;
    }
}
