import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;



public class GUIMain4 extends JFrame {
	 final String username = System.getProperty("user.name");

	static JFrame f = new JFrame();
	
	static int x = 0;
	
	

	public static void main(String args[]){
	//	System.out.println(args);
		 final String username = System.getProperty("user.name");

		DocumentCluster docu = new DocumentCluster();
		
//		System.out.println(docu.documentNumbers);
		
	//	for(int i=0;i<docu.documentNumbers.size();i++)
	//		System.out.println(docu.documentNumbers.get(i)+" "+i);
	//	System.out.println(args[0]);
//		System.out.println(args[1]);
		String s = null;
	
		int numClust = Integer.parseInt(args[0]); // num of clusters
		final String keyword = args[1]; // keyword
		String time = args[2]; // time
		String clstr = args[3]; // cluster with nums
		
		String inputWord = GUIMain.inputWord;
		
	String 	words[] = clstr.substring(1, clstr.length()-1).split(","); // removed sqr bracs
		
	//String clust[] = clstr.substring(1, clstr.length()-1).split(",");
	
//	for(int i=0;i<words.length;i++)
//		System.out.print(words[i]+" ");
	
//	for(int i=0;i<clust.length;i++)
	//	System.out.print(clust[i]+" ");
		ArrayList<String> newsNum = new ArrayList<>(); 

		JLabel label = new JLabel("Word "+keyword+" is found in "+numClust+" documents \n", SwingConstants.RIGHT);
		JLabel execTime = new JLabel("Execution time for Fuzzy C Means  with Particle Swarm Optimization for "+keyword+" is "+(Double.parseDouble(time))+" milliseconds\n");
		JButton button = new JButton("Cluster "+keyword+" Directory \n");
		
		
		File f4 = new File("/home/"+username+"/workspace/NewsCluster/pso_cluster_documents_"+keyword.trim());
		f4.mkdir();
		
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
	//			JDialog d= new JDialog(f, "woah "+n, true);
				try {
					Desktop.getDesktop().open(new File("/home/"+username+"/workspace/NewsCluster/pso_cluster_documents_"+keyword.trim()+"/"));
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
		

		JPanel panel2 = new JPanel();
	String  mydocs = clstr.trim();
//	System.out.println(mydocs+" hh");
		String strdocs[] = mydocs.substring(1, mydocs.length()-1).replace(" ", "").split(",");

		// String[] strdocs = strdocs.substring(1, strdocs.length()-1).replace("[", "").trim().split("],");
		
		// strdocs = strdocs.toString().split(" ");
		 
		// for(int i=0;i<strdocs.length;i++)
	//	System.out.print((Integer.parseInt(strdocs[i]))+" "+docu.news.get(Integer.parseInt(strdocs[i])-1)+" ");

		
		for(int i=0;i<words.length;i++){
		//					System.out.println("yo");
					//		newsNum.add(words[i].trim()+"_"+clust[l].trim());
							newsNum.add(words[i].trim());
							s = words[i].trim();
							
							try{
								File file = new File("/home/"+username+"/workspace/NewsCluster/pso_cluster_documents_"+keyword.trim()+"/"+s);
						    	file.createNewFile();
					//	    	System.out.println(Integer.parseInt((words[l].trim()))-1);
						    	  BufferedWriter out = new BufferedWriter
						    		         (new FileWriter("/home/"+username+"/workspace/NewsCluster/pso_cluster_documents_"+keyword.trim()+"/"+s));
						    		         out.write(docu.news.get(Integer.parseInt((words[i].trim()))-1));
						    		         out.close();
							}catch(Exception e){
								e.printStackTrace();
							}
					
				
			
		
			/*String docs = docu.documentNumbers.get(i).toString();
			
			String doc[] = docs.substring(1, docs.length()-1).split(",");
			System.out.println();
			for(int i1=0;i1<doc.length;i1++)
				System.out.print(doc[i1]+" k");*/
			
			
			
			final int num = i;
			final String s1 = s;
			JButton btn = new JButton("<HTML><FONT color=\"#FF8000\"><U>"+words[i].trim()+"</U><FONT></HTML>");
		
			btn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					//JDialog d= new JDialog(f, "woah "+n, true);
					
					try {
						Desktop.getDesktop().open(new File("/home/"+username+"/workspace/NewsCluster/pso_cluster_documents_"+keyword.trim()+"/"+s1));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			
			panel2.add(btn);
		}
		
	//	for(int i=0;i<newsNum.size();i++){
		//	System.out.println(newsNum.get(i));
	//	}
		
		panel.add(panel1);
		JPanel pan1 = new JPanel();
		
		pan1.add(label);
		panel.add(pan1);
	
	JPanel pan2 = new JPanel();
		
		pan2.add(execTime);
		panel.add(pan2);
		
		panel.add(panel2);
		
	//	panel.setBounds(xx, yy+20, 50, height+20);
		
		f.add(panel);
		f.setMinimumSize(new Dimension(0, 0));

		f.pack();
		
		f.setSize(1000, 600);
		
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
		boolean flag = true;
	Scanner obj = new Scanner(System.in);
		while(flag == true && x<numClust){
				System.out.println("Do you want to move to the next word (0/1) ");
				
				int choice = Integer.parseInt(obj.nextLine());
				if(choice == 1){
						flag = false;
						f.getContentPane().removeAll();
						break;
					  				
				}
				else{
				
					try{
					Thread.sleep(1000);
					}catch(Exception e){
						e.printStackTrace();
					}
				}
			}
		
		x++;

		
		}
		
		
		
}
	
