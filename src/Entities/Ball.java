package Entities;

import Interfaces.*;
import UserInterface.GUI;
import FX.Assets;

import java.awt.*;


/**
 * Created by vb on 11.4.2016 г..
 */
public class Ball implements GameBall, Tickable, Renderable {
    private float x, y, directionX, directionY;
    private static float speed = 15;
    private float velocityX, velocityY;
    private double velocityCorrection;
    private Rectangle boundingBox;
    private Wall wall;
    public static boolean isRelease = false;
    private Board table;
    private boolean isBounced = false;
    private long timer;

    public Ball(Board table, Wall wall) {
        this.table = table;
        this.x = table.getRectX() + 40;
        this.y = table.getRectY() - 20;
        this.velocityX = (float) Math.sqrt((speed * speed) / 2);
        this.velocityY = (float) Math.sqrt((speed * speed) / 2);
        this.directionX = 1;
        this.directionY = -1;
        this.timer = System.nanoTime();
        this.wall = wall;
        boundingBox = new Rectangle((int) this.x, (int) this.y, 20, 20);
    }


    public void setWall(Wall wall) {
        this.wall = wall;
    }

    public void setTable(Board table) {
        this.table = table;
    }

    public void tick() {

        bounceOfBrick();
        if (!isRelease) {
            this.x = table.getRectX() + 40;
            this.y = table.getRectY() - 20;
        } else {
            bounceOfTable();
            fall();
            this.x += velocityX * directionX;
            this.y += velocityY * directionY;

            if ((x >= 790) || (x <= 0)) {
                isBounced = false;

                directionX *= -1;
            }
            if ((y < 0)) {
                isBounced = false;
                directionY = -1 * directionY;
            }

        }
        this.boundingBox.setBounds((int) this.x, (int) this.y, 20, 20);
    }

    public void render(Graphics graf) {
        graf.drawImage(Assets.ball, (int) this.x, (int) this.y, 20, 20, null);
    }


    private void bounceOfTable() {
        if (this.boundingBox.intersects(table.getBoundingBox()) || table.getBoundingBox().intersects(this.boundingBox)) {
            velocityCorrection = Math.abs((this.boundingBox.getMinX() + 10) -
                    (this.table.getBoundingBox().getMinX() + this.table.getRectWidth() / 2));
            if (!isBounced) {
                Assets.bounce.setFramePosition(0);
                Assets.bounce.loop(0);
                System.out.println(speed);

                if (velocityCorrection >= 35) {
                    angle30(speed);
                } else if (velocityCorrection < (0.35 * table.getRectWidth()) && velocityCorrection > table.getRectWidth() / 5) {
                    angle45(speed);
                } else if (velocityCorrection <= table.getRectWidth() / 5 && velocityCorrection > table.getRectWidth() / 20) {
                    angle60(speed);
                } else if (velocityCorrection <= table.getRectWidth() / 20) {
                    angle75(speed);
                }
                directionY = -1 * directionY;
                isBounced = true;
            }
        }
    }

    private void bounceOfBrick() {
        for (Brick brick : this.wall.getWall()) {
            if (this.boundingBox.intersects(brick.getBoundingBox()) || brick.getBoundingBox().intersects(this.boundingBox)) {
                isBounced = false;
                if (System.nanoTime() - timer > 600) {
                    Assets.brickBreak.setFramePosition(0);
                    Assets.brickBreak.loop(0);
                    brick.getHit();
                    GUI.getInstance().setScores(brick.getScore());
                    directionY *= -1;
                    // angle45(speed);
                    timer = System.nanoTime();
                }
            }
        }
    }

    private void fall() {
        if (y > 620) {
            isRelease = false;
            this.directionX = 1;
            this.directionY = -1;
            GUI.getInstance().setBalls();
        }
    }

    private void angle30(float speed) {
        velocityX = (float) Math.sqrt((speed * speed) / 1.33333);
        velocityY = (float) ((Math.sqrt(3) * velocityX) / 3);
    }

    private void angle60(float speed) {
        velocityX = (float) Math.sqrt((speed * speed) / 4);
        velocityY = (float) Math.sqrt(3) * velocityX;
    }

    private void angle45(float speed) {
        velocityX = (float) Math.sqrt((speed * speed) / 2);
        velocityY = (float) Math.sqrt((speed * speed) / 2);
    }

    private void angle90(float speed) {
        velocityX = 0;
        velocityY = speed;
    }

    private void angle75(float speed) {
        velocityX = (float) Math.sqrt((speed * speed) / 14.9281);
        velocityY = (float) 3.7320 * velocityX;
    }

    public void changeSpeed() {
        speed = 15 + (GUI.getInstance().getLevel() / 3) * 5;
    }

    public void stickToBoard() {
        this.x = table.getRectX() + 40;
        this.y = table.getRectY() - 20;
    }
}
