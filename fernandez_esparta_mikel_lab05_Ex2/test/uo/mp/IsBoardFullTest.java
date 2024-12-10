package uo.mp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import uo.mp.s1.game.model.Game2048;

class IsBoardFullTest {

	/**
	 * Given: the Game2048 class
	 * When: the default constructor is invoked the array is empty
	 * Then: the matrix is full of zeroes, meaning it is not full
	 */
	@Test
	public void test1() {
		Game2048 a = new Game2048();
		
		assertEquals(false, a.isBoardFull());
	}
	
	/**
	 * Given: the Game2048 class
	 * When: the default constructor is invoked the array is empty
	 * Then: the matrix is full of zeroes, meaning it is not full
	 */
	@Test
	public void test2() {
		Game2048 a = new Game2048();
		
		int[][] b = {
				{0,2,2},
				{4,0,0},
				{2,2,0}
		};
		a.setBoardForTest(b);
		
		assertEquals(false, a.isBoardFull());
	}
	
	/**
	 * Given: the Game2048 class
	 * When: the other constructor is invoked with dimension 4x4
	 * Then: the matrix is full
	 */
	@Test
	public void test3() {
		Game2048 a = new Game2048(4,4);
		
		int[][] b = {
				{8,4,2,2},
				{4,8,2,2},
				{2,2,4,8}
		};
		a.setBoardForTest(b);
		
		assertEquals(true, a.isBoardFull());
	}
}
