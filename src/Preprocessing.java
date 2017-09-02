import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.tartarus.snowball.ext.englishStemmer;



 class Preprocessing {
	 
	englishStemmer stemmer = new englishStemmer();
ArrayList<ArrayList<String>> cleanDataArray = new ArrayList<>();
ArrayList<String> tfidfArray = new ArrayList<>();
ArrayList<String> cleanArray = new ArrayList<>();
ArrayList<ArrayList<String>> tfidf = new ArrayList<>();
ArrayList<String> addingTfidf = new ArrayList<>();
Logger cleanData = null;
//LoggerContentWords contentWord  = new LoggerContentWords();
LoggerStem logStem =null;
//LoggerStopWords logStop = new LoggerStopWords();

File cleanFile;
	 
BufferedReader in = null, in2 = null, lexread = null, contenWords = null, stopWord = null;

ArrayList<String> contentWords = new ArrayList<>();
ArrayList<String> stemWords = new ArrayList<>();
ArrayList<String> stopWords = new ArrayList<>();

final String username = System.getProperty("user.name");


public void preprocess(){
	// remove punctutaion, hyper markups, capitalization
	for(int x=1;x<176;x++){
		
		try {
			new File("cleanData/cleanData"+x+".txt").createNewFile();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	if(x<43) {

		String command = "Original_Dataset/English"+x+".txt";
		init(x,command);
	}
	if(x>42 && x<98){	
		String command = "Original_Dataset/Hindi"+x+"ToEnglish.txt";
		init(x,command);
	}
	else if(x>97){
		String command = "Original_Dataset/marathi"+x+"ToEnglish.txt";
		init(x,command);
	}
	}
	//System.out.println(stemWords);
} // end of preprocess
	
	
 
 public void init(int x, String command){
		//stemWords = new ArrayList<>();
		
		try {
			cleanData = new Logger();
			//cleanData.log(x+") ");

		}catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			in = new BufferedReader(new FileReader("/home/"+username+"/workspace/NewsCluster/"+command));
			
			String line = "";
			String data = "";
			
			while((line = in.readLine()) != null) {
				data += line;
			}
			
			String[] splitData = data.split("\\)");

			data = x+") ";
			
			
			for(int i=1;i<splitData.length;i++)
				data += splitData[i];
			
			
			
			
			//cleanData.log(x+") "+);
			cleanData.log(data);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		//logStem = new LoggerStem();
		
		//creating a log of Stop words in ArrayList

		/*
		try{
			
			stopWord = new BufferedReader(new FileReader("stopWords.txt"));
			
			String data = null;
			
			while((data = stopWord.readLine()) != null){
				stopWords.add(data.trim());
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	try {
		
		System.out.println("/home/"+username+"/workspace/NewsCluster/"+command+" command");
		
		in = new BufferedReader(new FileReader("/home/"+username+"/workspace/NewsCluster/"+command));

		
			String data = "";
		
			
		while((data = in.readLine()) != null){
			

			
			//System.out.println(data+"\n");
			
			data = data.toLowerCase();
			
			String[] words = data.split(" ");
			
			
			String pattern[] = {"[^a-z0-9\\s\\)]","http[^\\s]+"};	
					
			int i=0;
			
			while(i < pattern.length){		
			
				Pattern r = Pattern.compile(pattern[i++]);
			
				Matcher m = r.matcher(data);
				
				while(m.find()){
					
					String s = m.group();
					data = data.replaceAll("\\"+s, "");
				}
				
			
				}
			for(int l=0;l<words.length; l++){
				
				
				for(int m=0;m<stopWords.size();m++){
					
					if(stopWords.get(m).equals(words[l])){
						data.replace(words[l].trim(),"");
					}
				}
			}
			
			//System.out.println(data+"\n");
			cleanData.log(data+"\n");
		}
	
	} catch (Exception e) {
		}
	*/
	

	
	/*
	
	// check for content words
	
	try{
		
		in2 = new BufferedReader(new FileReader("cleanData/cleanData"+x+".txt"));
		String data = null,lexdata = null, lexword = null;
		
		while((data = in2.readLine()) != null){
			
			String words[] = data.split(" ");
			
			lexread = new BufferedReader(new FileReader("lexicons.txt"));
			
			while((lexdata = lexread.readLine()) != null){
				lexword = lexdata.split("\n")[0];
	//			System.out.println("wutt"+lexdata);
		//		for(int l=0; l<stopWords.size();l++)
		//		if(Arrays.asList(words).contains(stopWords.get(l).trim())){
		//s			contentWords.add(lexword);
	//				contentWord.log(lexword+"\n");
			//	}
				
				if(Arrays.asList(words).contains(lexword)){
					contentWords.add(lexword);
	//				contentWord.log(lexword+"\n");
				}
			}
			
		}
		
	}catch(Exception e){
		e.printStackTrace();
	}*/
	
	/*
	// Stemming the content words
	
	String data = null;
	int i=0;
//	System.out.println("content"+contentWords);
	while( i < contentWords.size()){
		
		stemmer.setCurrent(contentWords.get(i));
		if (stemmer.stem()){
			data = stemmer.getCurrent();
			stemWords.add(data);
		    logStem.log(data+"\n");
		}
		
		i++;
	}
	*/
	
	 
	 
 }
 
 
 /*

	public void startHadoopProcesses(){
//		runFromTerminal("sudo service ssh start");

	/*runFromTerminal("ssh localhost");
		runFromTerminal("sudo /home/"+username+"/hadoop/sbin/start-all.sh");
		runFromTerminal("jps");
	//	runFromTerminal("cd /home/"+username+"/hadoop");
		System.setProperty("user.dir", "/home/"+username+"/hadoop");
		runFromTerminal("/home/"+username+"/hadoop/hdfs namenode -format -force");
		runFromTerminal("/home/"+username+"/hadoop/hdfs dfs -mkdir -p /home/"+username+"/hadoop/input");
		runFromTerminal("/home/"+username+"/hadoop/hdfs dfs -copyFromLocal /home/"+username+"/workspace2/NewsArticleClusteringHadoop/bbc/*  /home/"+username+"/hadoop/input/");
		runFromTerminal("sudo /home/"+username+"/hadoop jar /home/"+username+"/workspace2/NewsArticleClusteringHadoop /tfidf.jar /home/"+username+"/hadoop/input /home/"+username+"/hadoop/output");
			

		runFromTerminal(" chmod a+x  initHadoop.sh");
			runFromTerminal(" ./initHadoop.sh");
	
	//runFromTerminal(" chmod a+x  advancedHadoop.sh");
	//runFromTerminal(" ./advancedHadoop.sh");
	
	}

	public void runFromTerminal(String callCommand){
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

		BufferedReader inobj = null;
		
		try{
			
			inobj = new BufferedReader(new FileReader("/usr/local/hadoop/finalOutput.txt"));
			
			if(inobj == null)
				System.out.println("hattttttttt");
			else
				System.out.println("xcgdfgdrgdfd");
			
			String mynewdata = null;
			
			while((mynewdata = inobj.readLine()) != null)
				System.out.println(mynewdata+"dgdfgdfg\n");
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
 }// end of class
	*/
	public void getTFIDF(){
		
		BufferedReader in=null;
		
		try{
			in = new BufferedReader(new FileReader("finalOutput.txt"));
	
			tfidfArray = new ArrayList<>();
			String data = null;
			int d=0;
			while((data = in.readLine()) != null){
				
				String pattern[] = {"\\[","\\]"};	
				
				int i=0;
				
				while(i < pattern.length){		
					Pattern r = Pattern.compile(pattern[i++]);
				
					Matcher m = r.matcher(data);
					
					while(m.find()){
						//System.out.println(data);
						String s = m.group();
						data = data.replaceAll("\\"+s, "");
					
					}
					
				
					}
				
				
				
				String myword = data.split("\t")[0].split("@")[0].trim();
				String myword2 = data.split("\t")[0].split("@")[1].trim();
				Double mydata = Double.parseDouble(data.substring(data.length()-6, data.length()-3).trim().replaceAll("\\D+",""));
				
				//myword2 = myword2.replaceAll("\\D+","");
				tfidfArray.add(myword+"-"+myword2.replaceAll("[^-?0-9]+", "")+"-"+mydata);
			}
			
			LoggerTfidf logtf = new LoggerTfidf();
			try{
				
				for(int i=0;i<tfidfArray.size();i++){
					logtf.log(tfidfArray.get(i)+"\n");
				}

			}catch(Exception e){
				e.printStackTrace();
			}
			
			
			tfidf.add(tfidfArray);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	
	
 
} // end of class
	


