package uo.mp.s1.game.model;
import java.util.Random;

/**
 * A simulation of the "2048" game, see http://juego2048.es/
 * Copyright (c) 2018 School of Computer Science - University of Oviedo
 * 
 * @author MP teachers
 * @version 1.0
 */
public class Game2048 {
	//CONSTANTS
	final static int MIN_DIM = 3;
	//FIELDS
	private int[][] matrix;
	
	/**
	 * Creates a 3x3 board
	 */
	public Game2048() {
		matrix = new int[MIN_DIM][MIN_DIM];
	}

	/**
	 * Creates a board with the specified sizes, zeroes all its positions 
	 */
	public Game2048(int height, int width) {
		if(height < 0 || width < 0) {
			throw new IllegalArgumentException("Error");
		}
		
		matrix = new int[height][width];
	}
	
	/**
	 * Returns true if it is free (==0)
	 * @param i containing the row
	 * @param j containing the column
	 * @return boolean true if it is free. Otherwise false.
	 */
	public boolean isFree(int i, int j) {
		return matrix[i][j] == 0;
	}
	
	/**
	 * A free position is a cell with a 0 value
	 * 
	 * @return true if there is no free positions on the board
	 */
	public boolean isBoardFull() {
		int a = 0;
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				if(matrix[i][j] == 0) {
					a++;
				}
			}
		}
		if(a != 0) {
			return false;
		}
		
		else {
			return true;
		}
	}

	/**
	 * checks if two adjacent tiles are equal combines them doubling the value 
	 * of the right tile and setting a zero on the left one.
	 * 
	 * @param row containing the row
	 */
	public void mergeRight(int row) {
		for(int col = matrix[0].length - 1; col > 0; col--) {
			if(matrix[row][col] == matrix[row][col-1]) {
				matrix[row][col] *= 2; 
				matrix[row][col-1] = 0;
			}
		}
	}
	
	
	/**
	 * Moves all non blank tiles to the right.
	 * 
	 * @param row containing the row
	 */
	public void shiftRight(int row) {
		for(int col = matrix[0].length -1; col >= 0; col--) {
			if(!isFree(row, col)) {
				int k = col;
				while(k < matrix[0].length - 1) {
					if(isFree(row, k+1)) {
						matrix[row][k+1] = matrix[row][k];
						matrix[row][k] = 0;
					}
					k++;
				}
			}
		}
	}
	
	/**
	 * Pseudocode:
	 * For each row
	 * 		shiftRight (moves all non blank tiles to the right)
	 * 		mergeRight (checks if two adjacent tiles are equal combines them 
     *					doubling the value of the right tile and setting a 
	 *					zero on the left one)
	 * 		shiftRight (again, as mergeRight has introduced new zeroes)
	 */
	public void moveRight() {
		for(int i = matrix.length -1; i >= 0; i--) {
			shiftRight(i);
			mergeRight(i);
			shiftRight(i);
		}
	}

	/**
	 * Move elements to the left with the same logic as in moveRight() By using 
	 * the rotateBoard() method it is much easier it is a combination of rotate,
	 * rotate, move right, rotate, rotate
	 */
	public void moveLeft() {
		rotateBoard();
		rotateBoard();
		moveRight();
		rotateBoard();
		rotateBoard();
	}

	/**
	 * Move elements up with the same logic as in moveRight() By using the
	 * rotateBoard() method it is much easier, a combination of rotations and
	 * moveRight
	 */
	public void moveUp() {
		rotateBoard();
		rotateBoard();
		rotateBoard();
		moveRight();
		rotateBoard();
	}

	/**
	 * Move elements down with the same logic as in moveRight() By using the
	 * rotateBoard() method it is much easier, a combination of rotations and
	 * moveRight
	 */
	public void moveDown() {
		rotateBoard();
		moveRight();
		rotateBoard();
		rotateBoard();
		rotateBoard();
	}

	/**
	 * Shows the board on the screen
	 */
	public void paint() {
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	/**
	 * Rotates the board to the left (counterclockwise)
	 * Hint: create a new array and copy the values in the rotated positions
	 */
	public void rotateBoard() {
		int aux[][] = new int[matrix[0].length][matrix.length];
		
		for(int i = 0; i < matrix.length; i++) {
			for(int j = matrix[0].length - 1; j >= 0; j--) {
				aux[matrix[0].length - 1 - j][i] = matrix[i][j];
			}
		}
		matrix = aux;
	}

	/**
	 * Puts a 2 value on a random free cell. 
	 * Ensure the board is not full.
	 */
	public void next() {
		Random coin = new Random();
		
		int i = coin.nextInt(matrix.length);
		int j = coin.nextInt(matrix[0].length);
		
		while(matrix[i][j] != 0) {
			i = coin.nextInt(matrix.length);
			j = coin.nextInt(matrix[0].length);
		}
		matrix[i][j] = 2;
	}

	/**
	 * Aux method for the tests, returns the board
	 * 
	 * @return int[][] containing the matrix
	 */
	public int[][] getBoardForTest() {
		return matrix;
	}
	
	/**
	 * Aux method for the tests
	 * 
	 * @param a containing a new array
	 */
	public void setBoardForTest(int[][] a) {
		matrix = a;
	}
}