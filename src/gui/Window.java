package gui;

import blackjack.Card;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Window {
	private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 680;
    private static final Color GREEN_FELT = new Color(53, 101, 77);
    
    private JFrame frame;
    private JPanel dealerPanel;
    private JPanel playerPanel;
    
    public Window(String windowTitle) {
    	frame = new JFrame(windowTitle);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(GREEN_FELT);
       
        dealerPanel = new JPanel();
        dealerPanel.setBackground(GREEN_FELT);
        frame.add(dealerPanel, BorderLayout.NORTH);
        
        playerPanel = new JPanel();
        playerPanel.setBackground(GREEN_FELT);
        frame.add(playerPanel, BorderLayout.SOUTH);
        
        
        frame.setVisible(true);
    }
    
    
    public void loadImage(Image cardImage, Boolean dealer) {
    	JLabel cardLabel = new JLabel(new ImageIcon(cardImage.getScaledInstance(Card.CARD_WIDTH, Card.CARD_HEIGHT, Image.SCALE_FAST)));
    	cardLabel.setHorizontalAlignment(JLabel.TRAILING);
    	
    	if (dealer) {
    		dealerPanel.add(cardLabel);
    		dealerPanel.revalidate();
    		dealerPanel.repaint();
    	}
    	else {
    		playerPanel.add(cardLabel);
    		playerPanel.revalidate();
    		playerPanel.repaint();
    	}
    }


}
