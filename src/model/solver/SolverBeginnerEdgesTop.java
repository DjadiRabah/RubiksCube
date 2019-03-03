package model.solver;

import java.util.ArrayList;
import event.RotationEvent;
import model.cube.Cube;
import model.rotation.Rotation;

public class SolverBeginnerEdgesTop extends Solver
{
	public SolverBeginnerEdgesTop() 
	{
		super();
	}
	
	private boolean checkEdge(Cube cube, int face)
	{
		int color = cube.getSquare(face).getColor();
		if (cube.getSquare(face).getColor(0,1) == color)
		{
			return true;
		}
		return false;
	}
	
	private ArrayList<RotationEvent> solveEdgesClockwise()
	{
		ArrayList<RotationEvent> newRotations = new ArrayList<RotationEvent>();
		newRotations.add(new RotationEvent(Rotation.CLOCKWISE,0));
		newRotations.add(new RotationEvent(Rotation.CLOCKWISE,0));
		newRotations.add(new RotationEvent(Rotation.LEFT,0));
		newRotations.add(new RotationEvent(Rotation.DOWN,0));
		newRotations.add(new RotationEvent(Rotation.DOWN,2));
		newRotations.add(new RotationEvent(Rotation.CLOCKWISE,0));
		newRotations.add(new RotationEvent(Rotation.CLOCKWISE,0));
		newRotations.add(new RotationEvent(Rotation.UP,0));
		newRotations.add(new RotationEvent(Rotation.UP,2));
		newRotations.add(new RotationEvent(Rotation.LEFT,0));
		newRotations.add(new RotationEvent(Rotation.CLOCKWISE,0));
		newRotations.add(new RotationEvent(Rotation.CLOCKWISE,0));
		return newRotations;
	}
	
	private ArrayList<RotationEvent> solveEdgesCounterClockwise()
	{
		ArrayList<RotationEvent> newRotations = new ArrayList<RotationEvent>();
		newRotations.add(new RotationEvent(Rotation.CLOCKWISE,0));
		newRotations.add(new RotationEvent(Rotation.CLOCKWISE,0));
		newRotations.add(new RotationEvent(Rotation.RIGHT,0));
		newRotations.add(new RotationEvent(Rotation.DOWN,0));
		newRotations.add(new RotationEvent(Rotation.DOWN,2));
		newRotations.add(new RotationEvent(Rotation.CLOCKWISE,0));
		newRotations.add(new RotationEvent(Rotation.CLOCKWISE,0));
		newRotations.add(new RotationEvent(Rotation.UP,0));
		newRotations.add(new RotationEvent(Rotation.UP,2));
		newRotations.add(new RotationEvent(Rotation.RIGHT,0));
		newRotations.add(new RotationEvent(Rotation.CLOCKWISE,0));
		newRotations.add(new RotationEvent(Rotation.CLOCKWISE,0));
		return newRotations;
	}

	@Override
	public void solve(Cube cube) 
	{
		Cube copy = new Cube(cube);
		
		while(!this.checkEdge(copy, Cube.LEFT) || !this.checkEdge(copy, Cube.FRONT) || !this.checkEdge(copy, Cube.RIGHT) || !this.checkEdge(copy, Cube.RIGHT))
		{
			int edgesSolved = 0;
			
			if(this.checkEdge(copy, Cube.LEFT))
			{
				edgesSolved++;
			}
			if(this.checkEdge(copy, Cube.FRONT))
			{
				edgesSolved++;
			}
			if(this.checkEdge(copy, Cube.RIGHT))
			{
				edgesSolved++;
			}
			if(this.checkEdge(copy, Cube.BACK))
			{
				edgesSolved++;
			}
			
			ArrayList<RotationEvent> newRotations = new ArrayList<RotationEvent>();
			
			if(edgesSolved == 0)
			{	
				newRotations.addAll(this.solveEdgesCounterClockwise());	
			}
			
			else if(edgesSolved == 1)
			{
				if(this.checkEdge(copy, Cube.LEFT))
				{
					newRotations.add(new RotationEvent(Rotation.LEFT,0));
					newRotations.add(new RotationEvent(Rotation.LEFT,1));
					newRotations.add(new RotationEvent(Rotation.LEFT,2));
				}
				else if(this.checkEdge(copy, Cube.FRONT))
				{
					newRotations.add(new RotationEvent(Rotation.LEFT,0));
					newRotations.add(new RotationEvent(Rotation.LEFT,1));
					newRotations.add(new RotationEvent(Rotation.LEFT,2));
					newRotations.add(new RotationEvent(Rotation.LEFT,0));
					newRotations.add(new RotationEvent(Rotation.LEFT,1));
					newRotations.add(new RotationEvent(Rotation.LEFT,2));
				} 
				else if(this.checkEdge(copy, Cube.RIGHT))
				{
					newRotations.add(new RotationEvent(Rotation.RIGHT,0));
					newRotations.add(new RotationEvent(Rotation.RIGHT,1));
					newRotations.add(new RotationEvent(Rotation.RIGHT,2));
				}
				for(int i = 0; i < newRotations.size(); i++)
				{
					RotationEvent rotation = newRotations.get(i);
					copy.rotate(rotation.getDirection(),rotation.getIndex());
				}
				this.rotations.addAll(newRotations);
				newRotations = new ArrayList<RotationEvent>();
				
				int colorLeft = copy.getSquare(Cube.LEFT).getColor();
				int colorFront = copy.getSquare(Cube.FRONT).getColor();
				int colorRight = copy.getSquare(Cube.RIGHT).getColor();
				if ((copy.getSquare(Cube.LEFT).getColor(0,1) == colorRight)
					&& (copy.getSquare(Cube.FRONT).getColor(0,1) == colorLeft)
					&& (copy.getSquare(Cube.RIGHT).getColor(0,1) == colorFront))
				{
					newRotations.addAll(this.solveEdgesClockwise());
				}
				
				else if ((copy.getSquare(Cube.LEFT).getColor(0,1) == colorFront)
						&& (copy.getSquare(Cube.FRONT).getColor(0,1) == colorRight)
						&& (copy.getSquare(Cube.RIGHT).getColor(0,1) == colorLeft))
				{
					newRotations.addAll(this.solveEdgesCounterClockwise());
				}
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
