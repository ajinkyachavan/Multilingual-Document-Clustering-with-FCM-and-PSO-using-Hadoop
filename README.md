# Multilingual-Document-Clustering-with-FCM-and-PSO-using-Hadoop

Summary 
------------------------

- Newspapers documents  Hindi and Marathi converted to English
- Clean the data using NLP techniques (lemmatization + removed stop words and other relatively useless components)
- Apply TFIDF to all the documents using Hadoop with Java - initHadoop.sh (hadoop 2.7.4 on Ubuntu 16.04)
- To search for a word in the documents, Apply Fuzzy C-Means and a combination of Fuzzy C-Means with PSO(Particle Swarm Optimization)
- Java Swing to implement GUI
- R with Java using shell processing for graphs and charts


Instructions to run
---------------------------

- Use Ubuntu
- Install Hadoop, R on Ubuntu
- Download snowball.jar (http://www.java2s.com/Code/Jar/s/Downloadsnowball10jar.htm)
- Right click on Project -> Properties -> Java Build Path -> Libraries -> Add External Jars -> Select snowball.jar from your compter

- This project contains preprocessed TFIDF with hadoop. If you want to run hadoop uncomment the following lines in Main.java:

  //	runFromTerminal(" chmod a+x  initHadoop.sh");
	//	runFromTerminal(" ./initHadoop.sh");
  
  - Hadoop processing takes 10-15 minutes. To check the status, go to hadoop localhost site at the port 
    you set during installation to see the progress of processing

- If you choose not to uncomment those lines, then you can directly run the program. 
  You will get a search box to input the word to search. You can search one word or 
  a combination of words to be processed
 
