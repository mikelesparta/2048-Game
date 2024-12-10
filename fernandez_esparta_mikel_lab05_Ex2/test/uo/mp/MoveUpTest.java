package uo.mp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import uo.mp.s1.game.model.Game2048;

class MoveUpTest {

	/**
	 * Given: the Game2048 class and invoking the default constructor
	 * When: given an array and calling the moveUp()
	 * Then: all the elements move up
	 */
	@Test
	public void test1() {
		Game2048 a = new Game2048();
		
		int[][] b = {
				{2,2,2},
				{2,0,4},
				{0,8,4}
		};
		
		int[][] expected = {
				{4,2,2},
				{0,8,8},
				{0,0,0}
		};
		
		a.setBoardForTest(b);
		a.moveUp();
		assertArrayEquals(expected, a.getBoardForTest());
	
	}

	/**
	 * Given: the Game2048 class and invoking the default constructor
	 * When: given an array and calling the moveUp()
	 * Then: all the elements move up
	 */
	@Test
	public void test2() {
		Game2048 a = new Game2048();
		
		int[][] b = {
				{4,8,0},
				{0,2,0},
				{8,2,2}
		};
		
		int[][] expected = {
				{4,8,2},
				{8,4,0},
				{0,0,0}
		};
		
		a.setBoardForTest(b);
		a.moveUp();
		assertArrayEquals(expected, a.getBoardForTest());
	}
}
