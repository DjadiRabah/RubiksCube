package cube;

import java.util.ArrayList;
import java.util.List;

import obs.Observable;
import obs.Observer;
import rotation.Rotation;
import rotation.RotationCube;
import rotation.RotationX;
import rotation.RotationY;
import rotation.RotationZ;
import shuffle.Shuffle;

public class Cube implements Observable, Observer
{
	public static final int TOP   = 0;
	public static final int LEFT  = 1;
	public static final int FRONT = 2;
	public static final int RIGHT = 3;
	public static final int BACK  = 4;
	public static final int DOWN  = 5;
	
	protected Square[] squares;
	protected int size;
	protected List<Observer> observers;
	
	public Cube(int size)
	{
		this.size = size;
		this.squares = new Square[6];
		
		for(int color = 0; color < 6; color++)
		{
			this.squares[color] = new Square(this.size,color);
		}
		this.observers = new ArrayList<>();
	}

	public int getSquareLeft(int square)
	{
		if (square == BACK)
			return Cube.RIGHT;
		else if (square == RIGHT)
			return Cube.FRONT;
		else if (square == FRONT)
			return Cube.LEFT;
		else if (square == LEFT)
			return Cube.BACK;
		else if (square == TOP)
			return Cube.LEFT;
		else if (square == DOWN)
			return Cube.LEFT;
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
	
	public void rotate(Integer[] rotation)
	{
		if(rotation[1] == -1)
			this.rotate(rotation[0]);
		else
			this.rotate(rotation[0], rotation[1]);
	}
	
	public void rotate(int direction)
	{
		this.notifyObserversRotation() ;
		new RotationCube().rotate(this,direction);
	}
	
	public void rotate(int direction, int index)
	{
		this.notifyObserversRotation() ;
		if ((direction == Rotation.RIGHT) || (direction == Rotation.LEFT))
		{
			new RotationX().rotate(this, direction, index);
		}
		else if ((direction == Rotation.UP) || (direction == Rotation.DOWN))
		{
			new RotationY().rotate(this, direction, index);
		}
		else if ((direction == Rotation.CLOCKWISE) || (direction == Rotation.COUNTERCLOCKWISE))
		{
			new RotationZ().rotate(this, direction, index);
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
	
	public void notifyObserversRotation() 
	{
		for(int i = 0; i < this.observers.size(); i++)
		{
			this.observers.get(i).update(this,0);
		}
	}

	@Override
	public void addObserver(Observer newObserver) 
	{
		this.observers.add(newObserver);
	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Observable observable, Object object) 
	{
		this.rotate((Integer[]) object);
	}
}
