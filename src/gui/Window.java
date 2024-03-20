package gui;

import blackjack.Card;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Window implements KeyListener {
	private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 680;
    private static final String DEALER_TEXT_INTRO = "Dealer total: ";
    private static final String PLAYER_TEXT_INTRO = "Player total: ";
    private static final Color GREEN_FELT = new Color(53, 101, 77);

    private JFrame frame;
    private JPanel dealerPanel;
    private JPanel playerPanel;
    private JLabel actionLabel;
    private JLabel dealerLabel;
    private JLabel playerLabel;
    
    private volatile int keyCode;
    
    
    public Window() {
    	frame = new JFrame("Blackjack");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(GREEN_FELT);
        frame.setIconImage(new ImageIcon(getClass().getResource("/resources/LOGO.jpg")).getImage());
    }
    
    public void clearPanels() {
    	dealerPanel.removeAll();
    	dealerPanel.revalidate();
		dealerPanel.repaint();
		
    	dealerLabel.removeAll();
    	dealerLabel.revalidate();
    	dealerLabel.repaint();
    	
    	playerPanel.removeAll();
    	playerPanel.revalidate();
    	playerPanel.repaint();
		
    	playerLabel.removeAll();
    	playerLabel.revalidate();
    	playerLabel.repaint();
    	
    	frame.remove(actionLabel);
    }
    
    
    
    public void initializeWindow() {
        /* Dealer card images and dealer total */
        dealerPanel = new JPanel();
        dealerPanel.setBackground(GREEN_FELT);
        frame.add(dealerPanel, BorderLayout.NORTH);
        
        dealerLabel = new JLabel();
        dealerLabel.setBackground(GREEN_FELT);
        dealerLabel.setForeground(Color.BLACK);
        dealerLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
        dealerLabel.setOpaque(true);
        dealerPanel.add(dealerLabel);
        
        
        /* Player card images and player total */
        playerPanel = new JPanel();
        playerPanel.setBackground(GREEN_FELT);
        frame.add(playerPanel, BorderLayout.SOUTH);
        
        playerLabel = new JLabel();
        playerLabel.setBackground(GREEN_FELT);
        playerLabel.setForeground(Color.BLACK);
        playerLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
        playerLabel.setOpaque(true);
        playerPanel.add(playerLabel);

        
        /* Game manager action section */
        actionLabel = new JLabel();
        actionLabel.setBackground(GREEN_FELT);
        actionLabel.setForeground(Color.BLACK);
        actionLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
        actionLabel.setHorizontalAlignment(JLabel.CENTER);
        actionLabel.setText("");
        frame.add(actionLabel, BorderLayout.CENTER);
        
        frame.setVisible(true);
    }
    
    
    public void flipDealerCard(Image[] cardImages, int handTotal) {
    	dealerPanel.removeAll();
    	dealerPanel.add(dealerLabel);
    	dealerPanel.revalidate();
		dealerPanel.repaint();
    	
    	for (int i = 0; i < cardImages.length; i++) {
			displayImage(cardImages[i], 0);
		}
    	
		displayTotal(handTotal, 0);
    }
    
    
    public void displayImage(Image cardImage, int dealerIdentifier) {
    	JLabel cardLabel = new JLabel(new ImageIcon(cardImage.getScaledInstance(Card.CARD_WIDTH, Card.CARD_HEIGHT, Image.SCALE_FAST)));
    	cardLabel.setHorizontalAlignment(JLabel.TRAILING);
    	cardLabel.setVerticalAlignment(JLabel.BOTTOM);
    	
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
    	if (dealerIdentifier == 0) {
    		dealerLabel.setText(DEALER_TEXT_INTRO + total);
    	}
    	else {
    		playerLabel.setText(PLAYER_TEXT_INTRO + total);
    	}
    }
    
    
    public void displayActionText(String text) {
    	actionLabel.setText(text);
    	actionLabel.revalidate();
    	actionLabel.repaint();
    }
    
    
    public int getKeyCode() {
    	frame.addKeyListener(this);
    	keyCode = -1;
    	
    	while (keyCode == -1) {
    		// do nothing
    	}
    	return keyCode;
    }



	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		this.keyCode = e.getKeyCode();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


}
