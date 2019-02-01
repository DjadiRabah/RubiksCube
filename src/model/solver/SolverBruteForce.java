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
	protected List<Integer[]> solution;
	protected int depth;
	protected List<Map<List<Integer[]>,Cube>> tree;
	
	public SolverBruteForce()
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
	
<<<<<<< HEAD
	public boolean isEdgeTopSolved(Cube cube, int i, int j)
	{
		int[][] index1 = {{0,1},{1,0},{1,2},{2,1}};
		int index = -1;
		for(int k = 0; k < index1.length; k++)
		{
			if ((index1[k][0] == i) && (index1[k][1] == j))
			{
				index = k;
				break;
			}
		}

			int[][] colors = cube.getSquare(Cube.TOP).getColors();
			int color = colors[1][1];
		
			int[] faces = null;
			int[][] index2 = null;
			int[][] colorsTmp = null;
			int colorTmp;

				faces = new int[]{Cube.BACK, Cube.LEFT, Cube.RIGHT, Cube.FRONT};
				index2 = new int[][]{{0,1},{0,1},{0,1},{0,1}};
				
		
				colorsTmp = cube.getSquare(faces[index]).getColors();
				colorTmp = colorsTmp[1][1];
				if ((colors[i][j] != color) || (colorsTmp[index2[index][0]][index2[index][1]] != colorTmp))
					return false;
			
		
		return false;
	}
	
	public boolean isEdgeSolved(Cube cube, int face, int i, int j)
	{
		int[][] index1 = {{0,1},{1,0},{1,2},{2,1}};
		int index = -1;
		for(int k = 0; k < index1.length; k++)
		{
			if ((index1[k][0] == i) && (index1[k][1] == j))
			{
				index = k;
			}
		}
		
		if(index != -1)
		{
			int[][] colors = cube.getSquare(face).getColors();
			int color = colors[1][1];
		
			int[] faces = null;
			int[][] index2 = null;
			int[][] colorsTmp = null;
			int colorTmp;
			if (face == Cube.TOP)
			{
				faces = new int[]{Cube.BACK, Cube.LEFT, Cube.RIGHT, Cube.FRONT};
				index2 = new int[][]{{0,1},{0,1},{0,1},{0,1}};
			}
			
			else if (face == Cube.LEFT)
			{
				faces = new int[]{Cube.TOP, Cube.BACK, Cube.FRONT, Cube.DOWN};
				index2 = new int[][]{{1,0},{1,2},{1,0},{1,0}};
			}
			
			else if (face == Cube.FRONT)
			{
				faces = new int[]{Cube.TOP, Cube.LEFT, Cube.RIGHT, Cube.DOWN};
				index2 = new int[][]{{2,1},{1,2},{1,0},{0,1}};
			}
			else if (face == Cube.RIGHT)
			{
				faces = new int[]{Cube.TOP, Cube.FRONT, Cube.BACK, Cube.DOWN};
				index2 = new int[][]{{1,2},{1,2},{1,0},{1,2}};
			}
			else if (face == Cube.BACK)
			{
				faces = new int[]{Cube.TOP, Cube.RIGHT, Cube.LEFT, Cube.DOWN};
				index2 = new int[][]{{0,1},{1,2},{1,0},{2,1}};
			}
			else if (face == Cube.DOWN)
			{
				faces = new int[]{Cube.FRONT, Cube.LEFT, Cube.RIGHT, Cube.BACK};
				index2 = new int[][]{{2,1},{2,1},{2,1},{2,1}};
			}
			colorsTmp = cube.getSquare(faces[index]).getColors();
			colorTmp = colorsTmp[1][1];
			if ((colors[i][j] != color) || (colorsTmp[index2[index][0]][index2[index][1]] != colorTmp))
				return false;
		}
		return true;
	}
	
	public int getNbrEdgesSolved(Cube cube, int face)
	{
		int edgeSolved = 0;
		int[][] edgeIndex = {{0,1},{1,0},{1,2},{2,1}};
		for(int i = 0; i < edgeIndex.length; i++)
		{
			if (isEdgeSolved(cube, face, edgeIndex[i][0], edgeIndex[i][1]))
			{
				edgeSolved = edgeSolved + 1;
			}
		}

		return edgeSolved;
	}
	
	
	
	/* Pour un cube 3 * 3 */
	public boolean isCrossSolved(Cube cube, int face)
	{
		int[][] index1 = {{0,1},{1,0},{1,2},{2,1}};
		int[][] colors = cube.getSquare(face).getColors();
		int color = colors[1][1];
		
		if (face == Cube.TOP)
		{
			int [] faces = {Cube.BACK, Cube.LEFT, Cube.RIGHT, Cube.FRONT};
			int[][] index2 = {{0,1},{0,1},{0,1},{0,1}};
			
			for(int i = 0; i < faces.length; i++)
			{
				int[][] colorsTmp = cube.getSquare(faces[i]).getColors();
				int colorTmp = colorsTmp[1][1];
				
				if ((colors[index1[i][0]][index1[i][1]] != color) || (colorsTmp[index2[i][0]][index2[i][1]] != colorTmp))
					return false;
			}
		}
		
		else if (face == Cube.LEFT)
		{
			int [] faces = {Cube.TOP, Cube.BACK, Cube.FRONT, Cube.DOWN};
			int[][] index2 = {{1,0},{1,2},{1,0},{1,0}};
			
			for(int i = 0; i < faces.length; i++)
			{
				int[][] colorsTmp = cube.getSquare(faces[i]).getColors();
				int colorTmp = colorsTmp[1][1];
				
				if ((colors[index1[i][0]][index1[i][1]] != color) || (colorsTmp[index2[i][0]][index2[i][1]] != colorTmp))
					return false;
			}
		}
		
		else if (face == Cube.FRONT)
		{
			int [] faces = {Cube.TOP, Cube.LEFT, Cube.RIGHT, Cube.DOWN};
			int[][] index2 = {{2,1},{1,2},{1,0},{0,1}};
			
			for(int i = 0; i < faces.length; i++)
			{
				int[][] colorsTmp = cube.getSquare(faces[i]).getColors();
				int colorTmp = colorsTmp[1][1];
				
				if ((colors[index1[i][0]][index1[i][1]] != color) || (colorsTmp[index2[i][0]][index2[i][1]] != colorTmp))
					return false;
			}
		}
		else if (face == Cube.RIGHT)
		{
			int [] faces = {Cube.TOP, Cube.FRONT, Cube.BACK, Cube.DOWN};
			int[][] index2 = {{1,2},{1,2},{1,0},{1,2}};
			
			for(int i = 0; i < faces.length; i++)
			{
				int[][] colorsTmp = cube.getSquare(faces[i]).getColors();
				int colorTmp = colorsTmp[1][1];
				
				if ((colors[index1[i][0]][index1[i][1]] != color) || (colorsTmp[index2[i][0]][index2[i][1]] != colorTmp))
					return false;
			}
		}
		else if (face == Cube.BACK)
		{
			int [] faces = {Cube.TOP, Cube.RIGHT, Cube.LEFT, Cube.DOWN};
			int[][] index2 = {{0,1},{1,2},{1,0},{2,1}};
			
			for(int i = 0; i < faces.length; i++)
			{
				int[][] colorsTmp = cube.getSquare(faces[i]).getColors();
				int colorTmp = colorsTmp[1][1];
				
				if ((colors[index1[i][0]][index1[i][1]] != color) || (colorsTmp[index2[i][0]][index2[i][1]] != colorTmp))
					return false;
			}
		}
		else if (face == Cube.DOWN)
		{
			int [] faces = {Cube.FRONT, Cube.LEFT, Cube.RIGHT, Cube.BACK};
			int[][] index2 = {{2,1},{2,1},{2,1},{2,1}};
			
			for(int i = 0; i < faces.length; i++)
			{
				int[][] colorsTmp = cube.getSquare(faces[i]).getColors();
				int colorTmp = colorsTmp[1][1];
				
				if ((colors[index1[i][0]][index1[i][1]] != color) || (colorsTmp[index2[i][0]][index2[i][1]] != colorTmp))
					return false;
			}
		}

		return true;
	}
	
	public int setTopCross()
	{
		Collection<Cube> cubes = this.tree.get(this.depth).values();
		Set<List<Integer[]>> rotations = this.tree.get(this.depth).keySet();
		Cube currentCube = (Cube) cubes.toArray()[0];
		
		int edgeSolved = this.getNbrEdgesSolved(currentCube, Cube.TOP);
		
		if(edgeSolved != 4)
		{
			boolean isSolved = false;
			this.depth = this.depth + 1;

			Map<List<Integer[]>,Cube> data = new HashMap<>();
			for(int i = 0; i < cubes.size(); i++)
			{
				currentCube = (Cube) cubes.toArray()[i];
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
									int edges = this.getNbrEdgesSolved(newCube, Cube.TOP);
									
									List<Integer[]> newRotations = new ArrayList<>(currentRotations);
									newRotations.add(rotation);
									
									data.put(newRotations, newCube);
									this.tree.add(data);
									if(edges > edgeSolved)
									{
										this.solution = newRotations;
										edgeSolved = edges;
										data = new HashMap<>();
										data.put(newRotations, newCube);
										this.tree.add(data);
										this.depth = this.depth + 1;
										return edgeSolved;
									}
								}
							}
					}
			}
			
		}
		return edgeSolved;
	}
	
=======
>>>>>>> d298fa99d525ddaf36868af351e73b45588e8b7d
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
<<<<<<< HEAD
									isSolved = this.isCrossSolved(newCube,Cube.TOP);
					
									if(isSolved)
									{
										break;
									}
								}
								
								
=======
									isSolved = newCube.isFaceSolved(currentFace) || newCube.isCrossSolved(currentFace);
									if(isSolved)
										break;
								}
								
>>>>>>> d298fa99d525ddaf36868af351e73b45588e8b7d
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

	@Override
	public ArrayList<Integer[]> solve(Cube cube) 
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
<<<<<<< HEAD
				System.out.print((this.solution.get(i)[0] + 1) + " " + (this.solution.get(i)[1] + 1) + " ");
=======
				System.out.print(this.solution.get(i)[0] + " " + this.solution.get(i)[1] + " ");
>>>>>>> d298fa99d525ddaf36868af351e73b45588e8b7d
				System.out.println();
		}
		
		return this.solution;
	}
}
