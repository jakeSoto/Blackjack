import javax.swing.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

public class Window extends JFrame implements KeyListener {
    static final int WINDOW_WIDTH = 800;
    static final int WINDOW_HEIGHT = 680;
    static final String IMAGES_FOLDER = "./images/";
    static final Color GREEN = new Color(53, 101, 77);

    private JFrame frame;
    private JLabel dealerText;
    private JLabel playerText;
    private JPanel dealerPanel;
    private JPanel playerPanel;
    private JPanel cardPanel = new JPanel();


    public Window(String windowTitle) {
        frame = new JFrame(windowTitle);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(GREEN);
        frame.addKeyListener(this);
        initializeDealer();
        //initializePlayer();
        frame.setVisible(true);
    }

    private void initializeDealer() {
        // dealerText = new JLabel();
        // dealerText.setBackground(GREEN);
		// dealerText.setForeground(Color.BLACK);
		// dealerText.setFont(new Font("Times New Roman", Font.BOLD,25));
		// dealerText.setHorizontalAlignment(JLabel.LEFT);
		// dealerText.setText("Dealer Showing: 0");
		// dealerText.setOpaque(true);

        dealerPanel = new JPanel();
        dealerPanel.setLayout(new GridLayout(1,5, 2, 0));
        //dealerPanel.setBounds(0,0,800,200);
        //dealerPanel.add(dealerText);
        frame.add(dealerPanel, BorderLayout.NORTH);
    }

    private void initializePlayer() {
        // playerText = new JLabel();
        // playerText.setBackground(GREEN);
		// playerText.setForeground(Color.BLACK);
		// playerText.setFont(new Font("Times New Roman", Font.BOLD,25));
		// playerText.setHorizontalAlignment(JLabel.LEFT);
		// playerText.setText("Player Showing: 0");
		// playerText.setOpaque(true);

        playerPanel = new JPanel();
        playerPanel.setLayout(new GridLayout(1,5, 2, 0));
        //playerPanel.setBounds(0,1,800,200);
        //playerPanel.add(playerText);
        frame.add(playerPanel, BorderLayout.SOUTH);
    }

    public void displayCard(Image cardImage, boolean dealer) {
        if (dealer) {
            dealerPanel.add(new JLabel(new ImageIcon(cardImage)));
        } else {
            playerPanel.add(new JLabel(new ImageIcon(cardImage)));
        }
    }

    public void setDealerText(String text) {
        dealerText.setText(text);
    }

    public void setPlayerText(String text) {
        playerText.setText(text);
    }

    // public void addDealerCard(Image cardImage) {
    //     JLabel cardLabel = new JLabel(new ImageIcon(cardImage.getScaledInstance(110, 140, Image.SCALE_REPLICATE)));
    //     cardLabel.setBackground(GREEN);
    //     cardLabel.setHorizontalAlignment(JLabel.LEFT);
    //     cardLabel.setVerticalAlignment(JLabel.BOTTOM);
    //     cardLabel.setOpaque(true);
    //     dealerPanel.add(cardLabel);
    // }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case 32:
                System.out.println("Hit");
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
