package graphic2d;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import cube.Cube;


public class Window extends JFrame
{
	public Window()
	{
		super("Rubik's Cube");
		this.setSize(1920,1080);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Cube cube = new Cube(3);
		
		Pattern pattern = new Pattern(cube);
		JButton scramble = new JButton("Melanger");
		scramble.addActionListener(new ButtonsController(cube, pattern));
		
		this.add(scramble, BorderLayout.NORTH);
		this.add(pattern, BorderLayout.CENTER);
		this.add(new Board(cube, pattern), BorderLayout.SOUTH);
	}
}
