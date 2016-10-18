package project;

public class Milestone6 {
	public static void main(String []args){
		int difficulty = 0,
			x = 0,
			y = 0;	
		System.out.println("Choose the difficulty(easy(1), medium(2), hard(3), custom(4))");
		System.out.println("Enter other numbers to end the game.");
		difficulty = IO.readInt();
		if(difficulty == 1){
			System.out.println("You chose (1)Easy");
			x = 5;
			y = 5;
		}else if(difficulty == 2){
			System.out.println("You chose (2)Medium");
			x = 10;
			y = 10;
		}else if (difficulty == 3){
			System.out.println("You chose (3)Hard");
			x = 15;
			y = 15;
		}else if (difficulty == 4){
			System.out.println("You chose (4)Custom");
			System.out.println("Enter the board size");
			x = IO.readInt();
			y = IO.readInt();
		}else{
			System.exit(0);
		}
		
			
		
		Board b = new Board(x,y);
		b.gui = new MsGUI(b);
		b.gui.setVisible(true);
		
	}
}
