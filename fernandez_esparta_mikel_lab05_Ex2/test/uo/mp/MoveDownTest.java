package uo.mp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import uo.mp.s1.game.model.Game2048;

class MoveDownTest {

	/**
	 * Given: the Game2048 class and invoking the default constructor
	 * When: given an array and calling the moveDown()
	 * Then: all the elements move down
	 */
	@Test
	public void test1() {
		Game2048 a = new Game2048();
		
		int[][] b = {
				{2,8,0},
				{2,0,4},
				{4,8,4}
		};
		
		int[][] expected = {
				{0,0,0},
				{4,0,0},
				{4,16,8}
		};
	
		a.setBoardForTest(b);
		a.moveDown();
		assertArrayEquals(expected, a.getBoardForTest());
	}

	/**
	 * Given: the Game2048 class and invoking the other constructor with 
	 * dimension 3x4
	 * When: given an array and calling the moveDown()
	 * Then: all the elements move down
	 */
	@Test
	public void test2() {
		Game2048 a = new Game2048(3,4);
		
		int[][] b = {
				{4,8,0,2},
				{0,2,2,2},
				{8,2,4,0}
		};
		
		int[][] expected = {
				{0,0,0,0},
				{4,8,2,0},
				{8,4,4,4}
		};
		
		a.setBoardForTest(b);
		a.moveDown();
		assertArrayEquals(expected, a.getBoardForTest());
	}
}
