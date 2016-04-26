package Game;

import Entities.Ball;
import Entities.BrickWall;
import Entities.Table;
import Interfaces.*;
import UserInterface.*;
import com.sun.org.apache.regexp.internal.RE;
import display.Display;
import FX.Assets;


import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;

public class Game implements Runnable {
    public static GameState State = GameState.MainMenu;
    public static String PlayerName;
    public static HighScores highScores;
    private int width, height;
    private static Board table;
    private static boolean restart = false;
    private Thread thread;
    private String title;
    private boolean isRunning;
    private MouseListener mouseInput;
    private KeyListener inputHandler;
    private Displayable display;
    private BufferStrategy bufferStrategy;
    private Graphics graphics;
    private GameBall ball;
    private Wall wall;
    private Image background;
    private Renderable mainMenu;
    private Renderable pauseMenu;
    private Renderable gameOver;

    public Game(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;

    }

    public void init() {
        Assets.Init();
        this.display = new Display(this.title, this.width, this.height);
        this.inputHandler = new InputHandler(this.display);
        this.mouseInput = new MouseInput(this.display);
        this.background = Assets.getBackground();
        table = new Table();
        wall = new BrickWall(this.table);
        wall.fillWall();
        ball = new Ball(this.table, this.wall);
        this.mainMenu = new MainMenu();
        this.pauseMenu = new PauseMenu();
        this.gameOver = new GameOver();
        this.highScores = new HighScores();
        Assets.mainMenuThema.setFramePosition(0);
        Assets.mainMenuThema.loop(3);
        //  highScores=new HighScores();
    }

    public void tick() {
        changeLevel();
        if (State == GameState.Game) {
            if (restart) {
                this.background = Assets.getBackground();
                this.wall.fillWall();
                this.ball = new Ball(table, wall);
                restart = false;
            }
            table.tick();
            ball.tick();
            wall.tick();
            GUI.getInstance().tick();
        }

    }

    public void render() {
        this.bufferStrategy = this.display.getCanvas().getBufferStrategy();
        if (this.bufferStrategy == null) {
            this.display.getCanvas().createBufferStrategy(2); //    - test 1 or 3 for best work
            this.bufferStrategy = this.display.getCanvas().getBufferStrategy();
        }
        this.graphics = this.bufferStrategy.getDrawGraphics();
        this.graphics.clearRect(0, 0, this.width, this.height);
        if (State == GameState.Game || State == GameState.PauseMenu) {
            this.graphics.drawImage(this.background, 0, 0, this.width, this.height, null);
            table.render(graphics);
            ball.render(graphics);
            wall.render(graphics);
            GUI.getInstance().render(graphics);
            if (State == GameState.PauseMenu) {
                pauseMenu.render(graphics);
            }
        } else if (State == GameState.MainMenu) {
            mainMenu.render(graphics);
        } else if (State == GameState.GameOver) {
            gameOver.render(graphics);
        }
        this.graphics.dispose();
        this.bufferStrategy.show();
    }

    @Override   // - "implements Runnable" - Creating Threads and Loops
    public void run() {
        this.init();
        int fps = 30;
        double timePerTick = 1_000_000_000.0 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        while (isRunning) {
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if (delta >= 1) {
                tick();
                render();
                ticks++;
                delta--;
            }

            if (timer >= 1_000_000_000) {
                ticks = 0;
                timer = 0;
            }
        }
        this.stop();
    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        this.isRunning = true;
    }

    public synchronized void stop() {
        try {
            this.isRunning = false;
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void restart() {
        GUI.getInstance().Reset();
        table = new Table();
        Ball.isRelease = false;
        restart = true;

        State = GameState.Game;
    }

    private void changeLevel() {
        if (this.wall.getWall().size() <= 0) {
            GUI.getInstance().setLevel();
            if (GUI.getInstance().getLevel() % 3 == 0) {
                this.ball.changeSpeed();
            }
            table.setMidPosition();
            this.ball.stickToBoard();
            this.wall.fillWall();
            this.ball.setTable(table);
            this.ball.setWall(wall);
            this.background = Assets.getBackground();
            Ball.isRelease = false;
        }
    }
}
