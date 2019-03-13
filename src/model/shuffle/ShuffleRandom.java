package model.shuffle;

import java.util.Random;
import model.cube.Cube;
import model.solver.IDA;
import model.solver.beginner.SolverBeginner;

public class ShuffleRandom implements Shuffle
{
	@Override
	public void shuffle(Cube cube)
	{
		cube.Init();
		for(int i = 0; i < 4; i++)
		{
			Random r = new Random();
			int direction = r.nextInt(6);
			int index = r.nextInt(cube.getSize());
			cube.rotate(direction, index);
		}
	}
}