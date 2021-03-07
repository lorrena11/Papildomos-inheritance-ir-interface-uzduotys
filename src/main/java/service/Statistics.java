package service;

import model.Like;
import model.Position;

import java.util.List;

public interface Statistics {
    int getStatisticsByName(List<Like> list, String name);
    int getManagerStatistics(List<Like> list);
    int getDeveloperStatistics(List<Like> list, Position position);
    public int getTotalStatistics(List<Like> list);
}
