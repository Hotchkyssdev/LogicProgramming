/*Ejercicio 2: Fibonacci
Crea una función recursiva que muestre los primeros n términos de la serie de Fibonacci.*/
#include <stdio.h>

//FIRMAS
int fibonacci(int numero);

int fibonacci(int numero) {
    if (numero <= 0) {
        printf("La posicion tiene que ser mayor que cero.\n");
        return 0;
    } else if (numero == 1) {
        return 0;
    } else if (numero == 2) {
        return 1;
    } else {
        return fibonacci(numero - 1) + fibonacci(numero - 2);
    }
}

int main() {
    int posicion;
    printf("\n\n---SUCESION DE FIBONACCI---\n");
    printf("Ingrese la posicion de la sucesion de fibonacci: ");
    scanf("%d", &posicion);
    printf("El resultado de la sucesion de fibonacci de la posicion %d es %d.", posicion, fibonacci(posicion));
    printf("\n\n");

    return 0;
}