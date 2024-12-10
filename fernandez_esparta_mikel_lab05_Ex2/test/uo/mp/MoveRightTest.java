package uo.mp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import uo.mp.s1.game.model.Game2048;

class MoveRightTest {

	/**
	 * Given: the Game2048 class and invoking the default constructor
	 * When: given an array and calling the moveRight()
	 * Then: all the elements move right
	 */
	@Test
	void test1() {
		Game2048 g = new Game2048();
		
		int[][] b = {
				{2,0,0},
				{0,2,0},
				{0,0,2}
		};
		
		int[][] expected = {
				{0,0,2},
				{0,0,2},
				{0,0,2}
		};
		
		g.setBoardForTest(b);
		
		g.moveRight();
		
		assertArrayEquals(expected, g.getBoardForTest());
	}
	
	/**
	 * Given: the Game2048 class and invoking the other constructor with
	 * dimension 3x4
	 * When: given an array and calling the moveRight()
	 * Then: all the elements move right
	 */
	@Test
	public void test2() {
		Game2048 a = new Game2048(3,4);
		
		int[][] b = {
				{2,2,0,4},
				{4,0,8,8},
				{8,2,2,8}
		};
		
		int[][] expected = {
				{0,0,4,4},
				{0,0,4,16},
				{0,8,4,8}
		};
		
		a.setBoardForTest(b);
		a.moveRight();
		assertArrayEquals(expected, a.getBoardForTest());
	}

}
