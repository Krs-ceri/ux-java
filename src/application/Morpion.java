package application;




public class Morpion {

	private Tictactoe current;
	protected Tictactoe plateau[][];
	private Tictactoe playerX = Tictactoe.CROSS;
	private Tictactoe playerY = Tictactoe.CIRCLE;
	
	
	public Morpion() {
		this.plateau = new Tictactoe[2][2];
		this.current = playerY;
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
	
	public void switchPlayer() {
		if(this.current == playerX)	this.current = playerY;
		else this.current = playerX;
	}
	
	public boolean addTac(Tictactoe player, int x, int y) {
		if(this.current == player) {
			if(this.plateau[x][y] == Tictactoe.CIRCLE || this.plateau[x][y] == Tictactoe.CROSS)	return false;
			this.plateau[x][y] = player;
			this.switchPlayer();
			return true;
		}
		return false;

	}
	
	
}
