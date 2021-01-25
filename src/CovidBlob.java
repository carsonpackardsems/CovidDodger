import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class CovidBlob extends GameObject{

	CovidBlob(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 5;
		// TODO auto-generated constructor stub
	}
	public void update() {
		x-=speed;
		Random ran = new Random();
		if(x == 25) {
			x = 825;
			y = ran.nextInt(500);
			GamePanel.timesDodged++;
		}
	}
	void draw(Graphics g) {
		   g.setColor(Color.RED);
	        g.fillOval(x, y, width, height);
	}
}
