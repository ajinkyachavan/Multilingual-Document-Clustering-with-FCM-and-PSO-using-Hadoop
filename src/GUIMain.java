import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
public class GUIMain  extends JPanel{

	static String inputWord = null;
	static JFrame f ;
	public void paint(Graphics g){
		
	}
	
	
	
	public static void main(String[] args) {
		
			
		 f = new JFrame();
		 inputWord = JOptionPane.showInputDialog("Input the word to search");
		
		
		
		
		
		f.addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		
		}
		);
		
		
		
		
	/*	ArrayList<Integer> n = new ArrayList<>();
		n.add(20);
		n.add(10);
		main2(2, n);*/
	}
		
	//	f.setContentPane(new Main());
//		f.setSize(400, 400);
	//	f.setVisible(true);
	
}
	
	
