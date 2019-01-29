package model.solver;

import java.util.List;
import model.cube.Cube;
import model.cube.piece.*;
import model.cube.Square;
import model.rotation.Rotation;

public class SolverBruteForceSecond implements Solver
{
	private int min = 40;
	private List<Integer[]> bestCombination;

	public List<Integer[]> solveCube(Cube c, int numberStep, List<Integer[]> previousSteps)
	{
		if(numberStep >= this.min)
			return null;

		if(c.isSolved())
		{
			return previousSteps;
		}

		int cubeSize = c.getSize();
		for(int i = 0; i < 6; i++)
		{
			for(int j = 0; j < cubeSize; j++)
			{
				c.rotate(i, j);

				numberStep++;
				int[] actualStep = {i, j};
				previousSteps.add(actualStep);

				previousSteps = solveCube(c, numberStep, previousSteps);

				if((steps != null) 
				{
					bestCombination = steps;
				}

				c.rotateInvert(i, j);
			}
		}
	}
}