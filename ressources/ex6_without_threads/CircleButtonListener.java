package ex6_without_threads;

import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import javafx.event.EventHandler;
import java.util.Random;

public class CircleButtonListener implements EventHandler<MouseEvent> {


	Drawing drawing;

	public CircleButtonListener(Drawing drawing){
		super();
		this.drawing = drawing;

    }
	protected Circle createCircle() {
		Random r = new Random();
		double radius = r.nextInt(50) + 5;
		double maxX = drawing.getLayoutBounds().getMaxX();
		double maxY = drawing.getLayoutBounds().getMaxY();
		double centerX = r.nextInt((int) (maxX - 2*radius)) + radius;
		double centerY = r.nextInt((int) (maxY - 2*radius)) + radius;
		Point center = new Point(centerX, centerY);

		Color color = new Color(r.nextDouble(), r.nextDouble(), r.nextDouble(), r.nextDouble());
		Circle c = new Circle(drawing, center, radius, color);

		return c;
	}

	@Override
	public void handle(MouseEvent mouseEvent) {
		if (mouseEvent.getEventType() == MouseEvent.MOUSE_CLICKED){
			drawing.addShape(createCircle());
		}
	}
}
