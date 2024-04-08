package com.workflow.conductor.mysql;

import com.workflow.conductor.domain.JobProperty;
import com.workflow.conductor.usecase.jobprop.port.JobPropertyRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MysqlJobPropertyRepository implements JobPropertyRepository {

    @Override
    public List<JobProperty> findAllByWorkflowId(long workflowId) {
        try (Connection connection = ConnectionStore.getConnection()) {
            String sql = "SELECT * FROM JOB_PROPERTY WHERE workflow_id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, workflowId);
            ResultSet rs = statement.executeQuery();
            List<JobProperty> result = new ArrayList<>();
            while (rs.next()) {
                result.add(
                        new JobProperty(
                                rs.getLong("id"),
                                rs.getLong("workflow_id"),
                                rs.getString("name"),
                                rs.getString("value")));
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return List.of();
    }

    @Override
    public void save(JobProperty jobProperty) {
        try (Connection connection = ConnectionStore.getConnection()) {
            String sql = "INSERT INTO JOB_PROPERTY (name, value, workflow_id) VALUE (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, jobProperty.getName());
            statement.setString(2, jobProperty.getValue());
            statement.setLong(3, jobProperty.getWorkflowId());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void saveAll(List<JobProperty> jobProperties) {
        jobProperties.forEach(this::save);
    }

    @Override
    public void update(JobProperty jobProperty) {
        try (Connection connection = ConnectionStore.getConnection()) {
            String sql = "UPDATE JOB_PROPERTY SET name=?, value=? WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, jobProperty.getName());
            statement.setString(2, jobProperty.getValue());
            statement.setLong(3, jobProperty.getId());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(long id) {
        try (Connection connection = ConnectionStore.getConnection()) {
            String sql = "DELETE FROM JOB_PROPERTY WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteByWorkflowId(long workflowId) {
        try (Connection connection = ConnectionStore.getConnection()) {
            String sql = "DELETE FROM JOB_PROPERTY WHERE workflow_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, workflowId);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
