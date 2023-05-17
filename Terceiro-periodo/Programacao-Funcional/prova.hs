-- Exercicio 1
type Cidade = String
type Pass = Int
type Hosp = Int
type Brinde = (Cidade, Pass, Hosp)

-- (a)
type Periodo = Int
mapa :: Periodo -> Brinde 
mapa 1 = ("Natal", 21,34)
mapa 2 = ("Bertioga", 17,65)
mapa 3 = ("Rio de Janeiro", 9,10)
mapa 4 = ("Curitiba", 3,54)
mapa 5 = ("Petrolina", 2,9)
mapa 6 = ("Salvador", 0,1)
mapa 7 = ("Teresina", 21,56)
mapa _ = ("", 0,0)

-- (b)
nCidade :: Brinde -> Cidade
nCidade (x,_,_) = x

nPassagens :: Brinde -> Pass
nPassagens (_,x,_) = x

nHospedagens :: Brinde -> Hosp
nHospedagens (_,_,x) = x

-- (c)
totalPassagens :: Periodo -> Pass
totalPassagens 0 = 0
totalPassagens x = nPassagens(mapa x) + totalPassagens (x-1)

-- (d)
totalHospedagens :: Periodo -> Hosp
totalHospedagens 0 = 0
totalHospedagens x = nHospedagens(mapa x) + totalHospedagens (x-1)

-- (e)
buscaCidade :: Cidade -> Periodo -> (Int, Pass, Hosp)
buscaCidade x y
    | x == nCidade(mapa y) = (y, nPassagens(mapa y), nHospedagens (mapa y))
    | otherwise = buscaCidade x (y-1)

-- (f)
verificaHospedagem :: (Cidade, Pass, Hosp) -> Periodo -> Bool
verificaHospedagem (_,_,_) 0 = False
verificaHospedagem (x, y, z) p
    | x == nCidade(mapa p) && y <= nPassagens(mapa p) && z <= nHospedagens(mapa p) = True
    | otherwise = verificaHospedagem (x,y,z) (p-1)

--tupla = [(1,2),(4,3),(5,5)]
verificaDupla1 :: (Int, Int) -> Int
verificaDupla1 (x, y)
    | x `mod` 2 /= 0 = x
    | y `mod` 2 /=0 = y
    | otherwise = 0

tuplaImpar :: [(Int, Int)] -> [Int]
tuplaImpar [] = []
tuplaImpar (a:b) 
    | verificaDupla1 a /= 0 =  verificaDupla1 a : tuplaImpar b  
    | otherwise = tuplaImpar b

--Lista ordenada
insereOrd :: Int -> [Int] -> [Int]
insereOrd x [] = [x]
insereOrd x (a:b)
    | x<=a = x:a:b
    | otherwise = a:(insereOrd x b)

ordenaLista :: [Int] -> [Int]
ordenaLista [] = []
ordenaLista (a:b) = insereOrd a (ordenaLista b)

ordenaListaLista ::  [[Int]] -> [[Int]]
ordenaListaLista [] = []
ordenaListaLista (a:b) = (ordenaLista a) : (ordenaListaLista b)