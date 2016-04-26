package UserInterface;

import Interfaces.Displayable;
import display.Display;
import Game.Game;
import Game.GameState;
import FX.Assets;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by vb on 14.4.2016 г..
 */
public class MouseInput implements MouseListener {
    public MouseInput(Displayable display) {
        display.getCanvas().addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }
    @Override
    public void mousePressed(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();
        //Play
        if (Game.State == GameState.MainMenu) {
            if (mouseX >350 && mouseX < 450) {
                if (mouseY > 275 && mouseY < 325) {
                    Game.State = GameState.Game;
                    Assets.mainMenuThema.stop();
                }
            }
            if (mouseX > 320 && mouseX < 505) {
                if (mouseY > 375 && mouseY < 425) {
                   MainMenu.isViewHighScores=true;
                }
            }
            //Quit
            if (mouseX > 350 && mouseX < 450) {
                if (mouseY > 475 && mouseY < 525) {
                    System.exit(0);
                }
            }
        } else if (Game.State == GameState.PauseMenu) {
            if (mouseX > 350 && mouseX < 450) {
                if (mouseY > 300 && mouseY < 350) {
                    System.exit(0);
                }
            }
        }
        else if (Game.State == GameState.GameOver) {
            if (mouseX > 620 && mouseX < 750) {
                if (mouseY > 455 && mouseY < 508) {
                    System.exit(0);
                }
            }

            if (mouseX > 45 && mouseX < 245) {
                if (mouseY > 455 && mouseY < 508) {
                    Game.restart();

                }
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
