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
		// default values:
		// size: 4
	}
	public void setChosenSize(int size) {
		// check if size is multiplication of 4
	}
	public void AddGroup() {
		
	}
	public void deleteGroup(String name) {
		
	}
	public void AddSquare() {
		
	}
	public void deleteSquare(String name) {
		
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
	// UI interacts
	
}
