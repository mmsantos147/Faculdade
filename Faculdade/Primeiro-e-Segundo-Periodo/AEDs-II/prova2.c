#include <stdlib.h>
#include <stdio.h>
#include <string.h>

typedef struct estudante_{
    int matricula;
    char nome[30];
}estudante;

typedef struct hash_{
    int qtd, TABLE_SIZE;
    estudante ** estudante;
}hash;

estudante * cria_estudante(char * nome, int matricula) {
    estudante *e = malloc(sizeof(estudante));
    e->matricula = matricula;
    strncpy(e->nome, nome, strlen(nome));
    return e;
}

hash * cria_hash(int TABLE_SIZE){
    hash *ha = malloc(sizeof(hash));

    if (ha != NULL) {
        int i;
        ha->estudante = malloc(TABLE_SIZE * sizeof(estudante *));
        if (ha->estudante == NULL){
            free(ha);
            return NULL;
        }
        ha->TABLE_SIZE = TABLE_SIZE;
        ha->qtd = 0;
        for (i = 0; i < TABLE_SIZE; i++){
            ha->estudante[i] = NULL;
        }
    }
    return ha;
}

void libera_hash(hash * ha){
    if (ha != NULL) {
        int i;

        for (i=0;i < ha->TABLE_SIZE;i++){
            if (ha->estudante[i] != NULL) {
                free(ha->estudante[i]);
            }
            free(ha->estudante);
            free(ha);
        }
    }
}

int chave_divisao(int chave, int TABLE_SIZE){
    if (chave < 0)
        chave *= -1;
    return chave % TABLE_SIZE;
}

int chave_multiplicacao(int chave, int TABLE_SIZE){
    if (chave < 0)
        chave *= -1;
    double a = 0.7834729723;
    double val = chave * a;    
    val = val - (int)val;
    return (int)(val * TABLE_SIZE);
}

int chave_dobra(int chave, int TABLE_SIZE){
	if (chave < 0)
		chave *= -1;
	if (chave < TABLE_SIZE)
		return chave;

	int numeros[10];
	int inicio = 0;
	int fim = 0;
	int div = chave;
	do {
		int resto = div % 10;
		numeros[inicio] = resto;
		if (numeros[inicio])
			fim = inicio;
		inicio++;
		div = div / 10;
	} while (inicio < 10);
	inicio = 0;

	while (chave > TABLE_SIZE) {
		while (fim > inicio) {
			numeros[inicio] = (numeros[inicio] + numeros[fim]) % 10;
			numeros[fim] = 0;
			inicio++;
			fim--;
		}
		inicio = 0;
		chave = 0;
		int fator = 1;
		while (inicio <= fim) {
			chave += numeros[inicio] * fator;
			fator *= 10;
			inicio++;
		}
		inicio = 0;
	}
	return chave;
}

int insere_hash(hash * ha, estudante * e){
    if (ha == NULL || ha->qtd == ha->TABLE_SIZE) return 0;
    int pos = chave_divisao(e->matricula, ha->TABLE_SIZE);
    
    ha->estudante[pos] = e;
    ha->qtd++;
}

char * busca_hash (hash * ha, int matricula){
    int pos = chave_divisao(matricula, ha->TABLE_SIZE);
    return &(ha->estudante[pos]->nome[0]);
}

int sondagem_linear(int pos, int i, int TABLE_SIZE){
    return((pos + i) % TABLE_SIZE);
}

int sondagem_quadratica(int pos, int i, int TABLE_SIZE){
    pos = pos + 2 * i + 5 * i*i;
    return (pos % TABLE_SIZE);
}

int duplo_hash(int h1, int chave, int i, int TABLE_SIZE){
    int h2 = chave_divisao(chave, TABLE_SIZE-1) + 1;
    return ((h1 + i * h2) % TABLE_SIZE);
}

int insere_hash_colisao(hash * ha, estudante * e){
    if (ha == NULL || ha->qtd == ha->TABLE_SIZE)
        return 0;
    int pos, i;
    pos = chave_dobra(e->matricula, ha->TABLE_SIZE);

    for (i=0;i<ha->TABLE_SIZE;i++) {
        //pos = sondagem_linear(pos, i, ha->TABLE_SIZE);
        //pos = sondagem_quadratica(pos, i, ha->TABLE_SIZE);
        pos = duplo_hash(pos, e->matricula, i, ha->TABLE_SIZE);
        if (ha->estudante[pos] == NULL) {
            ha->estudante[pos] = e;
            ha->qtd++;
            return 1;
        }
    }
    return 0;     
}

char * busca_hash_colisao(hash * ha, int matricula){
    int i;
    int pos = chave_dobra(matricula, ha->TABLE_SIZE);
    for (i = 0;i < ha->TABLE_SIZE;i++) {
        pos = duplo_hash(pos, matricula, i, ha->TABLE_SIZE);
        if (ha->estudante[pos] == NULL){
            return NULL;  
        } else if (ha->estudante[pos]->matricula == matricula){
            return &(ha->estudante[pos]->nome[0]);
        }
    }
    return NULL;
}    

int main () {
	hash * ha = cria_hash(1000);

	estudante * e = cria_estudante("Flavio Barbieri\0", 125);
	insere_hash_colisao(ha, e);

	e = cria_estudante("Joao das Couves\0", 1125);
	insere_hash_colisao(ha, e);

	char * a = busca_hash_colisao(ha, 125);
	if (a != NULL)
		printf("%s\n", a);
	else
		printf("Aluno nao encontrado.\n");

	a = busca_hash_colisao(ha, 1125);
	if (a != NULL)
		printf("%s\n", a);
	else
		printf("Aluno nao encontrado.");

	libera_hash(ha);
	return (EXIT_SUCCESS);
}