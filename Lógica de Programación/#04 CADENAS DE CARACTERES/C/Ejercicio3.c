/*Ejercicio 3: Comparación de cadenas
Pide al usuario dos cadenas de caracteres 
y determina si son iguales, o cuál de ellas es mayor en orden alfabético.*/
#include <stdio.h>
#include <string.h>
#define MAX_CAPACIDAD 100

int main() {
    char cadena1[MAX_CAPACIDAD];
    char cadena2[MAX_CAPACIDAD];
    int resultado;

    printf("Ingrese la primer cadena: ");
    if (fgets(cadena1, MAX_CAPACIDAD, stdin) == NULL) return 1;
    cadena1[strcspn(cadena1, "\n")] = '\0';

    printf("Ingrese la segunda cadena: ");
    if (fgets(cadena2, MAX_CAPACIDAD, stdin) == NULL) return 1;
    cadena2[strcspn(cadena2, "\n")] = '\0';

    printf("\n\n---RESULTADOS---\n");
    printf("Cadena 1: \"%s\"\n", cadena1);
    printf("Cadena 2: \"%s\"\n", cadena2);
    resultado = strcmp(cadena1, cadena2);

    if (resultado == 0) {
        printf("\nLas cadenas SON IGUALES.\n");
    } else if (resultado < 0) {
        printf("\nLa cadena 1 es MENOR a la cadena 2.\n");
        printf("(\"%s\" va antes que \"%s\" en orden alfabetico).\n", cadena1, cadena2);
    } else {
        printf("\nLa cadena 1 es MAYOR a la cadena 2.\n");
        printf("(\"%s\" va antes que \"%s\" en orden alfabetico).\n", cadena1, cadena2);
    }

    return 0;
}