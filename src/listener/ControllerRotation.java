package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.ButtonRotation;

public class ControllerRotation implements ActionListener
{
	protected ButtonRotation button;
	
	public ControllerRotation(ButtonRotation button) 
	{
		this.button = button;
	}

	@Override
	public void actionPerformed(ActionEvent event) 
	{
		this.button.notifyObservers();
	}
}
