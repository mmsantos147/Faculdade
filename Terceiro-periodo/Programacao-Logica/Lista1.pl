% Exercício 1

analisa_lista([]) :- write('A lista esta vazia').
analisa_lista([A|B]) :- write('A cabeça da lista é'), 
    write(A), 
    write('A cauda da lista é'), 
    write(B).

% Exercício 2

ap([],L,L).
ap([A|B],C, [A|D]) :- ap(B,C,D).

pertence(X,[X|_]).
pertence(X,[_|B]) :- pertence(X,B).

remove_duplicados([],[]).
remove_duplicados([A|B], List) :- pertence(A,B),!, 
    remove_duplicados(B, List).
remove_duplicados([A|B], [A|List]) :- remove_duplicados(B, List).

% Exercício 3

troca([],_,_,[]).
troca([X|B],X,Y,[Y|List]) :- troca(B,X,Y,List).
troca([A|B],X,Y,[A|List]) :- troca(B,X,Y,List).

% Exercício 4

potencia([],[]).
potencia([A|B],P).

% Exercício 5

mais_longa(_,[]).
mais_longa(A,B) :- .

% Exercício 6

distancia((0,0),(0,0),0).
distancia((X1,Y1),(X2,Y2), X) :- X is sqrt((X2-X1)**2 + (Y2-Y1)**2).

% Exercício 7

quadrado(N, C) :- quadrado(N,N,N,C),!.
quadrado(_,0,_,_).
quadrado(0,Y,S,C) :- B is Y - 1,
    nl,
    quadrado(S,B,S,C).

quadrado(X,Y,S,C) :- A is X-1,
    write(C), write(' '),
    quadrado(A,Y,S,C).

% Exercício  8

elemento_n().

% Exercício 9

soma([],0).
soma([A|B],S) :- soma(B,S1),
    S is A + S1.

tam([],0).
tam([A|B],T) :- tam(B,T1), 
    T is T1+1.

media([],0).
media([A|B],X) :-soma(B,Soma),
    tam([A|B],Tam), 
    X is (Soma + A)/Tam.

% Exercício 10

minimo([X],[X]).
minimo([A|R],B) :- minimo(R,B), B =< A.
minimo([A|R],A) :- minimo(R,B), B > A.

% Exercício 11

intervalo(Y,Y,[Y|_]).
intervalo(X,Y,[A|B]) :- X<=Y, A is X, intervalo(X+1,Y,B).

% Exercício 12

mdc().

% Exercício 13

ocorrencias().

% Exercício 14

divisores().