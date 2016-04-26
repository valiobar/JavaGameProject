package UserInterface;

import Entities.Ball;
import Entities.Table;
import Interfaces.Displayable;
import display.Display;
import Game.Game;
import Game.GameState;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener{

    public InputHandler(Displayable display) {
        display.getCanvas().addKeyListener(this);
    }

 //   private Canvas canvas;

 //  public InputHandler(Canvas canvas) {
  //      canvas.addKeyListener(this);
  //  }

    @Override
   public void keyTyped(KeyEvent e) {

   }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_LEFT) {
          System.out.println("LEFT"); // <-- debug
            Table.goingLeft = true;
            Table.goingRight = false;
        } if (code == KeyEvent.VK_RIGHT) {
           System.out.println("RIGHT"); // <-- debug
            Table.goingRight = true;
            Table.goingLeft = false;
        }
        if (code == KeyEvent.VK_SPACE) {
            Ball.isRelease=true;
        }
        if (code == KeyEvent.VK_ESCAPE) {
         //   System.exit(0);
           if (Game.State==GameState.MainMenu){
               MainMenu.isViewHighScores=false;
           }
           else if (Game.State!= GameState.PauseMenu){
                Game.State=GameState.PauseMenu;
            }else{
                Game.State=GameState.Game;
            }

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_LEFT) {
            Table.goingLeft = false;
            Table.goingRight = false;
        } else if (code == KeyEvent.VK_RIGHT) {
            Table.goingRight = false;
            Table.goingLeft = false;
        }
    }
}
