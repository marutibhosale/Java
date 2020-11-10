import java.util.ArrayList;
import java.util.Scanner;

public class TicTacToeGame {
	public char[][] gameBoard;
	static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
	
	public void createBoard() {
		gameBoard = new char [5][5];
		
        for ( int i=1; i<6; i++){
            for (int j=1; j<6; j++){
                if (i%2!=0 && j%2!=0){
                    gameBoard[i-1][j-1]=' ';
                }else if (i%2!=0 && j%2==0){
                     gameBoard[i-1][j-1]='|';
                }else if (i%2==0 && j%2!=0){
                     gameBoard[i-1][j-1]='-';
                }else if (i%2==0 && j%2==0){
                     gameBoard[i-1][j-1]='+';
                }

             }
        }			
	}	
	
	public String chooseLetter() {
		Scanner input = new Scanner(System.in);
        System.out.println("choose between X and 0:");
        String symbol  = input.next();
        if (symbol.equalsIgnoreCase("x") || symbol.equalsIgnoreCase("o")) { 
        	return symbol.toUpperCase();
        }else {
        	System.out.println("Invalid choice");
        	symbol="";
        	this.chooseLetter();
        	return "";
        }
	}
	
	public void displayBoard() {
		 for (char[] row :gameBoard){
             System.out.println(row);
       }
	}
   
	public int  selectPos() {
		 Scanner input = new Scanner(System.in);
         System.out.println("Enter your placement (1-9):");
         int playerPos = input.nextInt();
         
         if (( playerPos > 9 || playerPos < 1 )) {
        	 System.out.println("Enter number is not in range");
        	 this.selectPos();
         }
         if ((playerPositions.contains(playerPos))){
        	 System.out.println("Position already taken! :");
        	 this.selectPos();
         }
         playerPositions.add(playerPos);
         return playerPos;
         
        		
	}
	
	public void movePos(char player) {
		
		 int pos = this.selectPos();
		 
		 switch(pos) {
         case 1:
               gameBoard[0][0] = player;
               break;
         case 2:
               gameBoard[0][2] = player;
               break;
         case 3:
               gameBoard[0][4] = player;
               break;
         case 4:
               gameBoard[2][0] = player;
               break;
         case 5:
               gameBoard[2][2] = player;
               break;
         case 6:
               gameBoard[2][4] = player;
               break;
         case 7:
               gameBoard[4][0] = player;
               break;
         case 8:
               gameBoard[4][2] = player;
               break;
         case 9:
               gameBoard[4][4] = player;
               break;
             default:
                     break;
         }

		
	}
	
	public static void main(String[] args) {
		TicTacToeGame tictactoe = new TicTacToeGame();
		tictactoe.createBoard();
		//String letter =tictactoe.chooseLetter();
		//System.out.println(letter);
		tictactoe.displayBoard();
		//tictactoe.selectLoc();
		//tictactoe.moveLoc();
		//String p = tictactoe.chooseLetter();
		//char player = p.charAt(0);
		while ( playerPositions.size() < 9) {
			String p = tictactoe.chooseLetter();
			char player = p.charAt(0);
			 tictactoe.movePos(player);
			 tictactoe.displayBoard();
		}
	}

}
