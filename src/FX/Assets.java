package FX;

import UserInterface.GUI;

import javax.sound.sampled.Clip;
import java.awt.image.BufferedImage;

public class Assets {
    public static BufferedImage background;
    public static BufferedImage paddle;
    public static BufferedImage mainManuBackground;
    public static BufferedImage ball;
    public static BufferedImage gameOver;
    public static BufferedImage brick;
    public static BufferedImage hardestBrick;
    public static BufferedImage harderBrick;
    public static BufferedImage bonusBrick;
  public static  BufferedImage bounsBall;
    public static  BufferedImage bounsExtend;
    public static Clip bounce;
    public static Clip brickBreak;
    public static Clip mainMenuThema;
    public static Clip gameOverSound;

    public static void Init() {
        background = ImageLoader.loadImage("/backgroundLevel1.jpg");
        paddle = ImageLoader.loadImage("/paddle.png");
        mainManuBackground = ImageLoader.loadImage("/mainmenu.jpg");
        ball = ImageLoader.loadImage("/ball.png");
        brick = ImageLoader.loadImage("/bricks.png");
        hardestBrick = ImageLoader.loadImage("/HardestBrick.png");
        harderBrick = ImageLoader.loadImage("/HarderBrick.png");
        bonusBrick = ImageLoader.loadImage("/BonusBrick.png");
        bounsBall =ImageLoader.loadImage("/BonusBall.png");
        bounsExtend = ImageLoader.loadImage("/Extend.png");
        gameOver = ImageLoader.loadImage("/GameOver.jpg");
        bounce = AudioLoader.loadAudio("/bounce.wav");
        brickBreak = AudioLoader.loadAudio("/brickBreak.wav");
        mainMenuThema = AudioLoader.loadAudio("/MainMenuMusic.wav");
        gameOverSound = AudioLoader.loadAudio("/GameOverVader.wav");
    }

    public static BufferedImage getBackground() {
        switch (GUI.getInstance().getLevel() % 3) {
            case 0:
                background = ImageLoader.loadImage("/backgroundLevel1.jpg");
                break;
            case 1:
                background = ImageLoader.loadImage("/backgroundLevel2.png");
                break;
            case 2:
                background = ImageLoader.loadImage("/backgroundLevel3.png");
                break;
        }
        return background;
    }
}
