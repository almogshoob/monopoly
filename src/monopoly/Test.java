package monopoly;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// create Code Board
		BoardGameBuilder game = new BoardGameBuilder();
		game.setChosenSize(16);
		// add groups
		String[] names = {"High Level", "Low Level", "Assembler", "Web", "HDL", "Cards"};
		String[] colors = {"Yellow", "Green", "Blue", "Red", "Orange", "Pink"};
		for (int i = 0; i < names.length; i++)
			game.addGroup(new Group(names[i], colors[i]));
		// add cards
		game.addSurprise("Error", new Surprise("Index out of range! pay 512 bits"));
		game.addSurprise("Error", new Surprise("Devision by zero! pay 1024 bits"));
		game.addSurprise("Surprise", new Surprise("Good styling! get 512 bits"));
		game.addSurprise("Surprise", new Surprise("Very efficient! get 1024 bits"));
		
		
		game.addSurprise("Eilon", new Surprise("Index out of range! pay 512 bits"));
		game.addSurprise("Eilon", new Surprise("Devision by zero! pay 1024 bits"));
		game.addSurprise("Eilon", new Surprise("Good styling! get 512 bits"));
		game.addSurprise("Eilon", new Surprise("Very eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeefficient! get 1024 bits"));
		
		
		game.addSurprise("Yair", new Surprise("Index out of range! pay 512 bits"));
		game.addSurprise("Yair", new Surprise("ddddddddddddddddddddddddddddddddddddddddddddddddddddDevision by zero! pay 1024 bits"));
		game.addSurprise("Yair", new Surprise("Good styling! get 512 bits"));
		game.addSurprise("Yair", new Surprise("Very efficient! get 1024 bits"));
		
		
		// add squares
		//game.AddSquare(new SpecialSquare("Start", "", null, "Collect 200 bits"));
		game.AddSquare(new SimpleSquare("Python", "easy peasy", game.getGroup("High Level"), 5*1024));
		game.AddSquare(new SimpleSquare("Java", "for android app", game.getGroup("High Level"), 4*1024));
		game.AddSquare(new SimpleSquare("C#", "for windows app", game.getGroup("Highl Level"), 4*1024));
		game.AddSquare(new SimpleSquare("C", "remember malloc?", game.getGroup("Low Level"), 2*1024));
		game.AddSquare(new SimpleSquare("C++", "here go the OOP", game.getGroup("Low Level"), 3*1024));
		game.AddSquare(new SpecialSquare("Error", "I warned you!", game.getGroup("Cards"), "Take an Error card"));
		game.AddSquare(new SimpleSquare("Compiler", "you forgot a ';'!", game.getGroup("Assembler"), 1024));
		game.AddSquare(new SimpleSquare("Linker", "lets united all files",game.getGroup("Assembler"), 1024));
		game.AddSquare(new SimpleSquare("Loader", "and.. go!", game.getGroup("Assembler"), 1024));
		game.AddSquare(new SimpleSquare("HTML", "connect to your wifi", game.getGroup("Web"), 2*1024));
		game.AddSquare(new SimpleSquare("CSS", "lets decorate it", game.getGroup("Web"), 2*1024));
		game.AddSquare(new SimpleSquare("PHP", "data base", game.getGroup("Web"), 2*1024));
		game.AddSquare(new SpecialSquare("Surprise", "good luck!", game.getGroup("Cards"), "Take a Surprise card"));
		game.AddSquare(new SimpleSquare("vhdl", "what is that?", game.getGroup("HDL"), 512));
		game.AddSquare(new SimpleSquare("verilog", "I don't want it!", game.getGroup("HDL"), 512));
		
		// some more function to test
		game.addGroup(new Group("Stam", "Black"));
		//game.SetGroup("Stam", "Stam", "White");
		game.AddSquare(new SimpleSquare("Hi", "How you doing?", game.getGroup("Stam"), 10*1024));
		//game.deleteGroup("Stam");
		game.printSquareByName("Hi");
		//game.deleteSquare("Hi");
		//game.swapSquare(game.getSquareByName("C++"), game.getSquareByName("C"));
		game.exportBoard("CodeBoard");
		BoardGameBuilder game2 = new BoardGameBuilder();
		//game.PrintAllCards();
		//game.printAllSquares();
		game.printBoard();
		//game.shuffleSquares();
		//game.printBoard();
		//game.deleteSquare("Hi");
		//game.printBoard();
		
		//game.setChosenSize(8);
		//game.printBoard();
		//game2.importBoard("CodeBoard");
		//game2.printBoard();
	}

}
