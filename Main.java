
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	
	// Shuffles the Board
	static void mixBoard()
	{
		int rows = 4;
		int columns = 4;
		
		char[][] board = new char[rows][columns];
		
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
	
	
	public static void main (String[] args)
	{
		
		System.out.println("Welcome to Boggle!");
		System.out.println("Please type 'yes' to Shuffle the Board and Begin");
		
		Scanner scanner = new Scanner(System.in);
		String decison = scanner.nextLine();
		
		if(decison.equals("yes"))
		{
			mixBoard();
			
		}
		
		System.out.println();
		System.out.println("Type 'START' to begin the timer");
		decison = scanner.nextLine();
		
		
		
		if(decison.equals("START"))
		{
			System.out.println("Time Started!");
			System.out.println("Please use the next 90 seconds, to jot down words using the Boggle Board Letters");
			System.out.println("Words must be at least three letters in length, "
					+ "each letter after the first must be a horizontal, vertical, or diagonal neighbour of the one before it, "
					+ "and no individual letter may be used more than once in a word ");
			try {
				Thread.sleep(180000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Times Up!");
		System.out.println("Please Enter the Words you came up with in all Caps, separated by a space");
		String words = scanner.nextLine();
		ArrayList<String> wordCard = new ArrayList<>(Arrays.asList(words.split(" ")));
		int points = 0;
		for (int i = 0; i < wordCard.size(); i++)
		{
			points = i;
		}
		System.out.println("You've gained " + points + " points! Good Job!");
		scanner.close();

	}

}
