package Interfaces;

/**
 * Created by vb on 20.4.2016 г..
 */
public interface Item extends Tickable,Renderable{
    void activate(boolean activ);
    void takeEffect();
}
