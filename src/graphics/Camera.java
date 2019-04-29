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
	
	public static Matrix4f orthoMatrix = Matrix4f.ortographic(ORTHO_LEFT, ORTHO_RIGHT, ORTHO_BOTTOM, ORTHO_TOP, ORTHO_NEAR, ORTHO_FAR);
	
	
	public static final float FOV_ANGLE = 60f;
	public static final float PERSP_SCALE   = (float)(1.0 / Math.tan(FOV_ANGLE/2 * Math.PI/180));
	public static final float PERSP_NEAR   = -1.0f;
	public static final float PERSP_FAR    =  1.0f;
	///in work
	public static Matrix4f perspectiveMatrix = Matrix4f.perspective(PERSP_SCALE, PERSP_NEAR, PERSP_FAR);
}
