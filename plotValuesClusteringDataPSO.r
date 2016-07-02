


args <- commandArgs(trailingOnly = TRUE)

value <- args[1]
m <- args[2]
word <- args[3]


link <- paste(c("/home/deepa/workspace/NewsCluster/cluster_plots", word) , collapse="_")


setwd(link)



plotData <- function(value1, j, word){
  
  
  
  my <- value1
  
  
  
  
  
  d <- read.table(my)
  
  
  
  my <- as.expression(my)
  
  filename <- strsplit(toString(my),"/")
  
  filename <- filename[[1]][length(filename[[1]])]
  
  filename <- paste(toString(filename),word, sep="_")
  
  
  #mkdirs(paste("cluster", word, sep="_"))
  
  
  #setwd(paste("cluster",word,sep="_"))

  name <- paste(c("pso_plot", j,filename, ".pdf"), collapse = "_")
  pdf(name)
  
  
  plot(d,col="red",main=filename, pch=19, xlab = "TFIDF Values")
  
  

}



myPlot <- plotData(value, m, word)



