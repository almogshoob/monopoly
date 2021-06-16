package monopoly;

public class Surprise implements Cardable {
	String content;
	
	public Surprise(String s) {
		content=s;
	}
	
	public String getContent() {
		return this.content;
	}
	
	public void printCard() {
		System.out.println("Card:");
		System.out.println(content);
	}
}
