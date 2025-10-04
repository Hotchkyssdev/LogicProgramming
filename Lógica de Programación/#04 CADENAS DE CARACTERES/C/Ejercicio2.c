/*Ejercicio 2: Palabra invertida
Solicita una palabra al usuario e imprime la misma palabra al revés.*/
#include <stdio.h>
#include <string.h>
#define MAX_CAPACIDAD 25

int main() {
    char palabra[MAX_CAPACIDAD];
    int longitud;
    printf("Ingrese una palabra: ");
    if (fgets(palabra, MAX_CAPACIDAD, stdin) == NULL) return 1;
    palabra[strcspn(palabra, "\n")] = '\0';
    longitud = strlen(palabra);

    printf("\n\nPalabra original: %s", palabra);
    printf("\nPalabra invertida: ");
    for (int i = longitud - 1; i >= 0; i--) {
        printf("%c ", palabra[i]);
    }
    printf("\n");

    return 0;
}