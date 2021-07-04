package monopoly;

import java.util.Arrays;
public abstract class Square {
	
	private String name;
	private String description;
	private Group group;
	
	//CTOR
	public Square(String name, String description, Group group) {
		setName(name);
		this.description = description.isEmpty()? "None" : description;
		this.group = group;	
	}
	public Square() {
		setName("empty");
		this.description = "an empty square" ;
		this.group = null;	
	}
	public Square(Square other) {
        this(other.getName(), other.getDescription(),other.getGroup());
    }
	
	// Setters
	public void setName(String name) {
		if (name.length()<=15)
			this.name=name;
		else
			this.name=name.substring(0,15);
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
		if (this.group == null)
			return String.format("Squere's Name: "+this.name + " | Description: " + this.description + " | Group: " + " No Group.");
		return String.format("Squere's Name: "+this.name + " | Description: " + this.description + " | Group: " + this.group.getName());
			
		
    }

}
