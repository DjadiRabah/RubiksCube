package view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

import model.cube.Cube;
import model.cube.piece.*;
import model.observer.Observable;
import model.observer.Observer;

public class Pattern extends JComponent implements Observer
{
	protected Cube cube;
	public Pattern(Cube cube) 
	{
		super();
		this.cube = cube;
	}
	
	private void paintSquare(Graphics graphics, int square, int offsetX, int offsetY)
	{
		int squareSizeX = this.getWidth() / 4;
		int squareSizeY = this.getHeight() / 3;
		
		int[][] colors = this.cube.getSquare(square).getColors();
		for(int i = 0; i < this.cube.getSize(); i++)
		{
			for(int j = 0; j < this.cube.getSize(); j++)
			{
				if(colors[i][j] == Piece.WHITE)
					graphics.setColor(new Color(255,255,255));
				else if(colors[i][j] == Piece.GREEN)
					graphics.setColor(new Color(0,255,0));
				else if(colors[i][j] == Piece.RED)
					graphics.setColor(new Color(255,0,0));
				else if(colors[i][j] == Piece.BLUE)
					graphics.setColor(new Color(0,0,255));
				else if(colors[i][j] == Piece.ORANGE)
					graphics.setColor(new Color(255,128,0));
				else if(colors[i][j] == Piece.YELLOW)
					graphics.setColor(new Color(255,255,0));
				else if(colors[i][j] == Piece.NONE)
					graphics.setColor(this.getBackground());
				int realPosX = j * squareSizeX / cube.getSize() + offsetX;
				int realPosY = i * squareSizeY / cube.getSize() + offsetY;
				graphics.fillRoundRect(realPosX, realPosY, squareSizeX / this.cube.getSize(), squareSizeY / this.cube.getSize(),10,10);
				graphics.setColor(new Color(0,0,0));
				graphics.drawRoundRect(realPosX, realPosY, squareSizeX / this.cube.getSize(), squareSizeY / this.cube.getSize(),10,10);
				graphics.drawRoundRect(realPosX + 1, realPosY + 1, squareSizeX / this.cube.getSize() - 1, squareSizeY / this.cube.getSize() - 1,10,10);
				graphics.drawRoundRect(realPosX + 2, realPosY + 2, squareSizeX / this.cube.getSize() - 2, squareSizeY / this.cube.getSize() - 2,10,10);
			}
		}
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		Graphics newG = g.create();
		
		if (this.isOpaque()) 
		{
			newG.setColor(this.getBackground());
			newG.fillRect(0, 0, this.getWidth(), this.getHeight());
		}
		
		int squareSizeX = this.getWidth() / 4;
		int squareSizeY = this.getHeight() / 3;
		
		this.paintSquare(newG, Cube.TOP, squareSizeX, 0);
		this.paintSquare(newG, Cube.LEFT, 0, squareSizeY);
		this.paintSquare(newG, Cube.FRONT, squareSizeX, squareSizeY);
		this.paintSquare(newG, Cube.RIGHT, 2 * squareSizeX, squareSizeY);
		this.paintSquare(newG, Cube.BACK,  3 * squareSizeX, squareSizeY);
		this.paintSquare(newG, Cube.DOWN,  squareSizeX, 2 * squareSizeY);
    }

	@Override
	public void update(Observable observable, Object object) 
	{
		if(observable instanceof Cube)
		{
			this.repaint();
		}
	}
}
