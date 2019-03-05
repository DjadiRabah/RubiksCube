package model.rotation;

import model.cube.piece.*;
import model.cube.Square;

public class RotationSquare implements Rotation
{	
	protected int[][] transposeMatrix(int[][] colors)
	{
		int size = colors.length;
        int[][] temp = new int[size][size];
        for (int i = 0; i < size; i++)
        {
        	for (int j = 0; j < size; j++)
        	{
        		temp[i][j] = colors[j][i];
            }
        }
        return temp;
    }
	
	protected void reverseRows(Square square)
    {
		int size = square.getSize();
		if(size == 2)
		{
			for(int i = 0; i < size - 1; i++)
	    	{
	    		int[] temp = square.getRow(i);
	    		square.setRow(i, square.getRow(size - i - 1));
	    		square.setRow(size-i-1, temp);
	    	}
			
		}
		else
    	for(int i = 0; i < size - 2; i++)
    	{
    		int[] temp = square.getRow(i);
    		square.setRow(i, square.getRow(size - i - 1));
    		square.setRow(size-i-1, temp);
    	}
    }
	
	protected void reverseCols(Square square)
    {
		int size = square.getSize();
		if(size == 2)
			for(int i = 0; i < size - 1; i++)
	    	{
	    		int[] temp = square.getCol(i);
	    		square.setCol(i, square.getCol(size - i - 1));
	    		square.setCol(size-i-1, temp);
	    	}
		else
    	for(int i = 0; i < size - 2; i++)
    	{
    		int[] temp = square.getCol(i);
    		square.setCol(i, square.getCol(size - i - 1));
    		square.setCol(size-i-1, temp);
    	}
    }
	
	
	public void rotate(Square square, int direction)
	{
		if(direction == Rotation.CLOCKWISE)
		{
			square.setSquare(this.transposeMatrix(square.getColors()));
			this.reverseCols(square);
		}
		else if(direction == Rotation.COUNTERCLOCKWISE)
		{
			square.setSquare(this.transposeMatrix(square.getColors()));
			this.reverseRows(square);
		} 
	}
}
