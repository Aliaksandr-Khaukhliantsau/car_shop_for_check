package service.impl;

import entity.CompletionOption;
import repository.CompletionOptionRepository;
import repository.impl.CompletionOptionRepositoryImpl;
import service.CompletionOptionService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompletionOptionServiceImpl implements CompletionOptionService {
    CompletionOptionRepository completionOptionRepository = new CompletionOptionRepositoryImpl();

    public CompletionOptionServiceImpl() throws SQLException {
    }

    @Override
    public List<CompletionOption> getByIdCompletion(String idCompletion) throws SQLException {
        ResultSet resultSet = completionOptionRepository.getByIdCompletion(idCompletion);
        List<CompletionOption> completionOptionList = new ArrayList<>();

        while (resultSet.next()) {
            CompletionOption completionOption = new CompletionOption();
            completionOption.setIdCompletion(resultSet.getString("idcompletion"));
            completionOption.setIdOption(resultSet.getString("idoption"));

            completionOptionList.add(completionOption);
        }
        return completionOptionList;
    }

    @Override
    public List<CompletionOption> getByIdOption(String idOption) throws SQLException {
        ResultSet resultSet = completionOptionRepository.getByIdOption(idOption);
        List<CompletionOption> completionOptionList = new ArrayList<>();

        while (resultSet.next()) {
            CompletionOption completionOption = new CompletionOption();
            completionOption.setIdCompletion(resultSet.getString("idcompletion"));
            completionOption.setIdOption(resultSet.getString("idoption"));

            completionOptionList.add(completionOption);
        }
        return completionOptionList;
    }

    @Override
    public List<CompletionOption> getAllCompletionsOptions() throws SQLException {
        ResultSet resultSet = completionOptionRepository.getAllCompletionsOptions();
        List<CompletionOption> completionOptionList = new ArrayList<>();

        while (resultSet.next()) {
            CompletionOption completionOption = new CompletionOption();
            completionOption.setIdCompletion(resultSet.getString("idcompletion"));
            completionOption.setIdOption(resultSet.getString("idoption"));

            completionOptionList.add(completionOption);
        }
        return completionOptionList;
    }

    @Override
    public List<CompletionOption> create(String idCompletion, String idOption) throws SQLException {
        ResultSet resultSet = completionOptionRepository.create(idCompletion, idOption);
        List<CompletionOption> completionOptionList = new ArrayList<>();

        while (resultSet.next()) {
            CompletionOption completionOption = new CompletionOption();
            completionOption.setIdCompletion(resultSet.getString("idcompletion"));
            completionOption.setIdOption(resultSet.getString("idoption"));

            completionOptionList.add(completionOption);
        }
        return completionOptionList;
    }

//    @Override
//    public List<CompletionOption> update(String idCompletion, String idOption) throws SQLException {
//        ResultSet resultSet = completionOptionRepository.update(idCompletion, idOption);
//        List<CompletionOption> completionOptionList = new ArrayList<>();
//
//        while (resultSet.next()) {
//            CompletionOption completionOption = new CompletionOption();
//            completionOption.setIdCompletion(resultSet.getString("idcompletion"));
//            completionOption.setIdOption(resultSet.getString("idoption"));
//
//            completionOptionList.add(completionOption);
//        }
//        return completionOptionList;
//    }

    @Override
    public List<CompletionOption> delete(String idCompletion, String idOption) throws SQLException {
        ResultSet resultSet = completionOptionRepository.delete(idCompletion, idOption);
        List<CompletionOption> completionOptionList = new ArrayList<>();

        while (resultSet.next()) {
            CompletionOption completionOption = new CompletionOption();
            completionOption.setIdCompletion(resultSet.getString("idcompletion"));
            completionOption.setIdOption(resultSet.getString("idoption"));

            completionOptionList.add(completionOption);
        }
        return completionOptionList;
    }
}
