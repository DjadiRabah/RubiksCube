package model.rotation;

import model.cube.Cube;

public interface RotationComplex extends Rotation
{
	public void rotate(Cube cube,int direction, int index);
}
