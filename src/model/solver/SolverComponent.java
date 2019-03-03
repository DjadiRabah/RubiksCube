package model.solver;

import java.util.ArrayList;

import event.RotationEvent;
import model.cube.Cube;

public abstract class SolverComponent implements Solver
{
	protected ArrayList<RotationEvent> rotations;
	
	public SolverComponent()
	{
		this.rotations = new ArrayList<RotationEvent>();
	}
	public abstract ArrayList<RotationEvent> solve(Cube cube);
}
