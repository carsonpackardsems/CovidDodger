
import java.awt.Graphics;

import javax.swing.JFrame;

public class CovidFighters {
	JFrame frame;
	public static final int WIDTH = 800;
	public static final int HEIGHT = 500;
	GamePanel GP = new GamePanel();

	CovidFighters() {
		frame = new JFrame();
	}

	void setup() {
		frame.add(GP);
		frame.addKeyListener(GP);
		frame.setVisible(true);
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		CovidFighters LI = new CovidFighters();
		LI.setup();
	}

}
