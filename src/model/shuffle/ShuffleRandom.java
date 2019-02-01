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
		cube.Init();
		Deque<Integer[]> rotations =  new ArrayDeque<>();
<<<<<<< HEAD
		for(int i = 0; i < 5; i++)
=======
		for(int i = 0; i < 10; i++)
>>>>>>> d298fa99d525ddaf36868af351e73b45588e8b7d
		{
			Random r = new Random();
			int direction = r.nextInt(6);
			int index = r.nextInt(cube.getSize());
			cube.rotate(direction, index);
		}

		new SolverBruteForceSecond().solve(cube);
		return rotations;
	}
}