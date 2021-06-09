package monopoly;

import java.util.ArrayList;
import java.util.HashMap;

// Coding style:
// Classes: 			ClassName
// Objects/variables: 	object_name
// Functions:			functionName
public class BoardGameBuilder {
	String name;
	String description;
	String instructions;
	int chosen_size;
	ArrayList<Square> board;
	HashMap<String,ArrayList<Surprise>> surprise_cards;
	ArrayList<Group> groups;
	
	public BoardGameBuilder() {
		name = "Monopoly";
		description = "A wonderful game!";
		instructions = 	"a. Roll the dice/n" +
						"b. Move according to dice";
		chosen_size = 4;
		board = new ArrayList<Square>();
		surprise_cards = new HashMap<String,ArrayList<Surprise>>();
		groups = new ArrayList<Group>();
	}
	public void setChosenSize(int size) {
		if (size%4 ==0)
			chosen_size=size;
		else
			System.out.println("[ERROR] Size should be divisble by 4");
	}
	public void setName(String name) {
		
	}
	public void setDescription(String description) {
		
	}
	public void setInstructions(String instructions) {
		
	}
	public void AddGroup(Group g) {
		
	}
	public void deleteGroup(String name) {
		
	}
	public void AddSquare(Square s) {
		
	}
	public void deleteSquare(String name) {
		
	}
	public void deleteSquare(Square s1, Square s2) {
		
	}
	public void printAllSquares() {
		
	}
	public void exportBoard(String filename) {
		
	}
	public void importBoard(String filename) {
		// let the player know current board will be deleted
	}
	public void printBoard() {
		// Squares will be printed by order and according to chosen_size
		// TODO: check we have enough squares before start printing
	}
	public Square findSquareByName(String name) {
		
	}
	public void printSquareByName(String name) {
		// using find square..
	}
	public void shuffleSquares() {
		
	}
	public void addSurprise(Surprise s) {
		
	}
	// UI wrappers
	
}
