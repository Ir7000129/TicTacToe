package game;

import java.util.Random;
import java.util.Scanner;

public class TTT {

	private static char [][] board = {{' ','|',' ', '|', ' '},
									{'-','+','-', '+', '-'},
									{' ','|',' ', '|', ' '},
									{'-','+','-', '+', '-'},
									{' ','|',' ', '|', ' '}
															};	
	public static void main(String[] args) {
		printBoard();
		
		System.out.println("Enter");
		var scanner = new Scanner(System.in);
		int playerPos = scanner.nextInt();
		
		readInput(board, playerPos, "player");
		
		var rand = new Random();
		int cpuPos = rand.nextInt(9) + 1;
		
		readInput(board, cpuPos, "cpu");
		
		printBoard();
	}

	
	public void initializeBoard() {
		for(int i=0; i < 3; i++) {
			for(int j=0; j < 3; j++) {
				board[i][j] = '-';			
			}
		}
	}
	
	public static void printBoard() {
		System.out.println("-------------");
		for(char[] row: board) {
			for(char c: row) {
				System.out.print(c);
			}
			System.out.println();
		}
		System.out.println("-------------");
	}
	
	public static void readInput(char[][] board, int pos, String user) {
		char symbol ='X';
		
		if(user.equals("player")) {
			symbol = 'X';
		}else if (user.equals("cpu")){
			symbol ='O';		}
		switch (pos) {
		case 1:
			board[0][0] = symbol;
			break;
		case 2:
			board[0][2] = symbol;
			break;
		case 3:
			board[0][4] = symbol;
			break;
		case 4:
			board[2][0] = symbol;
			break;
		case 5:
			board[2][2] = symbol;
			break;
		case 6:
			board[2][4] = symbol;
			break;
		case 7:
			board[4][0] = symbol;
			break;
		case 8:
			board[4][2] = symbol;
			break;
		case 9:
			board[2][4] = symbol;
			break;
		default:
			break;
		}
	}
}
