package service;

import model.Like;
import model.Position;

import java.util.List;

public class LikeCounter implements Statistics {
    @Override
    public int getStatisticsByName(List<Like> list, String name) {
        int sum = 0;
        for (Like like : list) {
            if (like.getName().equals(name)) {
                sum++;
            }
        }
        return sum;
    }

    @Override
    public int getManagerStatistics(List<Like> list) {
        int sum = 0;
        for (Like like : list) {
            if (like.getPosition().equals(Position.PROJECT_MANAGER)) {
                sum++;
            }
        }
        return sum;
    }

    @Override
    public int getDeveloperStatistics(List<Like> list, Position position) {
        int sum = 0;
        for (Like like : list) {
            if (like.getPosition().equals(Position.SENIOR_DEVELOPER) || like.getPosition().equals(Position.MID_DEVELOPER) || like.getPosition().equals(Position.JUNIOR_DEVELOPER)) {
                sum++;
            }
        }
        return sum;
    }

    @Override
    public int getTotalStatistics(List<Like> list) {
        int sum = list.size();
        return sum;
    }
}
