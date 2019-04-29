package math;

import graphics.VertexArray;

public class Geometry {

	public static VertexArray createIsometricRectangle(float x,float y,float w,float h) {
		
		float[] vertices = {
				 
				 x-w/2,  y   ,0f,
				 x,    y+h/2 ,0f,
				 x +w/2, y   ,0f,
				 x,    y-h/2 ,0f
		};
		
		byte[] indices= {
				0, 1, 2,
				2, 3, 0
		};
		
		float[] textureCoordinates = {
				0, 1,
				0, 0,
				1, 0,
				1, 1
		};
		
		return new VertexArray(vertices,indices,textureCoordinates);
	}
	
	public static VertexArray createRectangleMesh(float x,float y,float size) {
		
		float[] vertices = {
				x, y ,0f,
				 x, y+size ,0f,
				 x+size, y+size ,0f,
				 x+size, y ,0f
				 
		};
		
		byte[] indices= {
				0, 1, 2,
				2, 3, 0
		};
		
		float[] textureCoordinates = {
				0, 1,
				0, 0,
				1, 0,
				1, 1
		};
		
		return new VertexArray(vertices,indices,textureCoordinates);
	}
}
