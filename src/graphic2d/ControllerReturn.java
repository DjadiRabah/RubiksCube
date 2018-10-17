package graphic2d;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cube.Cube;
import rotation.Rotation;
import rotation.RotationObserver;

public class ControllerReturn implements ActionListener
{
	protected Cube cube;
	protected RotationObserver manager;

	public ControllerReturn(Cube cube, RotationObserver manager) 
	{
		this.cube = cube;
		this.manager = manager;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) 
	{
		if(event.getActionCommand().equals("Retour"))
		{
			if(!this.manager.isEmpty())
			{
				Integer[] rotation = this.manager.pollLast();
				if(rotation[1].intValue() != -1)
				{
					if(rotation[0].intValue() == Rotation.LEFT)
						this.cube.rotate(Rotation.RIGHT, rotation[1].intValue());
					else if(rotation[0].intValue() == Rotation.RIGHT)
						this.cube.rotate(Rotation.LEFT, rotation[1].intValue());
					else if(rotation[0].intValue() == Rotation.UP)
						this.cube.rotate(Rotation.DOWN, rotation[1].intValue());
					else if(rotation[0].intValue() == Rotation.DOWN)
						this.cube.rotate(Rotation.UP, rotation[1].intValue());
					else if(rotation[0].intValue() == Rotation.CLOCKWISE)
						this.cube.rotate(Rotation.COUNTERCLOCKWISE, rotation[1].intValue());
					else if(rotation[0].intValue() == Rotation.COUNTERCLOCKWISE)
						this.cube.rotate(Rotation.CLOCKWISE, rotation[1].intValue());
				}
				else if(rotation[1].intValue() == -1)
				{
					if(rotation[0].intValue() == Rotation.LEFT)
						this.cube.rotate(Rotation.RIGHT);
					else if(rotation[0].intValue() == Rotation.RIGHT)
						this.cube.rotate(Rotation.LEFT);
					else if(rotation[0].intValue() == Rotation.UP)
						this.cube.rotate(Rotation.DOWN);
					else if(rotation[0].intValue() == Rotation.DOWN)
						this.cube.rotate(Rotation.UP);
					else if(rotation[0].intValue() == Rotation.CLOCKWISE)
						this.cube.rotate(Rotation.COUNTERCLOCKWISE);
					else if(rotation[0].intValue() == Rotation.COUNTERCLOCKWISE)
						this.cube.rotate(Rotation.CLOCKWISE);
				}
			}
		}
	}
}