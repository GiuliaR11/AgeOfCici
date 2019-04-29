package main;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import controllers.KeyboardInput;
import game.level.Tile;
import graphics.Camera;
import graphics.ShaderManager;
import testentity.TestEntity;
import textures.TileAtlas;


public class Game {

	private boolean isRunning;
	private final int FPS = 60;
	private final int WIDTH = 1270;
	private final int HEIGHT = (int)(9.0/16.0 * WIDTH);
	private final long WINDOW;
	public static String title = " AOC ";
	
	float fl = 0.0f;
	float spd = 0.05f;
	
	Tile t,t1;
	TestEntity te;
	List<Tile> tileList = new ArrayList<>();
	Random rnd = new Random();
	
	public Game() {
		isRunning = true;
		WINDOW = Window.createWindow(WIDTH,HEIGHT);
		float tw = 1.5f;
		float th = tw/2;
		float w = (float)( tw * Math.cos(Math.toRadians(30)) + th * Math.cos(Math.toRadians(60)));
		float h = (float)( tw * Math.sin(Math.toRadians(30)) + th * Math.sin(Math.toRadians(60)));
		float x = -16;
		float y = 0;
		float startX = x,startY = y;
		for(int i=0;i<25;i++) {
			
			for(int j=0;j<25;j++) {
				
				tileList.add(new Tile(startX + j * w/2, startY + j * h/2,w,h,rnd.nextFloat(),rnd.nextFloat(),rnd.nextFloat()));
			}
			startX+=w/2;
			startY-=h/2;
		}
			
				
				
		
		
	//	te = new TestEntity();
	}
	
	public void update() {
		glfwPollEvents();

		if(KeyboardInput.keys[GLFW_KEY_ESCAPE])
			isRunning = false;
		
		if(glfwWindowShouldClose(WINDOW))
			isRunning = false;
		
		
		
	}

	
	public void render() {
		
		
	//	glClearColor(0, 0, 0, 1.0f);

		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // clear the framebuffer
		
		
		for(int i=0;i<tileList.size();i++) {
			tileList.get(i).render();
		}
		
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
