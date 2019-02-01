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
	private List<Integer[]> bestCombination, stepsList;
	private Cube c;
	private int cubeSize;

	public SolverBruteForceSecond(Cube c)
	{
		this.bestCombination = new ArrayList<>();
		this.stepsList = new ArrayList<>();
		this.c = c;
		this.cubeSize =  = this.c.getSize();
	}

	private List<Integer[]> solveCube(int numberStep)
	{
		if(numberStep >= this.minSteps)
		{
			this.stepsList.add(null);
			return this.stepsList;
		}

		if(this.c.isSolved())
		{
			this.minSteps = numberStep;
			return this.stepsList;
		}

		
		for(int i = 0; i < 6; i++)
		{
			for(int j = 0; j < this.cubeSize; j++)
			{
				c.rotate(i, j);

				int[] actualStep = {i, j};
				this.stepsList.add(actualStep);

				this.stepsList = solveCube(numberStep + 1);

				if(this.stepsList.get(this.stepsList.size() - 1) != null)
				{
					this.setBestCombination();
				}

				for(int k = numberStep; k < this.stepsList.size(); k++)
				{
					this.stepsList.remove(k);
				}

				this.c.rotateInvert(i, j);
			}
		}

		return bestCombination;
	}

	private void setBestCombination()
	{
		this.bestCombination.removeRange(0, this.bestCombination.size() - 1);

		for(int i=0; i < this.steps.size(); i++)
		{
			this.bestCombination.add(this.steps.get(i));
		}
	}

	public List<Integer[]> getBestCombination()
	{
		return this.bestCombination;
	}
}