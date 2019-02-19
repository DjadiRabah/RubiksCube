package model.ai;

import java.util.ArrayList;
import java.util.Random;

public class Brain 
{
	/*
	protected int step;
	protected ArrayList<Integer[]> rotations;
	protected int cubeSize;
	
	public Brain(int cubeSize)
	{
		this.cubeSize = cubeSize;
		this.rotations = new ArrayList<Integer[]>();
		this.randomize();
		this.step = 0;
	}
	
	public Brain(Brain copy)
	{
		this.cubeSize = copy.cubeSize;
		this.step = copy.step;
		this.rotations = new ArrayList<Integer[]>(copy.rotations);
	}
	
	private void randomize()
	{
		for(int i = 0; i < 20; i++)
		{
			Random r = new Random();
			int direction = r.nextInt(6);
			int index = r.nextInt(this.cubeSize);
			
			this.rotations.add(new Integer[] {direction,index});	
		}
	}
	
	public ArrayList<Integer[]> getRotations()
	{
		return this.rotations;
	}
	
	public Integer[] getRotation()
	{
		return this.rotations.get(this.step);
	}
	public void nextStep()
	{
		this.step = this.step + 1;
	}
	
	public int getStep()
	{
		return this.step;
	}
	
	public void mutate()
	{
		this.step = 0;
		float mutationRate = 0.01f;
		float randomFloat = new Random().nextFloat();
		if(randomFloat < mutationRate)
		{
			Random r = new Random();
			int direction = r.nextInt(6);
			int index = r.nextInt(this.cubeSize);
			this.rotations.set(r.nextInt(this.rotations.size()),new Integer[] {direction,index});
		}
	}
	*/
}
