package graphic2d;

import obs.Observable;
import obs.Observer;
import rotation.Rotation;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

public class ButtonRotation extends JButton implements Observable, Observer
{
	protected List<Observer> observers;
	protected int index;
	
	public ButtonRotation(String string) 
	{
		super(string);
		this.index = 0;
		this.observers = new ArrayList<>();
	}

	@Override
	public void addObserver(Observer newObserver)
	{
		this.observers.add(newObserver);
	}

	@Override
	public void notifyObservers() 
	{
		Integer[] rotation = new Integer[2];
		for(int i = 0; i < this.observers.size(); i++)
		{
			rotation[1] = this.index;
			if(this.getText().equals("Tourner une ligne vers la gauche"))
				rotation[0] = Rotation.LEFT;
			else if(this.getText().equals("Tourner une ligne vers la droite"))
				rotation[0] = Rotation.RIGHT;
			else if(this.getText().equals("Tourner une colonne vers le haut"))
				rotation[0] = Rotation.UP;
			else if(this.getText().equals("Tourner une colonne vers le bas"))
				rotation[0] = Rotation.DOWN;
			else if(this.getText().equals("Tourner une face dans le sens horaire"))
				rotation[0] = Rotation.CLOCKWISE;
			else if(this.getText().equals("Tourner une face dans le sens trigo"))
				rotation[0] = Rotation.COUNTERCLOCKWISE;
			else
			{
				if(this.getText().equals("Tourner le cube vers la gauche"))
					rotation[0] = Rotation.LEFT;
				else if(this.getText().equals("Tourner le cube vers la droite"))
					rotation[0] = Rotation.RIGHT;
				else if(this.getText().equals("Tourner le cube vers le haut"))
					rotation[0] = Rotation.UP;
				else if(this.getText().equals("Tourner le cube vers le bas"))
					rotation[0] = Rotation.DOWN;
				else if(this.getText().equals("Tourner le cube dans le sens horaire"))
					rotation[0] = Rotation.CLOCKWISE;
				else if(this.getText().equals("Tourner le cube dans le sens trigo"))
					rotation[0] = Rotation.COUNTERCLOCKWISE;
				rotation[1] = -1;
			}
			this.observers.get(i).update(this,rotation);
		}
	}

	@Override
	public void update(Observable observable, Object object) 
	{
		this.index = (int)object;
	}
}
