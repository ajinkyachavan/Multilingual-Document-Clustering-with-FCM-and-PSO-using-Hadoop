import java.io.*;

public class LoggerIter {
	 final String username = System.getProperty("user.name");

	
	public LoggerIter(){
		
//		(new File("/home/"+username+"/workspace/NewsCluster/cluster_plots_"+myfilename)).mkdirs();

		
    try{
        BufferedReader  bf  = new BufferedReader(new FileReader("/home/"+username+"/workspace/NewsCluster/iter"));
   	 
   	 if(bf.readLine() != null){
   		 PrintWriter writer1 = new PrintWriter("/home/"+username+"/workspace/NewsCluster/iter");
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
      
 
 	 final String username = System.getProperty("user.name");

      
      
      try {
    	  
    	
    	 
		out = new PrintWriter(new FileWriter("/home/"+username+"/workspace/NewsCluster/iter", true), true);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      out.write(message);
      out.close();
    }
}