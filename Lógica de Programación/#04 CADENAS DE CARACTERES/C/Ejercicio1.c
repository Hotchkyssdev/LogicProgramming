/*Ejercicio 1: Contar vocales
Escribe un programa que pida una cadena al usuario y muestre cuántas vocales (a, e, i, o, u) contiene.*/
#include <stdio.h>
#include <string.h>
#define MAX_CAPACIDAD 100

int main() {
    char cadena[MAX_CAPACIDAD];
    int contador = 0;
    printf("Ingrese una cadena: ");
    if (fgets(cadena, MAX_CAPACIDAD, stdin) == NULL) return 1;
    cadena[strcspn(cadena, "\n")] = '\0';

    for (int i = 0; cadena[i] != '\0'; i++) {
        if (cadena[i] == 'A' || cadena[i] == 'E' || cadena[i] == 'I' || cadena[i] == 'O' || cadena[i] == 'U' || cadena[i] == 'a' || cadena[i] == 'e' || cadena[i] == 'i' || cadena[i] == 'o' || cadena[i] == 'u') {
            contador++;
        }
    }

    printf("\n\nLa cantidad de vocales es: %d", contador);
    return 0;
}