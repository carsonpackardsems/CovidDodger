import java.awt.Color;
import java.awt.Graphics;

public class Covid_Connor extends GameObject{
	boolean up;
	boolean down;
	boolean left;
	boolean right;
	
	Covid_Connor(int x, int y, int width, int height) {
		super(x, y, width, height);
		up = false;
		down = false;
		left = false;
		right = false;
	GameObject.speed = 10;
		
		// TODO Auto-generated constructor stub
	}
	void draw(Graphics g) {
		 g.setColor(Color.BLUE);
	        g.fillRect(x, y, width, height);
	}
	
	public void update(){
		if(up == true) {
			y-=speed;
		}
		if(down == true) {
			y+=speed;
		}
		if(left == true) {
			x-=speed;
		}
		if(right == true) {
			x+=speed;
		}
	}
	
	public void up() {
	    y-=speed;
	}
	public void down() {
	    y+=speed;
	}
	public void left() {
	    x-=speed;
	}
	public void right() {
	    x+=speed;
	}{
	if(x >= 0) {
		x = 25;
	}
	if(y >= 0) {
	y = 25;
}
	if(y >= 500) {
		y = 475;
	}
	}
	}

