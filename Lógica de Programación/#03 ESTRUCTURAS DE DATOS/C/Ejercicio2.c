/*Ejercicio 2: Cadenas de caracteres
Declara una cadena de caracteres (char[]).
Pide al usuario que ingrese un texto.
Reemplaza todas las letras 'a' por 'x'.
Elimina el último carácter de la cadena.
Ordena las letras de la cadena en orden alfabético y muéstrala.*/
#include <stdio.h>
#include <stdlib.h>
#include <string.h> 
#define MAX_TEXT 10
#define MAX_LEN 100

//FIRMAS
int comparar_caracteres(const void *a, const void *b);

int comparar_caracteres(const void *a, const void *b) {
    return(*(char*)a - *(char*)b);
}

int main() {
    int i;
    char cadena[MAX_LEN];
    int longitud;
    printf("Ingrese un texto (max %d caracteres): ", MAX_LEN - 1);
    if (fgets(cadena, MAX_LEN, stdin) == NULL)  {
        printf("Error al leer la entrada.\n");
        return 1;
    }
    cadena[strcspn(cadena, "\n")] = '\0'; 

    longitud = strlen(cadena);
    if (longitud == 0) {
        printf("Cadena vacia. Programa terminado.\n");
        return 1;
    }

    printf("\nCadena ingresada: %s\n", cadena);

    for (i = 0; cadena[i] != '\0'; i++) {
        if (cadena[i] == 'a' || cadena[i] == 'A') {
            cadena[i] = 'x';
        }
    }
    printf("\nDespues de reemplazar 'a' por 'x': %s\n", cadena);

    if (longitud > 0) {
        cadena[longitud - 1] = '\0';
        longitud--;
    }
    printf("\nDespues de eliminar el ultimo caracter de la cadena: %s\n", cadena);

    qsort(cadena, longitud, sizeof(char), comparar_caracteres);
    printf("\nCadena ordenada alfabeticamente: %s\n", cadena);

    return 0;
}