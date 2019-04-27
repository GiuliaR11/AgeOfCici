package main;

import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.system.MemoryUtil.*;

import org.lwjgl.Version;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;

import controllers.KeyboardInput;

public class Main {

	// The window handle
	// private long window;
	private Game game;

	public void run() {
		System.out.println("Hello LWJGL " + Version.getVersion() + "!");

		init();
		loop();

		glfwFreeCallbacks(game.getWINDOW());
		glfwDestroyWindow(game.getWINDOW());

		// Terminate GLFW and free the error callback
		glfwTerminate();
		glfwSetErrorCallback(null).free();
	}

	private void init() {
		// Setup an error callback. The default implementation
		// will print the error message in System.err.
		GLFWErrorCallback.createPrint(System.err).set();

		// Initialize GLFW. Most GLFW functions will not work before doing this.
		if (!glfwInit())
			throw new IllegalStateException("Unable to initialize GLFW");

		game = new Game();

		glfwSetKeyCallback(game.getWINDOW(), new KeyboardInput());

	}

	private void loop() {

		// fara asta nu merge
		// porneste contextul video
		GL.createCapabilities();

		int updates = 0, renders = 0;
		long t0, t1;
		t0 = System.currentTimeMillis();

		long lastTime = System.nanoTime();
		final double ns = 1000000000.0 / game.getFPS();
		double delta = 0.0;

		while (game.getIsRunning()) {

			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;

			while (delta >= 1) {
				game.update();
				updates++;
				delta--;

			}

			game.render();
			renders++;

			t1 = System.currentTimeMillis();

			if (t1 - t0 >= 1000) {
				t0 = t1;
				System.out.println("UPS: " + updates + " FPS: " + renders);
				updates = 0;
				renders = 0;
			}

		}

	}

	public static void main(String[] args) {
		new Main().run();
	}

}