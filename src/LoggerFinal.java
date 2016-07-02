import java.io.*;

public class LoggerFinal {
	static String filename = null;

	boolean bool = false;
	public LoggerFinal(String myfilename, int docNum){
		try{
		//	System.out.println("dcoNum "+docNum);
			// Create a directory; all non-existent ancestor directories are
			// automatically created
			(new File("/home/deepa/workspace/NewsCluster/cluster_documents_"+myfilename)).mkdirs();
	
//	System.out.println(docNum+" dhfds");		
		File file = new File("/home/deepa/workspace/NewsCluster/cluster_documents_"+myfilename+"/"+docNum+".txt");
    	bool = file.createNewFile();
		
		}catch(Exception e){
			e.printStackTrace();
		}
    	
    	filename = "/home/deepa/workspace/NewsCluster/cluster_documents_"+myfilename+"/"+docNum+".txt";
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