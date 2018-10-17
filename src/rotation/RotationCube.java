package rotation;

import cube.Cube;

public class RotationCube implements Rotation
{	
	public void rotate(Cube cube, int direction, int n)
	{
		for(int i = 0; i < cube.getSize(); i++)
		{
			if ((direction == Rotation.RIGHT) || (direction == Rotation.LEFT))
			{
				new RotationX().rotate(cube, direction, i, n);
			}
			else if ((direction == Rotation.UP) || (direction == Rotation.DOWN))
			{
				new RotationY().rotate(cube, direction, i, n);
			}
			else if ((direction == Rotation.CLOCKWISE) || (direction == Rotation.COUNTERCLOCKWISE))
			{
				new RotationZ().rotate(cube, direction, i, n);
			}
		}
	}
}
