package UserInterface;

import Game.Game;
import FX.Assets;

import Interfaces.Renderable;

import javax.swing.*;
import java.awt.*;
import java.util.Collections;

/**
 * Created by vb on 14.4.2016 г..
 */
public class MainMenu implements Renderable {
    public static boolean isViewHighScores = false;
    private Color transparentBlue = new Color(0f, 0f, 1f, .75f);
    private Rectangle playButton = new Rectangle(350,275, 100, 50);
    private Rectangle highScore = new Rectangle(320,375,185, 50);
    private Rectangle quitButton = new Rectangle(350, 475, 100, 50);

    public void render(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics.drawImage(Assets.mainManuBackground, 0, 0, 800, 600, null);
        Font fontTitle = new Font("ariel", Font.BOLD, 50);
        graphics.setFont(fontTitle);
        graphics.setColor(Color.WHITE);
        graphics.drawString("Space Arkanoid", 220, 200);
        Font fontButtons = new Font("ariel", Font.BOLD, 30);
        graphics.setFont(fontButtons);
        graphics.drawString("Play", playButton.x + 20, playButton.y + 35);
        graphics.drawString("HighScore", highScore.x + 20, highScore.y + 35);
        graphics.drawString("Quit", quitButton.x + 20, quitButton.y + 35);

        graphics2D.draw(playButton);
        graphics2D.draw(highScore);
        graphics2D.draw(quitButton);
      if (isViewHighScores) {
          this.highScoresMenu(graphics);
      }
    }

    private void highScoresMenu(Graphics graphics) {
       int y = 155;
        graphics.setColor(transparentBlue);
        graphics.fillRect(200, 100, 400, 320);
        Font fontTitle = new Font("ariel", Font.BOLD, 15);
        graphics.setFont(fontTitle);
        graphics.setColor(Color.WHITE);

   for (String str :Game.highScores.output() ) {
           graphics.drawString(str,320,y);
            y+=20;
        }
        Font fontInfo = new Font("ariel", Font.BOLD, 20);
        graphics.setFont(fontInfo);
        graphics.setColor(Color.WHITE);
        graphics.drawString("Press ESC Key to resume", 280, 400);
    }

}
