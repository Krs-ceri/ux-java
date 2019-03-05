package application;

import java.util.*;


public class Morpion {

	private static int current = 0;
	protected Tictactoe plateau[][];
	private int playerX = 1;
	private int playerY = 2;
	
	
	public Morpion() {
		this.plateau = new Tictactoe[2][2];
	/*	for (int i = 0; i < plateau.length; i++) {
			for (int j = 0; j < plateau.length; j++) {
				this.plateau[i][j] = -1;
			}
		}*/
		
	}
	
	public String winCondition() {
		String winner = "";		//Nobody win
		if(this.plateau[0][0] == Tictactoe.CIRCLE || this.plateau[0][0] == Tictactoe.CROSS) {
			if((this.plateau[0][1] == this.plateau[0][0] && this.plateau[0][2] == this.plateau[0][0]) 
					|| (this.plateau[1][0] == this.plateau[0][0] && this.plateau[2][0] == this.plateau[0][0]) 
					|| (this.plateau[1][1] == this.plateau[0][0] && this.plateau[2][2] == this.plateau[0][0])) { winner = this.plateau[0][0].toString(); }
	
		}
		if(this.plateau[0][0] == Tictactoe.CIRCLE || this.plateau[0][0] == Tictactoe.CROSS) {
			if((this.plateau[2][1] == this.plateau[2][2] && this.plateau[0][2] == this.plateau[2][2]) 
					|| (this.plateau[2][0] == this.plateau[2][2] && this.plateau[2][2] == this.plateau[1][2]) 
					|| (this.plateau[1][1] == this.plateau[2][2] && this.plateau[2][2] == this.plateau[0][0])) { winner = this.plateau[2][2].toString(); }
	
		}
		if(this.plateau[0][0] == Tictactoe.CIRCLE || this.plateau[0][0] == Tictactoe.CROSS) {
			if((this.plateau[0][1] == this.plateau[1][1] && this.plateau[0][2] == this.plateau[2][1]) 
					|| (this.plateau[1][0] == this.plateau[1][1] && this.plateau[1][1] == this.plateau[2][1])) { winner = this.plateau[1][1].toString(); }
	
		}

		return winner;
	}
	
	public boolean addTac(int player, int x, int y) {
		if(this.plateau[x][y] == Tictactoe.CIRCLE || this.plateau[x][y] == Tictactoe.CROSS)	return false;
		this.plateau[x][y] = player;
		return true;
	}
	
	
}
