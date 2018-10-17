package graphic2d;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import cube.Cube;

public class Board extends JPanel
{
	protected int index;
	public Board(Cube cube, Pattern pattern) 
	{
		super();
		this.index = 1;
		this.setLayout(new GridLayout(1,1));
		
		JPanel rotation = new JPanel();
		rotation.setLayout(new GridLayout(1,2));
		
		JPanel rotationSimplePanel = new JPanel();
		rotationSimplePanel.setLayout(new GridLayout(2,1));
		
		JButton[] rotationButtons = new JButton[6];
		rotationButtons[0] = new JButton("Tourner une ligne vers la gauche");
		rotationButtons[1] = new JButton("Tourner une ligne vers la droite");
		rotationButtons[2] = new JButton("Tourner une colonne vers le haut");
		rotationButtons[3] = new JButton("Tourner une colonne vers le bas");
		rotationButtons[4] = new JButton("Tourner une face dans le sens horaire");
		rotationButtons[5] = new JButton("Tourner une face dans le sens trigo");
		
		JPanel rotationSimple = new JPanel();
		rotationSimple.setLayout(new GridLayout(3,2));
		for(int i = 0; i < 6; i++)
		{
			rotationButtons[i].addActionListener(new ControllerRotation(cube,pattern,this));
			rotationSimple.add(rotationButtons[i]);
		}
		rotationSimplePanel.add(rotationSimple);
		
		JPanel indexPanel = new JPanel();
		JButton[] index = new JButton[cube.getSize()];
		for(int i = 0; i < index.length; i++)
		{
			index[i] = new JButton((i + 1) + "");
			if(i == 0)
			{
				index[i].setForeground(Color.RED);
			}
			index[i].addActionListener(new IndexController(this, index, index[i], cube.getSize()));
			indexPanel.add(index[i]);
		}
		rotationSimplePanel.add(indexPanel);
		
		JButton[] rotationCubeButtons = new JButton[6];
		rotationCubeButtons[0] = new JButton("Tourner le cube vers la gauche");
		rotationCubeButtons[1] = new JButton("Tourner le cube vers la droite");
		rotationCubeButtons[2] = new JButton("Tourner le cube vers le haut");
		rotationCubeButtons[3] = new JButton("Tourner le cube vers le bas");
		rotationCubeButtons[4] = new JButton("Tourner le cube dans le sens horaire");
		rotationCubeButtons[5] = new JButton("Tourner le cube dans le sens trigo");
		
		JPanel rotationCube = new JPanel();
		rotationCube.setLayout(new GridLayout(3,2));
		for(int i = 0; i < 6; i++)
		{
			rotationCubeButtons[i].addActionListener(new ControllerRotationCube(cube,pattern));
			rotationCube.add(rotationCubeButtons[i]);
		}
		
		rotation.add(rotationSimplePanel);
		rotation.add(rotationCube);

		this.add(rotation);
	}
	
	public void setindex(int index)
	{
		this.index = index;
	}
	
	public int getIndex()
	{
		return this.index;
	}
}
