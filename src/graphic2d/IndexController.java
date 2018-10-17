package graphic2d;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class IndexController implements ActionListener
{
	protected Board board;
	protected int size;
	protected JButton[] buttons;
	protected JButton button;
	
	public IndexController(Board board, JButton[] buttons, JButton button, int size) 
	{
		this.board = board;
		this.size = size;
		this.button = button;
		this.buttons = buttons;
	}

	@Override
	public void actionPerformed(ActionEvent event) 
	{
		for(int i = 1; i < this.size + 1; i++)
		{
			if(event.getActionCommand().equals(i + ""))
			{
				this.board.setindex(i);
				this.button.setForeground(Color.RED);
				for(int j = 1; j < this.size + 1; j++)
				{
					if(!this.buttons[j-1].getText().equals(i + ""))
					{
						this.buttons[j-1].setForeground(Color.BLACK);
					}
				}
			}
		}
	}

}
