package monopoly;

import java.util.Arrays;

public class SimpleSquare extends Square implements Cardable {

	private int value;
	
	//CTOR
	
	public SimpleSquare(String name, String description, Group group, int value) {
		super(name,description,group);
		this.value = value;
	}
	public SimpleSquare() {
		super();
		this.value = 0;
	}
	//Getter
	public int getValue() {
		return value;	
	}
	public String toString() {
        return String.format("Value:\n" + value);
    }
	
	
	@Override
	public void printCard() {
		// TODO Auto-generated method stub
		
		char[] chars = new char[15];
		Arrays.fill(chars, '_');
		String shell = new String(chars);
		
		System.out.println(shell);
		System.out.println("Card of "+super.name);
		System.out.println(super.toString() + "\n" + this.toString());
		System.out.println(shell);		
		
	}

}
