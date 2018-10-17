package shuffle;

import java.util.Random;

import Solver.SolverBeginner;
import cube.Cube;

public class ShuffleRandom implements Shuffle
{
	@Override
	public void shuffle(Cube cube)
	{
		for(int i = 0; i < 100000; i++)
		{
			Random r = new Random();
			int direction = r.nextInt(6);
			int index = r.nextInt(cube.getSize());
			cube.rotate(direction, index);
		}
		new SolverBeginner().solve(cube);
	}
}
