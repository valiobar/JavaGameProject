package Entities.Bricks;

import Interfaces.Board;
import Interfaces.Collidable;
import Interfaces.Wall;

/**
 * Created by vb on 13.4.2016 г..
 */
public class HarderBrick extends NormalBrick {
    public HarderBrick(int x, int y, Wall wall, Board table) {
        super(x, y,wall,table);
this.hitPoint=2;

    }
}
