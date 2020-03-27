package Exo_6;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

/**
 * Classe Interface graphique pour l'application de dessin
 */
public class Paint extends Application {

    private Button clearButton;
    private Button circleButton;
    private Button rectangleButton;
    private BorderPane mainPane;
    private TilePane buttonPane;
    private static Drawing drawing;

    @Override
    public void start(Stage stage) throws Exception {
        mainPane = new BorderPane();

        drawing = new Drawing();
        clearButton = new Button("Clear");
        circleButton = new Button("Circle");
        rectangleButton = new Button("Square");

        buttonPane = new TilePane();
        buttonPane.getChildren().add(clearButton);
        buttonPane.getChildren().add(circleButton);
        buttonPane.getChildren().add(rectangleButton);

        mainPane.setBottom(buttonPane);
        mainPane.setCenter(drawing);

        //listeners pour les boutons
        clearButton.setOnMouseClicked(new ClearButtonListener(drawing));
        DrawingMouseListener l = new DrawingMouseListener(drawing);
        drawing.setOnMousePressed(l);
        drawing.setOnMouseReleased(l);
        // circleButton.setOnMouseClicked(new CircleButtonListener(drawing, l));
        circleButton.setOnMouseClicked(new CircleButtonListener(drawing));
        rectangleButton.setOnMouseClicked(new SquareButtonListener(drawing));


        stage.setScene(new Scene(mainPane, 800, 650));
        stage.show();
    }


    public static void main(String[] args){
        launch();
    }

}

