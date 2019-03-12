package model.solver;

import java.util.List;
import java.util.ArrayList;
import model.cube.Cube;
import model.cube.piece.*;
import model.cube.Square;
import model.rotation.Rotation;

public class SolverBruteForceSecond implements Solver
{
	private int max = 21;
	private ArrayList<Integer[]> stepsList;
	private Cube c;
	private int cubeSize;

	private void solveCube(int numberStep)
	{
		if(numberStep >= this.max)
			return;

		if(c.isSolved())
			return;

		for(int i = 0; i < 6; i++)
		{
			for(int j = 0; j < this.cubeSize; j++)
			{
				if(!isLastRotationInverted(i, j))
				{
					c.rotate(i, j);

					Integer[] actualStep = {i, j};
					this.stepsList.add(actualStep);

					solveCube(numberStep + 1);

					if(c.isSolved())
						return;

					for(int k = numberStep; k < this.stepsList.size(); k++)
						this.stepsList.remove(k);

					this.c.rotateInvert(i, j);
				}
			}
		}
	}

	public ArrayList<Integer[]> solve(Cube cube) 
	{
		this.stepsList = new ArrayList<>();
		this.c = cube;
		this.cubeSize = this.c.getSize();
		this.solveCube(0);
		return this.stepsList;
	}

	private boolean isLastRotationInverted(int i, int j)
	{
		if(this.stepsList.isEmpty())
			return false;

		Integer[] tab = this.stepsList.get(this.stepsList.size() - 1);
		if(j != tab[1])
			return false;
		if(((i%2) == 0) && (i+1) == tab[0])
			return true;
		if(((i%2) == 1) && (i-1) == tab[0])
			return true;
		return false;
	}
}