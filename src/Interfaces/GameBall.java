package Interfaces;

import Entities.Table;

/**
 * Created by vb on 20.4.2016 г..
 */
public interface GameBall extends Tickable, Renderable {
    void setWall(Wall wall);

    void stickToBoard();

    void setTable(Board table);

    void changeSpeed();
}
