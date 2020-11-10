public class TicTacToeGame {
	public char[] gameBoard;
	
	public void createBoard() {
		gameBoard = new char [10];
		for (int i = 1; i < 11; i++) {
			gameBoard[i-1] = ' ';
		}
		
		System.out.println(gameBoard);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TicTacToeGame tictactoe = new TicTacToeGame();
		tictactoe.createBoard();

	}

}
