import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Window {
    static final int BOARD_WIDTH = 800;
    static final int BOARD_HEIGHT = 680;
    static final String IMAGES = "./images/";

    private JFrame frame;
    private JPanel gamePanel;


    public Window(String windowTitle) {
        // Window properties
        frame = new JFrame(windowTitle);
        frame.setSize(BOARD_WIDTH, BOARD_HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Background panel
        gamePanel = new JPanel();
        gamePanel.setLayout(new BorderLayout());
        gamePanel.setBackground(new Color(53, 101, 77));
        frame.add(gamePanel);
    }


    public void displayCard(Image cardImage, int xCoord, int yCoord) {
        JPanel card = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);

                g.drawImage(cardImage, xCoord, yCoord, Card.CARD_WIDTH, Card.CARD_HEIGHT, null);
            }
        };
        frame.add(card);
        card.repaint();
    }


    public void generateButtons() {
        JPanel buttonPanel = new JPanel();
        JButton hitButton = new JButton("Hit");
        JButton stayButton = new JButton("Stay");

        hitButton.setFocusable(false);
        buttonPanel.add(hitButton);
        stayButton.setFocusable(false);
        buttonPanel.add(stayButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);
    }

}
