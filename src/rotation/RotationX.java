package rotation;

import cube.Cube;
import cube.Piece;

public class RotationX implements RotationComplex
{	
	@Override
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
			            case LEFT : new RotationSquare().rotate(cube.getSquare(Cube.TOP), Rotation.CLOCKWISE, 1);         break;
			            case RIGHT: new RotationSquare().rotate(cube.getSquare(Cube.TOP), Rotation.COUNTERCLOCKWISE, 1);  break;
			            default: break;
					}
		        }
				else if(index == cube.getSize() - 1)
				{
					switch (direction) 
					{
			            case LEFT :  new RotationSquare().rotate(cube.getSquare(Cube.DOWN), Rotation.COUNTERCLOCKWISE, 1);       break;
			            case RIGHT:  new RotationSquare().rotate(cube.getSquare(Cube.DOWN), Rotation.CLOCKWISE, 1); break;
			            default: break;
					}
				}
				switch (direction) 
				{
		            case LEFT :
		            	Piece[] pieces = cube.getSquare(Cube.LEFT).getLayer(index);
						for(int i = 1; i < 4; i++)
						{
							cube.getSquare(i).setLayer(index, cube.getSquare(i+1).getLayer(index));
						}
						cube.getSquare(4).setLayer(index, pieces);
		            break;
		            case RIGHT:  
		            	pieces = cube.getSquare(Cube.BACK).getLayer(index);
						for(int i = 4; i > 1; i--)
						{
							cube.getSquare(i).setLayer(index, cube.getSquare(i-1).getLayer(index));
						}
						cube.getSquare(Cube.LEFT).setLayer(index, pieces);
					break;
		            default: break;
				}
			}
			else if(((n+1) % 4) == 0)
			{
				switch (direction) 
				{
		            case LEFT : this.rotate(cube, Rotation.RIGHT, index, 1); break;
		            case RIGHT: this.rotate(cube, Rotation.LEFT, index, 1);  break;
		            default: break;
				}
			}
			else
			{
				if(index == 0)
				{
					new RotationSquare().rotate(cube.getSquare(Cube.TOP), Rotation.CLOCKWISE, 2);
				}
				else if(index == cube.getSize() - 1)
				{
					new RotationSquare().rotate(cube.getSquare(Cube.DOWN), Rotation.CLOCKWISE, 2);
				}
				Piece[] temp = cube.getSquare(Cube.LEFT).getLayer(index);
				cube.getSquare(Cube.LEFT).setLayer(index, cube.getSquare(Cube.RIGHT).getLayer(index));
				cube.getSquare(Cube.RIGHT).setLayer(index, temp);
				temp = cube.getSquare(Cube.FRONT).getLayer(index);
				cube.getSquare(Cube.FRONT).setLayer(index, cube.getSquare(Cube.BACK).getLayer(index));
				cube.getSquare(Cube.BACK).setLayer(index, temp);
			}
		}
	}
}
