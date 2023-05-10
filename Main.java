
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	
	// function to determine whether a word is valid
	public boolean isValidWord(String word, char[][] board) {
	    int n = board.length;
	    boolean[][] visited = new boolean[n][n];
	    for (int i = 0; i < n; i++) {
	        for (int j = 0; j < n; j++) {
	            if (board[i][j] == word.charAt(0)) {
	                if (dfs(word, board, visited, i, j, 0)) {
	                    return true;
	                }
	            }
	        }
	    }
	    return false;
	}
	
	// use of depth-first-search algorithm to track boggle letter traversal for word construction
	private boolean dfs(String word, char[][] board, boolean[][] visited, int i, int j, int index) {
	    if (index == word.length()) {
	        return true;
	    }
	    if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(index)) {
	        return false;
	    }
	    visited[i][j] = true;
	    boolean res = dfs(word, board, visited, i - 1, j, index + 1)
	            || dfs(word, board, visited, i + 1, j, index + 1)
	            || dfs(word, board, visited, i, j - 1, index + 1)
	            || dfs(word, board, visited, i, j + 1, index + 1);
	    visited[i][j] = false;
	    return res;
	}
	

	
	public static void main (String[] args)
	{
		
		// 4x4 Character Array and Welcome Messages
		int rows = 4;
		int columns = 4;
		
		char[][] board = new char[rows][columns];
		
		System.out.println("Welcome to Boggle!");
		System.out.println("Please type 'yes' to Shuffle the Board and Begin");
		
		// Accept User Input
		Scanner scanner = new Scanner(System.in);
		String decison = scanner.nextLine();
		
		// Fills, Shuffles, and Displays Boggle Board
		if(decison.equals("yes"))
		{

			
			System.out.println();
			System.out.println("Shuffling......");
			System.out.println();
			
			for (int i = 0; i < rows; i++)
			{
				for (int j=0; j < columns; j++)
				{
					// to create a random character
					Random r = new Random();
					char letters = (char)(r.nextInt(26) + 'A');
					board[i][j] = letters;
				}
			}
			
			System.out.println("The Boggle Letters Are: ");
			for (int i = 0; i < rows; i++)
			{
				for (int j=0; j < columns; j++)
				{
					System.out.print(board[i][j] + "  ");
				}
				System.out.println();
			}
			
		}
		
		System.out.println();
		System.out.println("Type 'START' to begin the timer");
		decison = scanner.nextLine();
		
		
		// Once started, waits 3 Minutes, like in Boggle, until user comes up with answers
		if(decison.equals("START"))
		{
			System.out.println("Time Started!");
			System.out.println("Please use the next 90 seconds, to jot down words using the Boggle Board Letters");
			System.out.println("Words must be at least three letters in length, "
					+ "\n each letter after the first must be a horizontal, vertical, or diagonal neighbour of the one before it,"
					+ "\n sand no individual letter may be used more than once in a word ");
			try {
				Thread.sleep(180000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// Array List of users Inputed words and Point initialization
		System.out.println("Times Up!");
		System.out.println("Please Enter the Words you came up with in all Caps, separated by a space");
		String words = scanner.nextLine();
		ArrayList<String> wordCard = new ArrayList<>(Arrays.asList(words.split(" ")));
		int points = 0;
		Main solver = new Main();
		
		// checks if words are valid
		for (String word: wordCard)
		{
			boolean isValid = solver.isValidWord(word, board);
	        if (isValid) {
	            points++;
	            System.out.println("Found valid word: " + word);
	        } else {
	            System.out.println("Invalid word: " + word);
	        }
	    }
	    System.out.println("Congrats! You've Earned: " + points + " points! ");
	    System.out.println("Rerun the program to play again, Goodbye!");
		
		scanner.close();

	}

}
