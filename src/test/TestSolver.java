package test;

import java.util.ArrayList;

import event.RotationEvent;
import model.cube.Cube;
import model.shuffle.ShuffleRandom;
import model.solver.beginner.SolverBeginner;

public class TestSolver 
{
	public TestSolver() 
	{
	}
	
	/* renvoie true si les 10000 cubes sont resolus
	 * et false sinon
	 */
	public boolean test()
	{
		for(int i = 0; i < 10000; i++)
		{
			Cube cube = new Cube(3);
			cube.shuffle(new ShuffleRandom());
			ArrayList<ArrayList<RotationEvent>> rotations = new SolverBeginner().solve(cube);
			for(int currentSolver = 0; currentSolver < rotations.size(); currentSolver++)
			{
				ArrayList<RotationEvent> currentRotations = rotations.get(currentSolver);
				for(int currentRotation = 0; currentRotation < currentRotations.size(); currentRotation++)
				{
					RotationEvent rotation = currentRotations.get(currentRotation);
					cube.rotate(rotation.getDirection(), rotation.getIndex());
				}
			}
			if(!cube.isSolved())
			{
				System.out.println(i + " " + cube);
				return false;
			}
		}
		return true;
	}
}
