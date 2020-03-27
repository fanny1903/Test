package Exo_6;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Random;

public class Square extends Shape implements Runnable{


    static Random r = new Random();

    private Rectangle sq;
    private double length;
    private Thread t;

    public Square(Drawing d, Point origin, double length, Color color){
        super(d, origin);
        Random r = new Random();
        this.length = length;
        this.color = color;
        this.hDirection = r.nextInt(2)+1;
        this.vDirection = r.nextInt(2)+3;
        sq = new Rectangle();
        sq.setHeight(length);
        sq.setWidth(length);
        sq.setX(origin.getX());
        sq.setY(origin.getY());
        sq.setFill(color);

        t = new Thread(this);
        t.start();

    }


    @Override
    public void setOrigin(Point point) {
        origin.setX(point.getX());
        origin.setY(point.getY());
    }

    public boolean isOn(Point p) {
       return origin.getX() < p.getX() && p.getX() < origin.getX() + length &&
                origin.getY() < p.getY() && p.getY() < origin.getY() + length ;

    }


    public boolean touchLine(int yl){
        return origin.getY() < yl && yl < origin.getY() + length ;
    }

    public void move() {
        if(vDirection == UP)
        {
            origin.setY(origin.getY() - 1);
        }
        else if(vDirection == DOWN)
        {
            origin.setY(origin.getY() + 1);
        }
    }

    private double distanceToCenter(Point p){
        return this.origin.distance(p);
    }

    public Node getShape() {
        return sq;
    }

    public void update() {
        sq.setY(origin.getY());
        sq.setX(origin.getX());
    }

    @Override
    public void run() {
        while(true) {
            if (bottomLeft == null) {
                computeBounds();
            }
            if (this.touchLine((int)topLeft.y)) {
                vDirection = Shape.DOWN;
            } else if (this.touchLine((int)bottomLeft.y)) {
                vDirection = Shape.UP;
            }

            move();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

