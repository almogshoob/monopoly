package monopoly;

public class Group {
	
	private String name;
	private String color;
	
	public Group(String name, String color) {
		this.name = name;
		this.color = color;
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
		this.name = name;
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
	
}
