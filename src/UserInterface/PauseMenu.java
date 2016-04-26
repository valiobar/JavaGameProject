package UserInterface;
import Interfaces.Renderable;

import java.awt.*;

/**
 * Created by vb on 14.4.2016 г..
 */
public class PauseMenu implements Renderable {
    public Rectangle quitButton = new Rectangle(350,300, 100, 50);
    private Color transparentBlue = new Color(0f,0f,1f,.75f);

    public void render(Graphics graphics){
        Graphics2D graphics2D = (Graphics2D)graphics;
        graphics.setColor(transparentBlue);
        graphics.fillRect(200,100,400,300);
        Font fontTitle = new Font("ariel", Font.BOLD, 50);
        graphics.setFont(fontTitle);
        graphics.setColor(Color.WHITE);
        graphics.drawString("PAUSE", 320,175);
        Font fontInfo = new Font("ariel", Font.BOLD, 20);
        graphics.setFont(fontInfo);
        graphics.setColor(Color.WHITE);
        graphics.drawString("Press ESC Key to resume", 280,225);
         graphics2D.draw(quitButton);
        Font fontButton = new Font("ariel", Font.BOLD, 30);
        graphics.setFont(fontButton);
        graphics.drawString("Quit",quitButton.x+20,quitButton.y+35);
    }
}
