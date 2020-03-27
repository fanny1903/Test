package Exo_6;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.util.Random;

public class SquareButtonListener implements EventHandler<MouseEvent> {

    Drawing drawing;

    public SquareButtonListener(Drawing drawing){
        super();
        this.drawing = drawing;

    }
    private Square createSquare() {
        Random r = new Random();
        double length = r.nextInt(70) + 10;
        double maxX = drawing.getLayoutBounds().getMaxX();
        double maxY = drawing.getLayoutBounds().getMaxY();
        double centerX = r.nextInt((int) (maxX -length));
        double centerY = r.nextInt((int) (maxY - length));
        Point center = new Point(centerX, centerY);

        Color color = new Color(r.nextDouble(), r.nextDouble(), r.nextDouble(), r.nextDouble());
        Square sq = new Square(drawing, center, length, color);

        return sq;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        if (mouseEvent.getEventType() == MouseEvent.MOUSE_CLICKED){
            drawing.addShape(createSquare());
        }
    }


}
