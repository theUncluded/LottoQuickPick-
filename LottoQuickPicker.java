/**
 * LAB 3 -  Lotto QuickPicker Game 
 */
package src.edu.cuny.csi.csc330.lab3;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import edu.cuny.csi.csc330.util.Randomizer;

public class LottoQuickPicker {
	
	// constants  specific to current game - BUT NOT ALL GAMES 
	public final static int DEFAULT_GAME_COUNT = 1; 
	private final static String GAME_NAME = "Lotto"; 
	private final static int SELECTION_POOL_SIZE = 26; 
	private final static int SELECTION_COUNT = 1; 


	public LottoQuickPicker() {
		init(DEFAULT_GAME_COUNT); 
	}
	
	public LottoQuickPicker(int games) {
		init(games); 
	}
  

	private void init(int games) {
		}

	
	public void displayTicket(int games) {
	
		displayHeading(); 
		
		
		int gameItsOn=0;
		for(int i=0;i<SELECTION_COUNT*games;i++) {
				
			if(i%SELECTION_COUNT==0) {
				gameItsOn++;
				System.out.printf("\n( %d)  ",gameItsOn);
			}
				
			System.out.printf("%02d  ",Randomizer.generateInt(1,SELECTION_POOL_SIZE));
		}
		
		displayFooter(); 
		
		return;
	}
	
	protected void displayHeading() {
	LocalDateTime ld = LocalDateTime.now();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
	String formattedDateTime = ld.format(formatter);
	 System.out.printf("-----------------------------\n----------- %s -----------\n    %s\n", GAME_NAME,formattedDateTime);
	}
	
	protected void displayFooter() {
		 System.out.printf("\n\n------ (c) Rich's Deli ------\n-----------------------------\n");
	}
	
	public static void main(String[] args) {
		// takes an optional command line parameter specifying number of QP games to be generated
		//  By default, generate 1  
		int numberOfGames  = DEFAULT_GAME_COUNT; 
		
		if(args.length > 0) {  // if user provided an arg, assume it to be a game count
			numberOfGames = Integer.parseInt(args[0]);  // [0] is the 1st element!
		}
		
		LottoQuickPicker lotto = new LottoQuickPicker(numberOfGames);
		
		lotto.displayTicket(numberOfGames); 
	}

}
