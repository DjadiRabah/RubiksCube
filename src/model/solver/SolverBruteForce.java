package model.solver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import model.cube.Cube;
import model.cube.piece.*;
import model.cube.Square;
import model.rotation.Rotation;



public class SolverBruteForce implements Solver
{	
	protected int depth;
	protected List<Map<List<Integer[]>,Cube>> tree;
	
	public SolverBruteForce()
	{
		this.depth = 0;
		this.tree = new ArrayList<Map<List<Integer[]>,Cube>>();
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
						for(int index = 0; index < currentCube.getSize(); index++)
						{
							Integer[] rotation = new Integer[2];
							rotation[0] = Integer.valueOf(direction);
							rotation[1] = Integer.valueOf(index);
							
							
							Cube newCube = new Cube(currentCube);
							newCube.rotate(rotation);
							
							isSolved = newCube.isSolved();
							
							List<Integer[]> newRotations = new ArrayList<>(currentRotations);
							newRotations.add(rotation);
							
							data.put(newRotations, newCube);
							if(isSolved)
							{
								this.tree.add(data);
								return true;
							}
						}
				}
		}
		this.tree.add(data);
		
		return isSolved;
	}

	@Override
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
		
		Set<List<Integer[]>> rotations = this.tree.get(this.depth).keySet();
		for(int i = 0; i < rotations.size(); i++)
		{
			List<Integer[]> currentRotations = (ArrayList<Integer[]>) rotations.toArray()[i];
			for(int j = 0; j < currentRotations.size(); j++)
				System.out.print(currentRotations.get(j)[0] + " " + currentRotations.get(j)[1] + " ");
			System.out.println();
		}
	}
}
