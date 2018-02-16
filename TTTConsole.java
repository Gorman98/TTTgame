import java.util.Scanner;

public class TTTConsole  {

	public static Scanner in = new Scanner(System.in); // the input Scanner

	public static TicTacToe TTTboard = new TicTacToe();
	/** The entry main method (the program starts here) */
	public static void main(String[] args) {

		int currentState = TicTacToe.PLAYING;
		String userInput;
		TTTboard.printBoard();
		//game loop
		do {
			// Print message if game-over
			/**
			 * get player input here and call setMove(). user should input a number between 0-8
			 */
			userInput = in.nextLine();
			//checks if the user input a correct input
			if(userInput.hashCode() == "0".hashCode() 
					|| userInput.hashCode() == "1".hashCode()
					|| userInput.hashCode() == "2".hashCode()
					|| userInput.hashCode() == "3".hashCode()
					|| userInput.hashCode() == "4".hashCode()
					|| userInput.hashCode() == "5".hashCode()
					|| userInput.hashCode() == "6".hashCode()
					|| userInput.hashCode() == "7".hashCode()
					|| userInput.hashCode() == "8".hashCode()) {
				if(TTTboard.isEmpty(Character.getNumericValue(userInput.charAt(0)))) {
					TTTboard.setMove(1, Character.getNumericValue(userInput.charAt(0)));
					TTTboard.setMove(2, TTTboard.getComputerMove());
					TTTboard.printBoard();
					currentState = TTTboard.checkForWinner(); 
				} else {
					System.out.println("That move was taken");
				}

					//doesn't do anything if the user entered /q
			} else if(userInput.hashCode() == "q".hashCode()) {

				//tells the user their value was not a proper input
			} else {
				System.out.println("Please input a value between 0 and 8");
			}
			if (currentState == ITicTacToe.CROSS_WON) {
				System.out.println("'X' won! Bye!");
			} else if (currentState == ITicTacToe.NOUGHT_WON) {
				System.out.println("'O' won! Bye!");
			} else if (currentState == ITicTacToe.TIE) {
				System.out.println("It's a TIE! Bye!");
			}
			//user can break the loop. remove this line when you finish implementation.
		} while ((currentState == ITicTacToe.PLAYING) && (!userInput.equals("q")));
	} 
}