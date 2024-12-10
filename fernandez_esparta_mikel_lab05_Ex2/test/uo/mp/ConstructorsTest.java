package uo.mp;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

import uo.mp.s1.game.model.Game2048;

class ConstructorsTest {

	/**
	 * Given: the Game2048 class
	 * When: the default constructor is invoked
	 * Then: there is a matrix 3x3
	 */
	@Test
	public void test1() {
		Game2048 g = new Game2048();
		
		int[][] b = g.getBoardForTest();
		assertTrue(b.length == 3);
		assertTrue(b[0].length == 3);
	}
	
	/**
	 * Given: the Game2048 class
	 * When the other constructor is invoked with 4x4
	 * Then: there is a matrix of 4x4
	 */
	@Test
	public void test2() {
		Game2048 g = new Game2048(4,4);
		
		int[][] b = g.getBoardForTest();
		assertTrue(b.length == 4);
		assertTrue(b[0].length == 4);
	}
	
	/**
	 * Given: the Game2048 class
	 * When the other constructor is invoked with 4x6
	 * Then: there is a matrix of 4x6
	 */
	@Test
	public void test3() {
		Game2048 g = new Game2048(4,6);
		
		int[][] b = g.getBoardForTest();
		assertTrue(b.length == 4);
		assertTrue(b[0].length == 6);
	}
	
	/**
	 * Given: the Game2048 class
	 * When the other constructor is invoked with -1x3
	 * Then: throws an IllegalArgumentException
	 */
	@Test //(expected = IllegalArgumentException.class)
	public void test4() {
		try {
			new Game2048(-1,3);
			fail();
		}
		catch(IllegalArgumentException e) {
		
		}
		
	}
	
	/**
	 * Given: the Game2048 class
	 * When the other constructor is invoked with 4x-3
	 * Then: throws an IllegalArgumentException
	 */
	@Test
	public void test5() {
		try {
			new Game2048(4,-3);
			fail();
		}
		catch(IllegalArgumentException ex) {
	
		}
		catch(Exception e) {
			fail();
		}
	}
	
	/**
	 * Given:
	 * When the default constructor is invoked 
	 * Then: the matrix is full of zeroes
	 */
	@Test
	public void testFullOfZeroes() {
		Game2048 g = new Game2048();
		
		int[][] b = g.getBoardForTest();
		int count = numberOf(0, b);
		
		assertTrue(count == 9);
	}
	
	/**
	 * Aux method to count the number of times a number is repeated
	 * within the matrix
	 */
	private int numberOf(int a, int[][] b) {
		int counter = 0;
		
		for(int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[0].length; j++) {
				if(b[i][j] == a) {
					counter++;
				}
			}
		}
		return counter;
	}
}
