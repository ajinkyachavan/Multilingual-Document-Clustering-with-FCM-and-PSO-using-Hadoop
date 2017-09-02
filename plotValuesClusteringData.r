


args <- commandArgs(trailingOnly = TRUE)

value <- args[1]
m <- args[2]
word <- args[3]


username <- Sys.info()[["user"]]


link <- paste(c("/home/",username, "/workspace/NewsCluster/"),collapse="")

#link <- paste(c(pathName, word) , collapse="_")

print(link)
setwd(link)



#mkdirs <- function(fp) {
 # if(!file.exists(fp)) {
 #   mkdirs(dirname(fp))
 #   dir.create(fp)
 # }
#} 


plotData <- function(value1, j, word){
  
  
  
  my <- value1
  
  
  
  
  
  d <- read.table(my)
  
  
  
  my <- as.expression(my)
  
  filename <- strsplit(toString(my),"/")
  
  filename <- filename[[1]][length(filename[[1]])]
  
  filename <- paste(toString(filename),word, sep="_")
  
  
  #mkdirs(paste("cluster", word, sep="_"))
  
  
  #setwd(paste("cluster",word,sep="_"))

  name <- paste(c("plot", j,filename, ".pdf"), collapse = "_")
  pdf(name)
  
  label <- paste(c("TFIDF Values",word), collapse="_")

  plot(d,col="red",main=filename, pch=19, xlab = label)
  
  

}



myPlot <- plotData(value, m, word)



