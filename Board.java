public class Board {
	
	int H,//the height and width of the board.
		W,
		row,
		col,
		rand,
		mines = 0;
	char board [][],
		Answer [][];
	boolean revealed [][],// boolean array default is false.
			isFlagged [][];
		
	public MsGUI gui; //this is a field needed to be able to call win/lose
	
	public Board(int x,int y){//contructor
		this.H = x;
		this.W = y;
		this.Answer = new char [H][W];
		this.board = new char [H][W];
		this.isFlagged = new boolean [H][W];
		this.revealed = new boolean [H][W];
		this.isFlagged = new boolean [H][W];
		
		//fill up the random mines.
		for (int i = 0; i < Answer.length ; i ++){
			for(int j = 0; j< Answer[i].length ; j++){
				rand = (int)(Math.random()*50+1);
				if(rand > 40 && rand <=50){
					mines ++;
					Answer[i][j] = 'b';
				}else{				
					Answer[i][j] = '-';
				}
			}
		}
		System.out.println("numbers of mines  "+mines);
		
		//print out the answer board 
		for (int i = 0; i < Answer.length ; i ++){
			for(int j = 0; j< Answer[i].length ; j++){
				System.out.print(Answer[i][j]+ " ");
			}
				System.out.println();
		}
	}
		
	public void flagCell(int row, int col){
		if(row >=0 && row <H && col >=0 && col < W){
			if(revealed[row][col]== false){
				isFlagged[row][col] = true;
			}
		}
	}
	public boolean isFlagged(int row, int col){	
		return isFlagged[row][col];
	}
	public int getHeight(){
		return board.length;
	}
	public int getWidth(){
		return board[0].length;
	}
	public char getValue(int row, int col) {//checking the surrounding mines		
		if(row < H && row >= 0 && col < W && col >= 0){
			if(Answer[row][col] != 'b' && isFlagged[row][col] == false){ //check if it's not a bomb and it's been flagged.
					char bombCount = '0';
			        // Count bombs in surrounding cells
			        for(int r = -1; r <= 1; r++){
			                for(int c = -1; c <= 1; c++){
			                        int newx = row + r;
			                        int newy = col + c;
			                        if(newx < H && newx >= 0 && newy < W && newy >= 0){//check if it's out of bound
			                                if(Answer[newx][newy] == 'b'){// if it's bomb
			                                        bombCount++;
			                                }
			                        }
			                }
			        }
			        
			        Answer[row][col] = bombCount;
			        if (revealed[row][col] == true){
			        	if(Answer[row][col] == '0'){
			        		Answer[row][col] = ' ';
			        		return Answer[row][col];
			        	}else{
			        		return Answer[row][col];
			        	}
			        }else{
			        	return '-';
			        }
			}else if(isFlagged[row][col] ==true){
				return 'F';
			}else{
				return '-';
			}
		}else{
			return '-';
		}
	}
	public void revealCell(int row, int col){// recursively revealing cells.
		if (row >= 0 && col >= 0 && row < H && col < W){
			
			int winCounter = 1;
			for(int i = 0 ; i < Answer.length ; i++){
				for(int j = 0 ; j < Answer[i].length ; j++){
					if(revealed[i][j] == true){
						winCounter++;
					}
				}
			}if(((H*W)-winCounter) == mines){
				gui.win("You win!!");
				System.exit(0);
				return;
			}			
			//System.out.print(",hwcounter "+((H*W)-winCounter));
			//System.out.println("counter "+winCounter);
			
			
			if(Answer[row][col] =='b' && revealed[row][col] == false && isFlagged [row][col] == false){	 
				revealed[row][col] = true;
				gui.lose( "Learn to play, PLEASE!");
				System.exit(0);
				return;
			}else if (Answer[row][col] != '0' && revealed[row][col] == false && isFlagged[row][col] == false){						
				revealed[row][col] = true;
				return;				
			}else if (Answer[row][col] == '0' && revealed[row][col] == false && isFlagged[row][col] == false){
				revealed[row][col] = true;
				revealCell(row-1,col);//left
				revealCell(row+1,col);//right
				revealCell(row,col+1);//up
				revealCell(row,col-1);//down
				revealCell(row-1,col+1);//up-left
				revealCell(row+1,col+1);//up-right
				revealCell(row-1,col+1);//down-right
				revealCell(row+1,col-1);//down-left
				getValue(row,col);
				getValue(row,col);
				
			}else{
				return;
			}
		}		
	}
	public void unflagCell(int row, int col){
		if (row >= 0 && row < H && col >= 0 && col < W){
			isFlagged[row][col] = false;
		}
	}
	
}
