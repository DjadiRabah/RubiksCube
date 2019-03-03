package model.solver;

import java.util.ArrayList;

import event.RotationEvent;
import model.cube.Cube;
import model.rotation.Rotation;

public class SolverCrossTop extends Solver
{

	public SolverCrossTop() 
	{
		super();
	}
	
	private boolean checkCross(Cube cube)
	{
		int colorTop = cube.getSquare(Cube.TOP).getColor();
		if ((cube.getSquare(Cube.TOP).getColor(0,1) == colorTop)
			&& (cube.getSquare(Cube.TOP).getColor(1,0) == colorTop)
			&& (cube.getSquare(Cube.TOP).getColor(1,2) == colorTop)
			&& (cube.getSquare(Cube.TOP).getColor(2,1) == colorTop))
		{
			return true;
		}
		return false;
	}
	
	private boolean checkHorizontalLine(Cube cube)
	{
		int colorTop = cube.getSquare(Cube.TOP).getColor();
		if ((cube.getSquare(Cube.TOP).getColor(1,0) == colorTop)
			&& (cube.getSquare(Cube.TOP).getColor(1,2) == colorTop))
		{
			return true;
		}
		return false;
	}
	
	private boolean checkVerticalLine(Cube cube)
	{
		int colorTop = cube.getSquare(Cube.TOP).getColor();
		if ((cube.getSquare(Cube.TOP).getColor(0,1) == colorTop)
			&& (cube.getSquare(Cube.TOP).getColor(2,1) == colorTop))
		{
			return true;
		}
		return false;
	}
	
	private boolean checkLeftTopL(Cube cube)
	{
		int colorTop = cube.getSquare(Cube.TOP).getColor();
		if ((cube.getSquare(Cube.TOP).getColor(0,1) == colorTop)
			&& (cube.getSquare(Cube.TOP).getColor(1,0) == colorTop))
		{
			return true;
		}
		return false;
	}
	
	private boolean checkTopRightL(Cube cube)
	{
		int colorTop = cube.getSquare(Cube.TOP).getColor();
		if ((cube.getSquare(Cube.TOP).getColor(0,1) == colorTop)
			&& (cube.getSquare(Cube.TOP).getColor(1,2) == colorTop))
		{
			return true;
		}
		return false;
	}
	
	private boolean checkBotRightL(Cube cube)
	{
		int colorTop = cube.getSquare(Cube.TOP).getColor();
		if ((cube.getSquare(Cube.TOP).getColor(2,1) == colorTop)
			&& (cube.getSquare(Cube.TOP).getColor(1,2) == colorTop))
		{
			return true;
		}
		return false;
	}
	
	private boolean checkBotLeftL(Cube cube)
	{
		int colorTop = cube.getSquare(Cube.TOP).getColor();
		if ((cube.getSquare(Cube.TOP).getColor(2,1) == colorTop)
			&& (cube.getSquare(Cube.TOP).getColor(1,0) == colorTop))
		{
			return true;
		}
		return false;
	}

	@Override
	public void solve(Cube cube) 
	{
		Cube copy = new Cube(cube);
		
		while(!this.checkCross(copy))
		{
			ArrayList<RotationEvent> newRotations = new ArrayList<RotationEvent>();
			if(this.checkHorizontalLine(copy))
			{
				newRotations.add(new RotationEvent(Rotation.CLOCKWISE,0));
				newRotations.add(new RotationEvent(Rotation.UP,2));
				newRotations.add(new RotationEvent(Rotation.LEFT,0));
				newRotations.add(new RotationEvent(Rotation.DOWN,2));
				newRotations.add(new RotationEvent(Rotation.RIGHT,0));
				newRotations.add(new RotationEvent(Rotation.COUNTERCLOCKWISE,0));
			}
			
			else if(this.checkVerticalLine(copy))
			{
				newRotations.add(new RotationEvent(Rotation.LEFT,0));
				newRotations.add(new RotationEvent(Rotation.CLOCKWISE,0));
				newRotations.add(new RotationEvent(Rotation.UP,2));
				newRotations.add(new RotationEvent(Rotation.LEFT,0));
				newRotations.add(new RotationEvent(Rotation.DOWN,2));
				newRotations.add(new RotationEvent(Rotation.RIGHT,0));
				newRotations.add(new RotationEvent(Rotation.COUNTERCLOCKWISE,0));
			}
			
			else if(this.checkLeftTopL(copy))
			{
				newRotations.add(new RotationEvent(Rotation.CLOCKWISE,0));
				newRotations.add(new RotationEvent(Rotation.LEFT,0));
				newRotations.add(new RotationEvent(Rotation.UP,2));
				newRotations.add(new RotationEvent(Rotation.RIGHT,0));
				newRotations.add(new RotationEvent(Rotation.DOWN,2));
				newRotations.add(new RotationEvent(Rotation.COUNTERCLOCKWISE,0));
			}
			
			else if(this.checkTopRightL(copy))
			{
				newRotations.add(new RotationEvent(Rotation.RIGHT,0));
				newRotations.add(new RotationEvent(Rotation.CLOCKWISE,0));
				newRotations.add(new RotationEvent(Rotation.LEFT,0));
				newRotations.add(new RotationEvent(Rotation.UP,2));
				newRotations.add(new RotationEvent(Rotation.RIGHT,0));
				newRotations.add(new RotationEvent(Rotation.DOWN,2));
				newRotations.add(new RotationEvent(Rotation.COUNTERCLOCKWISE,0));
			}
			
			else if(this.checkBotRightL(copy))
			{
				newRotations.add(new RotationEvent(Rotation.RIGHT,0));
				newRotations.add(new RotationEvent(Rotation.RIGHT,0));
				newRotations.add(new RotationEvent(Rotation.CLOCKWISE,0));
				newRotations.add(new RotationEvent(Rotation.LEFT,0));
				newRotations.add(new RotationEvent(Rotation.UP,2));
				newRotations.add(new RotationEvent(Rotation.RIGHT,0));
				newRotations.add(new RotationEvent(Rotation.DOWN,2));
				newRotations.add(new RotationEvent(Rotation.COUNTERCLOCKWISE,0));
			}
			
			else if(this.checkBotLeftL(copy))
			{
				newRotations.add(new RotationEvent(Rotation.LEFT,0));
				newRotations.add(new RotationEvent(Rotation.CLOCKWISE,0));
				newRotations.add(new RotationEvent(Rotation.LEFT,0));
				newRotations.add(new RotationEvent(Rotation.UP,2));
				newRotations.add(new RotationEvent(Rotation.RIGHT,0));
				newRotations.add(new RotationEvent(Rotation.DOWN,2));
				newRotations.add(new RotationEvent(Rotation.COUNTERCLOCKWISE,0));
			}
			
			else
			{
				newRotations.add(new RotationEvent(Rotation.CLOCKWISE,0));
				newRotations.add(new RotationEvent(Rotation.LEFT,0));
				newRotations.add(new RotationEvent(Rotation.UP,2));
				newRotations.add(new RotationEvent(Rotation.RIGHT,0));
				newRotations.add(new RotationEvent(Rotation.DOWN,2));
				newRotations.add(new RotationEvent(Rotation.COUNTERCLOCKWISE,0));
			}
			
			for(int i = 0; i < newRotations.size(); i++)
			{
				RotationEvent rotation = newRotations.get(i);
				copy.rotate(rotation.getDirection(),rotation.getIndex());
			}
			this.rotations.addAll(newRotations);
		}
	
		for(int i = 0; i < this.rotations.size(); i++)
		{
			RotationEvent rotation = this.rotations.get(i);
			cube.rotate(rotation.getDirection(),rotation.getIndex());
		}
	}

}
