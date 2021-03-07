import model.Like;
import model.Position;
import service.LikeCounter;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // sukurti listą
        List<Like> list = new ArrayList<>();
        list.add(new Like("Jonas", Position.MID_DEVELOPER, "very good work yes"));
        list.add(new Like("Jonas", Position.MID_DEVELOPER, "very good work yes"));
        list.add(new Like("Jonas", Position.MID_DEVELOPER, "very good work yes"));
        list.add(new Like("Petras", Position.PROJECT_MANAGER, "very good"));
        LikeCounter is = new LikeCounter();

        System.out.println(is.getStatisticsByName(list, "Jonas"));
        System.out.println(is.getManagerStatistics(list));
        System.out.println(is.getTotalStatistics(list));
    }
}
