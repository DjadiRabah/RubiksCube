package rotation;

import cube.Piece;
import cube.Square;

public class RotationSquare implements Rotation
{	
	protected Piece[][] transposeMatrix(Piece[][] pieces)
	{
		int size = pieces.length;
        Piece[][] temp = new Piece[size][size];
        for (int i = 0; i < size; i++)
        {
        	for (int j = 0; j < size; j++)
        	{
        		temp[i][j] = pieces[j][i];
            }
        }
        return temp;
    }
	
	protected void reverseRows(Square square)
    {
		int size = square.getSize();
    	for(int i = 0; i < size - 2; i++)
    	{
    		Piece[] temp = square.getLayer(i);
    		square.setLayer(i, square.getLayer(size - i - 1));
    		square.setLayer(size-i-1, temp);
    	}
    }
	
	protected void reverseCols(Square square)
    {
		int size = square.getSize();
    	for(int i = 0; i < size - 2; i++)
    	{
    		Piece[] temp = square.getCol(i);
    		square.setCol(i, square.getCol(size - i - 1));
    		square.setCol(size-i-1, temp);
    	}
    }
	
	
	public void rotate(Square square, int direction, int n)
	{
		if(direction == Rotation.CLOCKWISE)
		{
			if((n%4) != 0)
			{
				if(((n-1) % 4) == 0)
				{
					square.setSquare(this.transposeMatrix(square.getPieces()));
					this.reverseCols(square);
				}
				else if(((n+1) % 4) == 0)
				{
					this.rotate(square, Rotation.COUNTERCLOCKWISE, 1);
				}
				else
				{
					this.rotate(square, direction, 1);
					this.rotate(square, direction, 1);
				}
			}
			
		}
		else if(direction == Rotation.COUNTERCLOCKWISE)
		{
			if((n%4) != 0)
			{
				if(((n-1) % 4) == 0)
				{
					square.setSquare(this.transposeMatrix(square.getPieces()));
					this.reverseRows(square);
				}
				else if(((n+1) % 4) == 0)
				{
					this.rotate(square, Rotation.CLOCKWISE, 1);
				}
				else
				{
					this.rotate(square, direction, 1);
					this.rotate(square, direction, 1);
				}
			}
		} 
	}
}
