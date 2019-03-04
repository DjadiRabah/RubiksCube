package model.solver;

import java.util.List;
import java.util.ArrayList;
import model.cube.Cube;
import model.cube.piece.*;
import model.cube.Square;
import model.rotation.Rotation;

public class SolverBruteForceSecond implements Solver
{
	private int minSteps = 25;
	private ArrayList<Integer[]> bestCombination, stepsList;
	private Cube c;
	private int cubeSize;

	public SolverBruteForceSecond()
	{
		this.bestCombination = new ArrayList<>();
		this.stepsList = new ArrayList<>();
	}

	private ArrayList<Integer[]> solveCube(int numberStep)
	{
		if(numberStep >= this.minSteps)
		{
			this.stepsList.add(null);
			return this.stepsList;
		}

		if(this.c.isSolved())
		{
			this.minSteps = numberStep;
			this.setBestCombination();
			return this.stepsList;
		}

		
		for(int i = 0; i < 6; i++)
		{
			for(int j = 0; j < this.cubeSize; j++)
			{
				c.rotate(i, j);

				Integer[] actualStep = {i, j};
				this.stepsList.add(actualStep);

				solveCube(numberStep + 1);

				/*if(this.stepsList.get(this.stepsList.size() - 1) != null)
				{
					this.setBestCombination();
					break;
				}*/

				for(int k = numberStep; k < this.stepsList.size(); k++)
				{
					this.stepsList.remove(k);
				}

				this.c.rotateInvert(i, j);
			}
		}

		return this.bestCombination;
	}

	private void setBestCombination()
	{
		this.bestCombination.clear();

		for(int i=0; i < this.stepsList.size(); i++)
		{
			this.bestCombination.add(this.stepsList.get(i));
		}
	}

	public ArrayList<Integer[]> getBestCombination()
	{
		return this.bestCombination;
	}

	public void solve(Cube cube) 
	{
		this.c = cube;
		this.cubeSize = this.c.getSize();
		this.solveCube(0);
	}
}