package entity;

import javafx.scene.canvas.GraphicsContext;

public class Entity {

	int x = 100,y = 100;
	
	public void update() {
		
	}
	
	public void render(GraphicsContext gc) {
		
		gc.fillRect(x, y, 50, 50);
		
	}
	
	
}
