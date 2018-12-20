package model.shuffle;

import java.util.Deque;

import model.cube.Cube;

public interface Shuffle 
{
	public Deque<Integer[]> shuffle(Cube cube);
}
