package model.solver;

import model.cube.Cube;
import model.rotation.Rotation;

import java.util.ArrayList;

import event.RotationEvent;;

public class FirstLayer extends Solver
{
	public FirstLayer() 
	{
		super();
	}

	@Override
	public void solve(Cube cube) 
	{	
		Cube copy = new Cube(cube);
		int size = cube.getSize() - 1;
		
		int colorTop = copy.getSquare(Cube.TOP).getColor();
		
		for(int currentCorner = 0; currentCorner < 4; currentCorner++)
		{
			int colorFront = copy.getSquare(Cube.FRONT).getColor();
			int colorRight = copy.getSquare(Cube.RIGHT).getColor();
			ArrayList<RotationEvent> newRotations = new ArrayList<RotationEvent>();
			if (((copy.getSquare(Cube.LEFT).getColor(0,0) == colorTop) && (copy.getSquare(Cube.TOP).getColor(0,0) == colorFront)
					&& (copy.getSquare(Cube.BACK).getColor(0,size) == colorRight))
				|| ((copy.getSquare(Cube.LEFT).getColor(0,0) == colorFront) && (copy.getSquare(Cube.TOP).getColor(0,0) == colorRight)
							&& (copy.getSquare(Cube.BACK).getColor(0,size) == colorTop)))
			{
				newRotations.add(new RotationEvent(Rotation.COUNTERCLOCKWISE, size));
				newRotations.add(new RotationEvent(Rotation.RIGHT, size));
				newRotations.add(new RotationEvent(Rotation.RIGHT, size));
				newRotations.add(new RotationEvent(Rotation.CLOCKWISE, size));
			}
			
			else if (((copy.getSquare(Cube.RIGHT).getColor(0,size) == colorTop) && (copy.getSquare(Cube.TOP).getColor(0,size) == colorRight)
					&& (copy.getSquare(Cube.BACK).getColor(0,0) == colorFront))
				|| ((copy.getSquare(Cube.RIGHT).getColor(0,size) == colorRight) && (copy.getSquare(Cube.TOP).getColor(0,size) == colorFront)
						&& (copy.getSquare(Cube.BACK).getColor(0,0) == colorTop))
				|| ((copy.getSquare(Cube.RIGHT).getColor(0,size) == colorFront) && (copy.getSquare(Cube.TOP).getColor(0,size) == colorTop)
						&& (copy.getSquare(Cube.BACK).getColor(0,0) == colorRight))
					)
			{
				newRotations.add(new RotationEvent(Rotation.CLOCKWISE, size));
				newRotations.add(new RotationEvent(Rotation.LEFT, size));
				newRotations.add(new RotationEvent(Rotation.COUNTERCLOCKWISE, size));
			}
			
			else if (((copy.getSquare(Cube.TOP).getColor(size,0) == colorTop) && (copy.getSquare(Cube.LEFT).getColor(0,size) == colorFront)
					&& (copy.getSquare(Cube.FRONT).getColor(0,0) == colorRight))		
				|| ((copy.getSquare(Cube.TOP).getColor(size,0) == colorFront) && (copy.getSquare(Cube.LEFT).getColor(0,size) == colorRight)
						&& (copy.getSquare(Cube.FRONT).getColor(0,0) == colorTop))
				|| ((copy.getSquare(Cube.TOP).getColor(size,0) == colorRight) && (copy.getSquare(Cube.LEFT).getColor(0,size) == colorTop)
						&& (copy.getSquare(Cube.FRONT).getColor(0,0) == colorFront)))
			{
				newRotations.add(new RotationEvent(Rotation.DOWN, 0));
				newRotations.add(new RotationEvent(Rotation.RIGHT, size));
				newRotations.add(new RotationEvent(Rotation.UP, 0));
			}
			
			else if (((copy.getSquare(Cube.FRONT).getColor(size,0) == colorTop) && (copy.getSquare(Cube.LEFT).getColor(size,size) == colorFront)
					&& (copy.getSquare(Cube.DOWN).getColor(0,0) == colorRight))
				|| ((copy.getSquare(Cube.FRONT).getColor(size,0) == colorRight) && (copy.getSquare(Cube.LEFT).getColor(size,size) == colorTop)
						&& (copy.getSquare(Cube.DOWN).getColor(0,0) == colorFront))
				|| ((copy.getSquare(Cube.FRONT).getColor(size,0) == colorFront) && (copy.getSquare(Cube.LEFT).getColor(size,size) == colorRight)
						&& (copy.getSquare(Cube.DOWN).getColor(0,0) == colorTop)))
			{
				newRotations.add(new RotationEvent(Rotation.RIGHT, size));
			}
			else if ((copy.getSquare(Cube.RIGHT).getColor(0,0) == colorTop) && (copy.getSquare(Cube.TOP).getColor(size,size) == colorFront)
					&& (copy.getSquare(Cube.FRONT).getColor(0,size) == colorRight))
			{
				newRotations.add(new RotationEvent(Rotation.CLOCKWISE, 0));
				newRotations.add(new RotationEvent(Rotation.LEFT, size));
				newRotations.add(new RotationEvent(Rotation.COUNTERCLOCKWISE, 0));
			}
			
			else if ((copy.getSquare(Cube.TOP).getColor(0,0) == colorTop) && (copy.getSquare(Cube.LEFT).getColor(0,0) == colorRight)
					&& (copy.getSquare(Cube.BACK).getColor(0,size) == colorFront))
			{
				newRotations.add(new RotationEvent(Rotation.UP, 0));
				newRotations.add(new RotationEvent(Rotation.LEFT, size));
				newRotations.add(new RotationEvent(Rotation.LEFT, size));
				newRotations.add(new RotationEvent(Rotation.DOWN, 0));
			}
			
			else if ((copy.getSquare(Cube.LEFT).getColor(size,0) == colorTop) && (copy.getSquare(Cube.DOWN).getColor(size,0) == colorRight)
					&& (copy.getSquare(Cube.BACK).getColor(size,size) == colorFront))
			{
				newRotations.add(new RotationEvent(Rotation.RIGHT, size));
				newRotations.add(new RotationEvent(Rotation.RIGHT, size));
			}
			
			else if (((copy.getSquare(Cube.RIGHT).getColor(size,size) == colorTop) && (copy.getSquare(Cube.DOWN).getColor(size,size) == colorFront)
					&& (copy.getSquare(Cube.BACK).getColor(size,0) == colorRight))
				|| ((copy.getSquare(Cube.RIGHT).getColor(size,size) == colorRight) && (copy.getSquare(Cube.DOWN).getColor(size,size) == colorTop)
						&& (copy.getSquare(Cube.BACK).getColor(size,0) == colorFront))
				|| ((copy.getSquare(Cube.RIGHT).getColor(size,size) == colorFront) && (copy.getSquare(Cube.DOWN).getColor(size,size) == colorRight)
						&& (copy.getSquare(Cube.BACK).getColor(size,0) == colorTop)))
			{
				newRotations.add(new RotationEvent(Rotation.LEFT, size));
			}
			
			else if (((copy.getSquare(Cube.BACK).getColor(size,size) == colorTop) && (copy.getSquare(Cube.DOWN).getColor(size,0) == colorFront)
					&& (copy.getSquare(Cube.LEFT).getColor(size,0) == colorRight))
				|| ((copy.getSquare(Cube.BACK).getColor(size,size) == colorRight) && (copy.getSquare(Cube.DOWN).getColor(size,0) == colorTop)
						&& (copy.getSquare(Cube.LEFT).getColor(size,0) == colorFront)))
			{
				newRotations.add(new RotationEvent(Rotation.LEFT, size));
				newRotations.add(new RotationEvent(Rotation.LEFT, size));
			}
			
			else if ((copy.getSquare(Cube.FRONT).getColor(0,size) == colorTop) && (copy.getSquare(Cube.TOP).getColor(size,size) == colorRight)
					&& (copy.getSquare(Cube.RIGHT).getColor(0,0) == colorFront))
			{
				newRotations.add(new RotationEvent(Rotation.DOWN, size));
				newRotations.add(new RotationEvent(Rotation.LEFT, size));
				newRotations.add(new RotationEvent(Rotation.UP, size));
				newRotations.add(new RotationEvent(Rotation.RIGHT, size));
			}
			
			for(int i = 0; i < newRotations.size(); i++)
			{
				RotationEvent rotation = newRotations.get(i);
				copy.rotate(rotation.getDirection(),rotation.getIndex());
			}
			
			this.rotations.addAll(newRotations);
			newRotations = new ArrayList<RotationEvent>();
			
			if ((copy.getSquare(Cube.FRONT).getColor(size,size) == colorFront) && (copy.getSquare(Cube.RIGHT).getColor(size,0) == colorTop)
					&& (copy.getSquare(Cube.DOWN).getColor(0,size) == colorRight))
			{
				newRotations.add(new RotationEvent(Rotation.DOWN, size));
				newRotations.add(new RotationEvent(Rotation.LEFT, size));
				newRotations.add(new RotationEvent(Rotation.UP, size));
			}
			else if ((copy.getSquare(Cube.FRONT).getColor(size,size) == colorTop) && (copy.getSquare(Cube.RIGHT).getColor(size,0) == colorRight)
					&& (copy.getSquare(Cube.DOWN).getColor(0,size) == colorFront))
			{
				newRotations.add(new RotationEvent(Rotation.LEFT, size));
				newRotations.add(new RotationEvent(Rotation.DOWN, size));
				newRotations.add(new RotationEvent(Rotation.RIGHT, size));	
				newRotations.add(new RotationEvent(Rotation.UP, size));
			}
			else if ((copy.getSquare(Cube.FRONT).getColor(size,size) == colorRight) && (copy.getSquare(Cube.RIGHT).getColor(size,0) == colorFront)
					&& (copy.getSquare(Cube.DOWN).getColor(0,size) == colorTop))
			{
				newRotations.add(new RotationEvent(Rotation.DOWN, size));
				newRotations.add(new RotationEvent(Rotation.RIGHT, size));
				newRotations.add(new RotationEvent(Rotation.RIGHT, size));
				newRotations.add(new RotationEvent(Rotation.UP, size));
				newRotations.add(new RotationEvent(Rotation.RIGHT, size));
				newRotations.add(new RotationEvent(Rotation.DOWN, size));
				newRotations.add(new RotationEvent(Rotation.LEFT, size));	
				newRotations.add(new RotationEvent(Rotation.UP, size));
			}
			
			for(int i = 0; i <= size; i++)
			{
				newRotations.add(new RotationEvent(Rotation.LEFT,i));
			}
				
			for(int i = 0; i < newRotations.size(); i++)
			{
				RotationEvent rotation = newRotations.get(i);
				copy.rotate(rotation.getDirection(),rotation.getIndex());
			}
			
			this.rotations.addAll(newRotations);
			newRotations = new ArrayList<RotationEvent>();
		}
		
		for(int i = 0; i < this.rotations.size(); i++)
		{
			RotationEvent rotation = this.rotations.get(i);
			cube.rotate(rotation.getDirection(),rotation.getIndex());
		}
	}

}
