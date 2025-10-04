/*Ejercicio 1: Factorial
Implementa una función recursiva que calcule el factorial de un número 
entero positivo ingresado por el usuario.*/
#include <stdio.h>

//FIRMAS
int factorial(int numero);

int factorial(int numero) {
    if (numero < 0) {
        printf("Los numeros negativos no son validos.\n");
        return 0;
    } else if (numero == 0) {
        return 1;
    } else {
        return numero * factorial(numero - 1);
    }
}

int main() {
    int numero;

    printf("\n---FACTORIAL---\n");
    printf("Ingrese el numero para hacer factorial: ");
    scanf("%d", &numero);
    printf("\nEl resultado del factorial de %d es %d.",  numero, factorial(numero));

    return 0;
}