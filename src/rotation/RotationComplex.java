package rotation;

import cube.Cube;

public interface RotationComplex extends Rotation
{
	public void rotate(Cube cube,int direction, int index);
}
