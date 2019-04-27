package graphics;

import math.Matrix4f;

 /**
 * @author Cezar
 *Class that manages camera position, and projection matrix
 */
public class Camera {

	public static final float ORTHO_LEFT   = -10.0f;
	public static final float ORTHO_RIGHT  =  10.0f;
	public static final float ORTHO_BOTTOM =  ORTHO_LEFT * 9.0f / 16.0f;
	public static final float ORTHO_TOP    =  ORTHO_RIGHT * 9.0f / 16.0f;
	public static final float ORTHO_NEAR   = -1.0f;
	public static final float ORTHO_FAR    =  1.0f;
	
	public static Matrix4f projectionMatrix = Matrix4f.ortographic(ORTHO_LEFT, ORTHO_RIGHT, ORTHO_BOTTOM, ORTHO_TOP, ORTHO_NEAR, ORTHO_FAR);
}
