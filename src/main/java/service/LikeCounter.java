package service;

import exception.EmployeeNotFound;
import model.Like;

import java.util.List;

public interface LikeCounter {
    int getStatisticsByName(List<Like> list, String name);
    int getManagerStatistics(List<Like> list);
    int getDeveloperStatistics(List<Like> list);
    int getTotalStatistics(List<Like> list);
    String retrieveMessages(List<Like> list, String name) throws EmployeeNotFound;
}
