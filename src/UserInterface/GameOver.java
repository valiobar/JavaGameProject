package UserInterface;

import Game.Game;
import FX.Assets;

import Interfaces.Renderable;

import java.awt.*;

/**
 * Created by vb on 14.4.2016 г..
 */
public class GameOver implements Renderable {
    public Rectangle quitButton = new Rectangle(620, 455 , 130, 53);
    public Rectangle restartButton = new Rectangle(45, 455 , 200, 53);

    public void render(Graphics graphics){
        Graphics2D graphics2D = (Graphics2D)graphics;
        graphics.drawImage(Assets.gameOver, 0, 0, 800, 600, null);
        Font fontTitle = new Font("ariel", Font.BOLD, 50);
        graphics.setFont(fontTitle);
        graphics.setColor(Color.WHITE);
        graphics.drawString("Restart", 50, 500);
        graphics.drawString("Quit", 630, 500);
//        graphics2D.draw(quitButton);
//        graphics2D.draw(restartButton);
    }
}
