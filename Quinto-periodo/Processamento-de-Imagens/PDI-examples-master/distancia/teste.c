#include <stdio.h>

typedef int *image;

int img[] = {
    0,0,0,0,0,0,
    0,0,1,1,0,0,
    0,1,1,1,1,0,
    0,1,1,1,1,0,
    0,0,1,1,0,0,
    0,0,0,0,0,0
};

void mostra(image img) {
    for (int i = 0; i<6; i++) {
        for (int j =0; j< 6; j++) {
            printf("%4d", img[i*6+j]); 
        }
         printf("\n");
    }
}

int min (int a, int b, int c) {
    if(a<b && a<c)
        return a;
    if(b<c)
        return b;
    return c;
}
void distancia (image img) {
    for (int i = 1; i<5; i++) {
        for (int j =1; j < 5; j++) {
        int a = img[(i-1) * 6+j];
        int b = img[i * 6 + j -1];
        int p = img[i * 6 +j];
        if (p) {
            img[i * 6 + j] = a + 1 < b ? a + b : b + 1;
        }
        }
    }

    for (int i = 4; i>=1; i--) {
        for (int j = 4; j >=1; j--) {
        int a = img[i * 6 + j + 1];
        int b = img[(i+1) * 6 + j];
        int p = img[i * 6 +j];
        if (p) {
            img[i * 6 + j] = min(a+1,b+1,p);
        }
        }
    }
}
int main () {
    mostra(img);
    distancia(img);
    puts("\nResultado");
    mostra(img);
}