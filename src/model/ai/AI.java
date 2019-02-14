package model.ai;

import java.util.ArrayList;

import model.cube.Cube;

public class AI 
{
	protected boolean isDead;
	protected boolean solved;
	protected Brain brain;
	protected Cube cube;
	protected int targetFitness;
	protected int targetStep;
	protected int fitness;
	protected boolean isBestAi;
	
	public AI(Cube cube)
	{
		this.isDead = false;
		this.solved = false;
		this.brain = new Brain(cube.getSize());
		this.cube = new Cube(cube);
		this.targetFitness = cube.getNumberRightColor();
		this.targetStep = 0;
		this.fitness = 0;
		this.isBestAi = false;
	}
	
	public AI(Cube cube, Brain brain, int bestFitness, int bestStep)
	{
		this.isDead = false;
		this.solved = false;
		this.brain = new Brain(brain);
		this.cube = new Cube(cube);
		this.targetFitness = bestFitness;
		this.targetStep = bestStep;
		this.fitness = 0;
		this.isBestAi = false;
	}
	
	public AI(Cube cube, int bestFitness, int bestStep)
	{
		this.isDead = false;
		this.solved = false;
		this.brain = new Brain(cube.getSize());
		this.cube = new Cube(cube);
		this.targetFitness = bestFitness;
		this.targetStep = bestStep;
		this.fitness = 0;
		this.isBestAi = false;
	}
	
	public void setBest(boolean isBest)
	{
		this.isBestAi = isBest;
	}
	
	public void rotate()
	{
		if(this.brain.getStep() < 20)
		{
			this.cube.rotate(this.brain.getRotation());
			this.fitness = this.cube.getNumberRightColor();
			if (this.fitness > this.targetFitness)
			{
				this.isDead = true;
			}
			else if (this.fitness == this.targetFitness)
			{
				if (this.brain.getStep() < this.targetStep)
				{
					this.isDead = true;	
				}
			}
			else
				this.brain.nextStep();
		}
		else
		{
			this.isDead = true;
		}
	}
	
	public Cube getCube()
	{
		return this.cube;
	}
	
	public void update()
	{
		if(this.isBestAi)
			this.isDead = true;
		if(!this.isDead && !this.solved)
		{
			this.rotate();
			if(this.cube.isSolved())
			{
				this.solved = true;
			}
		}
	}
	
	public boolean isDead()
	{
		return this.isDead;
	}
	
	public boolean hasSolved()
	{
		return this.solved;
	}
	
	public void setFitness()
	{
		if(this.solved)
		{
			this.fitness = this.cube.getSize() * this.cube.getSize() * 6;
		}
		else
		{
			this.fitness = this.cube.getNumberRightColor();
		}
	}
	
	public void setDeath(boolean isDead)
	{
		this.isDead = isDead;
	}
	
	public int getFitness()
	{
		return this.fitness;
	}
	
	public Brain getBrain()
	{
		return this.brain;
	}
	
	public AI getBaby(Cube cube, int bestFitness, int bestStep)
	{
		AI baby = new AI(cube,this.brain, bestFitness, bestStep);
		return baby;
	}
	
	public ArrayList<Integer[]> getRotations()
	{
		return this.brain.getRotations();
	}
	

}
