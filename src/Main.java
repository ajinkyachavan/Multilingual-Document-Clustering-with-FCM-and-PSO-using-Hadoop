import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String args[]){
		
		final String username = System.getProperty("user.name");
		
		Preprocessing process = new Preprocessing();
		
		System.out.println("Preprocessing done");
		
		new File("cleanData").mkdir();
		
		
	//	process.initPreprocess();
		process.preprocess();
		
	//	runFromTerminal(" chmod a+x  initHadoop.sh");
	//	runFromTerminal(" ./initHadoop.sh");
		
		/*
		System.setProperty("user.dir", "/home/"+System.getProperty("user.name")+"/workspace/NewsCluster/");
		
		//System.out.println(System.getProperty("user.dir"));
		
		runFromTerminal("chmod a+x  /home/"+System.getProperty("user.name")+"/workspace/initHadoop.sh");
		runFromTerminal("./initHadoop.sh");
		*/
		
		process.getTFIDF();
		DocumentCluster document = new DocumentCluster();
		
		String arg[] = {};
		
		GUIMain.main(arg);
	
		
		String input = GUIMain.inputWord;
		
	document.fuzzyCMeansWithoutPSO(input);
	

    Main.runFromTerminal("Rscript /home/"+username+"/workspace/NewsCluster/plotBar.r /home/"+username+"/workspace/NewsCluster/barTime "+input );
    Main.runFromTerminal("Rscript /home/"+username+"/workspace/NewsCluster/plotiter.r /home/"+username+"/workspace/NewsCluster/iter "+input);

	
//	String arr[] = {document.documentNumber.size()+"", document.documentNumber.toString(), document.fileNames.length+""};
	//GUIMain2.main(arr);
	
		//System.out.println(document.tfidf);
	//System.out.println(document.addingTfidf);
		
	//	document.kMeans();
		//document.getExecAndIterTime();
		//document.fuzzyCMeans();
		
		
	}
	
	

	public static void runFromTerminal(String callCommand){
		try {
			  String command =callCommand;

			  Runtime rt  = Runtime.getRuntime();
			  Process proc = rt.exec(command);
			  
		       
		       // Read the output

		       BufferedReader reader =  
		             new BufferedReader(new InputStreamReader(proc.getInputStream()));
		       
		       String line = "";
		       while((line = reader.readLine()) != null) {
		           System.out.print(line + "\n");
		       }
				
		       proc.waitFor();   
			   
		   
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}