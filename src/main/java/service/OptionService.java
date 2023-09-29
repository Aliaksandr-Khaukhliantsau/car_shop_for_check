package service;

import entity.Option;

import java.sql.SQLException;
import java.util.List;

public interface OptionService {

    List<Option> getById(String id) throws SQLException;

    List<Option> getByName(String name) throws SQLException;

    List<Option> getAllOptions() throws SQLException;

    List<Option> create(String name) throws SQLException;

    List<Option> update(String id, String name) throws SQLException;

    List<Option> delete(String id) throws SQLException;
}
