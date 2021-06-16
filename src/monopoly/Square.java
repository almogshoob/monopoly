package monopoly;

import java.util.Arrays;
public abstract class Square {
	
	private String name;
	private String description;
	private Group group;
	
	//CTOR
	public Square(String name, String description, Group group) {
		this.name = name;
		this.description = description;
		this.group = group;	
	}
	public Square() {
		this.name = "empty";
		this.description = "an empty squere" ;
		this.group = null;	
	}
	public Square(Square other) {
        this(other.getName(), other.getDescription(),other.getGroup());
    }
	
	// Getters
	public String getName() {	
		return 	name;
	}
	public String getDescription() {
		return description;
	}
	public Group getGroup() {
		return group;		
	}
	
	public void setGroup(Group g) {	
		this.group = g;
	}
	
	//TODO
	public void printSquare() {
		
	//implement smart print
		char[] chars = new char[name.length() + 4];
		Arrays.fill(chars, '_');
		String shell = new String(chars);
		
		System.out.println(shell);
		System.out.println("| "+ name+ " |");
		System.out.println(shell);		
		
	}
	public String toString() {
        return String.format("Squere:\n" + "Name: "+this.name + "Description: " + this.description + "Group: " + this.group);
    }

	
	public static void main() {
		
	}
}
