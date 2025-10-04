/*Ejercicio 1: Intercambio de valores
Escribe una función que reciba dos enteros por valor e intente intercambiarlos, 
y otra que los reciba por referencia usando punteros y logre el intercambio. Compara los resultados.*/
#include <stdio.h>

//FIRMAS
void programaValor(int variable1, int variable2);
void programaReferencia(int *variable1, int *variable2);

void programaValor(int variable1, int variable2) {
    int temp;
    temp = variable1;
    variable1 = variable2;
    variable2 = temp;
    
    printf("\n\nRESULTADO DE LA FUNCION POR VALOR.\n");
    printf("SOLO afecto a las COPIAS dentro de esta funcion.\n");
    printf("Variable 1 (local): %d\n", variable1);
    printf("Variable 2 (local): %d\n", variable2);
}

void programaReferencia(int *variablePuntero1, int *variablePuntero2) {
    int temp;
    temp = *variablePuntero1;
    *variablePuntero1 = *variablePuntero2;
    *variablePuntero2 = temp;
    
    printf("\n\nRESULTADO DE LA FUNCION POR REFERENCIA (PERMANENTE).\n");
    printf("AFECTA a la memoria original.\n");
    printf("Valor Puntero 1 (original): %d\n", *variablePuntero1);
    printf("Valor Puntero 2 (original): %d\n", *variablePuntero2);
}

int main() {
    int variable1 = 50;
    int variable2 = 100;
    int *variablePuntero1 = &variable1;
    int *variablePuntero2 = &variable2;

    printf("Variable 1: %d\n", variable1);
    printf("Variable 2: %d\n", variable2);
    programaValor(variable1, variable2);
    printf("En MAIN (Variable 1: %d) y (Variable 2: %d).\n", variable1, variable2);

    printf("\n\nPuntero 1: %d\n", *variablePuntero1);
    printf("Puntero 2: %d\n", *variablePuntero2);
    programaReferencia(variablePuntero1, variablePuntero2);
    printf("En MAIN (Variable 1: %d) y (Variable 2: %d).\n\n", variable1, variable2);

    return 0;
}