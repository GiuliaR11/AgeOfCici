package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import main.Game;
import utils.CGMath;

public class MainController implements Initializable{

	
	
	@FXML
	private Canvas mainCanvas = new Canvas();
	
	public GraphicsContext mainContext;
	
	@FXML
	public void handleMouseMoved(MouseEvent event) {
			
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	
	//	Game.mainContext = 
		mainContext = mainCanvas.getGraphicsContext2D();
	}


	


}
