package Exo_6;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ClearButtonListener implements EventHandler<MouseEvent> {

    Drawing drawing;

    public ClearButtonListener(Drawing drawing){
        this.drawing = drawing;
    }


    @Override
    public void handle(MouseEvent mouseEvent) {
        drawing.clear();
    }
}

