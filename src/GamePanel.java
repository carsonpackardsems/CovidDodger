import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
//NO.
public class GamePanel extends JPanel 
implements ActionListener, KeyListener{
	Font titleFont;
	Font smallText;
	Font smallerText;
	Timer frameDraw;
	Covid_Connor Connor;
	int timesHit= 0;
	boolean end = false;
	boolean success = false;
	int tier = 0;
	int timesDodged = 0;
	GamePanel(){
	titleFont = new Font("Arial",Font.PLAIN,48);
	smallText = new Font("Arial",Font.PLAIN, 20);
	smallerText = new Font("Arial", Font.PLAIN, 15);
	frameDraw = new Timer(1000/60, this);
	Connor = new Covid_Connor(250, 250, 50, 50);
	frameDraw.start();
	}
	@Override
	public void paintComponent(Graphics g) {
		if (currentState == MENU) {
			drawMenuState(g);
		} else if (currentState == GAME) {
			drawGameState(g);
		} else if (currentState == END) {
			drawEndState(g);
		}
	}

	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = MENU;

	void updateMenuState() {

	}

	void updateGameState() {
		Connor.update();
	}

	void updateEndState() {

	}
	
	if(timesDodged == 33) {
		tier = 1;
	}else if(timesDodged == 66) {
		tier = 2;
	}else if(timesDodged == 100) {
		success = true;
	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, CovidFighters.WIDTH, CovidFighters.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("COVID FIGHTERS", 25, 75);
		g.setFont(smallText);
		g.setColor(Color.YELLOW);
		g.drawString("Press ENTER to start", 125, 250);
		g.setFont(smallText);
		g.setColor(Color.YELLOW);
		g.drawString("Press SPACE for instructions", 100, 400);
	}

	void drawGameState(Graphics g) {
		if(tier == 0) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, CovidFighters.WIDTH, CovidFighters.HEIGHT);
		Connor.draw(g);
	}else if(tier == 1) {
		g.setColor(Color.ORANGE);
		g.fillRect(0, 0, CovidFighters.WIDTH, CovidFighters.HEIGHT);
	}else if(tier == 2) {
		g.setColor(Color.MAGENTA);
		g.fillRect(0, 0, CovidFighters.WIDTH, CovidFighters.HEIGHT);
	}
		

	void drawEndState(Graphics g) {
		if(success == false) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, CovidFighters.WIDTH, CovidFighters.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.BLACK);
		g.drawString("Game Over", 105, 75);
		g.setFont(smallerText);
		g.setColor(Color.BLACK);
		g.drawString("You have killed (enemy variable here) enemies." , 100, 250);
		g.setFont(smallerText);
		g.setColor(Color.BLACK);
		g.drawString("Press ENTER to restart", 125, 400);
		}
		else {
			g.setColor(Color.GREEN);
			g.fillRect(0, 0, CovidFighters.WIDTH, CovidFighters.HEIGHT);
			g.setFont(titleFont);
			g.setColor(Color.BLACK);
			g.drawString("YOU WIN!", 105, 75);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(currentState == MENU){
		    updateMenuState();
		}else if(currentState == GAME){
		    updateGameState();
		}else if(currentState == END){
		    updateEndState();
		}
		//System.out.println("action");
		repaint();
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
		    if (currentState == END) {
		        currentState = MENU;
		    } else {
		        currentState++;
		    }
		}   
		if (e.getKeyCode()==KeyEvent.VK_SPACE) {
		    if (currentState == MENU) {
		      JOptionPane.showMessageDialog(null, "Your name is now Connor.");
		      JOptionPane.showMessageDialog(null, "Yes, your name is Connor, now deal with it.");
		      JOptionPane.showMessageDialog(null, "Use the arrow keys to dodge the COVID that come from the right side of the screen.");
		      JOptionPane.showMessageDialog(null, "You have to make it through the yellow tier, the orange tier, and the purple tier to win.");
		      JOptionPane.showMessageDialog(null, "If you get hit three times, you are 100% infected, and the game is over.");
		      JOptionPane.showMessageDialog(null, "Good Luck!");
		      JOptionPane.showMessageDialog(null, "Cough, cough (You'll need it.)");
		    }
		    }  
		if (e.getKeyCode()==KeyEvent.VK_UP) {
			Connor.up = true;
		}if (e.getKeyCode()==KeyEvent.VK_DOWN) {
		    Connor.down = true;
		}if(e.getKeyCode()==KeyEvent.VK_LEFT)   { 
		    Connor.left = true;
		}if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
			Connor.right = true;
		}
		
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode()==KeyEvent.VK_UP) {
			Connor.up = false;
		}if (e.getKeyCode()==KeyEvent.VK_DOWN) {
		    Connor.down = false;
		}if(e.getKeyCode()==KeyEvent.VK_LEFT)   { 
		    Connor.left = false;
		}if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
			Connor.right = false;
		}
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}



}