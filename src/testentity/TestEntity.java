package testentity;

import graphics.Camera;
import graphics.ShaderManager;
import graphics.Texture;
import graphics.VertexArray;
import textures.TileAtlas;

public class TestEntity {

	private VertexArray mesh;
	private Texture texture;	
	
	public TestEntity(){
		
		int parts = 20;
		float angle = 360f / parts;
		float radius = 5f;
		
		float[] v = new float[parts * 3+6];
		byte[] b = new byte[parts * 3 + 6];
		float[] tc = new float[parts * 2 + 4];
		
		tc[0] = 0;
		tc[1] = 1;
		
		tc[2] = 0;
		tc[3] = 0;
		
		v[0] = 0;
		v[1] = 0;
		v[2] = 0;
		
		
		b[0] = 0;
		b[1] = 1;
		b[2] = 2;
		
		
		float cA = 0f;
		for(int i=1;i<=parts;i++) {
			v[i * 3]   = (float)Math.cos(Math.toRadians(cA)) * radius;
			v[i * 3 + 1] = (float)Math.sin(Math.toRadians(cA)) * radius;
			v[i * 3 + 2] = 0.0f;
			
			
			cA-=angle;
			
			if( i +1 < parts) {
				b[i * 3 ] = 0;
				b[i * 3 + 1] = (byte)(i+1);
				b[i * 3 + 2] = (byte)(i+2);
				System.out.println(b[i * 3]+" "+b[i* 3+1]+" "+b[i*3+2]);
			}
			
			if(i % 2 != 0) {
				tc[2 + i * 2] = 1;
				tc[2 + i * 2 + 1] = 0;	
			}else
			{
				tc[2 + i * 2] = 1;
				tc[2 + i * 2 + 1] = 1;
			}
			
		}
		
		b[parts*3] = 0;
		b[parts*3+1] = (byte)(parts);
		b[parts*3+2] = 1;
		
		
		
		///mesh beggins in bottom left corner
		float[] vertices = {
			Camera.ORTHO_LEFT ,Camera.ORTHO_BOTTOM, 0.0f,
			Camera.ORTHO_LEFT ,Camera.ORTHO_TOP   , 0.0f,
			Camera.ORTHO_RIGHT,Camera.ORTHO_TOP   , 0.0f,
			Camera.ORTHO_RIGHT,Camera.ORTHO_BOTTOM, 0.0f
		};
		
		///varfurile triunghiului
		byte[] indices = {
			0, 1, 2,
			2, 3, 0
		};
		
		//x y - coloana linie
		float[] textureCooridnates = {
			0, 1,
			0, 0,
			1, 0,
			1, 1
		};
		
		mesh = new VertexArray(v,b,tc);
		//texture = TileAtlas.GALAXY;
		
	}
	
	public void update() {
		
	}
	
	public void render() {
		texture.bind();
		ShaderManager.test.enable();
		mesh.render();
		ShaderManager.test.disable();
		texture.unbind();
	}
	
	
}
