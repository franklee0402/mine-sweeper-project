package project;

public class Milestone2 {
	public static void main (String []args) {
		
	char [][] board = new char [5][5];
	board [0][1] = 'B';
	board [1][2] = 'B';
	board [2][2] = 'B';
	board [3][3] = 'B';
	board [2][4] = 'B';
	
	board [0][0] = '1';
	board [1][0] = '1';
	board [2][0] = '0';
	board [3][0] = '0';
	board [4][0] = '0';
	board [1][1] = '3';
	board [2][1] = '2';
	board [3][1] = '1';
	board [4][1] = '0';
	board [0][2] = '2';
	board [3][2] = '2';
	board [4][2] = '1';
	board [0][3] = '0';
	board [1][3] = '3';
	board [2][3] = '4';
	board [4][3] = '1';
	board [0][4] = '0';
	board [1][4] = '1';
	board [3][4] = '2';
	board [4][4] = '1';
	
	boolean[][] revealboard = new boolean [5][5];
	revealboard [0][1] = false;
	revealboard [1][2] = false;
	revealboard [2][2] = false;
	revealboard [3][3] = false;
	revealboard [2][4] = false;
	
	revealboard [0][0] = true;
	revealboard [1][0] = true;
	revealboard [2][0] = true;
	revealboard [3][0] = true;
	revealboard [4][0] = true;
	revealboard [1][1] = true;
	revealboard [2][1] = true;
	revealboard [3][1] = true;
	revealboard [4][1] = true;
	revealboard [0][2] = true;
	revealboard [3][2] = true;
	revealboard [4][2] = true;
	revealboard [0][3] = true;
	revealboard [1][3] = true;
	revealboard [2][3] = true;
	revealboard [4][3] = true;
	revealboard [0][4] = true;
	revealboard [1][4] = true;
	revealboard [3][4] = true;
	revealboard [4][4] = true;
	

	actualboard(board, revealboard);
	
	revealCell(1, 3, revealboard);	
	
	}
	

	public static void actualboard(char[][] board, boolean[][] revealboard) {
		
		for (int row=0; row<board.length; row++) {
			
			for (int col=0; col<board[0].length; col++){
				
				if(revealboard[row][col]==false) {
					
					System.out.print("[ ] ");
				} else if(revealboard[row][col]==true) {
					
					System.out.print(board[row][col] + "  ");
				}
				
		}
			System.out.println();
			
		}
		
		return;
		
		
	}
	
	public static void revealCell(int Row, int Col, boolean[][] revealboard) {
		
		revealboard[Row][Col]=true;
		return;
				
			}
			
		}

