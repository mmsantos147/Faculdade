% Aula de 25/05/2023
%Funcao que adciona um elemento na lista

add(X,L,L) :- in(X,L), !.
add(X,L,[X|L]).
 
%Funcao que confere se um elemento esta na lista 

in(X, [X|_]) :- !.
in(X, [_|L]) :-in(X,L).

%Programacao Procedural

prog :- 
    ledado(D),
    calcula(D,R),
    escreve(R).

ledado(X) :- 
    write('Digite um valor: '),
    read(X).

calcula(D,R) :- R is D * D.

escreve(X) :- 
    write(" O quadrado eh "),
    write(X), nl.

%Pilha
%Funcao que empilha e desempilha em Listas

empilha(A,B,[A|B]) :- !.
desempilha(A,[A|B],B) :- !.

%Funcao que empilha e desempilha Listas em pilhas

empLista([A|B],X,Z) :- empilha(A,X,Y), !, empLista(B,Y,Z).
empLista([],A,A) :- !.

%Fila
%Funcao que insere e retira elementos em uma Fila
insereFila(A,B,F) :- append(B,[A],F), !.
retira(A,[A|B],B) :- !.

%Funcao que insere e retira listas em uma Fila
insLista([A|B],X,Z) :- insereFila(A,X,Y), !, insLista(B,Y,Z).
insLista([],A,A) :- !.

%Arvore Binaria
%Representacao de arvore em prolog
%no(raiz,esq,dir)

no(a,b,c).
no(b,d,[]).
no(d,[],[]).
no(c,e,f).
no(e,[],g).
no(f,[],[]).
no(g,[],[]).

preordem([]).
preordem(X) :-
    write(X), write(' '), no(X,E,D),
    preordem(E),
    preordem(D).

emordem([]).
emordem(X) :- 
    no(X,E,D),
    emordem(E),
    write(X), write(' '), no(X,E,D),
    emordem(D).

posordem([]).
posordem(X) :-
    no(X,E,D),
    posordem(E),
    posordem(D),
    write(X), write(' '), no(X,E,D).

%Outra representacao de arvore

insereArvore(X,[],no(X,[],[])) :- !.
insereArvore(X,no(X,E,D),no(X,E,D)) :- !.
insereArvore(X,no(I,E,D),no(I,E1,D)) :-
    X < I, !,
    insereArvore(X,E,E1).
insereArvore(X,no(I,E,D),no(I,E,D1)) :- 
    X > I, !, 
    insereArvore(X,D,D1).

insListaA([A|B],X,Z) :- !, 
    insereArvore(A,X,Y), 
    insListaA(B,Y,Z).
insListaA([],A,A) :- !.

preordem2([]).
preordem2(no(I,E,D)) :-
    write(I), write(' '),
    preordem2(E),
    preordem2(D).

emordem2([]).
emordem2(no(I,E,D)) :- 
    emordem2(E), 
    write(I), write(' '), 
    emordem2(D).

posordem2([]).
posordem2(no(I,E,D)) :-
    posordem2(E),
    posordem2(D),
    write(I), write(' ').

%Ordenacao
%Insercao Direta

insereOrd(X,[Y|L], [X,Y|L]) :-
    X =< Y, !.
insereOrd(X,[Y|L], [Y|Io]) :-
    X > Y, !, 
    insereOrd(X,L,Io).
insereOrd(X,[],[X]).

insercaoOrd([C|Ls],So) :- 
    insercaoOrd(Ls,Si), 
    insereOrd(C,Si,So).
insercaoOrd([],[]).
