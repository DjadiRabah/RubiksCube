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



public class SolverBeginner implements Solver
{	
	protected Map<List<Integer[]>,Cube> data;
	public SolverBeginner(Cube cube)
	{
		this.data = new HashMap<>();
		List<Integer[]> rotations = new ArrayList<Integer[]>();
		Cube solvedCube = new Cube(cube.getSize());

		this.setData(cube, rotations, 0, solvedCube);
		
		Collection<Cube> cubes = this.data.values();
		
		for(Cube currentCube : cubes)
		{
			if(currentCube.equals(cube))
				System.out.println("Oui");
		}
	}
	
	private void setData(Cube cube, List<Integer[]> rotations,  int depth, Cube solveCube)
	{
		Collection<Cube> cubes = this.data.values();
		
		for(Cube currentCube : cubes)
		{
			if(currentCube.isTopSolved())
			{
				System.out.println(depth);
				System.out.println(currentCube);
				return;
			}
		}
		
		for(int direction = Rotation.LEFT; direction < Rotation.COUNTERCLOCKWISE; direction++)
		{
			for(int index = 0; index < cube.getSize(); index++)
			{
				Integer[] rotation = new Integer[2];
				rotation[0] = Integer.valueOf(direction);
				rotation[1] = Integer.valueOf(index);
				
				Cube newCube = new Cube(cube);
				newCube.rotate(rotation);
				
				boolean isStored = false;
				
				for(Cube currentCube : cubes)
				{
					if(currentCube.equals(newCube))
					{
						isStored = true;
						break;
					}
				}
				
				if(!isStored)
				{
					List<Integer[]> newRotations = new ArrayList<>(rotations);
					newRotations.add(rotation);
					data.put(newRotations, newCube);
					if(newCube.equals(solveCube))
						return;
					else
					{
						if(depth < 5)
							this.setData(newCube, newRotations, depth+1, solveCube);
					}
				}
			}
		}
	}

	@Override
	public void solve(Cube cube) 
	{
	}
}
