package com.workflow.conductor.mysql;

import com.workflow.conductor.domain.GlobalProperty;
import com.workflow.conductor.usecase.globalprop.port.GlobalPropertyRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MysqlGlobalPropertyRepository implements GlobalPropertyRepository {

    @Override
    public Optional<GlobalProperty> findById(long id) {
        try (Connection connection = ConnectionStore.getConnection()) {
            String sql = "SELECT * FROM GLOBAL_PROPERTY WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                return Optional.of(new GlobalProperty(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("value")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<GlobalProperty> findAll() {
        try (Connection connection = ConnectionStore.getConnection()) {
            String sql = "SELECT * FROM GLOBAL_PROPERTY";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            List<GlobalProperty> result = new ArrayList<>();
            while (rs.next()) {
                result.add(
                        new GlobalProperty(
                                rs.getLong("id"),
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
    public void save(GlobalProperty globalProperty) {
        try (Connection connection = ConnectionStore.getConnection()) {
            String sql = "INSERT INTO GLOBAL_PROPERTY (name, value) VALUE (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, globalProperty.getName());
            statement.setString(2, globalProperty.getValue());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(GlobalProperty globalProperty) {
        try (Connection connection = ConnectionStore.getConnection()) {
            String sql = "UPDATE GLOBAL_PROPERTY SET name=?, value=? WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, globalProperty.getName());
            statement.setString(2, globalProperty.getValue());
            statement.setLong(3,globalProperty.getId());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(long id) {
        try (Connection connection = ConnectionStore.getConnection()) {
            String sql = "DELETE FROM GLOBAL_PROPERTY WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
