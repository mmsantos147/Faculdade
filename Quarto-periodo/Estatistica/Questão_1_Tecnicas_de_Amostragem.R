# Autor: Matheus Martins dos Santos
Dataset <- readXL("C:/Users/diohe/Downloads/Dados_Renda_Trabalho01 (1).xlsx", rownames=FALSE, header=TRUE, na="", 
  sheet="Dados_Trabalho_01", stringsAsFactors=TRUE)

# Ínicio questão 1

#Convertendo a variavel Situação laboral em fator
Dataset <- within(Dataset, {
  Situacao_Laboral <- as.factor(Situacao_Laboral)
})

#Selecionando Dados
dados <- Dataset$renda

#Definindo o Tamanho da amostragem
N<-length(dados)

n<-150

#Armazenando a variavel Situacao Laboral
situacao_laboral<-Dataset$Situacao_Laboral

#Verificando quantos elementos tem na população de cada situação
N1<-53663 
N2<-11704
N3<-3733 
N4<-2055  
N5<-1994   
N6<-331   
N7<-179

#Definindo tamanho população e amostra
TamanhoPop<-c(N1,N2,N3,N4,N5,N6,N7)
TamanhoPop

TamanhoAmos<-round((TamanhoPop/N)*n,0)
TamanhoAmos

# Fim questão 1

# Ínicio questão 2

#Separando as situações da população de cada estrato
situacao1<-c()
situacao2<-c()
situacao3<-c()
situacao4<-c()
situacao5<-c()
situacao6<-c()
situacao7<-c()

c1<-1
c2<-1
c3<-1
c4<-1
c5<-1
c6<-1
c7<-1

for(i in 1:N) {
    if(situacao_laboral[i]=="1") {
	situacao1[c1]<-dados[i]
	c1<-c1+1
    } else if (situacao_laboral[i]=="2") {
          situacao2[c2]<-dados[i]
	  c2<-c2+1
    } else if(situacao_laboral[i]=="3") {
    	  situacao3[c3]<-dados[i]
	  c3<-c3+1
    } else if(situacao_laboral[i]=="4") {
          situacao4[c4]<-dados[i]
	  c4<-c4+1
    } else if(situacao_laboral[i]=="5") {
          situacao5[c5]<-dados[i]
	  c5<-c5+1
    } else if(situacao_laboral[i]=="6") {
          situacao6[c6]<-dados[i]
	  c6<-c6+1
    } else if (situacao_laboral[i]=="7") {
          situacao7[c7]<-dados[i]
	  c7<-c7+1
    }
}

situacao1
situacao2
situacao3
situacao4
situacao5
situacao6
situacao7

#Sorteio das amostras
amostra1<-sample(situacao1,TamanhoAmos[1])
amostra2<-sample(situacao2,TamanhoAmos[2])
amostra3<-sample(situacao3,TamanhoAmos[3])
amostra4<-sample(situacao4,TamanhoAmos[4])
amostra5<-sample(situacao5,TamanhoAmos[5])
amostra6<-sample(situacao6,TamanhoAmos[6])
amostra7<-sample(situacao7,TamanhoAmos[7])

amostraest<-c(amostra1,amostra2,amostra3,amostra4,amostra5,amostra6,amostra7)
amostraest

# Fim questão 2

# Inicio questão 3

#Realizando a média da amostra
mediaest<-mean(amostraest)
mediaest

# Fim questão 3
