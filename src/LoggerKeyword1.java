import java.io.*;
import java.io.IOException;
import java.io.PrintWriter;

public class LoggerKeyword1 {
	
	
	public LoggerKeyword1(){
	
    try{
        BufferedReader  bf  = new BufferedReader(new FileReader("/home/deepa/workspace/NewsCluster/clusteredValues"));
   	 
   	 if(bf.readLine() != null){
   		 PrintWriter writer1 = new PrintWriter("/home/deepa/workspace/NewsCluster/clusteredValues");
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
    	  
    	
    	 
		out = new PrintWriter(new FileWriter("/home/deepa/workspace/NewsCluster/clusteredValues", true), true);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      out.write(message);
      out.close();
    }
}