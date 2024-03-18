package gui;

import blackjack.Card;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Window {
	private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 680;
    private static final String DEALER_TEXT_INTRO = "Dealer total: ";
    private static final String PLAYER_TEXT_INTRO = "Player total: ";
    private static final Color GREEN_FELT = new Color(53, 101, 77);
    
    private JFrame frame;
    private JPanel dealerPanel;
    private JPanel playerPanel;
    private JLabel dealerText;
    private JLabel playerText;
    
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
    
    
    public void loadImage(Image cardImage, int dealerIdentifier) {
    	JLabel cardLabel = new JLabel(new ImageIcon(cardImage.getScaledInstance(Card.CARD_WIDTH, Card.CARD_HEIGHT, Image.SCALE_FAST)));
    	cardLabel.setHorizontalAlignment(JLabel.TRAILING);
    	
    	if (dealerIdentifier == 0) {
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
    
    
    public void displayTotal(int total, int dealerIdentifier) {
    	JLabel scoreTotal = new JLabel();
    	scoreTotal.setForeground(Color.BLACK);
    	scoreTotal.setFont(new Font("Times New Roman", Font.BOLD, 25));
    	scoreTotal.setHorizontalAlignment(JLabel.CENTER);
    	
    	
    	if (dealerIdentifier == 0) {
    		scoreTotal.setText(DEALER_TEXT_INTRO + total);
    		scoreTotal.setVerticalAlignment(JLabel.TOP);
    		dealerPanel.add(scoreTotal);
    		dealerPanel.revalidate();
    		dealerPanel.repaint();
    	}
    	else {
    		scoreTotal.setText(PLAYER_TEXT_INTRO + total);
    		scoreTotal.setVerticalAlignment(JLabel.BOTTOM);
    		playerPanel.add(scoreTotal);
    		playerPanel.revalidate();
    		playerPanel.repaint();
    	}
    }


}
