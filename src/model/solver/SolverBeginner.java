package model.solver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.cube.Cube;
import model.cube.piece.*;
import model.cube.Square;
import model.rotation.Rotation;

public class SolverBeginner implements Solver
{
	protected int[][] edges;
	protected int[][] corners;
	
	public SolverBeginner()
	{
		this.edges = new int[24][5];
		this.corners = new int[8][12];
	}
	private int getSquareColor(Square square)
	{
		int[][] colors = square.getColors();
		return colors[(colors.length - 1) / 2][(colors.length - 1) / 2];
	}
	protected int getSquareColor(Square square, int row, int col)
	{
		int[][] colors = square.getColors();
		return colors[row][col];
	}
	protected int[] setEdgeTop(Cube cube, int square)
	{
		int[] edge = new int[5];
		edge[0] = this.getSquareColor(cube.getSquare(square), 0, 1);
		
		if(square == Cube.LEFT)
			edge[1] = this.getSquareColor(cube.getSquare(Cube.TOP), 1, 0);
		else if(square == Cube.FRONT)
			edge[1] = this.getSquareColor(cube.getSquare(Cube.TOP), 2, 1);
		else if(square == Cube.RIGHT)
			edge[1] = this.getSquareColor(cube.getSquare(Cube.TOP), 1, 2);
		else if(square == Cube.BACK)
			edge[1] = this.getSquareColor(cube.getSquare(Cube.TOP), 0, 1);
		else if(square == Cube.TOP)
			edge[1] = this.getSquareColor(cube.getSquare(Cube.BACK), 0, 1);
		else if((square == Cube.DOWN))
			edge[1] = this.getSquareColor(cube.getSquare(Cube.FRONT), 2, 1);
		
		edge[2] = square;
		edge[3] = 0;
		edge[4] = 1;

		return edge;
	}
	
	protected int[] setEdgeDown(Cube cube, int square)
	{
		int[] edge = new int[5];
		edge[0] = this.getSquareColor(cube.getSquare(square), 2, 1);
		
		if(square == Cube.LEFT)
			edge[1] = this.getSquareColor(cube.getSquare(Cube.DOWN), 1, 0);
		else if(square == Cube.FRONT)
			edge[1] = this.getSquareColor(cube.getSquare(Cube.DOWN), 0, 1);
		else if(square == Cube.RIGHT)
			edge[1] = this.getSquareColor(cube.getSquare(Cube.DOWN), 1, 2);
		else if(square == Cube.BACK)
			edge[1] = this.getSquareColor(cube.getSquare(Cube.DOWN), 2, 1);
		else if(square == Cube.TOP)
			edge[1] = this.getSquareColor(cube.getSquare(Cube.FRONT), 0, 1);
		else if((square == Cube.DOWN))
			edge[1] = this.getSquareColor(cube.getSquare(Cube.BACK), 2, 1);
		
		edge[2] = square;
		edge[3] = 2;
		edge[4] = 1;

		return edge;
	}
	
	protected int[] setEdgeLeft(Cube cube, int square)
	{
		int[] edge = new int[5];
		edge[0] = this.getSquareColor(cube.getSquare(square), 1, 0);
		
		if(square == Cube.LEFT)
			edge[1] = this.getSquareColor(cube.getSquare(Cube.BACK), 1, 2);
		else if(square == Cube.FRONT)
			edge[1] = this.getSquareColor(cube.getSquare(Cube.LEFT), 1, 2);
		else if(square == Cube.RIGHT)
			edge[1] = this.getSquareColor(cube.getSquare(Cube.FRONT), 1, 2);
		else if(square == Cube.BACK)
			edge[1] = this.getSquareColor(cube.getSquare(Cube.RIGHT), 1, 2);
		else if(square == Cube.TOP)
			edge[1] = this.getSquareColor(cube.getSquare(Cube.LEFT), 0, 1);
		else if((square == Cube.DOWN))
			edge[1] = this.getSquareColor(cube.getSquare(Cube.LEFT), 2, 1);
		
		edge[2] = square;
		edge[3] = 1;
		edge[4] = 0;

		return edge;
	}
	
	protected int[] setEdgeRight(Cube cube, int square)
	{
		int[] edge = new int[5];
		edge[0] = this.getSquareColor(cube.getSquare(square), 1, 2);
		
		if(square == Cube.LEFT)
			edge[1] = this.getSquareColor(cube.getSquare(Cube.FRONT), 1, 0);
		else if(square == Cube.FRONT)
			edge[1] = this.getSquareColor(cube.getSquare(Cube.RIGHT), 1, 0);
		else if(square == Cube.RIGHT)
			edge[1] = this.getSquareColor(cube.getSquare(Cube.BACK), 1, 0);
		else if(square == Cube.BACK)
			edge[1] = this.getSquareColor(cube.getSquare(Cube.LEFT), 1, 0);
		else if(square == Cube.TOP)
			edge[1] = this.getSquareColor(cube.getSquare(Cube.RIGHT), 0, 1);
		else if((square == Cube.DOWN))
			edge[1] = this.getSquareColor(cube.getSquare(Cube.RIGHT), 2, 1);
		
		edge[2] = square;
		edge[3] = 1;
		edge[4] = 2;

		return edge;
	}
	protected void setEdges(Cube cube)
	{
		int currentEdge = 0;
		for(int currentSquare = Cube.TOP; currentSquare <= Cube.DOWN; currentSquare++)
		{
			this.edges[currentEdge] = this.setEdgeTop(cube, currentSquare);
			currentEdge++;
			this.edges[currentEdge] = this.setEdgeLeft(cube, currentSquare);
			currentEdge++;
			this.edges[currentEdge] = this.setEdgeRight(cube, currentSquare);
			currentEdge++;
			this.edges[currentEdge] = this.setEdgeDown(cube, currentSquare);
			currentEdge++;
		}
	}
	
	private void setWhiteTop(Cube cube)
	{
		if(this.getSquareColor(cube.getSquare(Cube.TOP)) != Piece.WHITE)
		{
			if(this.getSquareColor(cube.getSquare(Cube.LEFT)) == Piece.WHITE)
				cube.rotate(Rotation.CLOCKWISE);
			else if(this.getSquareColor(cube.getSquare(Cube.FRONT)) == Piece.WHITE)
				cube.rotate(Rotation.UP);
			else if(this.getSquareColor(cube.getSquare(Cube.RIGHT)) == Piece.WHITE)
				cube.rotate(Rotation.COUNTERCLOCKWISE);
			else if(this.getSquareColor(cube.getSquare(Cube.BACK)) == Piece.WHITE)
				cube.rotate(Rotation.DOWN);
			else if(this.getSquareColor(cube.getSquare(Cube.DOWN)) == Piece.WHITE)
			{
				cube.rotate(Rotation.UP);
				cube.rotate(Rotation.UP);
			}
		}	
	}
	
	private int getEdgeColor(int square, int row, int col)
	{
		int color = 0;
		for(int i = 0; i < this.edges.length; i++)
		{
			if((this.edges[i][2] == square) && (this.edges[i][3] == row) && (this.edges[i][4] == col))
			{
				return this.edges[i][0];
			}
		}
		return color;
	}
	private int[] getEdgePosition(int colorA, int colorB)
	{
		int[] position = new int[2];
		for(int i = 0; i < this.edges.length; i++)
		{
			if((this.edges[i][0] == colorA) && (this.edges[i][1] == colorB))
			{
				position[0] = this.edges[i][2];
			}
			if((this.edges[i][0] == colorB) && (this.edges[i][1] == colorA))
			{
				position[1] = this.edges[i][2];
			}
		}
		return position;
	}
	
	private void setWhiteCross(Cube cube)
	{
		for(int i = 0; i < 4; i++)
		{
			this.setEdges(cube);
			int colorTop = this.getSquareColor(cube.getSquare(Cube.TOP));
			int colorFront = this.getSquareColor(cube.getSquare(Cube.FRONT));
			if((this.getEdgeColor(Cube.TOP, 2, 1) != colorTop) || ((this.getEdgeColor(Cube.FRONT, 0, 1) != colorFront)))
			{
				int[] edgePosition = this.getEdgePosition(colorTop, colorFront);
				
				if (edgePosition[0] == Cube.TOP)
				{
					if(edgePosition[1] == Cube.LEFT)
					{
						cube.rotate(Rotation.DOWN, 0);
						cube.rotate(Rotation.DOWN, 0);
						cube.rotate(Rotation.RIGHT, 2);
						cube.rotate(Rotation.CLOCKWISE, 0);
						cube.rotate(Rotation.CLOCKWISE, 0);
					}
					else if(edgePosition[1] == Cube.RIGHT)
					{
						cube.rotate(Rotation.DOWN, 2);
						cube.rotate(Rotation.DOWN, 2);
						cube.rotate(Rotation.LEFT, 2);
						cube.rotate(Rotation.CLOCKWISE, 0);
						cube.rotate(Rotation.CLOCKWISE, 0);
					}
					else if(edgePosition[1] == Cube.BACK)
					{
						cube.rotate(Rotation.CLOCKWISE, 2);
						cube.rotate(Rotation.CLOCKWISE, 2);
						cube.rotate(Rotation.LEFT, 2);
						cube.rotate(Rotation.LEFT, 2);
						cube.rotate(Rotation.CLOCKWISE, 0);
						cube.rotate(Rotation.CLOCKWISE, 0);
					}
				}
				else if (edgePosition[0] == Cube.LEFT)
				{
					if (edgePosition[1] == Cube.TOP)
					{
						cube.rotate(Rotation.DOWN, 0);
						cube.rotate(Rotation.CLOCKWISE, 0);
					}
					else if (edgePosition[1] == Cube.DOWN)
					{
						cube.rotate(Rotation.UP, 0);
						cube.rotate(Rotation.CLOCKWISE, 0);
						cube.rotate(Rotation.DOWN, 0);
					}
					else if (edgePosition[1] == Cube.BACK)
					{
						cube.rotate(Rotation.UP, 0);
						cube.rotate(Rotation.RIGHT, 2);
						cube.rotate(Rotation.DOWN, 0);
						cube.rotate(Rotation.CLOCKWISE, 0);
						cube.rotate(Rotation.CLOCKWISE, 0);
						cube.rotate(Rotation.RIGHT);
						cube.rotate(Rotation.DOWN, 2);
						cube.rotate(Rotation.LEFT, 0);
						cube.rotate(Rotation.COUNTERCLOCKWISE, 0);
						cube.rotate(Rotation.RIGHT, 0);
						cube.rotate(Rotation.LEFT);	
					}
					else if (edgePosition[1] == Cube.FRONT)
					{
						cube.rotate(Rotation.CLOCKWISE, 0);		
					}
				}
				else if(edgePosition[0] == Cube.FRONT)
				{
					if(edgePosition[1] == Cube.LEFT)
					{
						cube.rotate(Rotation.COUNTERCLOCKWISE, 0);	
						cube.rotate(Rotation.LEFT, 2);
						cube.rotate(Rotation.UP, 0);
						cube.rotate(Rotation.CLOCKWISE, 0);
						cube.rotate(Rotation.DOWN, 0);	
					}
					else if(edgePosition[1] == Cube.RIGHT)
					{
						cube.rotate(Rotation.CLOCKWISE, 0);	
						cube.rotate(Rotation.LEFT, 2);
						cube.rotate(Rotation.UP, 0);
						cube.rotate(Rotation.CLOCKWISE, 0);
						cube.rotate(Rotation.DOWN, 0);
					}
					else if(edgePosition[1] == Cube.DOWN)
					{
						cube.rotate(Rotation.LEFT, 2);
						cube.rotate(Rotation.UP, 0);
						cube.rotate(Rotation.CLOCKWISE, 0);
						cube.rotate(Rotation.DOWN, 0);	
					}	
					else if (edgePosition[1] == Cube.TOP)
					{
						cube.rotate(Rotation.COUNTERCLOCKWISE, 0);
						cube.rotate(Rotation.COUNTERCLOCKWISE, 0);
						cube.rotate(Rotation.LEFT, 2);
						cube.rotate(Rotation.UP, 0);
						cube.rotate(Rotation.CLOCKWISE, 0);
						cube.rotate(Rotation.DOWN, 0);
					}
				}
				else if (edgePosition[0] == Cube.RIGHT)
				{
					if(edgePosition[1] == Cube.TOP)
					{
						cube.rotate(Rotation.DOWN, 2);
						cube.rotate(Rotation.COUNTERCLOCKWISE, 0);
					}
					else if(edgePosition[1] == Cube.DOWN)
					{
						cube.rotate(Rotation.UP, 2);
						cube.rotate(Rotation.COUNTERCLOCKWISE, 0);
						cube.rotate(Rotation.DOWN, 2);
					}
					else if(edgePosition[1] == Cube.BACK)
					{
						cube.rotate(Rotation.UP, 2);
						cube.rotate(Rotation.UP, 2);
						cube.rotate(Rotation.COUNTERCLOCKWISE, 0);
						cube.rotate(Rotation.DOWN, 2);
						cube.rotate(Rotation.DOWN, 2);
					}
					else if(edgePosition[1] == Cube.FRONT)
					{
						cube.rotate(Rotation.COUNTERCLOCKWISE, 0);
					}
				}
				else if (edgePosition[0] == Cube.BACK)
				{
					if(edgePosition[1] == Cube.TOP)
					{
						cube.rotate(Rotation.CLOCKWISE, 2);
						cube.rotate(Rotation.CLOCKWISE, 2);
						cube.rotate(Rotation.LEFT, 2);
						cube.rotate(Rotation.UP, 2);
						cube.rotate(Rotation.COUNTERCLOCKWISE, 0);
						cube.rotate(Rotation.DOWN, 2);
					}
					else if(edgePosition[1] == Cube.RIGHT)
					{
						cube.rotate(Rotation.CLOCKWISE, 2);
						cube.rotate(Rotation.LEFT, 2);
						cube.rotate(Rotation.COUNTERCLOCKWISE, 2);
						cube.rotate(Rotation.UP, 2);
						cube.rotate(Rotation.COUNTERCLOCKWISE, 0);
						cube.rotate(Rotation.DOWN, 2);
					}
					else if(edgePosition[1] == Cube.LEFT)
					{
						cube.rotate(Rotation.COUNTERCLOCKWISE, 2);
						cube.rotate(Rotation.RIGHT, 2);
						cube.rotate(Rotation.CLOCKWISE, 2);
						cube.rotate(Rotation.UP, 0);
						cube.rotate(Rotation.CLOCKWISE, 0);
						cube.rotate(Rotation.DOWN, 0);
					}
					else if(edgePosition[1] == Cube.DOWN)
					{
						cube.rotate(Rotation.RIGHT, 2);
						cube.rotate(Rotation.UP, 0);
						cube.rotate(Rotation.CLOCKWISE, 0);
						cube.rotate(Rotation.DOWN, 0);
					}
				}
				else if (edgePosition[0] == Cube.DOWN)
				{
					if(edgePosition[1] == Cube.LEFT)
					{
						cube.rotate(Rotation.RIGHT, 2);
					}
					else if(edgePosition[1] == Cube.RIGHT)
					{
						cube.rotate(Rotation.LEFT, 2);
					}
					else if(edgePosition[1] == Cube.BACK)
					{
						cube.rotate(Rotation.LEFT, 2);
						cube.rotate(Rotation.LEFT, 2);
					}
					cube.rotate(Rotation.CLOCKWISE, 0);
					cube.rotate(Rotation.CLOCKWISE, 0);
				}
			}
			cube.rotate(Rotation.RIGHT);
		}
	}
	
	private void setCorners(Cube cube)
	{
		this.corners[0][0] = this.getSquareColor(cube.getSquare(Cube.FRONT), 0, 0);
		this.corners[0][1] = this.getSquareColor(cube.getSquare(Cube.TOP), 2, 0);
		this.corners[0][2] = this.getSquareColor(cube.getSquare(Cube.LEFT), 0, 2);
		
		this.corners[1][0] = this.getSquareColor(cube.getSquare(Cube.FRONT), 0, 2);
		this.corners[1][1] = this.getSquareColor(cube.getSquare(Cube.TOP), 2, 2);
		this.corners[1][2] = this.getSquareColor(cube.getSquare(Cube.LEFT), 0, 0);
		
	}
	
	private void setWhiteFace(Cube cube)
	{
		/*if((this.getSquareColor(cube.getSquare(Cube.FRONT), 0, 2) == Piece.WHITE) && (this.getSquareColor(cube.getSquare(Cube.TOP), 2, 2) == this.getSquareColor(cube.getSquare(Cube.RIGHT))))
		{
			for(int i = 0; i < 4; i++)
			{
				cube.rotate(Rotation.DOWN, 2);
				cube.rotate(Rotation.LEFT, 2);
				cube.rotate(Rotation.UP, 2);
				cube.rotate(Rotation.RIGHT, 2);
			}
		}*/
	}

	private boolean isTopEdgesSet(Cube cube)
	{
		int[] colorsFaces = new int[6];
		for(int i = 0; i < colorsFaces.length; i++)
		{
			colorsFaces[i] = this.getSquareColor(cube.getSquare(i));
		}

		int[][] index = {{1,0}, {2,1}, {1,2}, {0,1}};
		
		for(int i = Cube.LEFT; i < Cube.DOWN; i++)
		{
			if ((this.getSquareColor(cube.getSquare(Cube.TOP), index[i-1][0], index[i-1][1]) != this.getSquareColor(cube.getSquare(Cube.TOP)))
				|| (this.getSquareColor(cube.getSquare(i), 0, 1)) != this.getSquareColor(cube.getSquare(i)))
			{
				return false;
			}
		}

		return true;
	}

	private Cube[] nextCubes(Cube cube)
	{
		int cpt = 0;
		Cube[] nextCubes = new Cube[18];

		for(int i = 0; i < 6; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				nextCubes[cpt] = new Cube(cube);
				nextCubes[cpt].rotate(i,j); 
				cpt++;
			}
		}

		return nextCubes;
	}

	private Cube setWhiteCrossBruteForce(Cube cube)
	{
		if(cube.isSolved())
			return cube;

		Cube[] cubes = this.nextCubes(cube);

		for(int i = 0; i < cubes.length; i++)
		{
			if(cubes[i].isSolved())
			{
				return cubes[i];
			}
		}
		
		for(int i = 0; i < cubes.length; i++)
		{
			if(setWhiteCrossBruteForce(cubes[i]).isSolved())
				return setWhiteCrossBruteForce(cubes[i]);
		}
		
		return setWhiteCrossBruteForce(cubes[i]);
	}
	
	@Override
	public void solve(Cube cube) 
	{
		this.setWhiteCrossBruteForce(cube);
			/*
		this.setWhiteTop(cube);
		this.setWhiteCross(cube);
		if(this.isTopEdgesSet(cube))
			System.out.println("OUI");
		else
			System.out.println("NON");
	*/
	}
}
