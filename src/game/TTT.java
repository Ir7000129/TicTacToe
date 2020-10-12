package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TTT {
	static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
	static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();
	
	private static char [][] board = {{' ','|',' ', '|', ' '},
									{'-','+','-', '+', '-'},
									{' ','|',' ', '|', ' '},
									{'-','+','-', '+', '-'},
									{' ','|',' ', '|', ' '}
															};	
	public static void main(String[] args) {
		printBoard();
		
		while (true) {
			System.out.println("Enter");
			var scanner = new Scanner(System.in);
			int playerPos = scanner.nextInt();
			while(playerPositions.contains(playerPos) || cpuPositions.contains(playerPositions)) {
				System.out.println("Position Taken!");
				playerPos = scanner.nextInt();
			}
			
			readInput(board, playerPos, "player");
			
			var rand = new Random();
			int cpuPos = rand.nextInt(9) + 1;
			while(playerPositions.contains(cpuPos) || cpuPositions.contains(cpuPos)) {
				cpuPos = rand.nextInt(9) + 1;
			}
			readInput(board, cpuPos, "cpu");			
			printBoard();
			String result = checkWinner();
			System.out.println(result);
			
			if (checkWinner().equals("You Won!") || checkWinner().equals("You Lost!") || checkWinner().equals("Tie!")) {
				System.out.println("Game Over");
				break;
			} else continue;
		}
	
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
			playerPositions.add(pos);
		}else if (user.equals("cpu")){
			symbol ='O';
			cpuPositions.add(pos);
			}
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
			board[4][4] = symbol;
			break;
		default:
			break;
		}
	}
	
	public static String checkWinner() {
		
		List topRow = Arrays.asList(1, 2, 3);
		List midRow = Arrays.asList(4, 5, 6);
		List botRow = Arrays.asList(7, 8, 9);
		List leftCol= Arrays.asList(1, 4, 7);
		List midCol = Arrays.asList(2, 5, 8);
		List rightCol = Arrays.asList(3, 6, 9);
		List diagonal1 = Arrays.asList(1, 5, 9);
		List diagonal2 = Arrays.asList(3, 5, 7);
		
		List<List> winning = new ArrayList<List>();
		winning.add(topRow);
		winning.add(midRow);
		winning.add(botRow);
		winning.add(leftCol);
		winning.add(midCol);
		winning.add(rightCol);
		winning.add(diagonal1);
		winning.add(diagonal2);
		
		for(List l: winning) {
			if(playerPositions.containsAll(l)) {
				return "You Won!";
//				System.out.println("You Won!");
			} else if (cpuPositions.containsAll(l)) {
				return "You Lost!";
//				System.out.println("You Lost!");
			} else if(playerPositions.size() + cpuPositions.size() == 9) {
				return "Tie";
//				System.out.println("Tie");
			}
		}
		
		return "";
	}
}
