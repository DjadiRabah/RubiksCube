package model.solver;

import java.util.ArrayList;

import event.RotationEvent;
import model.cube.Cube;
import model.rotation.Rotation;

public class SecondLayer extends Solver
{
	public SecondLayer() 
	{
		super();
	}
	
	public ArrayList<RotationEvent> solveEdgeLeft()
	{
		ArrayList<RotationEvent> newRotations = new ArrayList<RotationEvent>();
		newRotations.add(new RotationEvent(Rotation.RIGHT,0));
		newRotations.add(new RotationEvent(Rotation.UP,0));
		newRotations.add(new RotationEvent(Rotation.LEFT,0));
		newRotations.add(new RotationEvent(Rotation.DOWN,0));
		newRotations.add(new RotationEvent(Rotation.LEFT,0));
		newRotations.add(new RotationEvent(Rotation.CLOCKWISE,0));
		newRotations.add(new RotationEvent(Rotation.RIGHT,0));
		newRotations.add(new RotationEvent(Rotation.COUNTERCLOCKWISE,0));
		return newRotations;
	}
	
	public ArrayList<RotationEvent> solveEdgeRight()
	{
		ArrayList<RotationEvent> newRotations = new ArrayList<RotationEvent>();
		newRotations.add(new RotationEvent(Rotation.LEFT,0));
		newRotations.add(new RotationEvent(Rotation.UP,2));
		newRotations.add(new RotationEvent(Rotation.RIGHT,0));
		newRotations.add(new RotationEvent(Rotation.DOWN,2));
		newRotations.add(new RotationEvent(Rotation.RIGHT,0));
		newRotations.add(new RotationEvent(Rotation.COUNTERCLOCKWISE,0));
		newRotations.add(new RotationEvent(Rotation.LEFT,0));
		newRotations.add(new RotationEvent(Rotation.CLOCKWISE,0));
		return newRotations;
	}

	@Override
	public void solve(Cube cube)
	{
		Cube copy = new Cube(cube);
		
		/* on place la face deja faite en bas */
		for(int i = 0; i < copy.getSize(); i++)
		{
			this.rotations.add(new RotationEvent(Rotation.DOWN,i));
			this.rotations.add(new RotationEvent(Rotation.DOWN,i));
		}
		
		for(int i = 0; i < this.rotations.size(); i++)
		{
			RotationEvent rotation = this.rotations.get(i);
			copy.rotate(rotation.getDirection(),rotation.getIndex());
		}
		
		for(int currentEdge = 0; currentEdge < 4; currentEdge++)
		{
		
			int colorFront = copy.getSquare(Cube.FRONT).getColor();
			int colorLeft = copy.getSquare(Cube.LEFT).getColor();
			
			ArrayList<RotationEvent> newRotations = new ArrayList<RotationEvent>();
			
			if ((copy.getSquare(Cube.FRONT).getColor(0,1) == colorFront)
					&& (copy.getSquare(Cube.TOP).getColor(2,1) == colorLeft))
			{
				newRotations.addAll(this.solveEdgeLeft());
			}
			
			else if ((copy.getSquare(Cube.LEFT).getColor(0,1) == colorFront)
					&& (copy.getSquare(Cube.TOP).getColor(1,0) == colorLeft))
			{
				newRotations.add(new RotationEvent(Rotation.RIGHT,0));
				newRotations.addAll(this.solveEdgeLeft());
			}
			
			else if ((copy.getSquare(Cube.LEFT).getColor(1,2) == colorFront)
					&& (copy.getSquare(Cube.FRONT).getColor(1,0) == colorLeft))
			{
				newRotations.addAll(this.solveEdgeLeft());
				newRotations.add(new RotationEvent(Rotation.LEFT,0));
				newRotations.add(new RotationEvent(Rotation.LEFT,0));
				newRotations.addAll(this.solveEdgeLeft());
			}
			
			else if ((copy.getSquare(Cube.LEFT).getColor(1,0) == colorFront)
					&& (copy.getSquare(Cube.BACK).getColor(1,2) == colorLeft))
			{
				newRotations.add(new RotationEvent(Rotation.RIGHT,1));
				newRotations.add(new RotationEvent(Rotation.RIGHT,2));
				newRotations.addAll(this.solveEdgeLeft());
				newRotations.add(new RotationEvent(Rotation.LEFT,0));
				newRotations.add(new RotationEvent(Rotation.LEFT,0));
				newRotations.addAll(this.solveEdgeRight());
				newRotations.add(new RotationEvent(Rotation.LEFT,1));
				newRotations.add(new RotationEvent(Rotation.LEFT,2));		
			}
			
			else if ((copy.getSquare(Cube.TOP).getColor(0,1) == colorFront)
					&& (copy.getSquare(Cube.BACK).getColor(0,1) == colorLeft))
			{
				newRotations.add(new RotationEvent(Rotation.LEFT,0));
				newRotations.add(new RotationEvent(Rotation.LEFT,0));
				newRotations.add(new RotationEvent(Rotation.RIGHT,1));
				newRotations.add(new RotationEvent(Rotation.RIGHT,2));
				newRotations.addAll(this.solveEdgeRight());
				newRotations.add(new RotationEvent(Rotation.LEFT,1));
				newRotations.add(new RotationEvent(Rotation.LEFT,2));
			}
			
			else if ((copy.getSquare(Cube.TOP).getColor(2,1) == colorFront)
					&& (copy.getSquare(Cube.FRONT).getColor(0,1) == colorLeft))
			{
				newRotations.add(new RotationEvent(Rotation.RIGHT,1));
				newRotations.add(new RotationEvent(Rotation.RIGHT,2));
				newRotations.addAll(this.solveEdgeRight());
				newRotations.add(new RotationEvent(Rotation.LEFT,1));
				newRotations.add(new RotationEvent(Rotation.LEFT,2));
			}
			
			else if ((copy.getSquare(Cube.TOP).getColor(1,0) == colorFront)
					&& (copy.getSquare(Cube.LEFT).getColor(0,1) == colorLeft))
			{
				newRotations.add(new RotationEvent(Rotation.RIGHT,0));
				newRotations.add(new RotationEvent(Rotation.RIGHT,1));
				newRotations.add(new RotationEvent(Rotation.RIGHT,2));
				newRotations.addAll(this.solveEdgeRight());
				newRotations.add(new RotationEvent(Rotation.LEFT,1));
				newRotations.add(new RotationEvent(Rotation.LEFT,2));
			}
			
			else if ((copy.getSquare(Cube.TOP).getColor(1,2) == colorFront)
					&& (copy.getSquare(Cube.RIGHT).getColor(0,1) == colorLeft))
			{
				newRotations.add(new RotationEvent(Rotation.LEFT,0));
				newRotations.add(new RotationEvent(Rotation.RIGHT,1));
				newRotations.add(new RotationEvent(Rotation.RIGHT,2));
				newRotations.addAll(this.solveEdgeRight());
				newRotations.add(new RotationEvent(Rotation.LEFT,1));
				newRotations.add(new RotationEvent(Rotation.LEFT,2));
			}
			
			else if ((copy.getSquare(Cube.RIGHT).getColor(1,2) == colorFront)
					&& (copy.getSquare(Cube.BACK).getColor(1,0) == colorLeft))
			{
				newRotations.add(new RotationEvent(Rotation.LEFT,1));
				newRotations.add(new RotationEvent(Rotation.LEFT,2));
				newRotations.addAll(this.solveEdgeRight());
				newRotations.add(new RotationEvent(Rotation.LEFT,0));
				newRotations.add(new RotationEvent(Rotation.LEFT,1));
				newRotations.add(new RotationEvent(Rotation.LEFT,2));
				newRotations.add(new RotationEvent(Rotation.LEFT,0));
				newRotations.add(new RotationEvent(Rotation.LEFT,1));
				newRotations.add(new RotationEvent(Rotation.LEFT,2));
				newRotations.addAll(this.solveEdgeRight());
				newRotations.add(new RotationEvent(Rotation.LEFT,1));
				newRotations.add(new RotationEvent(Rotation.LEFT,2));
			}
			
			else if ((copy.getSquare(Cube.FRONT).getColor(1,2) == colorFront)
					&& (copy.getSquare(Cube.RIGHT).getColor(1,0) == colorLeft))
			{
				newRotations.addAll(this.solveEdgeRight());
				newRotations.add(new RotationEvent(Rotation.LEFT,0));
				newRotations.add(new RotationEvent(Rotation.LEFT,0));
				newRotations.add(new RotationEvent(Rotation.RIGHT,1));
				newRotations.add(new RotationEvent(Rotation.RIGHT,2));
				newRotations.addAll(this.solveEdgeRight());
				newRotations.add(new RotationEvent(Rotation.LEFT,1));
				newRotations.add(new RotationEvent(Rotation.LEFT,2));
			}
			
			else if ((copy.getSquare(Cube.BACK).getColor(1,0) == colorFront)
					&& (copy.getSquare(Cube.RIGHT).getColor(1,2) == colorLeft))
			{
				newRotations.add(new RotationEvent(Rotation.LEFT,1));
				newRotations.add(new RotationEvent(Rotation.LEFT,2));
				newRotations.addAll(this.solveEdgeRight());
				newRotations.add(new RotationEvent(Rotation.LEFT,0));
				newRotations.add(new RotationEvent(Rotation.LEFT,0));
				newRotations.add(new RotationEvent(Rotation.RIGHT,1));
				newRotations.add(new RotationEvent(Rotation.RIGHT,2));
				newRotations.addAll(this.solveEdgeLeft());
			}
			
			else if ((copy.getSquare(Cube.RIGHT).getColor(1,0) == colorFront)
					&& (copy.getSquare(Cube.FRONT).getColor(1,2) == colorLeft))
			{
				newRotations.addAll(this.solveEdgeRight());
				newRotations.add(new RotationEvent(Rotation.LEFT,0));
				newRotations.add(new RotationEvent(Rotation.LEFT,0));
				newRotations.addAll(this.solveEdgeLeft());
			}
			
			else if ((copy.getSquare(Cube.RIGHT).getColor(0,1) == colorFront)
					&& (copy.getSquare(Cube.TOP).getColor(1,2) == colorLeft))
			{
				newRotations.add(new RotationEvent(Rotation.LEFT,0));
				newRotations.addAll(this.solveEdgeLeft());
			}
			
			else if ((copy.getSquare(Cube.BACK).getColor(0,1) == colorFront)
					&& (copy.getSquare(Cube.TOP).getColor(0,1) == colorLeft))
			{
				newRotations.add(new RotationEvent(Rotation.LEFT,0));
				newRotations.add(new RotationEvent(Rotation.LEFT,0));
				newRotations.addAll(this.solveEdgeLeft());
			}
			
			else if ((copy.getSquare(Cube.BACK).getColor(1,2) == colorFront)
					&& (copy.getSquare(Cube.LEFT).getColor(1,0) == colorLeft))
			{
				newRotations.add(new RotationEvent(Rotation.RIGHT,1));
				newRotations.add(new RotationEvent(Rotation.RIGHT,2));
				newRotations.addAll(this.solveEdgeLeft());
				newRotations.add(new RotationEvent(Rotation.LEFT,0));
				newRotations.add(new RotationEvent(Rotation.LEFT,0));
				newRotations.add(new RotationEvent(Rotation.LEFT,1));
				newRotations.add(new RotationEvent(Rotation.LEFT,2));
				newRotations.addAll(this.solveEdgeLeft());
			}
			
			if(currentEdge < 3)
			{
				newRotations.add(new RotationEvent(Rotation.LEFT,0));
				newRotations.add(new RotationEvent(Rotation.LEFT,1));
				newRotations.add(new RotationEvent(Rotation.LEFT,2));
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
