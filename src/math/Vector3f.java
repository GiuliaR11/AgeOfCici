package math;

public class Vector3f {

	public float x, y, z; // render order;z shows whether an object is in front(z>0) of another obj or
							// behind(z<0)

	public Vector3f() {
		x = 0.0f;
		y = 0.0f;
		z = 0.0f;
	}

	public Vector3f(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
}
