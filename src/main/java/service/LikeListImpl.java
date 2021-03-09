package service;

import model.Like;
import model.Position;

import java.util.List;

public class LikeListImpl implements LikeList {

    @Override
    public void addLike(List<Like> list, String name, Position position, String message) {
        list.add(new Like(name, position, message));
    }
}
