package Interfaces;

/**
 * Created by vb on 20.4.2016 г..
 */
public interface Brick extends Renderable,Collidable,Tickable {
     int getScore();

     int getHitPoint();

    void getHit();



}
