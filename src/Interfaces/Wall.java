package Interfaces;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vb on 20.4.2016 г..
 */
public interface Wall extends Tickable, Renderable {
    ArrayList<Brick> getWall();

    List<Item> getBonusItems();

    void fillWall();
}
