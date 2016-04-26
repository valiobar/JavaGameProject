package Entities;

import Entities.Bricks.BonusBrick;
import Entities.Bricks.NormalBrick;
import Entities.Bricks.HarderBrick;
import Entities.Bricks.HardestBrick;
import Interfaces.Board;
import Interfaces.Brick;
import Interfaces.Item;
import Interfaces.Wall;
import UserInterface.GUI;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by vb on 13.4.2016 г..
 */
public class BrickWall implements Wall {
    private ArrayList<Brick> wall;
    private List<Item> bonusItems = new ArrayList<>();
    private Board table;

    public BrickWall(Board table) {
        this.wall = new ArrayList<>();
        this.table = table;
    }

    public ArrayList<Brick> getWall() {
        return wall;
    }

    public List<Item> getBonusItems() {
        return bonusItems;
    }

    public void tick() {
        for (Item item : bonusItems) {
            item.tick();
        }
        for (int i = 0; i < wall.size(); i++) {
            if (wall.get(i).getHitPoint() <= 0) {
                wall.remove(i);
            }
        }
    }

    public void render(Graphics graf) {
        for (Item item : bonusItems) {
            item.render(graf);
        }
        for (Brick bricks : wall) {

            bricks.render(graf);
        }
    }

    public void fillWall() {
        this.wall.clear();
        switch (GUI.getInstance().getLevel() % 3) {
            case 0:
                this.lavel1Wall();
                break;
            case 1:
                this.lavel2Wall();
                break;
            case 2:
                this.lavel3Wall();
        }

    }

    private void lavel1Wall() {
        int numberOfBricks = 64;
        int x = 50;
        int y = 50;
        int endOfTheLine = x;
        int numberBrickOnLine = 15;
        int countLine = 0;
        for (int i = 0; i < numberOfBricks; i++) {

            if (countLine == numberBrickOnLine) {
                y += 25;
                x = endOfTheLine + 50;
                endOfTheLine = x;
                numberBrickOnLine -= 2;
                countLine = 0;
            }
            if (countLine == 0 || countLine == numberBrickOnLine - 1) {
                wall.add(new HardestBrick(x, y, this,this.table));
            } else if (countLine == 1 || countLine == numberBrickOnLine - 2) {
                wall.add(new HarderBrick(x, y, this,this.table));
            } else if (countLine == 2 || countLine == numberBrickOnLine - 3) {
                wall.add(new BonusBrick(x, y, this,this.table));
            } else {
                wall.add(new NormalBrick(x, y, this,this.table));
            }
            x += 45;
            countLine++;
        }
    }

    private void lavel2Wall() {
        int x = 0;
        int y = 30;
        for (int i = 0; i < 176; i++) {
            if (i % 16 == 0) {
                y += 15;
                x = 0;
            }
            if (i < 16 * 5) {
                wall.add(new NormalBrick(x, y, this,this.table));
                x += 50;
            } else if ((i >= 16 * 5) && (i < 16 * 9)) {
                wall.add(new HarderBrick(x, y, this,this.table));
                x += 50;
            } else {
                wall.add(new HardestBrick(x, y, this,this.table));
                x += 50;
            }

        }
    }

    private void lavel3Wall() {
        int x = 0;
        int y = 30;
        int factor = 0;
        for (int i = 0; i < 176; i++) {
            if (i % 16 == 0) {
                if (i / 16 < 6 && i != 0) {
                    factor++;
                } else if (i != 0) {
                    factor--;
                }
                y += 15;
                x = 0;
            }
            if (i % 16 >= 7 - factor && i % 16 <= 8 + factor) {
                wall.add(new HardestBrick(x, y, this,this.table));
                x += 50;
            } else {
                wall.add(new NormalBrick(x, y, this,this.table));
                x += 50;
            }

        }
    }
}
