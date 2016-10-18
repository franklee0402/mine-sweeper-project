package project;
/*1. see the menu selection.
 *2. F=flag, B=bomb, digits 0-9 representing how many bombs in the vicinity. 
 *3. win the game by detect all the existing bomb in the map.
 *4. lose when click on the bomb.
 *5. it's a text base(no graph involved)
 *6. input: coordinate.
 *7. output: blank, digits(number of bomb around), flag
 *8. error condition: */
public class Minesweeper {
	
	public static void main(String []args){
		
		//initialize variables.
		int sizeX = 0,
			sizeY = 0,
			menuSelection = 0,
			x = 0,
			y = 0,
			counter = 0,
			win =0;
		
		
		boolean lose = false;
		char [][] actual = {{'0','1','2','b','1'},
							{'1','2','b','2','1'},
							{'1','b','2','1','0'},
							{'1','1','1','0','0'},
							{'0','0','0','0','0'}};
		char [][] grid= {{'-','-','-','-','-'},
						 {'-','-','-','-','-'},
						 {'-','-','-','-','-'},
						 {'-','-','-','-','-'},
						 {'-','-','-','-','-'}};
		boolean [][] revealedyet = new boolean [5][5];//flase boolean array   
		for (int row = 0;row < revealedyet.length; row++){//finished revealing and print out the board.
			for (int column=0;column < revealedyet[row].length;column++){
				revealedyet [row][column]= false;
			}
		}//declare three arrays.
		
		
		for (int end = 0; menuSelection !=-1 ; end ++){
			System.out.println("Enter -1 to end, other numbers to start!");// menu selection to choose difficulty.
			menuSelection = IO.readInt();
			if (menuSelection == -1 ){
				break;
			}
				sizeX = 5; //change it for random and difficulty.
				sizeY = 5;
				System.out.println(sizeX+"*"+sizeY+" table:");//what user would see.
				
				//char [][] grid = new char [sizeX][sizeY];
				printBoard(grid);
		
			while( menuSelection != -1 ||lose == true || counter == 20){
				
				System.out.println("Which coordinate would you like to reveal?");
				System.out.println("row:");
				x = IO.readInt();
				while (x >= grid.length || x < 0){
					System.out.println("User enters bad input, enter row:");
					x = IO.readInt();
				}
				System.out.println("column:");
				y = IO.readInt();
				while(y >= grid[0].length || y< 0){
					System.out.println("User enters bad input, enter row:");
					y = IO.readInt();
				}
				
				revealCell( actual,grid,x,y, revealedyet);
				printBoard(grid);
				counter ++;
								
				if (grid[x][y] == 'b'){
					lose = true;
					System.out.println("noob! you lost");
					return;
				}
				//winning check.
				win = 0;
				for (int row = 0;row < grid.length; row++){
					for (int column=0;column < grid[row].length;column++){
						if(revealedyet[row][column] == true){
							win++;
							if(win == 22){//25 cells total minus 3 bombs. 
								System.out.println("I can't believe you win!!");
								return;
							}
						}
					}	
				}		
			}
			
			
		}
	}
	//to print out the board.
	public static void printBoard(char [][]ss ){
		
		
		for (int row = 0;row < ss.length; row++){
			for (int column=0;column < ss[row].length;column++){
				System.out.print(ss[row][column] +" "); 
			}
			System.out.println();
		}		
	}
	
	public static void revealCell(char[][]play, char [][]reveal, int x, int y, boolean[][] revealedyet){
		/* The recursive routine to uncover mineField
		   * Base cases:
		   *   cell position is out of grid bounds
		   *   cell hides a mine
		   *   cell holds a clue
		   *   cell is empty but has been uncovered
		   * Recursive case:
		   *   cell is empty and has not been revealed */
		if (x >= 0 && y >= 0 && x <= 4 && y <= 4){
			
			if(play[x][y] =='b' && revealedyet[x][y] == false){	 
				reveal[x][y] =play[x][y];
				revealedyet[x][y] = true;
				return;
			}else if (play[x][y] != '0' && revealedyet[x][y] == false){				
				reveal[x][y] =play[x][y];
				revealedyet[x][y] = true;
				return;				
			}else if (play[x][y] == '0' && revealedyet[x][y] == false){
				revealedyet[x][y] = true;
				revealCell(play,reveal,x-1,y,revealedyet);//left
				revealCell(play,reveal,x+1,y,revealedyet);//right
				revealCell(play,reveal,x,y+1,revealedyet);//up
				revealCell(play,reveal,x,y-1,revealedyet);//down
				revealCell(play,reveal,x-1,y+1,revealedyet);//up-left
				revealCell(play,reveal,x+1,y+1,revealedyet);//up-right
				revealCell(play,reveal,x-1,y+1,revealedyet);//down-right
				revealCell(play,reveal,x+1,y-1,revealedyet);//down-left
				reveal[x][y] = play[x][y];
				
			}
			
		}
		
		
	}
	
	
}
/**
 *		int x = 100;
 *		random numbers
 *		Random r = new Random();
 *		randomInt = randomGenerator.nextInt(x);
 *		this will create a random number between 1 and 100.
 * 
 *
 */
 