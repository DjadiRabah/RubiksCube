package listener;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import view.ButtonIndex;

public class IndexController implements ActionListener
{
	protected JButton[] buttons;
	protected ButtonIndex button;
	
	public IndexController(JButton[] buttons, ButtonIndex button) 
	{
		this.button = button;
		this.buttons = buttons;
	}

	@Override
	public void actionPerformed(ActionEvent event) 
	{
		for(int i = 1; i < this.buttons.length + 1; i++)
		{
			if(event.getActionCommand().equals(i + ""))
			{
				this.button.setForeground(Color.RED);
				for(int j = 1; j < this.buttons.length + 1; j++)
				{
					if(!this.buttons[j-1].getText().equals(i + ""))
					{
						this.buttons[j-1].setForeground(Color.BLACK);
					}
				}
				this.button.notifyObservers();
				return;
			}
		}
	}
}
