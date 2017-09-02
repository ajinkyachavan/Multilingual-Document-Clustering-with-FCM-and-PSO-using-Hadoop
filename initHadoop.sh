#!/bin/bash
#fuser -k -n tcp 50070
#fuser -k -n tcp 50090
#fuser -k -n tcp 50075
#fuser -k -n tcp 8062
#fuser -k -n tcp 8061

cd /usr/local/hadoop
hdfs dfsadmin -safemode leave

rm -rf /app/hadoop/tmp
rm -rf /usr/local/hadoop_store/*
rm -rf logs
/usr/local/hadoop/sbin/stop-all.sh

echo stopped


bin/hdfs namenode -format 

echo formatted

/usr/local/hadoop/sbin/start-all.sh

echo started

 

hdfs dfs -rm -r /usr/local/hadoop/input
hdfs dfs -rm -r /usr/local/hadoop/output
hdfs dfs -rm -r /usr/local/hadoop/user/ajinkya

echo jps
jps


bin/hdfs dfsadmin -safemode leave

echo left



bin/hdfs dfs -mkdir -p /usr/local/hadoop/input

echo input created

bin/hdfs dfs -copyFromLocal ~/workspace/NewsCluster/cleanData/* /usr/local/hadoop/input/


bin/hadoop jar ~/Documents/tfidf.jar /usr/local/hadoop/input /usr/local/hadoop/output
truncate -s 0 ~/workspace/NewsCluster/finalOutput.txt
bin/hdfs dfs -cat /usr/local/hadoop/output/part-r-00000 >> ~/workspace/NewsCluster/finalOutput.txt
#bin/hdfs dfs -cat /usr/local/hadoop/output/part-r-00000

