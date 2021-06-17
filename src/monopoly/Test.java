package monopoly;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BoardGameBuilder game = new BoardGameBuilder();
		game.setChosenSize(16);
		String[] names = {"High Level", "Low Level", "Assembler", "Web", "HDL", "Cards"};
		String[] colors = {"Yellow", "Green", "Blue", "Red", "Orange", "Pink"};
		Group[] groups = {};
		for (int i = 0; i < groups.length; i++) {
			groups[i] = new Group(names[i], colors[i]);
			game.addGroup(groups[i]);
		}
		game.addSurprise("Error", new Surprise("Index out of range! pay 512 bits"));
		game.addSurprise("Error", new Surprise("Devision by zero! pay 1024 bits"));
		game.addSurprise("Surprise", new Surprise("Good styling! get 512 bits"));
		game.addSurprise("Surprise", new Surprise("Very efficient! get 1024 bits"));
			
		game.AddSquare(new SpecialSquare("Start", "", null, "Collect 200 bits"));
		game.AddSquare(new SimpleSquare("Python", "easy peasy", groups[0], 5*1024));
		game.AddSquare(new SimpleSquare("Java", "for android app", groups[0], 4*1024));
		game.AddSquare(new SimpleSquare("C#", "for windows app", groups[0], 4*1024));
		game.AddSquare(new SimpleSquare("C", "remember malloc?", groups[1], 2*1024));
		game.AddSquare(new SimpleSquare("C++", "here go the OOP", groups[1], 3*1024));
		game.AddSquare(new SpecialSquare("Error", "I warned you!", groups[5], "Take an Error card"));
		game.AddSquare(new SimpleSquare("Compiler", "you forgot a ';'!", groups[2], 1024));
		game.AddSquare(new SimpleSquare("Linker", "lets united all files", groups[2], 1024));
		game.AddSquare(new SimpleSquare("Loader", "and.. go!", groups[2], 1024));
		game.AddSquare(new SimpleSquare("HTML", "connect to your wifi", groups[3], 2*1024));
		game.AddSquare(new SimpleSquare("CSS", "lets decorate it", groups[3], 2*1024));
		game.AddSquare(new SimpleSquare("PHP", "data base", groups[3], 2*1024));
		game.AddSquare(new SpecialSquare("Surprise", "good luck!", groups[5], "Take a Surprise card"));
		game.AddSquare(new SimpleSquare("vhdl", "what is that?", groups[4], 512));
		game.AddSquare(new SimpleSquare("verilog", "I don't want it!", groups[4], 512));
		
		// TODO: now add some stuff to delete after
		// add/delete group/square, swap c with cpp, print export import
		
	}

}
