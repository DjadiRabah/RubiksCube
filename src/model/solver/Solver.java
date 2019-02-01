package model.solver;

import java.util.ArrayList;

import model.cube.Cube;

public interface Solver
{
	public ArrayList<Integer[]> solve(Cube cube);
}
