package graphics;

import math.Matrix4f;

/**@javadoc
 * 
 * Class that manages all shaders laoding and variable allocation
 * */
public class ShaderManager {

	///indexul atributului pentru VERTEX,TEXTURA
	//reprezinta location in shader
	public static final int VERTEX_ATTRIB = 0;
	public static final int TEXTURE_COORD_ATTRIB = 1;
	 
	public static Shader TEST;
	
	
	private static void loadTestShader() {
		
		TEST = new Shader("shaders/Test.vertexShader","shaders/Test.fragmentShader");
		
		TEST.setUniformMatrix4f("projectionMatrix", Camera.projectionMatrix);
		TEST.setUniform1i("textureImage", 1);
	}
	
	public static void loadAllShaders() {
		loadTestShader();
	}
}
