package Entities.Bricks;

import FX.Assets;
import Interfaces.Board;
import Interfaces.Brick;
import Interfaces.Collidable;
import Interfaces.Wall;

import java.awt.*;

public class NormalBrick implements Brick, Collidable {
    public int x, y;
    protected final int WIGHT = 40;
    protected final int HIGHT = 10;
    private Rectangle boundingBox;
    protected Wall wall;
    protected int hitPoint = 1;
    protected int score = 10;
    protected Board table;

    public NormalBrick(int x, int y, Wall wall, Board table) {
        this.x = x;
        this.y = y;
        this.wall = wall;
        this.table = table;
        this.boundingBox = new Rectangle(x, y, WIGHT, HIGHT);

    }

    public void tick() {

    }

    public Rectangle getBoundingBox() {
        return boundingBox;
    }

    public int getScore() {
        return score;
    }

    public int getHitPoint() {
        return hitPoint;
    }


    public void render(Graphics g) {
        switch (hitPoint) {
            case 1:
                g.drawImage(Assets.brick, this.x, this.y, this.WIGHT, this.HIGHT, null);
                break;
            case 2:
                g.drawImage(Assets.harderBrick, this.x, this.y, this.WIGHT, this.HIGHT, null);
                break;

            case 3:
                g.drawImage(Assets.hardestBrick, this.x, this.y, this.WIGHT, this.HIGHT, null);
                break;

        }


    }

    public void getHit() {
        this.hitPoint--;
    }
}
