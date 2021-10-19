package monopoly;

import java.awt.Color;

import javax.swing.JFrame;

// Input Dialog class for jOptionPane
public class InputDialog extends JFrame {
    
	public InputDialog() {
		// set background and title
        getContentPane().setBackground(Color.DARK_GRAY);
        setTitle("BoardGameBuilder");
        // other settings
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
