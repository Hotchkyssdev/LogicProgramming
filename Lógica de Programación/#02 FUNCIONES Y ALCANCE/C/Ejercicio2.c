#include <stdio.h>

int variableGlobal = 20;

void imprimirGlobal() {
    printf("Variable global: %d\n", variableGlobal);
}

void imprimirLocal() {
    printf("No se puede acceder a la variable local desde esta funcion.\n");
}

int main() {
    int variableLocal = 10;

    imprimirGlobal(); 
    imprimirLocal();  

    printf("Variable local en main: %d\n", variableLocal);
    return 0;
}