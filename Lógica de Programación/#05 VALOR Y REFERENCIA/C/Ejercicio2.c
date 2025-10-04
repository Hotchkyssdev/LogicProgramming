/*Ejercicio 2: Suma de elementos
Crea una función que reciba un array de enteros:
    Una versión pasándolo por valor (no debe modificar el array).
    Otra versión pasándolo por referencia (usando punteros para modificar los valores).*/
#include <stdio.h>
#define TAM 10
//FIRMAS
void arrayValor(int arreglovalor[]);
void arrayReferencia(int arregloreferencia[]);

void arrayValor(int arreglovalor[]) {
    int suma = 0;
    int i;
    for (i = 0; i < TAM; i++) {
       suma += arreglovalor[i];
    }
    printf("\nLa suma de los elementos del arreglo por valor es: %d\n", suma);
}

void arrayReferencia(int arregloreferencia[]) {
    int suma = 0;
    int i;
    int *array_puntero = (int *)arregloreferencia; //La variable se trata como un puntero simple (int*) para la lógica. 
    arregloreferencia[0] = 0;

    for (i = 0; i < TAM; i++) {
        suma += array_puntero[i];
    }

    printf("\nLa suma de los elementos del arreglo por referencia es: %d\n", suma);
}

int main() {
    int arreglovalor[TAM] = {10,21,32,54,23,65,12,76,17,78};
    int arregloreferencia[TAM] = {76,31,54,16,87,19,11,75,89,95};
    int i;

    printf("\nARREGLO QUE SE PASARA POR VALOR\n");
    for (i = 0; i < TAM; i++) {
        printf("%d ", arreglovalor[i]);
    }
    arrayValor(arreglovalor);

    printf("\n\nARREGLO QUE SE PASARA POR REFERENCIA\n");
    for (i = 0; i < TAM; i++) {
        printf("%d ", arregloreferencia[i]);
    }
    arrayReferencia(arregloreferencia);
    return 0;
}