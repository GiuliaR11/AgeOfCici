package graphics;

import java.net.URL;

/**@javadoc
 * 
 * Class that manages all shaders laoding and variable allocation
 */
public class ShaderManager {

	///indexul atributului pentru VERTEX,TEXTURA
	//reprezinta location in shader
	public static final int VERTEX_ATTRIB = 0;
	public static final int TEXTURE_COORD_ATTRIB = 1;
	 
	public static Shader test;
	public static Shader tile;
	
	
	private static void loadTestShader() {
		
		test = new Shader("/shaders/Test.vertexShader","/shaders/Test.fragmentShader");

		test.setUniformMatrix4f("projectionMatrix", Camera.orthoMatrix);
		test.setUniform1i("textureImage", 1);
	}
	
	private static void loadTileShader() {
		
		
		tile = new Shader("/shaders/Tile.vertexShader","/shaders/Tile.fragmentShader");

		tile.setUniformMatrix4f("projectionMatrix", Camera.orthoMatrix);
		//tile.setUniform1i("textureImage", 1);
		
	}
	
	public static void loadAllShaders() {
		loadTestShader();
		loadTileShader();
	}
}
