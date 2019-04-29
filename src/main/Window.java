package main;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL13.*;
import static org.lwjgl.system.MemoryUtil.*;

import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;

 /**
 * @author Cezar
 *
 *Clasa pentru eranul jocului, aici se seteaza flagurile si rezolutia
 */
public class Window {
	
	public static long createWindow(int windowWidth,int windowHeight) {
		 
		///facem fereastra vizibila
		glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE); 
		
		///vrem ca fereastra sa nu se poata redimensiona
		glfwWindowHint(GLFW_RESIZABLE, GLFW_FALSE); 
		
		glfwWindowHint (GLFW_CONTEXT_VERSION_MAJOR, 3);
		glfwWindowHint (GLFW_CONTEXT_VERSION_MINOR, 2);
		glfwWindowHint (GLFW_OPENGL_PROFILE,        GLFW_OPENGL_CORE_PROFILE);
		glfwWindowHint(GLFW_OPENGL_FORWARD_COMPAT, GLFW_TRUE);
		
		long window =  glfwCreateWindow(windowWidth, windowHeight, "Age of Cici", NULL, NULL);
		
		
		if ( window == NULL )
			throw new RuntimeException("Failed to create the GLFW window");
		else {
			
			//seteaza contextul curent de desenare pe window(fereastra tocmai creata)
			glfwMakeContextCurrent(window);
			
			//vidmode reprezinta monitorul
			GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());
			
			int screenCenterX = (vidmode.width() - windowWidth) / 2;
			int screenCenterY = (vidmode.height() - windowHeight) / 2;
			
			//Set window to the center of the screen
			glfwSetWindowPos(window,screenCenterX,screenCenterY);
			
			//V Sync
			glfwSwapInterval(GLFW_FALSE);

			glfwShowWindow(window);
			
			// fara asta nu merge
			// porneste contextul video
			GL.createCapabilities();
			glEnable(GL_DEPTH_TEST);
			glEnable(GL_NORMALIZE);
			glActiveTexture(GL_TEXTURE1);
			
			return window;
		}
			
		
	}
	
}
