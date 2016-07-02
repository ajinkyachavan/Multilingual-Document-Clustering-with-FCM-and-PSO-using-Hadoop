import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String args[]){
		Preprocessing process = new Preprocessing();
		
	//	process.initPreprocess();
		process.preprocess();
		
	//	runFromTerminal(" chmod a+x  initHadoop.sh");
	//	runFromTerminal(" ./initHadoop.sh");
	
		System.setProperty("user.dir", "/home/deepa/workspace/NewsCluster/");
		
		runFromTerminal(" chmod a+x /home/deepa/workspace/NewsCluster/initHadoop.sh");
		runFromTerminal("   ./initHadoop.sh");
	
		
		process.getTFIDF();
		DocumentCluster document = new DocumentCluster();
		
		String arg[] = {};
		
		GUIMain.main(arg);
	
		
		String input = GUIMain.inputWord;
		
	document.fuzzyCMeansWithoutPSO(input);
	

//    Main.runFromTerminal("Rscript /home/deepa/workspace/NewsCluster/plotBar.r /home/deepa/workspace/NewsCluster/barTime "+input );
 //   Main.runFromTerminal("Rscript /home/deepa/workspace/NewsCluster/plotiter.r /home/deepa/workspace/NewsCluster/iter "+input);

	
//	String arr[] = {document.documentNumber.size()+"", document.documentNumber.toString(), document.fileNames.length+""};
	//GUIMain2.main(arr);
	
		//System.out.println(document.tfidf);
	//System.out.println(document.addingTfidf);
		
	//	document.kMeans();
		//document.getExecAndIterTime();
		//document.fuzzyCMeans();
		
	runFromTerminal("Rscript plotBar.r barTime names");
    runFromTerminal("Rscript plotiter.r iter names");
	}
	
	

	public static void runFromTerminal(String callCommand){
		try {
			  String command =callCommand;

		       Process proc = Runtime.getRuntime().exec(command);

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