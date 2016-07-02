#!/bin/bash
cd /home/deepa/hadoop
bin/hadoop dfsadmin -safemode leave
#fuser -k -n tcp 50070
#fuser -k -n tcp 50090
#fuser -k -n tcp 50075
#fuser -k -n tcp 8062
#fuser -k -n tcp 8061


rm -rf hadoop_data/*
rm -rf logs
/home/deepa/hadoop/sbin/stop-all.sh

bin/hdfs namenode -format

/home/deepa/hadoop/sbin/start-all.sh



 

bin/hdfs dfs -rm -r /home/deepa/hadoop/input
bin/hdfs dfs -rm -r /home/deepa/hadoop/output
bin/hdfs dfs -rm -r /home/deepa/hadoop/user/deepa

jps
bin/hadoop dfsadmin -safemode leave
cd /home/deepa/hadoop
bin/hdfs dfs -mkdir -p /home/deepa/hadoop/input
bin/hdfs dfs -copyFromLocal /home/deepa/workspace/NewsCluster/Stem/* /home/deepa/hadoop/input/
bin/hadoop jar /home/deepa/workspace/NewsCluster/tfidf.jar /home/deepa/hadoop/input /home/deepa/hadoop/output
truncate -s 0 ~/workspace/NewsCluster/finalOutput.txt
bin/hdfs dfs -cat /home/deepa/hadoop/output/part-r-00000 >> ~/workspace/NewsCluster/finalOutput.txt
#bin/hdfs dfs -cat /home/deepa/hadoop/output/part-r-00000

