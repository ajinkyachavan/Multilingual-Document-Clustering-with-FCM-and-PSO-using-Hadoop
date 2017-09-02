
import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


 class DocumentCluster{
	
	 final String username = System.getProperty("user.name");
	 
	 int iter=0;
	 double execTime=0.0;
		String[] fileNames = null;
	//ArrayList<Double> keyword_array_1 = new ArrayList<>();
	//ArrayList<Double> keyword_array_2 = new ArrayList<>();
	ArrayList<Integer> newsNumber = new ArrayList<>();
 	 ArrayList<Double> keyword_array_1 = new ArrayList<>();
 	ArrayList<Double> keyword_array = new ArrayList<>();
	ArrayList<String> news = new ArrayList<>(); 
	ArrayList<String> newsWithValues = new ArrayList<>(); 
	ArrayList<String> valuesWithLineNumbers = new ArrayList<>();
	ArrayList<ArrayList<String>> tfidf = new ArrayList<>();
	ArrayList<String> addingTfidf = new ArrayList<>();
	ArrayList<String> tfidfArray = new ArrayList<>();
	ArrayList<String> wordsOnly = new ArrayList<>();
	ArrayList<Integer> documentNumber = new ArrayList<>();
	ArrayList<ArrayList<Integer>> documentNumbers = new  ArrayList<>();
	BufferedReader in=null;
//	LoggerTfidf tf = new LoggerTfidf();
	LoggerAllKeywords logv = new LoggerAllKeywords();
	LoggerCombinedKeywords logc = new LoggerCombinedKeywords();
	LoggerIter itr = new LoggerIter();
    LoggerBar bar = new LoggerBar();
	//LoggerContentWords names = new LoggerContentWords();

	ArrayList<String> nonUniqueWords = new  ArrayList<>();
	ArrayList<String> uniqueWords = new  ArrayList<>();
	ArrayList<String> uniqueWordsListWithNum = new ArrayList<>();
	ArrayList<String> uniqueWordsWithCount = new ArrayList<>();
	
	
	
	ArrayList<String> uniqueNumsListWithNum = new ArrayList<>();
	ArrayList<String> uniqueNumsWithCount = new ArrayList<>();

	
	
	ArrayList<String> nonUniqueNums = new ArrayList<>();
	ArrayList<String> uniqueNums = new ArrayList<>();

	ArrayList<Integer> copyUniqueNums = new ArrayList<>();
	ArrayList<String> copyUniqueNums2 = new ArrayList<>();
	
	ArrayList<ArrayList<String>> total = new ArrayList<>();
	ArrayList<String> track = new ArrayList<>();
	
	ArrayList<ArrayList<String>> finalTestArray = new ArrayList<>();
	ArrayList<String> testArray = new ArrayList<>();
	ArrayList<ArrayList<String>> documents = new ArrayList<>();
	ArrayList<HashMap<String, Integer>> document = new ArrayList<>();
	HashMap<String, Integer> hashdocument = new HashMap<>();
	ArrayList<Integer> clusterNews = new ArrayList<>();
	boolean flag = false;
	double data;
	int i,j,l2=0;
	ArrayList<Double> zeroArray = new ArrayList<>();
	ArrayList<Double> oneArray = new ArrayList<>();
	ArrayList<String> search_keyword = new ArrayList<>();
	String search_keyword_1, search_keyword_2,search_keyword_3;
	LoggerKeywords logk = new LoggerKeywords();
	LoggerKeywordsPSO logk_pso = new LoggerKeywordsPSO();

	
	/******* Fuzzy C Means Variables***/
	boolean allowed = true;
	//LoggerFinale finale = new LoggerFinale();

	BufferedReader emotInput = null;
	ArrayList<String> inData = new ArrayList<>();
	ArrayList<Integer> lineNum = new ArrayList<>();
	ArrayList<Double> values = new ArrayList<>();
	ArrayList<Double> euclid = new ArrayList<>();
	ArrayList<Double> centroids = new ArrayList<>();
	ArrayList<Double> centroidBackup = new ArrayList<>();
	ArrayList<Double> distance = new ArrayList<>();
	ArrayList<ArrayList<Double>> membership = new ArrayList<>();
	ArrayList<Double> memArray = new ArrayList<>();
	ArrayList<Double> happyNumbers = new ArrayList<>();
	ArrayList<Double> fondNumbers = new ArrayList<>();
	ArrayList<String> mybar = new  ArrayList<>();
	ArrayList<String> myiter = new ArrayList<>();
	double mem1=0, mem2=0, mem=0, memadd=0, memHappy =0, memFond = 0;
	double euclidistance = 0;
	ArrayList<Double> num=null;
	ArrayList<Double> den = null;
	double m = 3;
	ArrayList<Double> gBest = new ArrayList<>();
	double gBest1=0, gBest2 = 0;
	LoggerFinal finale = null;
	LoggerFinalWithPSO finalePSO = null;
	double mean = 0;
	
	
	/****FCM with PSO variables***/

	double c1=0.03, c2=0.02;
	
	ArrayList<Double> position = new ArrayList<>();
	ArrayList<Double> positionBackup = new ArrayList<>();

	ArrayList<Double> pBest = new ArrayList<>();
	ArrayList<Double> velocity = new ArrayList<>();
	ArrayList<Double> velocityBackup = new ArrayList<>();

	ArrayList<Double> fitness = new ArrayList<>();
	ArrayList<Integer> lineNumbers = new ArrayList<>();
	
	
	public DocumentCluster(String s){
		
	}
	
public DocumentCluster(){

//	names  = new LoggerContentWords();
		/*****methods ***/
			for(int d=1; d<176;d++){
			try{
				documentNumber = new ArrayList<>();
				String mydata =null, mystring = "", curr="";
				in = new BufferedReader(new FileReader("/home/"+username+"/workspace/NewsCluster/cleanData/cleanData"+d+".txt"));
				
				while((mydata = in.readLine()) != null){
					mystring += mydata+" \n ";
				}
				//System.out.println("mystring - " +mystring);
			boolean flag = false;
			
			String[] words = mystring.split(" ");
				 i=0;
				
				while(i<words.length){
					
			//		System.out.println(data);
					
					if(flag == true){
						while( i<words.length && !(words[i].matches("^\\d+[)]"))){
					
							curr+=words[i]+" ";
							i++;
						}
		//			System.out.println(curr);
					
					news.add(curr);
					newsWithValues.add(d+"-"+curr);
		//			System.out.println("-------------");
						flag = false;
					}
					
					if(i!=0){
						curr="";
					}
					
					if(i < words.length && words[i].matches("^\\d+[)]")){
						Integer docNum = Integer.parseInt(words[i].substring(0,words[i].length()-1).trim());
						documentNumber.add(docNum);
						curr+=words[i]+" ";
						flag = true;
				
					}
					i++;
		
				
				}
			//	System.out.println(curr);
		//		System.out.println("-------------");
			}catch(Exception e){
				e.printStackTrace();
			}
			
			documentNumbers.add(documentNumber);
			}
			
			System.out.println(news.size());
		//		for(int k2=0;k2<news.size();k2++)
					//System.out.println(news.get(k2)+"\n\n");

			try{
			
			Scanner s = new Scanner(new File("/home/"+username+"/workspace/NewsCluster/tfidfArray.txt"));
			

				//	ArrayList<String> list = new ArrayList<String>();
			while (s.hasNext()){
			    tfidfArray.add(s.next());
			}
			s.close();
			
			}catch(Exception e){
				e.printStackTrace();
			}
	int k=0;
	while(k<tfidfArray.size())
		nonUniqueNums.add(tfidfArray.get(k++).split("-")[1]);
	
	//System.out.println("non "+nonUniqueNums);
	
		uniqueNums = new ArrayList<String>(new LinkedHashSet<String>(nonUniqueNums));
		
		for(int h=0;h<uniqueNums.size();h++)
			copyUniqueNums.add(Integer.parseInt(uniqueNums.get(h)));
		
	copyUniqueNums2= 	sort(copyUniqueNums);
			
	
	for(int l=0;l<tfidfArray.size();l++){
		wordsOnly.add(tfidfArray.get(l).split("-")[0].trim());
		
		
		
		
		
		
		
		
		
		
		
		//System.out.println(tfidfArray.get(l).split("-")[0].trim());
	}
	//		System.out.println("uniqqqq"+copyUniqueNums2);
		
	 i=0;
	j=0;
	String data= null;
	//System.out.println(uniqueNums.size());
	//System.out.println("uniq"+uniqueNums);
	
	while(i<copyUniqueNums.size()){
		track = new ArrayList<>();
		j = 0;
		while(j<nonUniqueNums.size()){
		
			
			if(nonUniqueNums.get(j).trim().equals(copyUniqueNums2.get(i).trim())){
				track.add(tfidfArray.get(j).split("-")[0]+"-"+(tfidfArray.get(j).split("-")[2]));
				}
			j++;
	}

		total.add(track);

		i++;
	}// outer while end
	 
	int l=0;
	
//	while(l<total.size()){
	//	System.out.println((l+1)+" "+total.get(l++));
	//}
	
	

	
		
		
			double value = 0;
			
			for(int n=0;n<total.size()-1;n++){
				value = 0;
				
				for(int a=0;a<total.get(n).size();a++){
					logv.log(Double.parseDouble(total.get(n).get(a).split("-")[1])/10+"\n");
					value += Double.parseDouble(total.get(n).get(a).split("-")[1])/10; 
				}

			logc.log(value+"\n");
				values.add(value);
				valuesWithLineNumbers.add((n+1)+"-"+value);
			}
			Main.runFromTerminal("Rscript /home/"+username+"/workspace/NewsCluster/plotValues.r all_keywords 1");

		Main.runFromTerminal("Rscript /home/"+username+"/workspace/NewsCluster/plotValues.r combined_keywords 2");

	//		System.out.println("size - "+values.size());
	//		System.out.println("values"+values);
		
	//		fuzzyCMeansWithoutPSO(values);
	//		fuzzyCMeansWithPSO(values);
//System.out.println("valuesssssssssss");
	//		for(int k1=0; k1<valuesWithLineNumbers.size();k1++){
	//			System.out.println(valuesWithLineNumbers.get(k1));
			}
			
		
		
		
		

	
	public static ArrayList<String> sort(ArrayList<Integer> copyUniqueNums){
		int iArr[] = new int[copyUniqueNums.size()];
		ArrayList<String> returnCopy = new ArrayList<>(); 
  		// initializing unsorted int array
		for(int i=0;i<copyUniqueNums.size();i++)
			iArr[i] = copyUniqueNums.get(i);
		   Arrays.sort(iArr);	
		   
		   for(int k=0;k<iArr.length;k++)
			   returnCopy.add(iArr[k]+"");
		   
		   return returnCopy;
	}
	

	
/*********************** Fuzzy C Means without PSO***/
		
		public  void fuzzyCMeansWithoutPSO(String br){
			
			
	//		for(int i=0;i<documentNumbers.size();i++)
	//			System.out.println(documentNumbers.get(i)+" docNum - "+(i+1));
			
			long startTime = System.nanoTime();

	//		System.out.println("Enter the  keywords to search");
			try{

				
//InputStreamReader r=new InputStreamReader(System.in);  
//BufferedReader br=new BufferedReader(r);  

String s = br;

int l1=0;
fileNames = new String[s.split(" ").length];




for(String s1:s.split(" ")){
	
	if(Collections.frequency(wordsOnly, s1) > 1){
		search_keyword.add(s1.trim());
String myname = s1.trim()+"_with_PSO";
//names.log(s1.trim()+"\n");
System.out.println(myname);
//		names.log(myname+"\n");
		
		File f3 = new File("/home/"+username+"/workspace/NewsCluster/cluster_documents_"+s1.trim());
		f3.mkdir();
		
		
		 f3 = new File("/home/"+username+"/workspace/NewsCluster/cluster_plots_"+s1.trim());
		f3.mkdir();
		
		
		 f3 = new File("/home/"+username+"/workspace/NewsCluster/pso_cluster_documents_"+s1.trim());
		f3.mkdir();
		
		
		 f3 = new File("/home/"+username+"/workspace/NewsCluster/pso_cluster_plots_"+s1.trim());
		f3.mkdir();
		
		
		//show("names");
}
	else{
		System.out.println(s1+" occurs only once. SO rejecting"); 
	}
		fileNames[l1++] = s1;
}

/*
 search_keyword_1 = br.readLine();
 search_keyword_2 = br.readLine();
 search_keyword_3 = br.readLine();
	*/	  



		//    System.out.println("keyyyyyyyyyyyy"+keyword_array);
			
			}catch(Exception e){
				e.printStackTrace();
			}
			  
		    for(int k2=0;k2<search_keyword.size();k2++){
		  
		    	LoggerKeyword1 logw1 = new LoggerKeyword1();
		    	LoggerCentroid logcent = new LoggerCentroid();
		    
		    	logk = new LoggerKeywords();	
		    	logw1 = new  LoggerKeyword1();
		    			
		    	centroids = new ArrayList<>();
		    	keyword_array = new ArrayList<>();
		    	
		    		search_keyword_1 = search_keyword.get(k2);
		    		

			  //  	bar = new LoggerBar(search_keyword_1);
			//    	itr = new LoggerIter(search_keyword_1);
		    //		System.out.println(	search_keyword_1);
		    	

		    	
		    for(int b1 = 0; b1<tfidfArray.size();b1++){
		    	//System.out.println(tfidfArray.get(b1).split("-")[0]);
		    	if(tfidfArray.get(b1).split("-")[0].trim().equals(search_keyword_1)){
	//    	System.out.println(tfidfArray.get(b1).split("-")[0].trim()+" "+tfidfArray.get(b1).split("-")[1].trim());
		    		
		    		keyword_array.add(Double.parseDouble(tfidfArray.get(b1).split("-")[2]));
		    		
		    	}
		    }
		    
		if(keyword_array != null){
//		    System.out.println(keyword_array.size()+" "+k2+" "+search_keyword_1);
//			System.out.println(keyword_array+" "+k2);
		}
		else{
			System.out.println("word not found "+search_keyword_1);
			System.exit(0);
		}
			
		
		for(int k3=0;k3<keyword_array.size();k3++)
			logk.log(keyword_array.get(k3)+"\n");
			
	/*	System.out.print("Values for");
		BufferedReader f3;
		
		try{
			f3 = new  BufferedReader(new FileReader("valuesForThisWord"));
		
			String data = null;
			
			while((data=f3.readLine()) != null){
				System.out.println(data);
			}
		
		}catch(Exception e){
			e.printStackTrace();
		}*/
		
		Main.runFromTerminal("Rscript /home/"+username+"/workspace/NewsCluster/plotValuesClusteringData.r /home/"+username+"/workspace/NewsCluster/valuesForThisWord 3 "+search_keyword_1 );
		
			centroids.add(1000.0);
			centroids.add(900.0);
			allowed = true;
			iter = 0;
			// Step 1 : Calculate membership matrix using the centroids assigned intitally and then update accordingly
	label1:while(allowed){
		iter++;
		logcent = new LoggerCentroid();
		membership = new ArrayList<>();

		num = new ArrayList<>();
		den = new ArrayList<>();
	//// System.out.println("centroids new one"+centroids);

			for(int i=0; i<keyword_array.size(); i++){ 

				mybar = new ArrayList<>();
				myiter = new ArrayList<>();
				memArray = new ArrayList<>();
				
					
					for(int h=0;h<centroids.size();h++){
						mem1 = 0;
						double currentVal = centroids.get(h);
						for(int g=0;g<centroids.size();g++)
							mem1 += Math.pow( Math.abs((keyword_array.get(i)-currentVal) / (keyword_array.get(i) - centroids.get(g))),2/(m-1)  );

						

						mem1 = 1/mem1;
						
			//			// System.out.println(mem1+" actual 1/m");
						
						memArray.add(mem1);
					}
					
					membership.add(memArray);

			//		// System.out.println("ipval cent0 cent1 "+values.get(i)+" "+centroids.get(0)+" "+centroids.get(1));
			//		mem1 += Math.pow( Math.abs((keyword_array.get(i)-centroids.get(0)) / (keyword_array.get(i) - centroids.get(0))),2/(m-1)  );
		//			// System.out.println("mem1 hap membership 0 0 - "+mem1);
		//			mem1 += Math.pow( Math.abs((keyword_array.get(i)-centroids.get(0)) / (keyword_array.get(i) - centroids.get(1))),2/(m-1)  );
			//		// System.out.println("mem1 hap membership 0 1			 - "+mem1);
					
			//		for(int k=0; k<centroids.size(); k++){
			//			// System.out.println("ipval cent0 cent1 "+values.get(i)+" "+centroids.get(j)+" "+centroids.get(k));
			//			mem1 += Math.pow( Math.abs((values.get(i)-centroids.get(j)) / (values.get(i) - centroids.get(k))),2/(m-1)  );
			//		}
					
					}
				
			
			num = findNumerator(membership,values);
			den = findDenominator(membership);
		//	// System.out.println("num - "+num);
		//	// System.out.println("den - "+den);
			centroidBackup = new ArrayList<>();

			for(int k=0; k< num.size(); k++){
				
//				// System.out.println("num/den "+k+" - "+((num.get(k)/den.get(k))));
				centroidBackup.add(num.get(k)/den.get(k));
			}
			
			centroids = centroidBackup;
			
			for(int i5=0;i5<centroids.size();i5++){
				LoggerCentroid.log(centroids.get(i5) +"\n");
			}

			Main.runFromTerminal("Rscript /home/"+username+"/workspace/NewsCluster/centroidsPlot.r /home/"+username+"/workspace/NewsCluster/valuesForThisWord /home/"+username+"/workspace/NewsCluster/centroids 4 "+search_keyword_1+" iter-"+iter);
		
		
			System.out.println("centroids - "+centroids);
			centroidBackup = new ArrayList<>();
			
			
			if(membership != null){
				System.out.println("mem"+membership);
				FindMatrixDifference(membership);
				
				
				
				if(allowed == false){
					keyword_array_1 = new ArrayList<>();
					System.out.println(iter+" iterations");
					//itr.log(iter+"\n");
					myiter.add(iter+"");
				
					
					zeroArray = new ArrayList<>();
					oneArray = new ArrayList<>();
					
					if(keyword_array.size() < 3){
						
						keyword_array_1 = keyword_array;
							}else{
					for(int i=0;i<keyword_array.size();i++){
						
						if(Math.abs(keyword_array.get(i)-centroids.get(0)) > Math.abs(keyword_array.get(i)-centroids.get(1))){
							zeroArray.add(keyword_array.get(i));
						}else{
							oneArray.add(keyword_array.get(i));
							
						}
					}
							}
					boolean compareFlag = false;

					
					if(centroids.get(1)>centroids.get(0) )
						compareFlag = true;
				if(keyword_array.size() > 2)	
					if(compareFlag)
						keyword_array_1= zeroArray;
					else
						keyword_array_1 = oneArray;
				
					
					//			System.out.println(keyword_array.size()+" izeee");
					
				//	for(int k=0;k<keyword_array.size();k++)
	//					System.out.println(keyword_array.get(k)+" "+news.get(k).split(" ")[0]+" "+k);
					lineNumbers = new ArrayList<>();
					
				for(int i=0;i<keyword_array_1.size();i++){
					
							for(int i1=0;i1<tfidfArray.size();i1++){
							
								if(tfidfArray.get(i1).split("-")[0].trim().equals(search_keyword.get(k2))){
								
				//					System.out.println(search_keyword.get(k2)+" "+tfidfArray.get(i1));
									
									if(Double.parseDouble(tfidfArray.get(i1).split("-")[2].trim()) == keyword_array_1.get(i)){
					//				System.out.println(search_keyword.get(k2)+"-"+tfidfArray.get(i1).split("-")[1].trim());
										lineNumbers.add(Integer.parseInt(tfidfArray.get(i1).split("-")[1].trim()));
										 //findNews(Integer.parseInt(tfidfArray.get(i1).split("-")[1].trim()));
										clusterNews.add(Integer.parseInt(tfidfArray.get(i1).split("-")[1].trim()));
								
								}
							}
							
						}
					
					}
			//		System.out.println("-----------------------------------------------------------------------------");
					
				clusterNews = new ArrayList<Integer>(new LinkedHashSet<Integer>(clusterNews));

				System.out.println(clusterNews);
				
				System.out.println(clusterNews.size()+" news found");
		
					documentNumber = new ArrayList<>();
				
				for(int m=0;m<clusterNews.size();m++){
					for(int m1=0;m1<documentNumbers.size();m1++){
						for(int m2=0;m2<documentNumbers.get(m1).size();m2++){
							
							if(documentNumbers.get(m1).get(m2).equals(clusterNews.get(m))){
							//	System.out.println(m1+1);
								documentNumber.add(m1+1);
							}
							
						}
					}
				}
				
				documentNumber = new ArrayList<Integer>(new LinkedHashSet<Integer>(documentNumber));
				
					for(int k4=0;k4<clusterNews.size();k4++){
						logw1.log(clusterNews.get(k4)+"\n");
					}
				
			

	Main.runFromTerminal("Rscript /home/"+username+"/workspace/NewsCluster/plotValuesClusteringData.r /home/"+username+"/workspace/NewsCluster/clusteredValues  5 "+search_keyword_1);

		for(int u=0;u<documentNumber.size();u++){
			
			String mystring = null;
			
			try{
				BufferedReader in = null;
				
			if(documentNumber.get(u)+1 < 43)
				 in = new BufferedReader(new FileReader("/home/"+username+"/workspace/NewsCluster/Original_Dataset/English"+(documentNumber.get(u)+1)+".txt"));
			else if(documentNumber.get(u)+1 > 97)
				in = new BufferedReader(new FileReader("/home/"+username+"/workspace/NewsCluster/Original_Dataset/marathi"+(documentNumber.get(u)+1)+"ToEnglish.txt"));
			else
				in = new BufferedReader(new FileReader("/home/"+username+"/workspace/NewsCluster/Original_Dataset/Hindi"+(documentNumber.get(u)+1)+"ToEnglish.txt"));
			
			String data = null;
			mystring ="";
			while((data = in.readLine()) != null){
				mystring += data+"\n";
			}
			}
			catch(Exception e){
			e.printStackTrace();	
			}
	
			finale = new LoggerFinal(search_keyword_1, documentNumber.get(u)+1);
			finale.log(mystring+"\n");
		
		}
	
		/*	for(int m=0;m<clusterNews.size();m++){
					//System.out.println(clusterNews.get(m)+" -  "+news.get(clusterNews.get(m)));
					finale.log(news.get(clusterNews.get(m)-1));
					finale.log("--------------\n\n");
				}*/
	   
	    	long stopTime = System.nanoTime();
	    	long time = (stopTime-startTime)/1000000;
	    	System.out.println("execution time for "+search_keyword_1+" without PSO "+( time)); // execution time for this word without PSO
	    //	bar.log(time+"\n");
	    
	    	mybar.add(time+"");
	    	BufferedReader bug = null;
	    	
	    	
	    	String mybug = null;
	    	
	    	try{
	    		 bug = new BufferedReader(new FileReader("barTime"));
	    		 
	    		 
	    		 while((mybug = bug.readLine()) != null){
	    			 System.out.println(mybug+" wwww");
	    		 }
	    		 
	    	}catch(Exception e){
	    		e.printStackTrace();
	    	}
	    //	   String[]	 arr = {documentNumber.size()+"", documentNumber.toString(), clusterNews.size()+"",  search_keyword_1, (time)+"", clusterNews.toString()};
	   	
	    	String arr[] = {clusterNews.size()+"",search_keyword_1,time+"",clusterNews.toString()};
	    	
	    	/*	
	   	    	 arr[0] = documentNumber.size()+"";
	   	    	 arr[1] = documentNumber.toString();
	   	    	 arr[2] = fileNames.length+"";
	   	    	 arr[3] = search_keyword_1;
	   	    	 arr[4] = (time/1000000)+"";*/
	   	    	 GUIMain3.main(arr);
	 	    	clusterNews = new ArrayList<>();

	 	    	
	 	    	
	 	    	show("centroids");
	    	
	    	if(iter>1)
	    	FuzzyCMeansWithPSO(search_keyword_1, lineNumbers);
	    	else{
	    		System.out.println("Clustering itself took 1 iteration. Cannot improvise further. Stopping here for this word..");
	    	}
	    	
	    	//show("barTime");
	    	//show("iter");
	    	//show("names");
	    		
	 
					break label1;
				}
			
			}
	}
			
			
			}
		    
		    
		    }
	
		
		
		public void findNews(int num){
			
			ArrayList<Integer> nums = new ArrayList<>();
			BufferedReader readNews = null;
			
			try{
		//		System.out.println(num+" num");
				readNews = new BufferedReader(new FileReader("/home/"+username+"/workspace/NewsCluster/cleanData/cleanData"+num+".txt"));
				
				String data = null, mystring = "";
				
				while((data = readNews.readLine()) != null){
					mystring += data;
				}
				mystring = mystring.replaceAll("\n"," ");
		//		System.out.println("mystring- "+mystring);
				//System.out.println();
				String words[] = mystring.split(" ");
				
				for(int i=0;i<words.length;i++){
					//System.out.println(words[i].trim());
					if(words[i].trim().matches("^\\d+[)]")){
						
						String mydata = words[i];
						mydata = mydata.replace(")", "");

			//			System.out.println(mydata+" "+i);
			//		System.out.println(mydata);
						
			//		System.out.println("news - "+(Integer.parseInt(mydata.trim())-1));
						
					if((Integer.parseInt(mydata.trim())-1) < news.size())	
						if(news.get(Integer.parseInt(mydata.trim())-1).contains(search_keyword_1)){
							clusterNews.add(Integer.parseInt(mydata));
					//	System.out.println(news.get(Integer.parseInt(mydata.trim())));
						}
								
					}
				}
				
				
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}


		/*****************Fuzzy C Means with PSO********/
		
	public void FuzzyCMeansWithPSO(String search_keyword, ArrayList<Integer> lineNumbers){
	
		
		long startTime = System.nanoTime();

		System.out.println("-------------------PSO--------------------");
		LoggerPSO pso = new LoggerPSO();
		//find mean for fitness function
		double sum = 0;
		
    	logk_pso = new LoggerKeywordsPSO();	

		
		for(int i=0;i<keyword_array.size();i++)
			sum += keyword_array.get(i);
		
		mean = sum/keyword_array.size();
		
System.out.println("mean "+mean);
		
		position = keyword_array;
		
		for(int i=0;i<keyword_array.size();i++){
			velocity.add(Math.random()*1);
		}
	//	System.out.println("numbers- "+keyword_array);
	//	System.out.println("velo- "+velocity);
		
		for(int i=0;i<position.size();i++){
			double fit = fitnessFunction(i, position.get(i));
			
			fitness.add(fit);
		}
		//System.out.println(" fit- "+fitness);
		
		int iterations = 10;
		int i1=0;
	//	System.out.println(position.size());
while(i1<iterations){
//	System.out.println(i1+" i");
	gBest = new ArrayList<>();
	pBest = new ArrayList<>();		
	velocityBackup = new ArrayList<>();
	positionBackup = new ArrayList<>();
	gBest1 =0;  gBest2 = 0;
			double curr = 0;
			//actual processing
			for(int j=0;j<position.size();j++){
	//		System.out.println("position "+position);
		//	System.out.println("yo"+position.get(j));
				
				double r1 = Math.random()*2 -1;
				double r2 = Math.random()*2-1;
				
				double pFit = fitnessFunction(j, position.get(j));
				
				if(pFit<0)
					pFit = 10.0;
				
				pBest.add(pFit);
			//	System.out.println(pBest+" pbest");
				int var = 0;
				if(pFit > 0){
					gBest2 = gBest2 + (pFit)/10;
					var = 1;
					curr = gBest2;
				}else{

					gBest1 = gBest1 - (pFit);
					var = 0;
					curr = gBest1;
				}
			
		//		System.out.println((c1*r1*(pBest.get(j)-position.get(j)))+" local");
		//		System.out.println((c2*r2*(curr-position.get(j)))+" global");
				velocityBackup.add(velocity.get(j)+ (c1*r1*(pBest.get(j)-position.get(j))) + (c2*r2*(curr-position.get(j))))	;
				positionBackup.add(position.get(j)+velocityBackup.get(j));
		//		System.out.println(j+" yo ");
				//System.out.println("back- "+positionBackup.get(j));
			}
			
			pso.log(i1+" -: keywords- "+keyword_array+"\n");
			pso.log(i1+"  - : position- "+positionBackup+"\n");
			//System.out.println(i+"  - : position- "+positionBackup);
			pso.log(i1+" - : velocity- "+velocityBackup+"\n");
			//System.out.println(i+" - : velocity- "+velocityBackup);
			pso.log(i1+" -: gBest- "+gBest1+" - "+gBest2+"\n");
		//System.out.println(i+" -: gBest- "+gBest1+" - "+gBest2);
		position = positionBackup;
		velocity = velocityBackup;
		gBest.add(gBest1);
		gBest.add(gBest2);
//		gBest = gBestBackup;
	i1++;
		//	System.out.println("-------------------------------------------------");
	}
		
if(position == null){
	System.out.println("Word not found with PSO - "+search_keyword_1);
	System.exit(0);
}
	keyword_array = position;


	centroids = new ArrayList<>();
	
	
	
	LoggerKeywords1PSO logw1_pso = new LoggerKeywords1PSO();
	LoggerCentroidWithPSO logcent_pso = new LoggerCentroidWithPSO();
	
	
	for(int k3=0;k3<keyword_array.size();k3++){
//		System.out.println("Logging "+keyword_array.get(k3));
		LoggerKeywordsPSO.log(keyword_array.get(k3)+"\n");
	}
		

	
	centroids.add(gBest.get(0));
	centroids.add(gBest.get(1));
	
	allowed = true;
	iter = 0;
	// Step 1 : Calculate membership matrix using the centroids assigned intitally and then update accordingly
label1:while(allowed){
	
	logcent_pso = new LoggerCentroidWithPSO();

	iter++;
membership = new ArrayList<>();

num = new ArrayList<>();
den = new ArrayList<>();
//// System.out.println("centroids new one"+centroids);

	for(int i=0; i<keyword_array.size(); i++){ 

			
		
    	logw1_pso = new  LoggerKeywords1PSO();
    			
		
		memArray = new ArrayList<>();
		
			mem1 = 0;
			
	//		// System.out.println("ipval cent0 cent1 "+values.get(i)+" "+centroids.get(0)+" "+centroids.get(1));
			mem1 += Math.pow( Math.abs((keyword_array.get(i)-centroids.get(0)) / (keyword_array.get(i) - centroids.get(0))),2/(m-1)  );
//			// System.out.println("mem1 hap membership 0 0 - "+mem1);
			mem1 += Math.pow( Math.abs((keyword_array.get(i)-centroids.get(0)) / (keyword_array.get(i) - centroids.get(1))),2/(m-1)  );
	//		// System.out.println("mem1 hap membership 0 1			 - "+mem1);
			
	//		for(int k=0; k<centroids.size(); k++){
	//			// System.out.println("ipval cent0 cent1 "+values.get(i)+" "+centroids.get(j)+" "+centroids.get(k));
	//			mem1 += Math.pow( Math.abs((values.get(i)-centroids.get(j)) / (values.get(i) - centroids.get(k))),2/(m-1)  );
	//		}
			
			mem1 = 1/mem1;
			
//			// System.out.println(mem1+" actual 1/m");
			
			memArray.add(mem1);
			memArray.add(1-mem1);
			membership.add(memArray);
			}
		
	
	num = findNumerator(membership,values);
	den = findDenominator(membership);
//	// System.out.println("num - "+num);
//	// System.out.println("den - "+den);
	

	
	centroidBackup = new ArrayList<>();

	for(int k=0; k< num.size(); k++){
		
//		// System.out.println("num/den "+k+" - "+((num.get(k)/den.get(k))));
		centroidBackup.add(num.get(k)/den.get(k));
	}


	centroids = centroidBackup;
	
	for(int i5=0;i5<centroids.size();i5++){
		LoggerCentroidWithPSO.log(centroids.get(i5) +"\n");
	}
	
	

	System.out.println(search_keyword_1);
	
	show("centroidsPSO");
	show("valuesForThisWordPSO");
	
	Main.runFromTerminal("Rscript /home/"+username+"/workspace/NewsCluster/centroidPlotPSO.r /home/"+username+"/workspace/NewsCluster/valuesForThisWordPSO /home/"+username+"/workspace/NewsCluster/centroidsPSO  7 "+search_keyword_1+" iter-"+iter);

	
	 System.out.println("centroids - "+centroids);
	centroidBackup = new ArrayList<>();
	
	
	if(membership != null){
		System.out.println("mem"+membership);
		FindMatrixDifference(membership);
		if(allowed == false){
			keyword_array_1 = new ArrayList<>();
			System.out.println(iter+" iterations with PSO");
			//itr.log(iter+"\n");
			myiter.add(iter+"");
			zeroArray = new ArrayList<>();
			oneArray = new ArrayList<>();
			if(keyword_array.size() < 3){
				keyword_array_1 = keyword_array;
					}else{
			for(int i=0;i<keyword_array.size();i++){
				
				if(Math.abs(keyword_array.get(i)-centroids.get(0)) > Math.abs(keyword_array.get(i)-centroids.get(1))){
					zeroArray.add(keyword_array.get(i));
				}else{
					oneArray.add(keyword_array.get(i));
					
				}
			}
			
			boolean compareFlag = false;

			if(centroids.get(1)>centroids.get(0))
				compareFlag = true;
			
			if(compareFlag)
				keyword_array_1= zeroArray;
			else
				keyword_array_1 = oneArray;
				
			
		
	//			System.out.println(keyword_array.size()+" izeee");
			
		//	for(int k=0;k<keyword_array.size();k++)
//					System.out.println(keyword_array.get(k)+" "+news.get(k).split(" ")[0]+" "+k);

		for(int i=0;i<keyword_array_1.size();i++){
		
			if(i<lineNumbers.size())
				clusterNews.add(lineNumbers.get(i));		
				//findNews(lineNumbers.get(i));

					
				
			
			}
			
	//			System.out.println(keyword_array.size()+" izeee");
			
		//	for(int k=0;k<keyword_array.size();k++)
//					System.out.println(keyword_array.get(k)+" "+news.get(k).split(" ")[0]+" "+k);

	
	//		System.out.println("-----------------------------------------------------------------------------");


		System.out.println(clusterNews);
		
		System.out.println(clusterNews.size()+" news found");
		
		documentNumber = new ArrayList<>();
		
		for(int m=0;m<clusterNews.size();m++){
			for(int m1=0;m1<documentNumbers.size();m1++){
				for(int m2=0;m2<documentNumbers.get(m1).size();m2++){
					
					if(documentNumbers.get(m1).get(m2).equals(clusterNews.get(m))){
						documentNumber.add(m1+1);
					}
					
				}
			}
		}
		
		
		
		for(int k4=0;k4<documentNumber.size();k4++)
			logw1_pso.log(documentNumber.get(k4)+"\n");
			
		documentNumber = new ArrayList<Integer>(new LinkedHashSet<Integer>(documentNumber));

		}
		

	Main.runFromTerminal("Rscript /home/"+username+"/workspace/NewsCluster/plotValuesClusteringDataPSO.r /home/"+username+"/workspace/NewsCluster/clusteredValuesPSO  8 "+search_keyword_1);

//			for(int h=0;h<news.size();h++)
//		System.out.println(news.get(h));
		// if the directory does not exist, create it

	for(int u=0;u<documentNumber.size();u++){
		
		String mystring = null;
		
		try{
		BufferedReader in = new BufferedReader(new FileReader("/home/"+username+"/workspace/NewsCluster/cleanData/cleanData"+(documentNumber.get(u)+1)+".txt"));
	
		String data = null;
		mystring ="";
		while((data = in.readLine()) != null){
			mystring += data+"\n";
		}
		}
		catch(Exception e){
		e.printStackTrace();	
		}

		finalePSO = new LoggerFinalWithPSO(search_keyword_1, documentNumber.get(u)+1);
		finalePSO.log(mystring+"\n");
	
	}
	
			break label1;
			
		}
	
	}

	
	
	}
	long stopTime = System.nanoTime();
	double timePSO = (stopTime - startTime)/1000000;
	System.out.println("execution time for "+search_keyword_1+" with PSO"+(timePSO));
	//arr[5] = timePSO+"";
	//GUIMain3.main(arr);

   // String[]	 arr = {documentNumber.size()+"", documentNumber.toString(), fileNames.length+"", search_keyword_1, (timePSO)+"", clusterNews.toString()};
	
	  // String[]	 arr = {documentNumber.size()+"", documentNumber.toString(), clusterNews.size()+"",  search_keyword_1, (timePSO)+"", clusterNews.toString()};
   		String arr[] = {clusterNews.size()+"",search_keyword_1,timePSO+"",clusterNews.toString()};

	/*	
    	 arr[0] = documentNumber.size()+"";
    	 arr[1] = documentNumber.toString();
    	 arr[2] = fileNames.length+"";
    	 arr[3] = search_keyword_1;
    	 arr[4] = (time/1000000)+"";*/
   // System.out.println("yo");
    GUIMain4.main(arr);
	clusterNews = new ArrayList<>();

    mybar.add(timePSO+"");
    
    for(int j4=0;j4<mybar.size();j4++)
    	bar.log(mybar.get(j4)+"\n");
   // bar.log(timePSO+"\n");
    
    

    for(int j4=0;j4<myiter.size();j4++)
    	itr.log(myiter.get(j4)+"\n");
    
/*	BufferedReader bug = null;
	
	
	String mybug = null;
	
	try{
		 bug = new BufferedReader(new FileReader("barTime"));
		 
		 
		 while((mybug = bug.readLine()) != null){
			 System.out.println(mybug+" wwww");
		 }
		 
	}catch(Exception e){
		e.printStackTrace();
	}*/
    

    System.out.println("---------------------------------------------------------------------------------\n\n");
	} // end of fcm with PSO
	
	
	
	public Double fitnessFunction(int i,double fit){
		
		double fitnessValue = fit + ((fit-mean)/10);
		
		
		return fitnessValue;
	}
		
	// end of fcmwithoutPSO
	
	
	
	public void show(String s){
		
		BufferedReader in = null;
	
	try{
		
		
		in = new BufferedReader(new FileReader("/home/"+username+"/workspace/NewsCluster/"+s));
		
		String mydata = null;
		
		
		while((mydata = in.readLine()) != null)
			System.out.println(""+mydata);
		
	}catch(Exception e){
		e.printStackTrace();
	}
	
		
		
		
	}


		public ArrayList<Double> findNumerator(ArrayList<ArrayList<Double>> membership2, ArrayList<Double> values){
			ArrayList<Double> num = new ArrayList<>();
			double mem1 = 0, mem2 = 0;
		
			for(int i=0; i<(keyword_array.size()); i++){
				
				int j =0;
				mem1 += (Math.pow(membership.get(i).get(j), m)*keyword_array.get(i));
		//		// System.out.println("j=0 i= "+i+" input-"+values.get(i)+"  membe - "+membership.get(i).get(j)+" mem1 - "+ (Math.pow(membership.get(i).get(j), m)*values.get(i)));

				//	// System.out.println("0 - "+membership.get(i).get(j));
				j = 1;

				mem2 += (Math.pow(membership.get(i).get(j), m)*keyword_array.get(i));
		//		// System.out.println("j=1 i= "+i+" input-"+values.get(i)+"  membe - "+membership.get(i).get(j)+" mem1 - "+ (Math.pow(membership.get(i).get(j), m)*values.get(i)));

			//	// System.out.println("1 - "+membership.get(i).get(j));
			}
		
	
			
			
			
			
			
			num.add(mem1);
			num.add(mem2);
			return num;
		}
		
		public ArrayList<Double> findDenominator(ArrayList<ArrayList<Double>> membership2){
			ArrayList<Double> num = new ArrayList<>();
			double mem1 = 0, mem2 = 0;
			int k=0;
			for(int i=0; i<keyword_array.size(); i++){
				int j =0;
				mem1 += (Math.pow(membership.get(i).get(j), m));
//				// System.out.println("mem1 - "+mem1);
//				// System.out.println("den j = 0 "+(Math.pow(membership.get(i).get(j), m)));
				j = 1;
				mem2 += (Math.pow(membership.get(i).get(j), m));
//				// System.out.println("den j = 1 "+(Math.pow(membership.get(i).get(j), m)));
			}
			
			num.add(mem1);
			num.add(mem2);
			return num;
		}
		
		public void FindMatrixDifference(ArrayList<ArrayList<Double>> membership){
			
			boolean flag = false;
			int index = 0;
			ArrayList<Double> incr = new ArrayList<>();

			double diff = 0;
			for(int i=0; i<keyword_array.size(); i++){
				if(i==0)
					diff =  Math.abs(membership.get(i).get(0) - membership.get(i).get(1));
				
				if( Math.abs(membership.get(i).get(0) - membership.get(i).get(1)) > 0.2){
				//	System.out.println(" lol "+membership.get(i).get(0)+" "+membership.get(i).get(1)+" "+ Math.abs(membership.get(i).get(0) - membership.get(i).get(1)));

					if( Math.abs(membership.get(i).get(0) - membership.get(i).get(1)) < diff){
						diff =  Math.abs(membership.get(i).get(0) - membership.get(i).get(1));
					}
				//	System.out.println(diff+" diff ");
					index++;
				
					}
			/*	if(Math.abs(membership.get(i).get(0) - membership.get(i).get(1)) < 0.1){
					incr.add(membership.get(i).get(0)+0.09);
				incr.add(membership.get(i).get(1)-0.09);
					// System.out.println("-------------");
					// System.out.println("old membership"+membership.get(i));

					membership.get(i).add(incr.get(0));
					membership.get(i).add(incr.get(1));
					membership.get(i).remove(0);
					membership.get(i).remove(1);
					// System.out.println("new membership"+membership.get(i));
					// System.out.println("-----end-------");
				}*/
			
			
			}
			if(diff> 0.2  && index > 0.7*keyword_array.size()-1){
				//System.out.println("final diff "+diff);
				allowed = false;
			}
		}
		
	

		


	
}
		

	