

setwd("/home/deepa/workspace/NewsCluster/")

args <- commandArgs(trailingOnly = TRUE)



value <- args[1]
m <- args[2]

#print(paste(c( value," value"), collapse = "_"))
#print(paste(c(m," number"), collapse = "_"))




plotData <- function(value, j){

  
#  print(value)
 # print(m)
  
my <- value
  
#print(my)



d <- read.table(my)



my <- as.expression(my)

filename <- strsplit(toString(my),"/")

filename <- filename[[1]][length(filename[[1]])]




name <- paste(c("plot", j,filename, ".pdf"), collapse = "_")
pdf(name)


plot(d,col="red",main=filename, pch=4, xlab = "TFIDF Values")



}

myPlot <- plotData(value, m)




