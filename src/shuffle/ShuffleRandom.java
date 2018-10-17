package shuffle;

import java.util.Random;

import cube.Cube;

public class ShuffleRandom implements Shuffle
{
	@Override
	public void shuffle(Cube cube)
	{
		for(int i = 0; i < 10000; i++)
		{
			Random r = new Random();
			int direction = r.nextInt(4);
			int index = r.nextInt(cube.getSize()-1);
			cube.rotate(direction, index, 1);
		}
	}
}
