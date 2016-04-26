
package Entities.BonusItems;

import Game.Game;
import Interfaces.Board;
import Interfaces.Collidable;
import Interfaces.Renderable;
import Interfaces.Tickable;


import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by vb on 20.4.2016 г..
 */
public abstract class BonusItem implements Tickable, Renderable {
    private int x;
    private int y;
    protected Board table;
    protected Rectangle boundingBox;
    private BufferedImage image;
    protected boolean isActiv = false;

    public BonusItem(int x, int y, int wigth, int hight, Board table, BufferedImage image) {
        this.x = x;
        this.y = y;
        this.boundingBox = new Rectangle(this.x, this.y, wigth, hight);
        this.table = table;
        this.image = image;
    }

    public void activate(boolean activ) {
        isActiv = activ;
    }

    @Override
    public void render(Graphics graphics) {
        if (isActiv) {
            graphics.drawImage(this.image, this.x, this.y, this.boundingBox.width, this.boundingBox.width, null);
        }
    }

    @Override
    public void tick() {
        this.boundingBox.setBounds(this.x, this.y,20,20);
        if (isActiv) {
            y += 2;

            if (this.boundingBox.intersects(this.table.getBoundingBox()) || this.table.getBoundingBox().intersects(this.boundingBox)) {
                this.takeEffect();

            }
        }
    }

    abstract void takeEffect();
}
