username <- Sys.info()[["user"]]

pathName <- paste(c("/home/",username, "/workspace/NewsCluster/cluster_plots"),collapse="")

setwd(pathName)

args <- commandArgs(trailingOnly = TRUE)

#value1 <- args[1]
#value2 <- args[2]
plot.new()


value1 <- "valuesForThisWord"

value2 <- "centroids"

d <- read.table(value1)

d2 <- read.table(value2)


#total <- cbind(d, d2)


plot(d, col="blue", axes=FALSE, xlab = "TFIDF Values")
axis(side = 1, at = c(1:1000))

#mydata <- total[,2][1:2]


par(new = T)
  plot(d2, col="red", pch=4, cex=2, axes=FALSE, xlab = "TFIDF Values")
  