package uo.mp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import uo.mp.s1.game.model.Game2048;

class NextTest {

	/**
	 * Given: the Game2048 class
	 * When: the default constructor is invoked as well as the next()
	 * Then: the matrix must have only one two
	 */
	@Test
	public void test1() {
		Game2048 a = new Game2048();
		
		int[][] b = a.getBoardForTest();
		a.next();
		assertTrue(countTwo(b) == 1);
	}

	/**
	 * Given: the Game2048 class
	 * When: the other constructor is invoked with dimensions 4x4
	 * as well as the next() method two times
	 * Then: the matrix must have two twos
	 */
	@Test
	public void test2() {
		Game2048 a = new Game2048(4,4);
		
		int[][] b = a.getBoardForTest();
		
		for(int i = 0; i < 2; i++) {
			a.next();
		}
		
		assertTrue(countTwo(b) == 2);
	}
	
	/**
	 * Given: the Game2048 class
	 * When: the default constructor is invoked 
	 * as well as the next() method three times
	 * Then: the matrix must have three twos
	 */
	@Test
	public void test3() {
		Game2048 a = new Game2048();
		
		int[][] b = a.getBoardForTest();
		
		for(int i = 0; i < 3; i++) {
			a.next();
		}
		
		assertTrue(countTwo(b) == 3);
	}
	
	/**
	 * Given: the Game2048 class
	 * When: the default constructor is invoked 
	 * as well as the next() method four times
	 * Then: the matrix must have four twos
	 */
	@Test
	public void test4() {
		Game2048 a = new Game2048();
		int[][] b = a.getBoardForTest();
		
		for(int i = 0; i < 4; i++) {
			a.next();
		}
		assertTrue(countTwo(b) == 4);
	}
	
	@Test
	public void test5() {
		Game2048 a = new Game2048();
		int[][] b = a.getBoardForTest();
		
		for(int i = 0; i < 5; i++) {
			a.next();
		}
		assertTrue(countTwo(b) == 5);
	}
	
	/**
	 * Aux method to count the number of 2 that appear in the matrix
	 * @param matrix containing an int[][]
	 * @return int containg the number of times that it appears
	 */
	private int countTwo(int[][] matrix) {
		int counter = 0;
		
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				if(matrix[i][j] == 2) {
					counter++;
				}
			}
		}
		return counter;
	}
}
