package service;

import model.Like;
import model.Position;

import java.util.List;

public interface LikeList {
    void addLike(List<Like> list, String name, Position position, String message);
}
