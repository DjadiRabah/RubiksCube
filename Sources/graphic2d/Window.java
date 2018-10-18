package graphic2d;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import cube.Cube;
import rotation.RotationObserver;


public class Window extends JFrame
{
	public Window()
	{
		super("Rubik's Cube");
		this.setSize(1920,1200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Cube cube = new Cube(3);
		Pattern pattern = new Pattern(cube);
		cube.addObserver(pattern);
		RotationObserver rotationObserver = new RotationObserver();
		
		JPanel upperBoard = new JPanel();
		JButton returnButton = new JButton("Retour");
		
		upperBoard.add(returnButton);
		upperBoard.setLayout(new GridLayout(1,2));
		
		JButton scramble = new JButton("Melanger");
		scramble.addActionListener(new ButtonsController(cube, pattern));
		upperBoard.add(scramble);
		returnButton.addActionListener(new ControllerReturn(cube, rotationObserver));
		
		this.add(upperBoard, BorderLayout.NORTH);
		this.add(pattern, BorderLayout.CENTER);
		this.add(new Board(cube,rotationObserver), BorderLayout.SOUTH);
	}
}
