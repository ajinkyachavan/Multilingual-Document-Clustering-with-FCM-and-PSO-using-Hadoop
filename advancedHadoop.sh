#!/bin/bash

cd usr/local/hadoop
#bin/hdfs dfs -rm -r /usr/hadoop/input
#/home/ajinkya/hadoop/sbin/start-all.sh

#bin/hdfs dfs -rm -r ~/hadoop/output
#bin/hdfs dfs -rm -r /user/ajinkya
#/home/ajinkya/hadoop/sbin/stop-all.sh
#/home/ajinkya/hadoop/sbin/start-all.sh
jps
cd /usr/local/hadoop
#/home/ajinkya/hadoop/bin/hdfs namenode -format -force
#bin/hdfs dfs -mkdir -p ~/hadoop/input
#bin/hdfs dfs -copyFromLocal /home/ajinkya/workspace2/NewsArticleClusteringHadoop/cleanData/*  ~/hadoop/input/
bin/hadoop jar /home/ajinkya/workspace2/NewsArticleClusteringHadoop2/tfidf.jar /usr/local/hadoop/input /usr/local/hadoop/output
bin/hdfs dfs -cat /usr/local/hadoop/output/part-r-00000 >> ~/workspace2/NewsArticleDocuClustering/finalOutput.txt

