package model.solver.beginner;

import model.solver.SolverComposite;
import model.solver.SolverFirstCross;
import model.solver.beginner.components.FirstLayer;
import model.solver.beginner.components.SecondLayer;
import model.solver.beginner.components.SolverBeginnerCornersTop;
import model.solver.beginner.components.SolverBeginnerEdgesTop;
import model.solver.beginner.components.SolverCrossTop;
import model.solver.beginner.components.SolverFaceTop;

public class SolverBeginner extends SolverComposite
{
	public SolverBeginner() 
	{
		super();
		this.addSolver(new SolverFirstCross());
		this.addSolver(new FirstLayer());
		this.addSolver(new SecondLayer());
		this.addSolver(new SolverCrossTop());
		this.addSolver(new SolverFaceTop());
		this.addSolver(new SolverBeginnerCornersTop());
		this.addSolver(new SolverBeginnerEdgesTop());
	}
}
