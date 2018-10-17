package graphic2d;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cube.Cube;
import rotation.Rotation;

public class ControllerRotation implements ActionListener
{
	protected Cube cube;
	protected Pattern pattern;
	protected Board board;
	
	public ControllerRotation(Cube cube, Pattern pattern, Board board) 
	{
		this.cube = cube;
		this.pattern = pattern;
		this.board = board;
	}

	@Override
	public void actionPerformed(ActionEvent event) 
	{
		if(event.getActionCommand().equals("Tourner une ligne vers la gauche"))
		{
			this.cube.rotate(Rotation.LEFT, this.board.getIndex() - 1, 1);
			this.pattern.update();
		}
		else if(event.getActionCommand().equals("Tourner une ligne vers la droite"))
		{
			this.cube.rotate(Rotation.RIGHT, this.board.getIndex() - 1, 1);
			this.pattern.update();
		}
		else if(event.getActionCommand().equals("Tourner une colonne vers le haut"))
		{
			this.cube.rotate(Rotation.UP, this.board.getIndex() - 1, 1);
			this.pattern.update();
		}
		else if(event.getActionCommand().equals("Tourner une colonne vers le bas"))
		{
			this.cube.rotate(Rotation.DOWN, this.board.getIndex() - 1, 1);
			this.pattern.update();
		}
		else if(event.getActionCommand().equals("Tourner une face dans le sens horaire"))
		{
			this.cube.rotate(Rotation.CLOCKWISE, this.board.getIndex() - 1, 1);
			this.pattern.update();
		}
		else if(event.getActionCommand().equals("Tourner une face dans le sens trigo"))
		{
			this.cube.rotate(Rotation.COUNTERCLOCKWISE, this.board.getIndex() - 1, 1);
			this.pattern.update();
		}
	}

}
