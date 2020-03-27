package ex6_ennonce;


import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * Listener pour gérer la souris dans la zone de dessin
 */
public class DrawingMouseListener implements EventHandler<MouseEvent> {

	Drawing drawing;
	Shape currentShape = null;

	public DrawingMouseListener(Drawing d){
		drawing = d;
	}


	/**
	 * Selectionne la forme sur laquelle l'utilisateur a clique
	 */
	public void mousePressed(MouseEvent e) {
		for(Shape s : drawing){
			if(s.isOn(new Point(e.getX(), e.getY()))){
				System.out.println("its on");
				currentShape = s;
				break;
			}
		}
	}

	/**
	 * Bouge et deselectionne la forme
	 */
	public void mouseReleased(MouseEvent e) {
		if(currentShape != null){
			currentShape.setOrigin(new Point(e.getX(), e.getY()));
			currentShape = null;
		}
	}

	@Override
	public void handle(MouseEvent mouseEvent) {
		if (mouseEvent.getEventType() == MouseEvent.MOUSE_PRESSED){
			mousePressed(mouseEvent);
		}
		else if (mouseEvent.getEventType() == MouseEvent.MOUSE_RELEASED){
			mouseReleased(mouseEvent);
		}
	}
}
