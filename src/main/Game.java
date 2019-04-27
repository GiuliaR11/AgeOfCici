package main;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;

import controllers.KeyboardInput;
import entity.TestEntity;


public class Game {

	private boolean isRunning;
	private final int FPS = 30;
	private final int WIDTH = 1270;
	private final int HEIGHT = (int)(9.0/16.0 * WIDTH);
	private final long WINDOW;
	public static String title = " AOC ";
	
	float fl = 0.0f;
	float spd = 0.05f;
	TestEntity e;

	public Game() {
		isRunning = true;
		WINDOW = Window.createWindow(WIDTH,HEIGHT);
		
		e = new TestEntity();
	}
	
	public void update() {
		glfwPollEvents();
		
		if(KeyboardInput.keys[GLFW_KEY_R])
			fl += spd;			

		if(KeyboardInput.keys[GLFW_KEY_ESCAPE])
			isRunning = false;
		
		if(glfwWindowShouldClose(WINDOW))
			isRunning = false;
		
		if(fl >= 1 || fl <= 0)
			spd *= -1;
		
	}

	
	public void render() {
		
		
	//	glClearColor(0, 0, 0, 1.0f);

		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // clear the framebuffer
		
		e.render();
		
		glfwSwapBuffers(WINDOW);
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
	
	public int getWIDTH() {
		return WIDTH;
	}

	public int getHEIGHT() {
		return HEIGHT;
	}

	public long getWINDOW() {
		return WINDOW;
	}
}
