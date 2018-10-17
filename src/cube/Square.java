package cube;

import rotation.RotationSquare;

public class Square
{
	protected int size;
	protected Piece[][] pieces;
	
	public Square(Square square)
	{
		this.size = square.getSize();
		this.pieces = new Piece[this.size][this.size];
		for(int i = 0; i < this.pieces.length; i++)
		{
			for(int j = 0; j < this.pieces[i].length; j++)
			{
				this.pieces[i][j] = square.pieces[i][j];
			}
		}
	}
	
	public Square(int size, int color)
	{
		this.size = size;
		this.pieces = new Piece[this.size][this.size];
		for(int i = 0; i < this.pieces.length; i++)
		{
			for(int j = 0; j < this.pieces[i].length; j++)
			{
				if((color < Piece.WHITE) || (color > Piece.YELLOW))
				{
					this.pieces[i][j] = new Piece(Piece.NONE);
					
				}
				else
				{
					
					this.pieces[i][j] = new Piece(color);
				}
			}
		}
	}
	
	public Piece[][] getPieces()
	{
		Piece[][] square = new Piece[this.size][this.size];
		for(int i = 0; i < this.size; i++)
		{
			for(int j = 0; j < this.size; j++)
			{
				square[i][j] = this.pieces[i][j];
			}
		}
		return square;
	}
	
	public int[][] getColors()
	{
		int[][] colors = new int[this.size][this.size];
		for(int i = 0; i < this.size; i++)
		{
			for(int j = 0; j < this.size; j++)
			{
				colors[i][j] = this.pieces[i][j].getColor();
			}
		}
		return colors;
	}
	
	public int getSize()
	{
		return this.size;
	}
	public void setLayer(int layer, Piece[] pieces)
	{
		for(int i = 0; i < this.size; i++)
		{
			 this.pieces[layer][i] = pieces[i];
		}
	}
	public void setLayerReverse(int layer, Piece[] pieces)
	{
		for(int i = 0; i < this.size; i++)
		{
			 this.pieces[layer][i] = pieces[this.size - 1 - i];
		}
	}
	
	public void setSquare(Piece[][] square)
	{
		for(int i = 0; i < this.size; i++)
		{
			for(int j = 0; j < this.size; j++)
			{
				this.pieces[i][j] = square[i][j];
			}
		}
	}
	
	public Piece[] getLayer(int layer)
	{
		Piece[] row = new Piece[this.size];
		for(int currentPiece = 0; currentPiece < this.size; currentPiece++)
		{
			row[currentPiece] = this.pieces[layer][currentPiece];
		}
		return row;
	}
    
    public void setCol(int col,Piece[] pieces)
	{
		for(int i = 0; i < this.size; i++)
		{
			 this.pieces[i][col] = pieces[i];
		}
	}
    public void setColReverse(int col,Piece[] pieces)
	{
		for(int i = 0; i < this.size; i++)
		{
			 this.pieces[i][col] = pieces[this.size - 1 - i];
		}
	}
	public Piece[] getCol(int col)
	{
		Piece[] pieces = new Piece[this.size];
		for(int i = 0; i < this.size; i++)
		{
			pieces[i] = this.pieces[i][col];
		}
		return pieces;
	}
	
	public String toStringLayer(int layer)
	{
		String str = "";
		for(int i = 0; i < this.size; i++)
		{
			str = str + this.pieces[layer][i] + " ";
		}
		return str;
	}

	public String toString()
	{
		String str = "";
		for(int i = 0; i < this.size; i++)
		{
			str = str + this.toStringLayer(i) + '\n';
		}
		return str;
	}
	
	public boolean isSolved()
	{
		int color = this.pieces[0][0].getColor();
		for(int i = 0; i < this.size; i++)
		{
			for(int j = 0; j < this.size; j++)
			{
				if(this.pieces[i][j].getColor() != color)
				{
					return false;
				}
			}
		}
		return true;
	}
	
	public void rotate(int direction, int n)
	{
		new RotationSquare().rotate(this,direction,n);
	}
}
