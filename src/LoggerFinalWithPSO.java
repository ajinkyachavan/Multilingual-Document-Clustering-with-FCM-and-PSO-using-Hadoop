import java.io.*;

public class LoggerFinalWithPSO {
	static String filename = null;

	boolean bool = false;
	public LoggerFinalWithPSO(String myfilename, int docNum){
		try{

			// Create a directory; all non-existent ancestor directories are
			// automatically created
			(new File("/home/deepa/workspace/NewsCluster/pso_cluster_documents_"+myfilename)).mkdirs();
	
	//System.out.println(docNum+".txt"+" dhfds");		
		File file = new File("/home/deepa/workspace/NewsCluster/pso_cluster_documents_"+myfilename+"/"+docNum+".txt");
    	bool = file.createNewFile();
		
		}catch(Exception e){
			e.printStackTrace();
		}
    	
    	filename = "/home/deepa/workspace/NewsCluster/pso_cluster_documents_"+myfilename+"/"+docNum+".txt";
   // 	System.out.println(filename);
    try{
    
        BufferedReader  bf  = new BufferedReader(new FileReader(filename));
   	 
   	 if(bf.readLine() != null){
   		 PrintWriter writer1 = new PrintWriter(filename);
   		 writer1.print("");
   		 writer1.close();
   	 }else{
   		 bf = null;
   	 } ;
        }catch(Exception e){
      	  e.printStackTrace();
        }
	
	
	
	}
	
	
    public static void log(String message) { 
      PrintWriter out = null;
      
 
      
      
      
      try {
    	  
    	
    	 
		out = new PrintWriter(new FileWriter(filename, true), true);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      out.write(message);
      out.close();
    }
}