
public class Solution {

	public static String run(String startPosition, int rows, int columns) {
		/*
		* Write your code below; return type and arguments should be according to the problem's requirements
		*/
		ChessBoard board = new ChessBoard(8,8);
		board.placePawn(startPosition);
		board.printBoard();
		System.out.println("after moving :");
		String newPosition = board.movePawn(rows,columns);
		board.printBoard();

		
		String endPosition = newPosition;
		return endPosition;
	}
	public static class ChessBoard {
		private int[][] board;
		private int numberOfRows;
		private int numberOFColumns;

		public ChessBoard(int rows, int columns) {
			this.numberOfRows = rows;
			this.numberOFColumns = columns;
			this.board = new int[rows][columns];
		}
		
		public void placePawn(String position) {
			int column = position.charAt(position.length() - 1) - '1';

			int row = Integer.parseInt(position.substring(0,1)) - 1;
			if (row >= 0 && row < numberOfRows && column >= 0 && column < numberOFColumns){
				board[row][column] = 1;
			}
		}
		
		public String movePawn(int rows, int columns) {
			int[][] newBoard = new int[numberOfRows][numberOFColumns];
			int currentrow = 0;
			int currentcolumn = 0;
			outerloop:
			for (int i = 0; i < numberOfRows; i++) {
				for (int j = 0; j < numberOFColumns; j++){
					if (board[i][j] == 1){
						currentrow= i;
						currentcolumn= j;
						break outerloop;
					}
				

					
					
				}
			}
			int newrow = (currentrow+rows) % numberOfRows;
			int newcolumn = (currentcolumn+columns) % numberOFColumns;
			if (newrow < 0) {
				newrow += numberOfRows;	
			}
			if (newcolumn < 0) {
				newcolumn += numberOFColumns;
			}
			newBoard[newrow][newcolumn] = 1;
			board = newBoard;
			return (newrow+1) + "" + (char)('A' + newcolumn);
		}

		public void printBoard(){
			for (int i=0; i < numberOfRows; i++){
				for (int j=0; j < numberOFColumns; j++) {
					System.out.print(board[i][j] + " ");
				}
				System.out.println();

			}
		}
	}
}
