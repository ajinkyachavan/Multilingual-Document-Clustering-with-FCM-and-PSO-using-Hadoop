import java.io.*;

public class Logger {
	static int x = 0;
	static String filename = null;

	 final String username = System.getProperty("user.name");

	public Logger() throws Exception{
		x++;
		
		
    	filename = "/home/"+username+"/workspace/NewsCluster/cleanData/cleanData"+x+".txt";
		File file = new File("/home/"+username+"/workspace/NewsCluster/cleanData/cleanData"+x+".txt");
    	
		boolean bool = file.createNewFile();
		
    	//System.out.println(filename);
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