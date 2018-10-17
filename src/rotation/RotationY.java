package rotation;

import cube.Cube;
import cube.Piece;

public class RotationY implements RotationComplex
{	

	public void rotate(Cube cube, int direction, int index, int n)
	{
		if((n%4) != 0)
		{
			if(((n-1) % 4) == 0)
			{
				if(index == 0)
				{
					switch (direction) 
					{
			            case UP :  new RotationSquare().rotate(cube.getSquare(Cube.LEFT), Rotation.COUNTERCLOCKWISE, 1); break;
			            case DOWN: new RotationSquare().rotate(cube.getSquare(Cube.LEFT), Rotation.CLOCKWISE, 1); break;
			            default: break;
					}
		        }
				else if(index == cube.getSize() - 1)
				{
					switch (direction) 
					{
			            case UP :  new RotationSquare().rotate(cube.getSquare(Cube.RIGHT), Rotation.CLOCKWISE, 1); break;
			            case DOWN: new RotationSquare().rotate(cube.getSquare(Cube.RIGHT), Rotation.COUNTERCLOCKWISE, 1); break;
			            default: break;
					}
				}
				switch (direction) 
				{
		            case UP :
		            	Piece[] top = cube.getSquare(Cube.TOP).getCol(index);
		            	cube.getSquare(Cube.TOP).setCol(index, cube.getSquare(Cube.FRONT).getCol(index));
		            	cube.getSquare(Cube.FRONT).setCol(index, cube.getSquare(Cube.DOWN).getCol(index));
		            	cube.getSquare(Cube.DOWN).setColReverse(index, cube.getSquare(Cube.BACK).getCol(cube.getSize() - index - 1));
		            	cube.getSquare(Cube.BACK).setColReverse(cube.getSize() - index - 1, top);
		            break;
		            case DOWN:  
		            	Piece[] front = cube.getSquare(Cube.FRONT).getCol(index);
		            	cube.getSquare(Cube.FRONT).setCol(index, cube.getSquare(Cube.TOP).getCol(index));
		            	cube.getSquare(Cube.TOP).setColReverse(index, cube.getSquare(Cube.BACK).getCol(cube.getSize() - index - 1));
		            	cube.getSquare(Cube.BACK).setColReverse(cube.getSize() - index - 1, cube.getSquare(Cube.DOWN).getCol(index));
		            	cube.getSquare(Cube.DOWN).setCol(index, front);
					break;
		            default: break;
				}
			}
			else if(((n+1) % 4) == 0)
			{
				switch (direction) 
				{
		            case UP : this.rotate(cube, Rotation.DOWN, index, 1); break;
		            case DOWN: this.rotate(cube, Rotation.UP, index, 1);  break;
		            default: break;
				}
			}
			else
			{
				if(index == 0)
				{
					new RotationSquare().rotate(cube.getSquare(Cube.LEFT), Rotation.CLOCKWISE, 2);
				}
				else if(index == cube.getSize() - 1)
				{
					new RotationSquare().rotate(cube.getSquare(Cube.RIGHT), Rotation.CLOCKWISE, 2);
				}
				Piece[] temp = cube.getSquare(Cube.TOP).getCol(index);
            	cube.getSquare(Cube.TOP).setColReverse(index, cube.getSquare(Cube.DOWN).getCol(index));
            	cube.getSquare(Cube.DOWN).setColReverse(index, temp);
            	temp = cube.getSquare(Cube.FRONT).getCol(index);
            	cube.getSquare(Cube.FRONT).setColReverse(index, cube.getSquare(Cube.BACK).getCol(cube.getSize() - index - 1));
            	cube.getSquare(Cube.BACK).setColReverse(cube.getSize() - index - 1, temp);
			}
		}
	}
}
