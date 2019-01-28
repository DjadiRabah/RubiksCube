package model.shuffle;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;

import model.cube.Cube;
import model.solver.*;

public class ShuffleRandom implements Shuffle
{
	@Override
	public Deque<Integer[]> shuffle(Cube cube)
	{
		Deque<Integer[]> rotations =  new ArrayDeque<>();
		for(int i = 0; i < 3; i++)
		{
			Random r = new Random();
			int direction = r.nextInt(6);
			int index = r.nextInt(cube.getSize());
			cube.rotate(direction, index);
		}

		new SolverBruteForce().solve(cube);
		return rotations;
	}
}
