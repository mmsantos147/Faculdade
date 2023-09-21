
fix(Teste)
fix(Teste)
Teste2 <- 
  readXL("/home/2022.1.08.025/Downloads/Dados_Est_Clientes_Drogaria.xlsx", 
  rownames=FALSE, header=TRUE, na="", sheet="Planilha1", 
  stringsAsFactors=TRUE)
load("/home/2022.1.08.025/Downloads/Dados_Est_Clientes_Drogaria.xlsx")
library(abind, pos=19)
library(e1071, pos=20)
numSummary(Teste2[,"Renda_Familiar", drop=FALSE], statistics=c("mean", "sd",
   "IQR", "quantiles"), quantiles=c(0,.25,.5,.75,1))
numSummary(Teste2[,"Renda_Familiar", drop=FALSE], statistics=c("mean", "sd",
   "IQR", "quantiles"), quantiles=c(0,.25,.5,.75,1))

