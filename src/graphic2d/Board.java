package graphic2d;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import cube.Cube;
import rotation.RotationObserver;

public class Board extends JPanel
{
	protected int index;
	public Board(Cube cube, RotationObserver rotationObserver) 
	{
		super();
		this.index = 1;
		this.setLayout(new GridLayout(1,1));
		
		JPanel rotation = new JPanel();
		rotation.setLayout(new GridLayout(1,2));
		
		JPanel rotationSimplePanel = new JPanel();
		rotationSimplePanel.setLayout(new GridLayout(2,1));
		
		ButtonRotation[] rotationButtons = new ButtonRotation[6];
		rotationButtons[0] = new ButtonRotation("Tourner une ligne vers la gauche");
		rotationButtons[1] = new ButtonRotation("Tourner une ligne vers la droite");
		rotationButtons[2] = new ButtonRotation("Tourner une colonne vers le haut");
		rotationButtons[3] = new ButtonRotation("Tourner une colonne vers le bas");
		rotationButtons[4] = new ButtonRotation("Tourner une face dans le sens horaire");
		rotationButtons[5] = new ButtonRotation("Tourner une face dans le sens trigo");
		
		JPanel rotationSimple = new JPanel();
		rotationSimple.setLayout(new GridLayout(3,2));
		for(int i = 0; i < 6; i++)
		{
			rotationButtons[i].addActionListener(new ControllerRotation(rotationButtons[i]));
			rotationButtons[i].addObserver(rotationObserver);
			rotationButtons[i].addObserver(cube);
			rotationSimple.add(rotationButtons[i]);
		}
		rotationSimplePanel.add(rotationSimple);
		
		JPanel indexPanel = new JPanel();
		indexPanel.setLayout(new GridLayout(1, cube.getSize()));
		ButtonIndex[] index = new ButtonIndex[cube.getSize()];
		for(int i = 0; i < index.length; i++)
		{
			index[i] = new ButtonIndex((i + 1) + "");
			if(i == 0)
			{
				index[i].setForeground(Color.RED);
			}
			index[i].addActionListener(new IndexController(index, index[i]));
			for(int j = 0; j < 6; j++)
			{
				index[i].addObserver(rotationButtons[j]);
			}
			indexPanel.add(index[i]);
		}
		rotationSimplePanel.add(indexPanel);
		
		ButtonRotation[] rotationCubeButtons = new ButtonRotation[6];
		rotationCubeButtons[0] = new ButtonRotation("Tourner le cube vers la gauche");
		rotationCubeButtons[1] = new ButtonRotation("Tourner le cube vers la droite");
		rotationCubeButtons[2] = new ButtonRotation("Tourner le cube vers le haut");
		rotationCubeButtons[3] = new ButtonRotation("Tourner le cube vers le bas");
		rotationCubeButtons[4] = new ButtonRotation("Tourner le cube dans le sens horaire");
		rotationCubeButtons[5] = new ButtonRotation("Tourner le cube dans le sens trigo");
		
		JPanel rotationCube = new JPanel();
		rotationCube.setLayout(new GridLayout(3,2));
		for(int i = 0; i < 6; i++)
		{
			rotationCubeButtons[i].addActionListener(new ControllerRotation(rotationCubeButtons[i]));
			rotationCubeButtons[i].addObserver(rotationObserver);
			rotationCubeButtons[i].addObserver(cube);
			rotationCube.add(rotationCubeButtons[i]);
		}
		
		rotation.add(rotationSimplePanel);
		rotation.add(rotationCube);

		this.add(rotation);
	}
}
