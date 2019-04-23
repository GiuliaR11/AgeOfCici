package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;



public class Main extends Application implements Runnable{

	
	private Thread gameThread;
	private Game game;
	
	
	
	public static void main(String[] args) {
		launch(args);
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		startGameThread();
		
		game.fxmlLoader = new FXMLLoader(getClass().getResource("/controllers/Window.fxml"));
		GridPane root = (GridPane)game.fxmlLoader.load();
		
		
		
		Scene scene = new Scene(root,600,400);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		
	}

	@Override
	public void stop() {
		stopGameThread();
		
	}
	
	

	public synchronized void startGameThread() {
		game = new Game();
		game.setIsRunning(true);
		gameThread = new Thread(this);
		gameThread.start();
		
	}
	
	public synchronized void stopGameThread() {
		try {
			game.setIsRunning(false);
			gameThread.join();
			System.out.println("Application closed");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		
		int updates=0,renders=0;
		long t0,t1;
		t0 = System.currentTimeMillis();
		
		long lastTime = System.nanoTime();
		final double ns = 1000000000.0 / game.getFPS();
		double delta = 0.0;
		
		while(game.getIsRunning()) {
			
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			
			while(delta >= 1) {
				game.update();
				updates++;
				delta--;
				
			}
			
			game.render();
			renders++;
			
			t1 = System.currentTimeMillis();
			
			if(t1 - t0 >= 1000) {
				t0 = t1;
				System.out.println("UPS: " + updates + " RPS: " + renders);
				updates = 0;
				renders = 0;
			}
		}
		
	}
	
}
