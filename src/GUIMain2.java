import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class GUIMain2 extends JFrame {

	 final String username = System.getProperty("user.name");

	
	static int x = 0;
	static JFrame f[];
	
	public static void createJFrameArray(int num){
		
		 f = new JFrame[num];
	
	}
	

	public static void main(String args[]){
	//	System.out.println(args);
		
	//	System.out.println(args[0]);
//		System.out.println(args[1]);
		 final String username = System.getProperty("user.name");


		int n = Integer.parseInt(args[0]);
		String docNum = args[1];
		int numDoc = Integer.parseInt(args[2]);
		
		if(x == 0)
			createJFrameArray(numDoc);
			
		
		
		
		final String inputWord = GUIMain.inputWord;
		
		
	final String 	words[] = docNum.substring(1, docNum.length()-2).split(",");
		

		JLabel label = new JLabel("Cluster 1 contains "+n+" values", SwingConstants.RIGHT);
		
		JButton button = new JButton("Cluster Directory");
		
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
	//			JDialog d= new JDialog(f, "woah "+n, true);
				try {
					Desktop.getDesktop().open(new File("/home/"+username+"/workspace/NewsCluster/cluster_"+inputWord+"/"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		ArrayList<JButton> buttons = new ArrayList<>();
		JPanel panel = new JPanel();
		JPanel panel1 = new JPanel();
		panel1.add(button);
		panel1.add(label);
		

		JPanel panel2 = new JPanel();
		for(int i=0;i<words.length;i++){
	//		JButton btn = new JButton("<HTML><a href=\"/home/"+username+"/workspace2/NewsCluster3/cluster"+inputWord+"\" >"+n+"</a></HTML>");
			final int num = i;
			JButton btn = new JButton("<HTML><FONT color=\"#009900\"><U>"+words[i]+"</U><FONT></HTML>");
		
			btn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					//JDialog d= new JDialog(f, "woah "+n, true);
					try {
						Desktop.getDesktop().open(new File("/home/"+username+"/workspace/NewsCluster/cleanData/cleanData"+Integer.parseInt(words[num].trim())+".txt"));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			
			panel2.add(btn);
		}
		
		panel.add(panel1);
		panel.add(panel2);
		
		f[x] = new JFrame();
		
		
		f[x].add(panel);

		
		f[x].setSize(800, 400);
		
		f[x].setVisible(true);
		f[x].setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
		
		
		
		x++;
}
	
}
