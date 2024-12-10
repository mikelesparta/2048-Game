package uo.mp.s1.game.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import uo.mp.s1.game.model.Game2048;

/**
 * Main class of the 2048 game

 * 2048 is a game created by Gabriele Cirulli. The objective is to combine 
 * numbers (powers of 2) to get the number 2048 and then win the play.
 * To move the numbers on the board you choose the movement direction (up, down, 
 * left and right) with the keyboard. Then the numbers move in the chosen
 * direction and one of this things may happen:
 * 	- If the next-in-the-direction-to-move cell's value is free the value changes
 * 		to that cell
 * 	- If the current value is equal to the next-in-the-direction-to-move cell's 
 * 		value then both values add up in the next cell
 * 	- If the current value is different then the movement is blocked
 * 
 * Copyright: Copyright (c) 2018
 * School of Computing Science - University of Oviedo
 * 
 * @author MP teachers
 * @version 1.0
 */
public class GameApp {
	private Game2048 game;

	public void run() {
		do {
			play();
		} while ( userWantsAnotherPlay() );
	}

	private void play() {
		showTitle();
		game = new Game2048();		
		
		do {
			game.next();
			game.paint();
			doMovement();
			
		} while (!game.isBoardFull());
		
		showGameOver();
	}

	private boolean userWantsAnotherPlay() {
		showNewGamePrompt();
		return readCharacter() == 's';
	}

	private void doMovement() {
		showMovements();
		switch ( readCharacter() ) {
		case 'r':
		case 'R':
			game.moveRight();
			break;
		case 'l':
		case 'L':
			game.moveLeft();
			break;
		case 'u':
		case 'U':
			game.moveUp();
			break;
		case 'd':
		case 'D':
			game.moveDown();
			break;
		}
	}

	private void showNewGamePrompt() {
		System.out.print("Do you want another try? s/n: ");
	}

	private void showGameOver() {
		System.out.println("GAME OVER");
	}

	private void showMovements() {
		System.out.print("Choose one direction [r R]/[l L]/[u U]/[d D]: ");
	}

	private void showTitle() {
		System.out.print("2048 GAME\n");
	}

	/**
	 * Reads an character from the standard input (usually the keyboard)
	 * @return 
	 */
	private int readCharacter() {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		int character = 0;
		try {
			character = br.read();
		} catch (IOException e) {
			System.out.println("An error has happen with the data input!");
			System.exit(0);
		}
		return character;
	}
}
