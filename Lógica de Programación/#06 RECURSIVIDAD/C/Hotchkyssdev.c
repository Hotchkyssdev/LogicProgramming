/* EJERCICIO:
 * Entiende el concepto de cuentaAtras creando una función recursiva que imprima
 * números del 100 al 0.
 *
 * DIFICULTAD EXTRA (opcional):
 * Utiliza el concepto de recursividad para:
 * - Calcular el factorial de un número concreto (la función recibe ese número).
 * - Calcular el valor de un elemento concreto (según su posición) en la 
 *   sucesión de Fibonacci (la función recibe la posición).
 */
#include <stdio.h>

//FIRMAS
void cuentaAtras(int numero);
int factorial(int numero);
int fibonacci(int numero);

void cuentaAtras(int numero) {
    if (numero >= 0) {
        printf("%d\n", numero);
        cuentaAtras(numero - 1);
    }
}

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
    int numero, posicion;
    printf("\n---CUENTA ATRAS---\n");
    cuentaAtras(100);

    printf("\n---FACTORIAL---\n");
    printf("Ingrese el numero para hacer factorial: ");
    scanf("%d", &numero);
    printf("\nEl resultado del factorial de %d es %d.",  numero, factorial(numero));

    printf("\n\n---SUCESION DE FIBONACCI---\n");
    printf("Ingrese la posicion de la sucesion de fibonacci: ");
    scanf("%d", &posicion);
    printf("El resultado de la sucesion de fibonacci de la posicion %d es %d.", posicion, fibonacci(posicion));
    printf("\n\n");

    return 0;
}