package rotation;

import cube.Cube;
import cube.Piece;

public class RotationZ implements RotationComplex
{	
	@Override
	public void rotate(Cube cube, int direction, int index)
	{
		if(index == 0)
		{
			switch (direction) 
			{
	            case CLOCKWISE :        new RotationSquare().rotate(cube.getSquare(Cube.FRONT), Rotation.CLOCKWISE, 1);        break;
	            case COUNTERCLOCKWISE : new RotationSquare().rotate(cube.getSquare(Cube.FRONT), Rotation.COUNTERCLOCKWISE, 1); break;
	            default: break;
			}
        }
		else if (index == cube.getSize() - 1)
		{
			switch (direction) 
			{
	            case CLOCKWISE :       new RotationSquare().rotate(cube.getSquare(Cube.BACK), Rotation.COUNTERCLOCKWISE, 1);  break;
	            case COUNTERCLOCKWISE: new RotationSquare().rotate(cube.getSquare(Cube.BACK), Rotation.CLOCKWISE, 1);         break;
	            default: break;
			}
		}
		switch (direction) 
		{
            case CLOCKWISE :
            	Piece[] top = cube.getSquare(Cube.TOP).getLayer(cube.getSize() - index - 1);
            	cube.getSquare(Cube.TOP).setLayerReverse(cube.getSize() - index - 1, cube.getSquare(Cube.LEFT).getCol(cube.getSize() - index - 1));
            	cube.getSquare(Cube.LEFT).setCol(cube.getSize() - index - 1, cube.getSquare(Cube.DOWN).getLayer(index));
            	cube.getSquare(Cube.DOWN).setLayerReverse(index, cube.getSquare(Cube.RIGHT).getCol(index));
            	cube.getSquare(Cube.RIGHT).setCol(index, top);
            break;
            case COUNTERCLOCKWISE :
            	Piece[] tp = cube.getSquare(Cube.TOP).getLayer(cube.getSize() - index - 1);
            	cube.getSquare(Cube.TOP).setLayer(cube.getSize() - index - 1, cube.getSquare(Cube.RIGHT).getCol(index));
            	cube.getSquare(Cube.RIGHT).setColReverse(index, cube.getSquare(Cube.DOWN).getLayer(index));
            	cube.getSquare(Cube.DOWN).setLayer(index, cube.getSquare(Cube.LEFT).getCol(cube.getSize() - index - 1));
            	cube.getSquare(Cube.LEFT).setColReverse(cube.getSize() - index - 1, tp);
			break;
            default: break;
		}
	}
}
