package monopoly;

import javax.swing.JOptionPane;

public class Menus {
	static InputDialog frame;
	static BoardGameBuilder game;
	
	public static void LOG(Object o) {
		System.out.println("[LOG] <" + Thread.currentThread().getStackTrace()[2].getMethodName() + "> " + o.toString());
	}
	
    private static Boolean getYesNoAnswer(String message) {
    	int ans = JOptionPane.showConfirmDialog(frame, message, null, JOptionPane.YES_NO_OPTION);
    	System.out.println("[LOG] " + ((ans == JOptionPane.YES_OPTION)? "True" : "False"));
    	if(ans == JOptionPane.YES_OPTION)
    		return true;
    	return false;
    }
	
    // TODO: maybe check for input correctness
    private static String getNominalAnswer(String message) {
    	String ans = JOptionPane.showInputDialog(frame, message);
    	System.out.println("[LOG] " + ans);
    	return ans;
    }
    
    private static int getAnswerIdx(String message, String title, String [] options){
    	String ans = (String) JOptionPane.showInputDialog(frame, message, title, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
    	System.out.println("[LOG] " + ans);
    	for (int i=0;i<options.length; i++) {
    		if (options[i].equals(ans))
    			return i;
    	}
    	return -1;
    }
    
    private static void menuSettings(){
		Boolean exit = false;
		String s;
		int n;
		String[] options = {
	        	"Set Name",
	        	"Set Description",
	        	"Set Instructions",
	        	"Set Board Size"};
		while (exit == false) {
			int ans = getAnswerIdx("Settings:", "Settings",options);
			switch (ans) {
			case 0: // Set Name
				s = getNominalAnswer("Name:");
				game.setName(s);
				break;
			case 1: // Set Description
				s = getNominalAnswer("Description:");
				game.setDescription(s);
				break;
			case 2: // Set Instructions
				s = getNominalAnswer("Instructions:");
				game.setInstructions(s);
				break;
			case 3: // Set Board Size
				n = Integer.parseInt(getNominalAnswer("Size:"));
				game.setChosenSize(n);
				break;
			default:
				exit = true;
				break;
			}
		}
    }
    
    private static void menuComponents(){
		Boolean exit = false;
		String s1, s2, s3, s4;
		int n;
		Group g;
		String[] options = {
	        	"Add Simple Square (has vlaue)",
	        	"Add Special Square (has action)",
	        	"Delete Square",
	        	"Add Group",
	        	"Delete Group",
	        	"Add Surprise",
	        	"Swap Squares",
	        	"Shuffle Squares",
	        	"Review Squares",
	        	"Export Components",
	        	"Import Components"};
		while (exit == false) {
			int ans = getAnswerIdx("Squares Menu:", "Manage Squares:",options);
			switch (ans) {
			case 0: // Add Simple Square
				s1 = getNominalAnswer("Square Name:");
				s2 = getNominalAnswer("Square Description:");
				s3 = getNominalAnswer("Add to Group? (leave blank for null group)");
				g = game.getGroup(s3);
				n = Integer.parseInt(getNominalAnswer("Value:"));
				game.AddSquare(new SimpleSquare(s1,s2,g,n));
				break;
			case 1: // Add Special Square
				s1 = getNominalAnswer("Square Name:");
				s2 = getNominalAnswer("Square Description:");
				s3 = getNominalAnswer("Add to Group? (leave blank for null group)");
				g = game.getGroup(s3);
				s4 = getNominalAnswer("Action:");
				game.AddSquare(new SpecialSquare(s1,s2,g,s4));
				break;
			case 2: // Delete Square
				s1 = getNominalAnswer("Square Name To Delete:");
				game.deleteSquare(s1);
				break;
			case 3: // Add Group
				s1 = getNominalAnswer("Name:");
				s2 = getNominalAnswer("Color:");
				game.addGroup(new Group(s1, s2));
				break;
			case 4: // Delete Group
				s1 = getNominalAnswer("Group Name To Delete:");
				game.deleteGroup(s1);
				break;
			case 5: // Add Surprise
				s1 = getNominalAnswer("Type:");
				s2 = getNominalAnswer("Content:");
				game.addSurprise(s1, new Surprise(s2));
				break;
			case 6: // Shuffle Squares
				game.shuffleSquares();
				break;
			case 7: // Review Squares
				//game.setInstructions();
				// TODO: implement nice print of all squares (just a list in OptionPane)
				break;
			case 8: // Export Squares
				s1 = getNominalAnswer("Export To File Name:");
				game.exportBoard(s1);
				break;
			case 9: // Import Squares
				s1 = getNominalAnswer("Import From File Name:");
				if (getYesNoAnswer("All your Components will be deleted, Are you sure you wish to continue?"))
					game.importBoard(s1);
				break;
			default:
				exit = true;
				break;
			}
		}
    }
   
    private static void menuPrints(){
		String[] options = {
	        	"Print Board",
	        	"Print All Simple Square Cards",
	        	"Print All Surprise Cards"};
		
		int ans = getAnswerIdx("Settings:", "Settings",options);
		switch (ans) {
		case 0: // Print Board
			game.printBoard();
			break;
		case 1: // Print Simple Square Cards
			//game.printSimpleSquareCards();
			// TODO: implement
			break;
		case 2: // Print All Surprise Cards
			//game.printSurpriseCards();
			// TODO: implement
			break;
		default:
			break;
		}
    }
    
    private static void menuMain(){
    	Boolean exit = false;
		String[] options = {
	        	"Settings",
	        	"Components Management",
	            "Print"};
		while (exit == false) {
			int ans = getAnswerIdx("Choose Menu:", "Main Menu",options);
			switch (ans) {
			case 0: // Settings
				menuSettings();
				break;
			case 1: // Components
				menuComponents();
				break;
			case 2: // Prints
				menuPrints();
				break;
			default:
				exit = true;
				break;
			}
		}
    }
	public static void main(String[] args) {
		game = new BoardGameBuilder();
		frame = new InputDialog();
		menuMain();
		frame.closeIt();
	}

}
