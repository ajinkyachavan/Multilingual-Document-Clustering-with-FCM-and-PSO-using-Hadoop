

setwd("/home/deepa/workspace/NewsCluster/")

args <- commandArgs(trailingOnly = TRUE)



value <- args[1]

dirname <- args[2]


link <- paste(c("/home/deepa/workspace/NewsCluster/cluster_plots", dirname) , collapse="_")

setwd(link)

#print(paste(c( value," value"), collapse = "_"))
#print(paste(c(m," number"), collapse = "_"))




plotData <- function(value){

  
#  print(value)
 # print(m)
  
my <- value
  
#print(my)



d <- read.table(my)



my <- as.expression(my)

filename <- strsplit(toString(my),"/")

filename <- filename[[1]][length(filename[[1]])]




name <- paste(c("iterPlot", filename, ".pdf"), collapse = "_")
pdf(name)


#plot(d,col="red",main=filename, pch=4, xlab = "TFIDF Values")

d1 <- as.matrix(d) 

#d <- c(8,1)

barplot(d1[,1], xlab="FCM vs FCM with PSO", ylab="Iterations", col="blue")

}

myPlot <- plotData(value)




