package monopoly;

import java.util.Arrays;

import javax.swing.JOptionPane;

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
        return String.format(super.toString() + " | Value: " + value);
    }
		
	@Override
	public void printCard() {
		JOptionPane.showMessageDialog(null, toString());
	}

}
