package model.solver;

import java.util.ArrayList;

import event.RotationEvent;
import model.cube.Cube;

public class SolverComposite implements Solver
{
	protected ArrayList<SolverComponent> solvers;
	public SolverComposite() 
	{
		solvers = new ArrayList<SolverComponent>();	
	}

	public void addSolver(SolverComponent solver)
	{
		this.solvers.add(solver);
	}
	
	public ArrayList<ArrayList<RotationEvent>> solve(Cube cube)
	{
		ArrayList<ArrayList<RotationEvent>> rotations = new ArrayList<ArrayList<RotationEvent>>();
		if(!cube.isSolved())
		{
			Cube copy = new Cube(cube);
			for(int currentSolver = 0; currentSolver < this.solvers.size(); currentSolver++)
			{
				rotations.add(this.solvers.get(currentSolver).solve(copy));
			}
		}
		return rotations;
	}
}
