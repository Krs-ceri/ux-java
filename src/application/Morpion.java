package application;

import java.util.*;


public class Morpion {

	private static int current = 0;
	protected int plateau[][];
	private int playerX = 1;
	private int playerY = 2;
	
	
	public Morpion() {
		this.plateau = new int[2][2];
		for (int i = 0; i < plateau.length; i++) {
			for (int j = 0; j < plateau.length; j++) {
				this.plateau[i][j] = -1;
			}
		}
		
	}
	
	public int winCondition() {
		int winner = -1;		//Nobody win
		if(this.plateau[0][0] != -1 ) {
			if((this.plateau[0][1] == this.plateau[0][0] && this.plateau[0][2] == this.plateau[0][0]) 
					|| (this.plateau[1][0] == this.plateau[0][0] && this.plateau[2][0] == this.plateau[0][0]) 
					|| (this.plateau[1][1] == this.plateau[0][0] && this.plateau[2][2] == this.plateau[0][0])) { winner = this.plateau[0][0]; }
	
		}
		if(this.plateau[2][2] != -1) {
			if((this.plateau[2][1] == this.plateau[2][2] && this.plateau[0][2] == this.plateau[2][2]) 
					|| (this.plateau[2][0] == this.plateau[2][2] && this.plateau[2][2] == this.plateau[1][2]) 
					|| (this.plateau[1][1] == this.plateau[2][2] && this.plateau[2][2] == this.plateau[0][0])) { winner = this.plateau[2][2]; }
	
		}
		if(this.plateau[1][1] != -1) {
			if((this.plateau[0][1] == this.plateau[1][1] && this.plateau[0][2] == this.plateau[2][1]) 
					|| (this.plateau[1][0] == this.plateau[1][1] && this.plateau[1][1] == this.plateau[2][1])) { winner = this.plateau[1][1]; }
	
		}

		return winner;
	}
	
	public boolean addTac(int player, int x, int y) {
		if(this.plateau[x][y] != -1 )	return false;
		this.plateau[x][y] = player;
		return true;
	}
	
	
}
