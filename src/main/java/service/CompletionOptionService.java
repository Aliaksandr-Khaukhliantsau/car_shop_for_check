package service;

import entity.CompletionOption;

import java.sql.SQLException;
import java.util.List;

public interface CompletionOptionService {

    List<CompletionOption> getByIdCompletion(String idCompletion) throws SQLException;

    List<CompletionOption> getByIdOption(String idOption) throws SQLException;

    List<CompletionOption> getAllCompletionsOptions() throws SQLException;

    List<CompletionOption> create(String idCompletion, String idOption) throws SQLException;

//    List<CompletionOption> update(String idCompletion, String idOption) throws SQLException;

    List<CompletionOption> delete(String idCompletion, String idOption) throws SQLException;
}
