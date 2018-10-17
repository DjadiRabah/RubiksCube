package cube;

import rotation.Rotation;
import rotation.RotationCube;
import rotation.RotationX;
import rotation.RotationY;
import rotation.RotationZ;
import shuffle.Shuffle;

public class Cube 
{
	public static final int TOP   = 0;
	public static final int LEFT  = 1;
	public static final int FRONT = 2;
	public static final int RIGHT = 3;
	public static final int BACK  = 4;
	public static final int DOWN  = 5;
	
	protected Square[] squares;
	protected int size;
	
	public Cube(int size)
	{
		this.size = size;
		this.squares = new Square[6];
		
		for(int color = 0; color < 6; color++)
		{
			this.squares[color] = new Square(this.size,color);
		}
	}
	
	public void shuffle(Shuffle s)
	{
		s.shuffle(this);
	}
	
	public Square getSquare(int position)
	{
		return this.squares[position];
	}
	
	public int getSize()
	{
		return this.size;
	}
	
	public boolean isSolved()
	{
		for(int i = 0; i < this.size; i++)
		{
			if(this.squares[i].isSolved() == false)
			{
				return false;
			}
		}
		return true;
	}
	
	public void rotate(int direction, int n)
	{
		new RotationCube().rotate(this,direction,n);
	}
	
	public void rotate(int direction, int index,  int n)
	{
		if ((direction == Rotation.RIGHT) || (direction == Rotation.LEFT))
		{
			new RotationX().rotate(this, direction, index, n);
		}
		else if ((direction == Rotation.UP) || (direction == Rotation.DOWN))
		{
			new RotationY().rotate(this, direction, index, n);
		}
		else if ((direction == Rotation.CLOCKWISE) || (direction == Rotation.COUNTERCLOCKWISE))
		{
			new RotationZ().rotate(this, direction, index, n);
		}
	}
	
	public String toString()
	{
		String str = "";
		
		for(int i = 0; i < this.size; i++)
		{
			for(int j = 0; j < 2*this.size+1; j++)
			{
				str = str + " ";
			}
			str = str + this.squares[TOP].toStringLayer(i) + '\n';
		}
		str = str + '\n';
		for(int i = 0; i < this.size; i++)
		{
			str = str + this.squares[LEFT].toStringLayer(i) +  " " + this.squares[FRONT].toStringLayer(i) + " " + this.squares[RIGHT].toStringLayer(i) + " " + this.squares[BACK].toStringLayer(i) + '\n';
		}
		str = str + '\n';
		for(int i = 0; i < this.size; i++)
		{
			for(int j = 0; j < 2*this.size+1; j++)
			{
				str = str + " ";
			}
			str = str + this.squares[DOWN].toStringLayer(i) + '\n';
		}

		return str;
	}
}
