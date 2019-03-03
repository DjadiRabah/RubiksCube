package model.solver;

import java.util.ArrayList;

import event.RotationEvent;
import model.cube.Cube;
import model.rotation.Rotation;

public class SolverBeginnerCornersTop extends Solver
{
	public SolverBeginnerCornersTop() 
	{
		super();
	}
	
	private boolean checkLeftBack(Cube cube)
	{
		int colorLeft = cube.getSquare(Cube.LEFT).getColor();
		int colorBack = cube.getSquare(Cube.BACK).getColor();
		if ((cube.getSquare(Cube.LEFT).getColor(0,0) == colorLeft)
			&& (cube.getSquare(Cube.BACK).getColor(0,2) == colorBack))
		{
			return true;
		}
		return false;
	}
	
	private boolean checkLeftFront(Cube cube)
	{
		int colorLeft = cube.getSquare(Cube.LEFT).getColor();
		int colorFront = cube.getSquare(Cube.FRONT).getColor();
		if ((cube.getSquare(Cube.LEFT).getColor(0,2) == colorLeft)
			&& (cube.getSquare(Cube.FRONT).getColor(0,0) == colorFront))
		{
			return true;
		}
		return false;
	}
	
	private boolean checkRightBack(Cube cube)
	{
		int colorRight = cube.getSquare(Cube.RIGHT).getColor();
		int colorBack = cube.getSquare(Cube.BACK).getColor();
		if ((cube.getSquare(Cube.RIGHT).getColor(0,2) == colorRight)
			&& (cube.getSquare(Cube.BACK).getColor(0,0) == colorBack))
		{
			return true;
		}
		return false;
	}
	
	private boolean checkRightFront(Cube cube)
	{
		int colorRight = cube.getSquare(Cube.RIGHT).getColor();
		int colorFront = cube.getSquare(Cube.FRONT).getColor();
		if ((cube.getSquare(Cube.RIGHT).getColor(0,0) == colorRight)
			&& (cube.getSquare(Cube.FRONT).getColor(0,2) == colorFront))
		{
			return true;
		}
		return false;
	}
	
	public ArrayList<RotationEvent> solveCorners()
	{
		ArrayList<RotationEvent> newRotations = new ArrayList<RotationEvent>();
		newRotations.add(new RotationEvent(Rotation.DOWN,2));
		newRotations.add(new RotationEvent(Rotation.CLOCKWISE,0));
		newRotations.add(new RotationEvent(Rotation.DOWN,2));
		newRotations.add(new RotationEvent(Rotation.COUNTERCLOCKWISE,2));
		newRotations.add(new RotationEvent(Rotation.COUNTERCLOCKWISE,2));
		newRotations.add(new RotationEvent(Rotation.UP,2));
		newRotations.add(new RotationEvent(Rotation.COUNTERCLOCKWISE,0));
		newRotations.add(new RotationEvent(Rotation.DOWN,2));
		newRotations.add(new RotationEvent(Rotation.COUNTERCLOCKWISE,2));
		newRotations.add(new RotationEvent(Rotation.COUNTERCLOCKWISE,2));
		newRotations.add(new RotationEvent(Rotation.UP,2));
		newRotations.add(new RotationEvent(Rotation.UP,2));
		newRotations.add(new RotationEvent(Rotation.RIGHT,0));
		return newRotations;
	}

	@Override
	public void solve(Cube cube) 
	{
		Cube copy = new Cube(cube);
		
		while (!this.checkLeftBack(copy) || !this.checkLeftFront(copy)
				|| !this.checkRightBack(copy) || !this.checkRightFront(copy))
		{
			int max = 0;
			int corners = 0;
			for(int i = 0; i < 4; i++)
			{
				if (this.checkLeftBack(copy))
				{
					corners++;
				}
				if (this.checkLeftFront(copy))
				{
					corners++;
				}
				if (this.checkRightBack(copy))
				{
					corners++;
				}
				if (this.checkRightFront(copy))
				{
					corners++;
				}
				if(corners > max)
					max = corners;
				copy.rotate(Rotation.LEFT, 0);
				corners = 0;
			}
			ArrayList<RotationEvent> newRotations = new ArrayList<RotationEvent>();
			while(corners != max)
			{
				corners = 0;
				if (this.checkLeftBack(copy))
				{
					corners++;
				}
				if (this.checkLeftFront(copy))
				{
					corners++;
				}
				if (this.checkRightBack(copy))
				{
					corners++;
				}
				if (this.checkRightFront(copy))
				{
					corners++;
				}
				if(corners != max)
				{
					newRotations.add(new RotationEvent(Rotation.LEFT,0));
					copy.rotate(Rotation.LEFT,0);
				}
			}
			
			this.rotations.addAll(newRotations);
			newRotations = new ArrayList<RotationEvent>();
			
			if(max == 2)
			{
				if(this.checkLeftBack(copy) && this.checkLeftFront(copy))
				{
					newRotations.add(new RotationEvent(Rotation.LEFT,0));
					newRotations.add(new RotationEvent(Rotation.LEFT,1));
					newRotations.add(new RotationEvent(Rotation.LEFT,2));
				}
				else if(this.checkRightBack(copy) && this.checkRightFront(copy))
				{
					newRotations.add(new RotationEvent(Rotation.RIGHT,0));
					newRotations.add(new RotationEvent(Rotation.RIGHT,1));
					newRotations.add(new RotationEvent(Rotation.RIGHT,2));
				}
				else if(this.checkRightFront(copy) && this.checkLeftFront(copy))
				{
					newRotations.add(new RotationEvent(Rotation.RIGHT,0));
					newRotations.add(new RotationEvent(Rotation.RIGHT,1));
					newRotations.add(new RotationEvent(Rotation.RIGHT,2));
					newRotations.add(new RotationEvent(Rotation.RIGHT,0));
					newRotations.add(new RotationEvent(Rotation.RIGHT,1));
					newRotations.add(new RotationEvent(Rotation.RIGHT,2));
				}
				newRotations.addAll(this.solveCorners());
			}
			
			this.rotations.addAll(newRotations);
			for(int i = 0; i < newRotations.size(); i++)
			{
				RotationEvent rotation = newRotations.get(i);
				copy.rotate(rotation.getDirection(),rotation.getIndex());
			}
		}
		
		for(int i = 0; i < this.rotations.size(); i++)
		{
			RotationEvent rotation = this.rotations.get(i);
			cube.rotate(rotation.getDirection(),rotation.getIndex());
		}	
	}
}
