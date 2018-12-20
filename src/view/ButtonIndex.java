package view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

import model.observer.Observable;
import model.observer.Observer;

public class ButtonIndex extends JButton implements Observable
{
	protected List<Observer> observers;
	
	public ButtonIndex(String string) 
	{
		super(string);
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
		for(int i = 0; i < this.observers.size(); i++)
		{
			this.observers.get(i).update(this,Integer.parseInt(this.getText()) - 1);
		}
	}
}
