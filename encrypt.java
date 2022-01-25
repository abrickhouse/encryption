import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class encrypt implements ActionListener{

	private static ArrayList<String> alpha = new ArrayList<String>() {
		{	add("a");
		add("b");
		add("c");
		add("d");
		add("e");
		add("f");
		add("g");
		add("h");
		add("i");
		add("j");
		add("k");
		add("l");
		add("m");
		add("n");
		add("o");
		add("p");
		add("q");
		add("r");
		add("s");
		add("t");
		add("u");
		add("v");
		add("w");
		add("x");
		add("y");
		add("z");
		}
	};
	private JFrame frame;
	private JLabel label;
	private JButton buttonA;
	private JButton buttonB;
	private JPanel panel;
	private JTextField textfield;

	public encrypt() {
		frame = new JFrame();

		buttonA = new JButton("Encrypt");
		buttonB = new JButton("Decrypt");
		buttonA.addActionListener(this);
		buttonB.addActionListener(this);
		label = new JLabel("");
		textfield = new JTextField("");

		panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		panel.setLayout(new GridLayout(0, 1));
		panel.add(textfield);
		panel.add(buttonA);
		panel.add(buttonB);
		panel.add(label);

		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Cipher");
		frame.pack();
		frame.setVisible(true);
	}	

	public static void main(String[] args) {
		
		new encrypt();
		//System.out.println(encryptWord("the quick fox jumped over the lazy brown dog"));
		//System.out.println(decryptWord("ymj vznhp ktc ozruji tajw ymj qfed gwtbs itl"));
		//System.out.println(decryptWord("frfndf gwnhpmtzxj"));

	}

	public void actionPerformed(ActionEvent e) {
		
		String s = textfield.getText();
		if(e.getSource()==buttonA){  
			label.setText(encryptWord(s));  
		}else if(e.getSource()==buttonB){  
			label.setText(decryptWord(s));
		}
	}

	public static String encryptWord(String s) {

		char[] chars = s.toCharArray();
		String enc = "";

		for(int i = 0; i < chars.length; i++) {
			for(int j = 0; j != 26; j++) {
				if(chars[i] == alpha.get(j).charAt(0)) {
					enc += alpha.get((j+5)%26);
				}
			}
			if(enc.length()==i) 
				enc += chars[i];
		}
		return enc;
	}

	public static String decryptWord(String s) {

		char[] chars = s.toCharArray();
		String dec = "";

		for(int i = 0; i < chars.length; i++) {
			for(int j = 0; j != 26; j++) {
				if(chars[i] == alpha.get(j).charAt(0)) {
					if((j-5)<0) {
						dec += alpha.get(26+(j-5));
					} else {
						dec += alpha.get((j-5)%26);
					}
				}
			}
			if(dec.length()==i) 
				dec += chars[i];
		}
		return dec;
	}
}
