package main;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;

import entity.Entity;
import javafx.fxml.FXMLLoader;
import javafx.scene.canvas.GraphicsContext;



public class Game {

	private boolean isRunning;

	private final int FPS = 60;
	
	public static GraphicsContext mainContext;
	
	
	float fl = 0.0f;
	
	Entity e = new Entity();

	public Game() {
		isRunning = true;
		
		
	}
	
	public void update() {
		
		
		//
	}

	
	public void render(long window) {
		
		//e.render(mainContext);
		
		glClearColor(fl, 0f, 0f, 1.0f);
		fl+=0.01;
		if(fl >= 1)
			fl = 0;
		
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // clear the framebuffer

		glfwSwapBuffers(window); // swap the color buffers

		// Poll for window events. The key callback above will only be
		// invoked during this call.
		
	
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
