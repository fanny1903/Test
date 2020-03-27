package ex6_corrige;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Random;

public class Square extends Shape implements Runnable{

	double size;
	private Rectangle rec;
	private Thread t;
	int vDirection = Shape.UP;

	public Square(Drawing drawing, Point origin, double size, Color color){
		super(drawing,  origin);
		Random r = new Random();
		this.size = size;
		this.color = color;
		this.vDirection = r.nextInt(2)+3;

		rec = new Rectangle();
		rec.setX(0);
		rec.setY(0);
		rec.setHeight(size);
		rec.setWidth(size);
		rec.setFill(color);
		t = new Thread(this);
		t.start();
	}

	public boolean isOn(Point p) {
		return (origin.getY() < p.getY() && origin.getY() + size > p.getY()
				&& origin.getX() < p.getX() && origin.getX() + size > p.getY());
	}


	@Override
	public void update() {
	    rec.setY(origin.getY());
		rec.setX(origin.getX());
	}

	@Override
	public Node getShape() {
		return rec;
	}


	public void setOrigin(Point p){
		origin.y = p.y;
	}

	public boolean touchHorizontalLine(double y1){
		double y0 = origin.getY();
		boolean res = false;

		if (y1 > y0 ) {
			// top border
			res = y1 <y0 + size;
		}
		else if (y1 < y0+size){
			res = y1 > y0;
		}
		if (res){
			System.out.println(res);
		}
		return res;
	}

	public void move()
	{		
		if(vDirection == UP)
		{
			origin.setY(origin.getY() - 1);
		}
		else if(vDirection == DOWN)
		{
			origin.setY(origin.getY() + 1);
		}
	}


	public void run(){
		if (bottomLeft == null) {
			computeBounds();
		}
		while(true)
		{
			if(this.touchHorizontalLine(topLeft.getY())){
				vDirection = DOWN;
			}
			else if(touchHorizontalLine(bottomLeft.getY())){
				vDirection = UP;
			}

			move();
			try{
				Thread.sleep(20);
			}
			catch(InterruptedException e) {}
		}
	}
}
