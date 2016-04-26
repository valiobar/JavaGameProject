package display;

import Game.Game;
import Interfaces.Displayable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Display implements Displayable {

    private Canvas canvas;
    private JFrame frame;
    private JPanel namePanel;
    private JTextField nameText;
    private JFrame nameFrame;
    private JLabel nameLabel = new JLabel("Enter Your Name");

    public Display(String name, int width, int height) {
        this.frame = new JFrame(name);
        this.frame.setPreferredSize(new Dimension(width, height));
        this.frame.setMaximumSize(new Dimension(width, height));
        this.frame.setMinimumSize(new Dimension(width, height));
        this.frame.setVisible(true);
        this.frame.setFocusable(true);
        this.frame.setResizable(false);
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.frame.setLocationRelativeTo(null); // - Set window in center.
        nameFrame = new JFrame();
        nameFrame.setPreferredSize(new Dimension(200, 100));
        nameFrame.setMaximumSize(new Dimension(200, 100));
        nameFrame.setMinimumSize(new Dimension(200, 100));
        nameFrame.setFocusable(true);
        nameFrame.setLocationRelativeTo(null);
        nameFrame.setVisible(true);
        namePanel = new JPanel();
        nameText = new JTextField(15);
        nameText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game.PlayerName=nameText.getText();
              nameFrame.setVisible(false);
            }
        });
        namePanel.setVisible(true);
        namePanel.add(nameText);
        namePanel.add(nameLabel);
        nameFrame.add(namePanel);
        this.canvas = new Canvas();
        this.canvas.setPreferredSize(new Dimension(width, height));
        this.canvas.setMaximumSize(new Dimension(width, height));
        this.canvas.setMinimumSize(new Dimension(width, height));
        this.canvas.setFocusable(true);
        this.frame.add(this.canvas);    // - Add the canvas into the frame

        this.frame.pack();  // - Pack the frame to ensure visibility

    }

    public Canvas getCanvas() {
        return canvas;
    }


}
