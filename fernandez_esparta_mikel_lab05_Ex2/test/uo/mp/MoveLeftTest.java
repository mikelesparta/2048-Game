package uo.mp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import uo.mp.s1.game.model.Game2048;

class MoveLeftTest {

	/**
	 * Given: the Game2048 class and invoking the default constructor
	 * When: given an array and calling the moveLeft()
	 * Then: all the elements move left
	 */
	@Test
	public void test1() {
Game2048 g = new Game2048();
		
		int[][] b = {
				{2,0,0},
				{0,2,0},
				{0,0,2}
		};
		
		int[][] expected = {
				{2,0,0},
				{2,0,0},
				{2,0,0}
		};
		
		g.setBoardForTest(b);
		
		g.moveLeft();
		
		assertArrayEquals(expected, g.getBoardForTest());
	}
	
	/**
	 * Given: the Game2048 class and invoking the other constructor with 
	 * dimension 4x3
	 * When: given an array and calling the moveLeft()
	 * Then: all the elements move left
	 */
	@Test
	public void test2() {
		Game2048 a = new Game2048(4,3);
		
		int[][] b = {
				{2,2,0},
				{4,0,8},
				{8,2,2},
				{2,8,8}
		};
		
		int[][] expected = {
				{4,0,0},
				{4,8,0},
				{8,4,0},
				{2,16,0}
		};
		
		a.setBoardForTest(b);
		a.moveLeft();
		assertArrayEquals(expected, a.getBoardForTest());
	}

}
