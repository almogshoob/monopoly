package monopoly;

public class SpecialSquare extends Square {
	
	private String action;
	
	//CTOR
	public SpecialSquare(String name, String description, Group group, String action) {
		super(name, description, group);
		this.action = action;
	}
	public SpecialSquare() {
		super();
		this.action = "no action";
	}

	//Getter
	public String getAction() {
		return action;	
	}
	
	public String toString() {
        return String.format("Action:\n" + action);
    }
}
