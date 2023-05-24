-- Exercicio 1

fa :: Int->Int
fa x
    | x>= 0 = (x+4) `div` (x+2)
    | otherwise = 2 `div` x

fb :: Int->Int->Int
fb x y
    | x >= y = x + y 
    | otherwise = x - y

fc :: Int->Int->Int->Int
fc x y z
    | (x + y) > z = x + y + z
    | (x + y) < z = x - y - z
    | otherwise = 0
    
-- Exercicio 3

soma :: Int->Int->Int
soma _ 0 = 0
soma x y = x + soma x (y-1)

-- Exercicio 4

intToList :: Int->Int->[Int]
intToList 0 _ = []
intToList x y 
    | (x - (10 ^ y)) >= 0 = intToList x (y + 1) ++ [(x `mod` (10 ^ y)) `div` (10 ^ (y - 1))]
    | otherwise = [(x `mod` (10 ^ y)) `div` (10 ^ (y - 1))]

inverte :: [Int]->Int->Int
inverte [] _ = 0
inverte (a:b) y = a * (10 ^ y) + inverte b (y + 1)

inverteInt :: Int->Int
inverteInt x = inverte (intToList x 1) 0

-- Exercicio 5

square :: Int -> Int
square x = x * x

fourPower :: Int -> Int
fourPower x = (square x) * (square x)

-- Exercicio 6

raizInfi :: Float -> Float
raizInfi 0 = 0
raizInfi x = sqrt(6) + raizInfi (x - 1)

-- Exercicio 7

-- Exercicio 8

mdc :: Int -> Int -> Int
mdc x y
    |x `mod` y /= 0 = mdc y (x `mod` y)  
    |otherwise = y

-- Exercicio 9

howManyMultiples :: Int -> Int -> Int -> Int 
howManyMultiples _ _ 0 = 0
howManyMultiples x y z
    | z `mod` x == 0 = howManyMultiples x y (z - 1) +  1
    | otherwise =  howManyMultiples x y (z - 1)

-- Exercicio 10

lastDigit :: Int -> Int
lastDigit x = x `mod` 10

-- Exercicio 11

--Resolução MAGNETUDE

--Resolução clean

-- Exercicio 12

allDifferent :: Int -> Int -> Int -> Bool
allDifferent m n p = (m /= n) && (n /= p) && (m/=p)

-- Exercicio 13

howManyEqual :: Int -> Int -> Int -> Int
howManyEqual x y z
    | x == y && x == z = 3
    | x == y || y == z || x == z = 2
    | otherwise = 0

-- Exercicio 14

-- Exercicio 15

fib ::  Int -> Int
fib 0 = 1
fib 1 = 1
fib x = fib(x-1) + fib(x-2)

