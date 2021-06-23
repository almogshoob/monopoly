package monopoly;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;

// TODO:
// 1. Omer: add shuffleCards to menu	
//	  Omer: add printAllCards and PrintAllSquares() to menu. - NOTICE: we made printAllCards instead of printSimplSuareCards/printSurpriseCard.. (we change)
//	  Omer: please limit the user input of square name and group name to 15 chars. 	
//    (OPTIONAL) print singel card by calling square/cars.printCard() --> due to use of JOptionPane we didnt use polimorphism so much... :\  
//	  (OPTIONAL) Omer : Smile

// 5. Yair: implement printSimpleSquareCards and printSurpriseCards by iterating all relevant cards and using Cardable.printCard. Print to JOptionPane
// 6. Think and try edge cases

// Coding style:
// Classes: 			ClassName
// Objects/variables: 	object_name
// Functions:			functionName

public class BoardGameBuilder {
	String name;
	String description;
	String instructions;
	int chosen_size;
	ArrayList<Group> groups;
	ArrayList<Square> board;
	HashMap<String,ArrayList<Surprise>> surprise_cards;
	
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
		if (size%4 ==0) {
			chosen_size=size;
			LOG(chosen_size);
		}
		else
			System.out.println("[ERROR] Size should be divisble by 4");
		
	}
	
	public void setName(String name) {
		this.name=name;
		LOG(name);
	}
	
	public void setDescription(String description) {
		this.description=description;
		LOG(description);
	}
	
	public void setInstructions(String instructions) {
		this.instructions=instructions;
		LOG(instructions);
	}
	
	public Group getGroup(String name) {
		for (Group g: this.groups)
			if (g.getName() == name) { // each group has a unique name
				LOG(g);
				return g;
			}
		return null;
	}
	
	public int addGroup(Group g) {
		if (this.groups.contains(g)) // contain = by name
			return -1;
		this.groups.add(g);
		LOG(g);
		return 0;
	}
	
	public int deleteGroup(String name) {
		Group to_delete = getGroup(name);
		if (to_delete == null) // no such group
			return -1;
		for (Square s: this.board) // update squares which point to this group
			if (s.getGroup() == to_delete)
				s.setGroup(null);
		this.groups.remove(to_delete);
		LOG(to_delete);
		return 0;
	}
	
	public int SetGroup(String old_name, String new_name, String new_color) {
		if (this.groups.contains(new Group(new_name, new_color)) && old_name != new_name)
			return -1; // name already exist
		Group g = this.getGroup(old_name);
		if (g == null) // no such group
			return -1;
		g.setName(new_name);
		g.setColor(new_color);
		LOG(g);
		return 0;
	}
	
	public void AddSquare(Square s) {	
		board.add(s);
		LOG(s);
	}
	
	public int deleteSquare(String name) {
		Square s = getSquareByName(name);
		if (s == null)
			return -1;
		board.remove(s);
		LOG(s);
		return 0;
	}
	
	public int swapSquare(Square s1, Square s2) {
		if (!( board.contains(s2) && board.contains(s1) ))
			return -1;	
		Collections.swap(board, board.indexOf(s1), board.indexOf(s2)); //do the same :(
		return 0;
	}
	
	public void shuffleSquares() {
		Collections.shuffle(this.board);
	}

	public void shuffleCards() {
		Iterator it = surprise_cards.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        Collections.shuffle((List<?>) pair.getValue());
	    }
		
	}
	
	public void PrintAllCards() {
		int hight = 0; //height of dialog box
		int max_width = 0;  //width of dialog box
		String old_output; 
		String output = ""; //holding the string to be send to JOptionPane
		ArrayList<Cardable> card_array;
		Iterator it = surprise_cards.entrySet().iterator(); //iterating the HashMap
	    while (it.hasNext()) { //IF NOT EMPTY 
	        Map.Entry pair = (Map.Entry)it.next(); 
	        card_array = (ArrayList<Cardable>) pair.getValue(); //holding the array with cards.
	        output += "\nCards of: " + pair.getKey()+"\n"; 
			for(int i = 0; i < card_array.size() ; i++){
				old_output = output; //SAVING OLD LENGTH
				output += "Card number " + (i+1) + ". "+ card_array.get(i).toString() + "\n";
				if ( (output.length() - old_output.length() ) > max_width ) //if current length is longer, increase max_width. 
					max_width = output.length() - old_output.length();
			}
			hight += card_array.size(); //increase height.			        
	    }
	    
	    output += "\n\nSquare Cards: \n";	    
	    for (Square s : this.board) { //taking care of SimpleSquares.
	    	if (s instanceof SimpleSquare) { 
	    		 old_output = output;
	    		
	    		 output += s.toString() + "\n";	    
	    		 if ( (output.length() - old_output.length() ) > max_width ) 
						max_width = output.length() - old_output.length();
	    		 hight++;
	    	}
	    }
	    max_width += 150;
	           
	    UIManager.put("OptionPane.minimumSize",new Dimension(max_width ,hight));  //PRINT WITH JOptionPane
	    JOptionPane.showMessageDialog(null, output, "Cards list", JOptionPane.PLAIN_MESSAGE);		
	}
		
	public void printAllSquares() {
		int hight = 0; // high of dialog box
		int max_width = 0;  //width of dialog box
		String old_output; 
		String output = ""; //holding the string to be send to JOptionPane
		output += "List of all Squares: \n";	    
		for (Square s : this.board) { //taking care of SimpleSquares.
	    		 old_output = output;
	    		 output += s.toString() + "\n";	    
	    		 if ( (output.length() - old_output.length() ) > max_width ) 
						max_width = output.length() - old_output.length();
	    		 hight++;
	    	}
	    max_width += 150;
	           
	    UIManager.put("OptionPane.minimumSize",new Dimension(max_width ,hight));  //PRINT WITH JOptionPane
	    JOptionPane.showMessageDialog(null, output, "Cards list", JOptionPane.PLAIN_MESSAGE);		
	}
	
	public int exportBoard(String file_name) {
		File board_file = null;
		// open file
        try {
        	board_file = new File(file_name + ".txt");
            if (!board_file.createNewFile()) {
                System.out.println("[ERROR] File already exists!");
                return -1;
            }
        } catch (IOException e) {
            System.out.println("[ERROR] Error opening file!");
            e.printStackTrace();
            return -1;
        }
    	
        // create text to write to file
        // '%%\n' between attributes (name, borad, groups, etc..)
        // '##\n' between object in list/map
        // '@@' as a ',' between object properties
        String text = "";
        // namen description, instruction, chosen_size
        text = text + this.name + "%%\n" + this.description + "%%\n" + this.instructions + "%%\n";
        text = text + String.valueOf(this.chosen_size) + "%%\n";
        // groups
        for (Group g: this.groups)
        	text = text + g.getName() + "@@" + g.getColor() + "##\n";
        text += "%%\n";
        // squares
        for (Square s: board) {
        	String class_name = s.getClass().getName();
        	text = text + class_name + "@@";
        	if (class_name == "SimpleSquare")
        		text = text + String.valueOf(((SimpleSquare)s).getValue()) + "@@";
        	else // SpecialSquare
        		text = text + ((SpecialSquare)s).getAction() + "@@";
        	text = text + s.getName() + "@@" + s.getDescription() + "@@" + s.getGroup().getName();
        	text += "##\n";
        }
        text = text + "%%\n";
        // surprise cards
        for (HashMap.Entry<String,ArrayList<Surprise>> entry : surprise_cards.entrySet()) {
        	text = text + entry.getKey() + "@@";
        	for (Surprise s: entry.getValue())
        		text = text + s.getContent() + "@@";
        	text += "##\n";
        }
        
        // write to file
        try {
            FileWriter myWriter = new FileWriter(board_file.getName());
            myWriter.write(text);
            myWriter.close();
            System.out.println("Successfully saved!");
        } catch (IOException e) {
            System.out.println("Error writing to file!");
            e.printStackTrace();
            return -1;
        }
    	return 0;
	}
	
	public void importBoard(String file_name) {
		//TODO: let the player know current board will be deleted
		
		//read from file
		String text = "";
		try {
            File board_file = new File(file_name + ".txt");
            Scanner myReader = new Scanner(board_file);
            while (myReader.hasNextLine()) {
                text += myReader.nextLine();
            }
            myReader.close();
            System.out.println("[ERROR] Read Successfully!");
        } catch (FileNotFoundException e) {
            System.out.println("[ERROR] File not found!");
            e.printStackTrace();
        }
		
		// split text and set BoardGameBuilder attributes
		// exactly as we explained in 'exportBoard' function
		String[] attributes = text.split("%%\n");
		this.name = attributes[0];
		this.description = attributes[1];
		this.instructions = attributes[2];
		this.chosen_size = Integer.parseInt(attributes[3]);
		this.groups = new ArrayList<Group>();
		String[] groups_text = attributes[4].split("##\n");
		for (String g: groups_text) {
			String[] name_color = g.split("@@");
			this.addGroup(new Group(name_color[0], name_color[1]));
		}
		this.surprise_cards = new HashMap<String,ArrayList<Surprise>>();
		String[] surprise_text = attributes[6].split("##\n");
		for (String s: surprise_text) {
			String[] key_values = s.split("@@", 2);
			String key = key_values[0];
			String[] values = key_values[1].split("@@");
			for (String v: values)
				this.addSurprise(key, new Surprise(v));
		}
		this.board = new ArrayList<Square>();
		String[] squares = attributes[5].split("##\n");
		for (String s: squares) {
			String[] info = s.split("@@"); // info = class, value/action, name, description, group
			String class_name = info[0];
			Group g = this.getGroup(info[4]);
			if (class_name == "SimpleSquare")
				this.board.add(new SimpleSquare(info[2], info[3], g, Integer.parseInt(info[1])));
			else // SpecialSquare
				this.board.add(new SpecialSquare(info[2], info[3], g, info[1]));
		}
	}
	
	public void printBoard() {
		//this was one of the more challenging methods.
		//we are printing the game's board.
		//in order to fit the "monopoly" kind of a board, We will print the board in a circular shape when the progress is clockwise.
		//The order of the squares will be printed according to the order of their absorption.
		//In order to receive valid output we are demanding a valid chose_size --> Divided by 4.
		
		int line_length = this.chosen_size/4 + 1; //making a square board out of our size.
		int board_idx = 0, array_end_idx = 0, array_len = board.size(); //indexes for prints.
		if ( (chosen_size % 4) != 0){
			UIManager.put("OptionPane.minimumSize",new Dimension(200 ,50));  //PRINT WITH JOptionPane
	        JOptionPane.showMessageDialog(new JFrame(), "WRONG BOARD SIZE! please make sure that your dimentions are multiply of 4.", "GAME BOARD ERROR", JOptionPane.PLAIN_MESSAGE);
	        return;
		}
		if (chosen_size != board.size()){
			UIManager.put("OptionPane.minimumSize",new Dimension(150 ,50));  //PRINT WITH JOptionPane
	        JOptionPane.showMessageDialog(new JFrame(), "WRONG BOARD DIMENSIONS! Number of squares is not matching Board size.", "GAME BOARD ERROR", JOptionPane.PLAIN_MESSAGE);
	        return;
		}
		
		JPanel pane = new JPanel(); //initializing JPane class to work with.
		Square s =null;
		JLabel label=null;
		int black =0;
	
		pane.setLayout(new GridLayout(0, line_length, 0, 0));
        for (int i = 0; i < line_length; i++) {
            for (int j = 0; j < line_length; j++) { // 2d for loop in order to go on whole 2d board matrix
            	if ( ( (i > 0) && (i < line_length -1)) && ( (j >0) && (j < (line_length -1) ))){      	//in case that we are in the middle of the board.
	                label = new JLabel(" ");
	                label.setBorder(BorderFactory.createLineBorder(Color.BLACK)); 
	                black = 1;
	           	}
            	else if (i==0){ //creating first line of the board. upper line.
            		s = this.board.get(board_idx);
	                board_idx++;
            	}
            	else if (i == (line_length-1)) { //creating last line of the board, buttom line.
            		s = this.board.get((array_len-1) - array_end_idx);
	            	array_end_idx ++;          			
            	}
            	else{
        			if ( board_idx > (line_length-1) ) { //in case that we reached the more interesting park of the board, left and right lines.
           				if (j == 0) {
        					s = this.board.get((array_len-1) - array_end_idx); // print from the end of the array
        	            	array_end_idx ++;
        				}
        				else if (j == (line_length-1)){ // print from the end of the array
        					s = this.board.get(board_idx);
        	            	board_idx++;
        				}     	            	
    	           	}	       				
        		}
                 
            	if (black == 0) {
            		if(s.getGroup() != null) 
                		label = new JLabel( " "+s.getGroup().getName()+": "+ s.getName());
            		else
            			label = new JLabel(" " + s.getName());    
           	
	            	if(s instanceof SimpleSquare) //choosing color by  kind of square.
	            		label.setBorder(BorderFactory.createLineBorder(Color.GREEN));
	            	else
	            		label.setBorder(BorderFactory.createLineBorder(Color.RED));       		
            	}
            	pane.add(label);
            	black = 0;
            }
        }  
        
        UIManager.put("OptionPane.minimumSize",new Dimension(1000 ,1000));  //PRINT WITH JOptionPane
        JOptionPane.showMessageDialog(new JFrame(), pane, "GAME BOARD", JOptionPane.PLAIN_MESSAGE);
	}
	
	public Square getSquareByName(String name) {
		for (Square s : board) {
			if (s.getName() == name) {
				LOG(s);
				return s;
			}
		}
		System.out.println("[ERROR] couldn't find " + name);
		return null;
	}
	
	public void printSquareByName(String name) {
		// TODO: using find square..
	}
	
	public void addSurprise(String key, Surprise s) {
		ArrayList<Surprise> temp = this.surprise_cards.get(key);
		if (temp==null)//create a new key
			temp = new ArrayList<Surprise>();
		temp.add(s);
		surprise_cards.put(key, temp);
		LOG(s);
	}

	public static void LOG(Object o) {
		System.out.println("[LOG] <" + Thread.currentThread().getStackTrace()[2].getMethodName() + "> " + o.toString());
	}
}
