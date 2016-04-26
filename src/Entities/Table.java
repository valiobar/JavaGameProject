package Entities;

import FX.Assets;
import Interfaces.Board;
import Interfaces.Collidable;
import Interfaces.Renderable;
import Interfaces.Tickable;

import java.awt.*;

public class Table implements Collidable, Tickable, Renderable, Board{
    private int rectX, rectY, rectWidth, rectHeight, velocity;
     private Rectangle boundingBox;
    public static boolean goingLeft;
    public static boolean goingRight;


    public Table() {
        this.rectX = 350;
        this.rectY = 550;
        this.rectWidth = 100;
        this.rectHeight = 20;
        this.velocity = 20;
         boundingBox=new Rectangle(this.rectX,this.rectY,this.rectWidth,this.rectHeight);
        goingLeft = false;
        goingRight = false;
    }

    public void tick() {
        this.boundingBox.setBounds(this.rectX, this.rectY, this.rectWidth, this.rectHeight);
        if (goingLeft && this.rectX > 0) { // 00000000000000000
//            System.out.println("left"); // <-- debug
            this.rectX -= this.velocity;
        //    System.out.println(this.rectX); // <-- debug
        } else if (goingRight && this.rectX < 700) {  // 0000000000000
//            System.out.println("right"); // <-- debug
            this.rectX += this.velocity;
         //   System.out.println(this.rectX); // <-- debug
        }
        this.boundingBox.setBounds(this.rectX, this.rectY, this.rectWidth, this.rectHeight);
    }

    public void render(Graphics graphics) {
        graphics.drawImage(Assets.paddle, this.rectX, this.rectY, this.rectWidth, this.rectHeight, null);

    }

    public int getRectX() {
        return rectX;
    }

    public Rectangle getBoundingBox() {
        return boundingBox;
    }

    public int getRectY() {
        return rectY;
    }

    public int getRectWidth() {
        return rectWidth;
    }

    public void setRectWidth(int rectWidth) {
        this.rectWidth = rectWidth;
    }
    public void setMidPosition(){
        this.rectX = 350;
        this.rectY = 550;
    }
}
