package model.solver;

import java.util.ArrayList;

import model.cube.Cube;
import model.rotation.Rotation;

public class FirstTwoLayers implements Solver
{
	/*
	public void addRotation(ArrayList<Integer[]> rotations, int direction, int index, int n)
	{
		for(int i = 0; i < n; i++)
		{
			Integer[] rotation = new Integer[] {direction,index};
			rotations.add(rotation);
		}
	}
	
	public void addRotation(ArrayList<Integer[]> rotations, String string)
	{
		for(int i = 0; i < string.length(); i = i + 3)
		{
			if(string.charAt(i) == 'L')
			{
				if (string.charAt(i+1) == '\'')
					this.addRotation(rotations, Rotation.UP, 0, 1);
				else if (string.charAt(i+1) == '2')
					this.addRotation(rotations, Rotation.DOWN, 0, 2);
				else
					this.addRotation(rotations, Rotation.DOWN, 0, 1);
			}
			else if(string.charAt(i) == 'U')
			{
				if (string.charAt(i+1) == '\'')
					this.addRotation(rotations, Rotation.RIGHT, 0, 1);
				else if (string.charAt(i+1) == '2')
					this.addRotation(rotations, Rotation.LEFT, 0, 2);
				else
					this.addRotation(rotations, Rotation.LEFT, 0, 1);
			}
			else if(string.charAt(i) == 'R')
			{
				if (string.charAt(i+1) == '\'')
					this.addRotation(rotations, Rotation.DOWN, 2, 1);
				else if (string.charAt(i+1) == '2')
					this.addRotation(rotations, Rotation.UP, 2, 2);
				else
					this.addRotation(rotations, Rotation.UP, 2, 1);
			}
			else if(string.charAt(i) == 'B')
			{
				if (string.charAt(i+1) == '\'')
					this.addRotation(rotations, Rotation.COUNTERCLOCKWISE, 2, 1);
				else if (string.charAt(i+1) == '2')
					this.addRotation(rotations, Rotation.CLOCKWISE, 2, 2);
				else
					this.addRotation(rotations, Rotation.CLOCKWISE, 2, 1);
			}
			
		}
	}
	
	public ArrayList<Integer[]> solveT(Cube cube)
	{
		ArrayList<Integer[]> rotations = new ArrayList<Integer[]>();
		this.addRotation(rotations, Cube.DOWN, 0, 2);
		this.addRotation(rotations, Cube.DOWN, 1, 2);
		this.addRotation(rotations, Cube.DOWN, 2, 2);
	
		int[] colors = new int[6];
		
		for(int i = 0; i < 6; i++)
		{
			colors[i] = cube.getColor(i);
		}
		
		if ((cube.getColor(Cube.FRONT,1,2) == cube.getColor(Cube.FRONT)) &&
				(cube.getColor(Cube.RIGHT,1,0) == cube.getColor(Cube.RIGHT)))
		{
			if ((cube.getColor(Cube.FRONT,2,2) == cube.getColor(Cube.RIGHT)) &&
			(cube.getColor(Cube.RIGHT,2,0) == cube.getColor(Cube.DOWN)) &&
			(cube.getColor(Cube.DOWN,0,2) == cube.getColor(Cube.FRONT)))
			{
				this.addRotation(rotations, "L2 U2 L  U  L' U  L  U2 L ");
			}
			else if ((cube.getColor(Cube.FRONT,2,2) == cube.getColor(Cube.DOWN)) &&
					(cube.getColor(Cube.RIGHT,2,0) == cube.getColor(Cube.FRONT)) &&
					(cube.getColor(Cube.DOWN,0,2) == cube.getColor(Cube.RIGHT)))
			{
				this.addRotation(rotations, "L' U2 L' U' L  U' L' U2 L2");
			}	
		}
		
		else if ((cube.getColor(Cube.FRONT,1,2) == cube.getColor(Cube.RIGHT)) &&
				(cube.getColor(Cube.RIGHT,1,0) == cube.getColor(Cube.FRONT)))
		{
			if ((cube.getColor(Cube.FRONT,2,2) == cube.getColor(Cube.RIGHT)) &&
			(cube.getColor(Cube.RIGHT,2,0) == cube.getColor(Cube.DOWN)) &&
			(cube.getColor(Cube.DOWN,0,2) == cube.getColor(Cube.FRONT)))
			{
				this.addRotation(rotations, "L' U  L' U' B' U  B  L2");
			}
			else if ((cube.getColor(Cube.FRONT,2,2) == cube.getColor(Cube.DOWN)) &&
					(cube.getColor(Cube.RIGHT,2,0) == cube.getColor(Cube.FRONT)) &&
					(cube.getColor(Cube.DOWN,0,2) == cube.getColor(Cube.RIGHT)))
			{
				this.addRotation(rotations, "R  U' R  U  B  U' B' R2");
			}	
		}
		
		else if ((cube.getColor(Cube.FRONT,2,2) == cube.getColor(Cube.FRONT)) &&
				(cube.getColor(Cube.RIGHT,2,0) == cube.getColor(Cube.RIGHT)) &&
				(cube.getColor(Cube.DOWN,0,2) == cube.getColor(Cube.DOWN)))
		{
			if ((cube.getColor(Cube.FRONT,1,2) == cube.getColor(Cube.RIGHT)) &&
					(cube.getColor(Cube.RIGHT,1,0) == cube.getColor(Cube.FRONT)))
			{
				this.addRotation(rotations, "R  U' R' U2 R  U2 R' U  F' U' F ");	
			}
			else if ((cube.getColor(Cube.TOP,1,2) == cube.getColor(Cube.FRONT)) &&
					(cube.getColor(Cube.RIGHT,1,0) == cube.getColor(Cube.RIGHT)))
			{
				this.addRotation(rotations, "U' L' U  L  d  R  U' R'");	
			}
			else if ((cube.getColor(Cube.TOP,2,1) == cube.getColor(Cube.RIGHT)) &&
					(cube.getColor(Cube.FRONT,1,0) == cube.getColor(Cube.FRONT)))
			{
				this.addRotation(rotations, "U  R  U' R' d' L' U  L ");
			}
		}

		return rotations;
	}
	
	@Override
	public void solve(Cube cube)
	{
		ArrayList<Integer[]> rotations = this.solveT(cube);
		for(int i = 0; i < rotations.size(); i++)
		{
			cube.rotate(rotations.get(i));
		}
	}
	*/

	@Override
	public void solve(Cube cube) 
	{
		
	}

}
