


args <- commandArgs(trailingOnly = TRUE)

value1 <- args[1]
value2 <- args[2]
m <- args[3]
iter <- args[5]
word <- args[4]



link <- paste(c("/home/deepa/workspace/NewsCluster/cluster_plots", word) , collapse="_")


setwd(link)


word2 <- paste(toString(word),iter,sep="_")


#print(word)




plotData <- function(value1, value2, j, word2, iter){
  
  
  d <- read.table(value1)
  
  d2 <- read.table(value2)
  
  my <- paste(value1,value2, sep="_")
  
  my <- as.expression(my)
  
  filename <- strsplit(toString(my),"/")
  
  filename <- filename[[1]][length(filename[[1]])]
  
  filename2 <- paste(toString(filename),word2, sep="_")
  
  
  
  mypath <- paste("/home/deepa/workspace/NewsCluster/cluster_plots",word,sep="_")
  
  setwd(mypath)
  

  name <- paste(c("plot", j,filename2,".pdf"), collapse = "_")
  pdf(name)
  
  

  

  plot(d, col="blue", axes=FALSE, xlab = "TFIDF Values")
  
  
  par(new = T)
  plot(d2, col="red", pch=4, cex=2, axes = FALSE)
  
  
  axis(side = 1, at = c(1:1000))
  
  #plot(d,col=colr, type="p", main=filename, pch=1)


}



myPlot <- plotData(value1, value2, m, word2, iter )
