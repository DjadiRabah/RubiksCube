package model.solver;

import java.util.List;
import java.util.ArrayList;
import model.cube.Cube;
import model.cube.piece.*;
import model.cube.Square;
import model.rotation.Rotation;

public class SolverBruteForceSecond implements Solver
{
	private int minSteps = 40;
	private List<Integer[]> bestCombination;

	public SolverBruteForceSecond()
	{
		this.bestCombination = new ArrayList<>();
	}

	public startSolver(Cube c)
	{
		//List<Integer[]> l = new ArrayList<>();
		this.solveCube(c, 0, l);
		//this.bestCombination = l;
	}

	private List<Integer[]> solveCube(Cube c, int numberStep, List<Integer[]> stepsList)
	{
		if(numberStep >= this.minSteps)
			return null;

		if(c.isSolved())
		{
			this.minSteps = numberStep;
			return stepsList;
		}

		int cubeSize = c.getSize();
		for(int i = 0; i < 6; i++)
		{
			for(int j = 0; j < cubeSize; j++)
			{
				c.rotate(i, j);

				int[] actualStep = {i, j};
				stepsList.add(actualStep);

				stepsList = solveCube(c, (numberStep + 1), stepsList);

				if(stepsList != null)
				{
					this.bestCombination = steps;
				}

				//probleme nullpointerexception (je pense)
				for(int k = tmp; k < stepsList.size(); k++)
				{
					stepsList.remove(k);
				}

				c.rotateInvert(i, j);
			}
		}

		return bestCombination;
	}
}