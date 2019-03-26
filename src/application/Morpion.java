package application;


import java.lang.*;
import java.util.*;



public class Morpion {

    private static volatile Morpion instance = null;
	private Tictactoe current;
	protected Tictactoe plateau[][];
	private Tictactoe playerX = Tictactoe.CROSS;
	private Tictactoe playerO = Tictactoe.CIRCLE;
	private int clique = 0;
	
	public static void main(String[] args) {
		Morpion atchoum = new Morpion();

		/*System.out.println();
		atchoum.addTac(atchoum.current, 0, 0);
		atchoum.Print();*/
		atchoum.Game();
		atchoum.Print1();
		
	}
	
	
	
	public Morpion() {
		this.plateau = new Tictactoe[3][3];
		boolean choice = Math.random() < 0.5;					// Ramdom
		if(choice == true)	this.current = playerO;
		else {
			this.current = playerX;
		}
		System.out.println("le joueur "+  this.current.toString() + " commence.");
	}
	
	public void Game() {
		do{
			int x,y=-1;	
			int siz=plateau.length;		//size of player's deck
			
			do{
				Print();
				System.out.println();
				System.out.println("joueur : "+current.toString());
				System.out.println();
				System.out.print("wich coord in x : ");
				x=Catch(siz);
				System.out.print("wich coord in y : ");
				y=Catch( siz);
			}while(!isEmpty(x,y));
			addTac(current, x ,y);
			System.out.println(this.clique);
		}while(winCondition() == null || !nulRound());
		if(nulRound())	System.out.println("Match nul !!");
		else System.out.println("Le joueur "+ winCondition() + " have won !");
	}
	
	public Tictactoe winCondition() {
		Tictactoe winner = null;		//Nobody win
		if(this.plateau[0][0] == Tictactoe.CIRCLE || this.plateau[0][0] == Tictactoe.CROSS) {
			if((this.plateau[0][1] == this.plateau[0][0] && this.plateau[0][2] == this.plateau[0][0]) 
					|| (this.plateau[1][0] == this.plateau[0][0] && this.plateau[2][0] == this.plateau[0][0]) 
					|| (this.plateau[1][1] == this.plateau[0][0] && this.plateau[2][2] == this.plateau[0][0])) { winner = this.plateau[0][0]; }
	
		}
		if(this.plateau[2][2] == Tictactoe.CIRCLE || this.plateau[2][2] == Tictactoe.CROSS) {
			if((this.plateau[2][1] == this.plateau[2][2] && this.plateau[2][0] == this.plateau[2][2]) 
					|| (this.plateau[0][2] == this.plateau[2][2] && this.plateau[2][2] == this.plateau[1][2]) ) { winner = this.plateau[2][2]; }
	
		}
		if(this.plateau[1][1] == Tictactoe.CIRCLE || this.plateau[1][1] == Tictactoe.CROSS) {
			if((this.plateau[0][1] == this.plateau[1][1] && this.plateau[2][1] == this.plateau[1][1]) 
					|| (this.plateau[1][0] == this.plateau[1][1] && this.plateau[1][1] == this.plateau[1][2]) 
					|| (this.plateau[0][0] == this.plateau[1][1] && this.plateau[2][2] == this.plateau[1][1]) 
					|| (this.plateau[2][0] == this.plateau[1][1] && this.plateau[1][1] == this.plateau[0][2])) { winner = this.plateau[1][1]; }
		}
		return winner;
	}
	
	public boolean nulRound() {
		if( this.clique == 9)	return true;
		return false;
	}
	protected boolean isEmpty(int x , int y) {
		if(this.plateau[x][y] == null)	return true;
		return false;
	}
	
	public void switchPlayer() {
		if(this.current == playerX)	this.current = playerO;
		else this.current = playerX;
	}
	
	public void Print() {
		for (int i = 0; i < plateau.length; i++) {
			for (int j = 0; j < plateau.length; j++) {
				System.out.print("|");
				if(!isEmpty(i, j)) System.out.print( this.plateau[i][j].toString());
				else {
					System.out.print(" ");
				}
			}
			System.out.print("|");
			System.out.println();
		}
	}
	
	public void Print1() {
		for (int i = 0; i < plateau.length; i++) {
			for (int j = 0; j < plateau.length; j++) {
				System.out.print("|");
				System.out.print( i + "," + j);

			}
			System.out.print("|");
			System.out.println();
		}
	}
	
	public boolean addTac(Tictactoe player, int x, int y) {
		if(this.current == player) {
			if(this.plateau[x][y] == Tictactoe.CIRCLE || this.plateau[x][y] == Tictactoe.CROSS)	return false;
			this.plateau[x][y] = player;
			this.switchPlayer();
			this.clique += 1;
			return true;
		}
		return false;
	}
	
	public final static Morpion getInstance()
	{
		if(Morpion.instance == null)
		{
			synchronized(Morpion.class)
			{
				if(Morpion.instance == null)
				{
					Morpion.instance = new Morpion();
				}
			}
		}
		return Morpion.instance;
	}
	
	public Tictactoe Current() {
		return this.current;
	}

	@SuppressWarnings("resource")
	public int Catch(int max) {
    	Scanner sc = new Scanner(System.in);
    	boolean flag = false;
    	int tmp = -1;
    	do {
    		try {
    			tmp = sc.nextInt();
    			if(tmp < 0 || tmp > max) { System.out.println("Value out of bound"); }
    			else {
    				flag = true;
    			}
    		}
    		catch(InputMismatchException e){
    			System.out.println("Only integer value !");
    			sc.next();
    		}
    	}while(!flag);
    	
    	return tmp;
	}
}
