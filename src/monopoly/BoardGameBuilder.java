package monopoly;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


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
	private Group GetGroup(String name) {
		for (Group g: this.groups)
			if (g.getName() == name)
				return g;
		return null;
	}
	public boolean AddGroup(Group g) {
		if (this.groups.contains(g))
			return false;
		this.groups.add(g);
		return true;
	}
	public boolean deleteGroup(String name) {
		Group to_delete = GetGroup(name);
		if (to_delete == null)
			return false;
		for (Square s: this.board)
			if (s.getGroup() == to_delete)
				s.setGroup(null);
		this.groups.remove(to_delete);
		return true;
	}
	public boolean SetGroup(String old_name, String new_name, String new_color) {
		for (Group g: this.groups) {
			if (g.getName() == old_name) {
				g.setName(new_name);
				g.setColor(new_color);
				return true;
			}
		}
		return false;
	}
	public void AddSquare(Square s) {
		
	}
	public void deleteSquare(String name) {
		
	}
	public void deleteSquare(Square s1, Square s2) {
		
	}
	public void printAllSquares() {
		
	}
	public boolean exportBoard(String file_name) {
		File board_file = null;
        try {
        	board_file = new File(file_name + ".txt");
            if (!board_file.createNewFile()) {
                System.out.println("File already exists!");
                return false;
            }
        } catch (IOException e) {
            System.out.println("Error opening file!");
            e.printStackTrace();
            return false;
        }
    	
        String text = "";
        text = text + this.name + "%%\n" + this.description + "%%\n" + this.instructions + "%%\n";
        text = text + String.valueOf(this.chosen_size) + "%%\n";
        for (Group g: groups)
        	text = text + g.getName() + "@@" + g.getColor() + "##\n";
        text += "%%\n";
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
        for (HashMap.Entry<String,ArrayList<Surprise>> entry : surprise_cards.entrySet()) {
        	text = text + entry.getKey() + "@@";
        	for (Surprise s: entry.getValue())
        		text = text + s.getContent() + "@@"; //TODO: Surprise.getContent()
        	text += "##\n";
        }
        
        try {
            FileWriter myWriter = new FileWriter(board_file.getName());
            myWriter.write(text);
            myWriter.close();
            System.out.println("Successfully saved!");
        } catch (IOException e) {
            System.out.println("Error writing to file!");
            e.printStackTrace();
            return false;
        }
    	return true;
	}
	public void importBoard(String file_name) {
		//TODO: let the player know current board will be deleted
		String text = "";
		try {
            File board_file = new File(file_name + ".txt");
            Scanner myReader = new Scanner(board_file);
            while (myReader.hasNextLine()) {
                text += myReader.nextLine();
            }
            myReader.close();
            System.out.println("Read Successfully!");
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        }
		
		String[] attributes = text.split("%%\n");
		this.name = attributes[0];
		this.description = attributes[1];
		this.instructions = attributes[2];
		this.chosen_size = Integer.parseInt(attributes[3]);
		this.groups = new ArrayList<Group>();
		String[] groups_text = attributes[4].split("##\n");
		for (String g: groups_text) {
			String[] name_color = g.split("@@");
			this.AddGroup(new Group(name_color[0], name_color[1]));
		}
		this.surprise_cards = new HashMap<String,ArrayList<Surprise>>();
		String[] surprise_text = attributes[6].split("##\n");
		for (String s: surprise_text) {
			String[] key_values = s.split("@@", 2);
			String key = key_values[0];
			String[] values = key_values[1].split("@@");
			for (String v: values)
				this.addSurprise(key, new Surprise(v)); //TODO: Surprise constructor
		}
		this.board = new ArrayList<Square>();
		String[] squares = attributes[5].split("##\n");
		for (String s: squares) {
			String[] info = s.split("@@"); // info = class, value/action, name, description, group
			String class_name = info[0];
			Group g = this.GetGroup(info[4]);
			if (class_name == "SimpleSquare")
				this.board.add(new SimpleSquare(info[2], info[3], g, Integer.parseInt(info[1])));
			else // SpecialSquare
				this.board.add(new SpecialSquare(info[2], info[3], g, info[1]));
		}
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
	public void addSurprise(String key, Surprise s) {
		
	}
	// TODO: UI wrappers
	
}
