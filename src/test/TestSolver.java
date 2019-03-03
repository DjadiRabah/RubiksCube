package test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import event.RotationEvent;
import model.cube.Cube;
import model.shuffle.ShuffleRandom;
import model.solver.beginner.SolverBeginner;

class TestSolver 
{
	/*echoue si 1 cube parmi les 10000 n'est pas resolu */
	@Test
	void test() 
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
				fail(i + " " + cube);
			}
		}
	}
}
