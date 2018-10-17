package graphic2d;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cube.Cube;
import rotation.Rotation;

public class ControllerRotationCube implements ActionListener
{
	protected Cube cube;
	protected Pattern pattern;
	
	public ControllerRotationCube(Cube cube, Pattern pattern) 
	{
		this.cube = cube;
		this.pattern = pattern;
	}

	@Override
	public void actionPerformed(ActionEvent event) 
	{
		if(event.getActionCommand().equals("Tourner le cube vers la gauche"))
		{
			this.cube.rotate(Rotation.LEFT, 1);
			this.pattern.update();
		}
		else if(event.getActionCommand().equals("Tourner le cube vers la droite"))
		{
			this.cube.rotate(Rotation.RIGHT, 1);
			this.pattern.update();
		}
		else if(event.getActionCommand().equals("Tourner le cube vers le haut"))
		{
			this.cube.rotate(Rotation.UP, 1);
			this.pattern.update();
		}
		else if(event.getActionCommand().equals("Tourner le cube vers le bas"))
		{
			this.cube.rotate(Rotation.DOWN, 1);
			this.pattern.update();
		}
		else if(event.getActionCommand().equals("Tourner le cube dans le sens horaire"))
		{
			this.cube.rotate(Rotation.CLOCKWISE, 1);
			this.pattern.update();
		}
		else if(event.getActionCommand().equals("Tourner le cube dans le sens trigo"))
		{
			this.cube.rotate(Rotation.COUNTERCLOCKWISE, 1);
			this.pattern.update();
		}
	}

}
