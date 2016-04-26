package Interfaces;

import java.awt.*;

/**
 * Created by vb on 20.4.2016 г..
 */
public interface Board extends Collidable, Tickable, Renderable {
    int getRectX();

    int getRectY();

    int getRectWidth();

    void setMidPosition();

    void setRectWidth(int rectWidth);
}
