package graphic2d;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
