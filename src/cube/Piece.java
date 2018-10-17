package cube;

public class Piece 
{
	public static final int WHITE  = 0;
	public static final int GREEN  = 1;
	public static final int RED    = 2;
	public static final int BLUE   = 3;
	public static final int ORANGE = 4;
	public static final int YELLOW = 5;
	public static final int NONE   = 6;
	
	protected int color;
	
	public Piece(int color)
	{
		this.setColor(color);
	}
	
	public void setColor(int color)
	{
		this.color = color;
	}
	
	public int getColor()
	{
		return this.color;
	}
	
	public String toString()
	{
		return this.color + "";
	}
	
}
