package monopoly;

import javax.swing.JOptionPane;

public class Surprise implements Cardable {
	String content;
	
	public Surprise(String s) {
		content=s;
	}
	
	public String getContent() {
		return this.content;
	}
	
	public void printCard() {
		JOptionPane.showMessageDialog(null, toString());		
	}
	
	public String toString() {
        return String.format("Content: "+ this.content );
	}
	
}
