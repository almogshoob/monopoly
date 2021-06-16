package monopoly;

import java.awt.Color;

import javax.swing.JFrame;

public class InputDialog extends JFrame {
    
	public InputDialog() {
        getContentPane().setBackground(Color.DARK_GRAY);
        setTitle("BoardGameBuilder");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setSize(800, 600);
        getContentPane().setLayout(null);
    }
	
    public void closeIt(){
        this.getContentPane().setVisible(false);
        this.dispose();
    }
    

}
