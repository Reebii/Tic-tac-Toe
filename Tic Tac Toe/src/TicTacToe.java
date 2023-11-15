import java.util.*;

public class TicTacToe {
	//Storing the User and C.P.U Inputs
	static ArrayList<Integer> Humanpos = new ArrayList<Integer>();
	static ArrayList<Integer> Cpupos = new ArrayList<Integer>();
	
    //Creating a tic-tac Board
	 public static void main(String[] args) {
		char [][] gameBoard = {{' ','|' ,' ','|', ' ' },
				{'-','+' ,'-','+', '-' },
				{' ','|' ,' ','|', ' ' },
				{'-','+' ,'-','+', '-' },
				{' ','|' ,' ','|', ' ' }};
		
		   PrintGameBoard(gameBoard);
		   
		  //User Input 
		   while(true) {
			   Scanner scan =  new Scanner(System.in);
			   System.out.println("Enter your placement (1-9): ");
			   int pos = scan.nextInt();
			   while(Humanpos.contains(pos) || Cpupos.contains(pos) ) {
				   System.out.println("Position taken! Enter another Position!");
				   pos  = scan.nextInt();
			   }
			   
			   System.out.print(pos);
			   
			   Placepieces(gameBoard, pos, "Human");
			   
			   //Check for the Winner !
			   String res = checkWinner();
			   if(res.length() > 0) {	
				   System.out.println(res);
				   break;
				   }
			   //C.P.U input 
			   Random random  = new Random();
			   int cpuPos = random.nextInt(9)+1;	
			   while(Humanpos.contains(cpuPos) || Cpupos.contains(cpuPos) ) {
				   cpuPos = random.nextInt(9)+1;
			   }
			   
			   Placepieces(gameBoard, cpuPos, "Cpu");
			   System.out.println();
			   PrintGameBoard(gameBoard);
			   
			   //Check for the Winner!!
			   res  = checkWinner();
			   if(res.length() > 0) {	
			   System.out.println(res);
			   break;
			   }
			    
		   }
		 
	 
	}

	 public static void PrintGameBoard(char [][] gameBoard) {
		 for(int i =0;i<gameBoard.length ; i++) {
			  for(int j = 0; j< gameBoard[0].length;j++) {
				  System.out.print(gameBoard[i][j]);
			  }
			  System.out.println();
		  }
		  
	 }
	 
	 public static void Placepieces(char[][] gameBoard , int pos, String user) {
		char sym = 'X';
		if(user.equals("Human")) {
			sym = 'X';
			Humanpos.add(pos);
		}else if(user.equals("Cpu")) {
			sym = 'O';
			Cpupos.add(pos);
		}
		 
		 switch(pos) {
		 case 1: 
			 gameBoard[0][0] = sym;
		     break;
		 case 2:
			 gameBoard[0][2] = sym;
			 break;
		 case 3: 
			 gameBoard[0][4] = sym;
		     break;
		 case 4:
			 gameBoard[2][0] = sym;
			 break;
		 case 5: 
			 gameBoard[2][2] = sym;
		     break;
		 case 6:
			 gameBoard[2][4] = sym;
			 break;
		 case 7: 
			 gameBoard[4][0] = sym;
		     break;
		 case 8: 
			 gameBoard[4][2] = sym;
		     break;
		 case 9:
			 gameBoard[4][4] = sym;
			 break;
         default:
        	 break;

		 }	 
	 }
	 
	 public static String checkWinner() {
		 
		 List topRow = 	Arrays.asList(1,2,3);
		 List midRow = 	Arrays.asList(4,5,6);
		 List botRow = 	Arrays.asList(7,8,9);
		 
		 List topcol = 	Arrays.asList(1,4,7);
		 List midcol = 	Arrays.asList(2,5,8);
		 List botcol= 	Arrays.asList(3,6,9);
		 
		 List Cross1 = 	Arrays.asList(1,5,9);
		 List Cross2 = 	Arrays.asList(3,5,7);
		 
		 
		 
		 List<List> wins = new ArrayList<>();
		 wins.add(topRow);
		 wins.add(midRow);
		 wins.add(botRow);
		 wins.add(topcol);
		 wins.add(midcol);
		 wins.add(botcol);
		 wins.add(Cross1);
		 wins.add(Cross2);
		 
		 for(List l : wins) {
			 if(Humanpos.containsAll(l)) {
				 return "Bravo! Human Kind"; 
			 }else if(Cpupos.containsAll(l)) {
				 return " CPU wins! :>>";
			 }else if(Humanpos.size() + Cpupos.size() == 9){
				 return "Its a Draw !";
			 }
		 }
		 return "";
	 }
	 

}
