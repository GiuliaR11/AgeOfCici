package game.level;

import graphics.Camera;
import graphics.ShaderManager;
import graphics.Texture;
import graphics.VertexArray;
import math.Geometry;
import math.Vector3f;
import textures.TileAtlas;

public class Tile {

	float x,y,w,h;
	VertexArray mesh;
	Texture texture;
	float r,g,b;
	Vector3f clr;
	public Tile(float x,float y,float w,float h,float r,float g,float b) {
		clr = new Vector3f(r,g,b);
		
		
		this.x = x;
		this.y = y;
		this.w = w;
		this.h= h;
		mesh = Geometry.createIsometricRectangle(x,y,w,h);
		
		texture = TileAtlas.GALAXY;
	}
	
	
	public void render() {
		if(x + w < Camera.ORTHO_LEFT || x-w > Camera.ORTHO_RIGHT ||
			y < Camera.ORTHO_BOTTOM || y > Camera.ORTHO_TOP )
			return;
		texture.bind();
		ShaderManager.test.enable();
		ShaderManager.tile.setUniform3f("tileColor",clr);
		mesh.render();
		ShaderManager.test.disable();
		texture.unbind();
		
		
	}
}
