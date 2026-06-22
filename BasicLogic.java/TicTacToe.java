import java.util.Scanner;
public class TicTacToe{

	public static void main (String [] args){

		Scanner input = new Scanner (System.in);

		char [] gameBoard = {'0','1', '2', '3', '4', '5', '6', '7', '8'};

		boardOutput(gameBoard);

		int count = 0;
		int player = 1;
		while (count < 9){
			System.out.printf("Player %d: Enter position %n", player);
			char movePosition = input.next().trim().charAt(0);
			int moveInt = (int) movePosition;
		
			while(validatePresence(gameBoard, movePosition) == false){
				System.out.printf("Player %d: Enter position %n", player);
				movePosition = input.next().trim().charAt(0);
			}
				
			int position = movePosition - '0';
		
			if (player == 1){
				gameBoard[position] = 'X';
				boardOutput(gameBoard);
				if(determineWinner(gameBoard) == true){
					System.out.printf("Player %d Won!%n", player);
					break;
				}
			}
			else{
				gameBoard[position] = 'O';
				boardOutput(gameBoard);
				if(determineWinner(gameBoard) == true){
					System.out.printf("Player %d Won!%n", player);
					break;
				}
			}
			count++;
			if (player == 1){
				player = 2;
			}
			else{
				player = 1;
			}
			if (count == 9 && determineWinner(gameBoard) == false)	{
				System.out.println("Draw!");
			}	

		}


	}
	

	public static boolean validatePresence(char [] board, char letter){

		if ((letterContained(board, letter) == true) && (letter >= '0' && letter <= '8')){

			if ((board[letter - '0'] != 'X') && (board[letter - '0'] != 'O')){
			return true;
			}
		}
		return false;
	}

	public static boolean letterContained(char [] board, char letter){

		for (char character : board){
			if (character == letter){
				return true;
			}
		}
		return false;
	}

	public static boolean determineWinner(char [] board){
		if (board[2] == board[4] && board[2] == board[6]){
			return true;
		}
		else if (board[0] == board[3] && board[3] == board[6]){
			return true;
		}
		else if (board[1] == board[4] && board[4] == board[7]){
			return true;
		}
		else if (board[2] == board[5] && board[5] == board[8]){
			return true;
		}
		else if (board[0] == board[1] && board[1] == board[2]){
			return true;
		}
		else if (board[3] == board[4] && board[4] == board[5]){
			return true;
		}
		else if (board[0] == board[4] && board[4] == board[8]){
			return true;
		}
		else if (board[6] == board[7] && board[7] == board[8]) {
			return true;
		}
		else{
			return false;
		}

	}

	public static void boardOutput(char [] board){

		System.out.printf("""
________________________________________________
|		|		|		|
|	%s	|	%s	|	%s	|
|________________________________________________
|		|		|		|
|	%s	|	%s	|	%s	|
|________________________________________________
|		|		|		|
|	%s	|	%s	|	%s	|
-------------------------------------------------

""", board[0], board[1], board[2], board[3], board[4], board[5], board[6], board[7], board[8]);
	}

}