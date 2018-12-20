package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.cube.Cube;
import model.shuffle.ShuffleRandom;
import view.Pattern;

public class ButtonsController implements ActionListener
{
	protected Cube cube;
	protected Pattern pattern;
	
	public ButtonsController(Cube cube, Pattern pattern)
	{
		this.cube = cube;
		this.pattern = pattern;
	}

	@Override
	public void actionPerformed(ActionEvent event) 
	{
		if(event.getActionCommand().equals("Melanger"))
		{
			this.cube.shuffle(new ShuffleRandom());
		}
	}
}
