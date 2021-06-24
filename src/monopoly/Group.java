package monopoly;

public class Group {
	
	private String name;
	private String color;
	
	public Group(String name, String color) {
		setName(name);
		this.color = color;
	}
	public Group(Group g) {
		this(g.name, g.color);
	}
	
	// Getters
	public String getName() {
		return this.name;
	}
	
	public String getColor() {
		return this.color;
	}
	
	// Setters
	public void setName(String name) {
		if (name.length()<=15)
			this.name=name;
		else
			this.name=name.substring(0,15);
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	// for 'contains' function
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Group))
			return false;
		Group other = (Group) obj;
		return this.name.equalsIgnoreCase(other.name); // each group has a unique name
	}
	
   public String toString() {
        return String.format("Group:\n" + " Name: "+this.name + " | Color: " + this.color);
   }
	
}
