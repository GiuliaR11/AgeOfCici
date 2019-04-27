package graphics;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL30.*;

import utils.BufferUtils;




public class VertexArray {

	private int vertexArrayObject, vertexBufferObject, indicesBufferObject, textureBufferObject;
	private int count;
	
	public VertexArray(float[] vertices,byte[] indices, float[] textureCoordinates) {
		
		count = indices.length;
		
		vertexArrayObject = glGenVertexArrays();
		glBindVertexArray(vertexArrayObject);
		
		
		vertexBufferObject = glGenBuffers();
		glBindBuffer(GL_ARRAY_BUFFER, vertexBufferObject);
		glBufferData(GL_ARRAY_BUFFER, BufferUtils.createFloatBuffer(vertices), GL_STATIC_DRAW);
		///3 - datele din vertex sunt in format x y z, adica  la fiecare 3 coordonate se ajunge din nou la x
		glVertexAttribPointer(ShaderManager.VERTEX_ATTRIB, 3, GL_FLOAT, false, 0, 0);
		glEnableVertexAttribArray(ShaderManager.VERTEX_ATTRIB);
		
		textureBufferObject = glGenBuffers();
		glBindBuffer(GL_ARRAY_BUFFER, textureBufferObject);
		glBufferData(GL_ARRAY_BUFFER, BufferUtils.createFloatBuffer(textureCoordinates), GL_STATIC_DRAW);
		///2 - datele din texture sunt in format x y, adica  la fiecare 2 coordonate se ajunge din nou la x
		glVertexAttribPointer(ShaderManager.TEXTURE_COORD_ATTRIB, 2, GL_FLOAT, false, 0, 0);
		glEnableVertexAttribArray(ShaderManager.TEXTURE_COORD_ATTRIB);  
		
		
		indicesBufferObject = glGenBuffers();
		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER,indicesBufferObject);
		glBufferData(GL_ELEMENT_ARRAY_BUFFER,BufferUtils.createByteBuffer(indices),GL_STATIC_DRAW);
		
		
		glBindBuffer(GL_ARRAY_BUFFER,0);
		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER,0);
		glBindVertexArray(0);
		
	}
	
	
	public void bind() {
		glBindVertexArray(vertexArrayObject);
		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER,indicesBufferObject);	
	}
	
	public void unbind() {
		glBindVertexArray(0);
		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER,0);	
	}	
	
	public void draw() {
		glDrawElements(GL_TRIANGLES,count,GL_UNSIGNED_BYTE,0);
	}
	
	public void render() {
		bind();
		draw();
	}
	
	
	
}
