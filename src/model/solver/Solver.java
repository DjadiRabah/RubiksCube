package model.solver;

import java.util.ArrayList;

import event.RotationEvent;
import model.cube.Cube;

public abstract class Solver
{
	protected ArrayList<RotationEvent> rotations;
	
	public Solver()
	{
		this.rotations = new ArrayList<RotationEvent>();
	}
	public abstract void solve(Cube cube);
}
