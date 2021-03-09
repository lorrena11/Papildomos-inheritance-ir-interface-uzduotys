package service;

import exception.EmployeeNotFound;
import model.Like;
import model.Position;

import java.util.List;

public class LikeCounterImpl implements LikeCounter {
    @Override
    public int getStatisticsByName(List<Like> list, String name) {
        int sum = 0;

        for (Like like : list) {
            if (like.getName().equalsIgnoreCase(name)) {
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
    public int getDeveloperStatistics(List<Like> list) {
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

    @Override
    public String retrieveMessages(List<Like> list, String name) throws EmployeeNotFound {
        StringBuilder messages = new StringBuilder();
        try {
            messages.append("Gautos zinutes: \n");
            for (Like like : list) {
                if (like.getName().equalsIgnoreCase(name)) {
                    messages.append("[" + like.getMessage() + "] \n");
                }
            }
            if (String.valueOf(messages).equals("Gautos zinutes: \n")) {
                messages.delete(0, 18);
                throw new EmployeeNotFound();
            }
        } catch (EmployeeNotFound e) {
            messages.append("Adresatas siuo vardu zinuciu neturi");
        }

        return String.valueOf(messages);
    }
}
