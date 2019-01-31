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

	private List<Integer[]> solveCube(Cube c, int numberStep, List<Integer[]> stepsList)
	{
		if(numberStep >= this.minSteps)
		{
			stepsList.add(null);
			return stepsList;
		}

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

				if(stepsList.get(stepsList.size() - 1) != null)
				{
					this.setBestCombination(stepsList);
				}

				for(int k = tmp; k < stepsList.size(); k++)
				{
					stepsList.remove(k);
				}

				c.rotateInvert(i, j);
			}
		}

		return bestCombination;
	}

	private void setBestCombination(List<Integer[]> steps)
	{
		this.bestCombination.removeRange(0, this.bestCombination.size() - 1);

		for(int i=0; i < steps.size(); i++)
		{
			this.bestCombination.add(steps.get(i));
		}
	}

	public List<Integer[]> getBestCombination()
	{
		return this.bestCombination;
	}
}