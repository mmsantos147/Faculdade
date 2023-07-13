% Lista 2
% Exercicio 1:

% Exercicio 2:

a:-a(0).
a(X):- X>10,!.
a(X):- write(X),write(' '), X1 is X+1,a(X1).

% Exercicio 3:

wN(0):-write(0),!.
wN(N):-write(N),N1 is N-1, wN(N1),write(N).

espaco(0) :- !.
espaco(N) :- write(' '), N1 is N-1, espaco(N1).

f3(X) :- f3(X, 0).
f3(0,Y) :- espaco(0), wN(Y).  
f3(X,Y) :- espaco(X), wN(Y), X1 is X-1, Y1 is Y+1, nl, f3(X1,Y1).

wE(0) :- !.
wE(X) :- write(' '), X1 is X-1, wE(X1).

pyramid(X) :- forall(between(0,X,I),(X1 is X-I, wE(X1),wN(I),nl)).

% Exercicio 4:

f4(X,0,R) :- R is 1.
f4(X,Y,R) :- Y1 is Y-1, f4(X, Y1, R1), X1 is X * X, R is X1 * R1.

% Exercicio 5 

d(0).
d(1).

% Exercicio 6

palindromo(X) :- reverse(X,X1), X1 = X. 

% Exercicio 7

metIguais2(Lista) :- append(Metade, Metade, Lista), !.

% Exercicio 8

insereOrd(X,[Y|L], [Y|Io]) :-
    X > Y, !, 
    insereOrd(X,L,Io).
insereOrd(X,[Y|L], [X,Y|L]).

% Exercicio 9


% Exercicio 10


% Exercicio 11


% Exercicio 12


% Exercicio 13


% Exercicio 14

transforma('encher o jarro 1', [X,Y], [3,Y]) :- X < 3.
transforma('enchar o jarro 2', [X,Y], [X,4]) :- Y < 3.
transforma('esvaziar o jarro 1', [X,Y], [0,Y]) :- X > 0.
transforma('esvaziar o jarro 2', [X,Y], [X,0]) :- Y > 0.
transforma('transferir do jarro 1 para o 2', [X,Y], [0,Baldao]) :- X > 0, Y < 4, Baldao is X + Y, Baldao =< 4.
transforma('transferir do jarro 2 para o 1', [X,Y], [Baldao,0]) :- Y > 0, X < 3, Baldao is X + Y, Baldao =< 3.
%--- considerando que ainda restara agua no jarro de origem
transforma('transferir do jarro 1 para o 2', [X,Y], [Baldao,4]) :- X > 0, Y < 4, Baldao is X + Y - 4, X + Y > 4.
transforma('transferir do jarro 2 para o 1', [X,Y], [3,Baldao]) :- Y > 0, X < 3, Baldao is X + Y - 3, X + Y > 3.

% Jarro1 = 0L
% Jarro2 = 0L
% Baldao = 0L

% Prova Antiga

paresjp([X|Xs], [X|Rs]) :-
    X mod 2 =:= 0, !,
    pares(Xs,Rs).

paresjp([_|Xs], Rs) :-
    paresjp(Xs, Rs).
    
pares([A|B],X) :- findall((A mod 2 =:= 0), [A|B], X).