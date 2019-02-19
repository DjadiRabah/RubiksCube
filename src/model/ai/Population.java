package model.ai;

import java.util.Random;

import model.cube.Cube;

public class Population 
{
	/*
	protected AI[] ais;
	protected Cube cube;
	protected int generation;
	protected int maxStep;
	protected int bestAi;
	protected int fitnessSum;
	protected boolean hasSolved;
	
	public Population(int size, Cube cube)
	{
		this.generation = 1;
		this.hasSolved = false;
		this.ais = new AI[size];
		this.cube = cube;
		for(int i = 0; i < size; i++)
		{
			this.ais[i] = new AI(this.cube);
		}
		this.maxStep = 20;
		this.bestAi = -1;
		this.fitnessSum = 0;
	}
	
	public boolean hasSolved()
	{
		return this.hasSolved;
	}
	public void update()
	{
		for(int i = 0; i < this.ais.length; i++)
		{
			if(this.ais[i].getBrain().getStep() > this.maxStep)
			{
				this.ais[i].setDeath(true);
			}
			else
			{
				this.ais[i].update();
				if(this.ais[i].hasSolved())
				{
					this.hasSolved = true;
					this.bestAi = i;
					return;
				}
			}
		}
	}
	
	public void naturalSelection()
	{
		this.generation = this.generation + 1;
		AI[] newAis = new AI[ais.length];
		this.setBestAiIndex();
		this.setFitnessSum();
		
		newAis[0] = new AI(this.ais[this.bestAi].getCube(),this.ais[this.bestAi].getBrain(), this.ais[this.bestAi].getFitness(), this.ais[this.bestAi].getBrain().getStep());
		System.out.println(this.generation + " : " + this.ais[this.bestAi].getFitness() + " " + this.ais[this.bestAi].getBrain().getStep());
		for(int i = 1; i < this.ais.length; i++)
		{
			newAis[i] = new AI(this.cube, this.ais[this.bestAi].getFitness(), this.ais[this.bestAi].getBrain().getStep());
		}
		for(int i = 0; i < this.ais.length; i++)
		{
			this.ais[i] = newAis[i];
			if(i == 0)
				this.ais[i].setBest(true);
			else
				this.ais[i].setBest(false);
		}
	}
	
	public AI getParent()
	{
		int random = new Random().nextInt(this.fitnessSum);
		int cpt = 0;
		for(int i = 0; i < this.ais.length; i++)
		{
			cpt = cpt + this.ais[i].getFitness();
			if(cpt > random)
			{
				return this.ais[i];
			}
		}
		return null;
	}
	
	public void setFitness()
	{
		for(int i = 0; i < this.ais.length; i++)
		{
			this.ais[i].setFitness();
		}
	}
	
	public void setFitnessSum()
	{
		this.fitnessSum = 0;
		for(int i = 0; i < this.ais.length; i++)
		{
			this.fitnessSum = this.fitnessSum + this.ais[i].getFitness();
		}
	}
	
	public boolean isAllDead()
	{
		for(int i = 0; i < this.ais.length; i++)
		{
			if(!this.ais[i].isDead())
				return false;
		}
		return true;
	}
	
	private void setBestAiIndex()
	{
		int index = 0;
		int fitness = this.ais[0].getFitness();
		for(int i = 1; i < this.ais.length; i++)
		{
			int currentFitness = this.ais[i].getFitness();
			if(currentFitness > fitness)
			{
				index = i;
				fitness = currentFitness;
			}
			else if (currentFitness == fitness)
			{
				if(this.ais[i].getBrain().getStep() < this.ais[index].getBrain().getStep())
				{
					index = i;
					fitness = currentFitness;
				}
			}
		}
		this.bestAi = index;
	}
	
	public AI getBestAI()
	{
		this.setBestAiIndex();
		return this.ais[this.bestAi];
	}
	
	public void mutate()
	{
		for(int i = 1; i < this.ais.length; i++)
		{
			this.ais[i].getBrain().mutate();
		}
	}
	*/

}
