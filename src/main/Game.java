package main;

import entity.Entity;
import javafx.fxml.FXMLLoader;
import javafx.scene.canvas.GraphicsContext;



public class Game {

	private boolean isRunning;

	private final int FPS = 60;
	
	private GraphicsContext gc;
	
	public FXMLLoader fxmlLoader;
	
	
	Entity e = new Entity();

	public Game() {
		fxmlLoader = new FXMLLoader();
		//gc = fxmlLoader.getController();
		
	}
	
	public void update() {
		
		
		
	}

	
	public void render() {
		
		//e.render(gc);
		
	}
		
	
	public boolean getIsRunning() {
		return isRunning;
	}



	public void setIsRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}
	
	public int getFPS() {
		return FPS;
	}
	
}
