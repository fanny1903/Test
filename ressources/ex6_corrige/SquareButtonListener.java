package ex6_corrige;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.util.Random;

public class SquareButtonListener implements EventHandler<MouseEvent> {
    private Drawing drawing;

	public SquareButtonListener(Drawing drawing){
		this.drawing = drawing;
	}
	
	protected Shape createSquare() {
		Random r = new Random();

		double size = r.nextInt(50) + 5;
		double maxX = drawing.getLayoutBounds().getMaxX();
		double maxY = drawing.getLayoutBounds().getMaxY();

		double centerX = r.nextInt((int) (maxX - size));
		double centerY = r.nextInt((int) (maxY - size));
		Point center = new Point(centerX, centerY);

		Color color = new Color(r.nextDouble(), r.nextDouble(), r.nextDouble(), r.nextDouble());
		Square sq = new Square(drawing, center, size, color);

		return sq;
	}

	@Override
	public void handle(MouseEvent mouseEvent) {
		drawing.addShape(createSquare());
	}
}
