package model.solver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import model.cube.Cube;
import model.rotation.Rotation;

public class IDA implements Solver
{	
	
	protected List<Integer[]> solution;
	protected int depth;
	protected List<Map<List<Integer[]>,Cube>> tree;
	
	public IDA()
	{
		this.depth = 0;
		this.solution = new ArrayList<Integer[]>();
		this.tree = new ArrayList<Map<List<Integer[]>,Cube>>();
	}
	
	public boolean isAlreadyStoredDepth(Cube cube, int depth)
	{
		Collection<Cube> cubes = this.tree.get(depth).values();
		for(Cube currentCube : cubes)
		{
			if(currentCube.isEquals(cube))
			{
				return true;
			}
		}
		return false;
	}
	
	public boolean isAlreadyStored(Cube cube)
	{
		for(int i = 0; i < this.depth; i++)
		{
			if(this.isAlreadyStoredDepth(cube, i))
					return true;
		}
		return false;
	}
	
	public boolean setNextDepth()
	{
		boolean isSolved = false;
		this.depth = this.depth + 1;
		
		Collection<Cube> cubes = this.tree.get(this.depth - 1).values();
		Set<List<Integer[]>> rotations = this.tree.get(this.depth - 1).keySet();
		
		Map<List<Integer[]>,Cube> data = new HashMap<>();
		for(int i = 0; i < cubes.size(); i++)
		{
			Cube currentCube = (Cube) cubes.toArray()[i];
			List<Integer[]> currentRotations = (ArrayList<Integer[]>) rotations.toArray()[i];
				for(int direction = Rotation.LEFT; direction < Rotation.COUNTERCLOCKWISE + 1; direction++)
				{
						for(int index = 0; index < currentCube.getSize(); index=index+2)
						{
							Integer[] rotation = new Integer[2];
							rotation[0] = Integer.valueOf(direction);
							rotation[1] = Integer.valueOf(index);
									
							Cube newCube = new Cube(currentCube);
							newCube.rotate(rotation);
							
							if(!this.isAlreadyStored(newCube))
							{
								for(int currentFace = 0; currentFace < 6; currentFace++)
								{
									isSolved = newCube.isSolved();
					
									if(isSolved)
									{
										break;
									}
								}
								
								List<Integer[]> newRotations = new ArrayList<>(currentRotations);
								newRotations.add(rotation);
								
								data.put(newRotations, newCube);
								if(isSolved)
								{
									this.solution = newRotations;
									this.tree.add(data);
									return true;
								}
							}
						}
				}
		}
		this.tree.add(data);
		
		return isSolved;
	}

	public void solve(Cube cube) 
	{
		
		Map<List<Integer[]>,Cube> cubes = new HashMap<>();
		cubes.put(new ArrayList<Integer[]>(), cube);
		this.tree.add(cubes);
		
		boolean isSolved = false;
		do
		{
			isSolved = this.setNextDepth();
		} while(!isSolved);
		
		for(int i = 0; i < this.solution.size(); i++)
		{
				System.out.print((this.solution.get(i)[0] + 1) + " " + (this.solution.get(i)[1] + 1) + " ");
				System.out.println();
		}
	}
}
