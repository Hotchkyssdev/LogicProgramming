/*Ejercicio 3: Invertir cadena
Escribe una función recursiva que reciba una cadena de caracteres y la devuelva invertida.*/
#include <stdio.h>
#include <string.h>
#define MAX 100

//FIRMAS
void invertirCadena(char *cadena, int inicio, int fin);

void invertirCadena(char *cadena, int inicio, int fin) {
    if (inicio >= fin) { //Caso base
        return;
    }

    char temp = cadena[inicio]; //Intercambia los caracteres en las posiciones de inicio y fin
    cadena[inicio] = cadena[fin];
    cadena[fin] = temp;

    invertirCadena(cadena, inicio + 1, fin - 1); //Llama a la función para la subcadena restante
}

int main() {
    char cadena[MAX];
    int longitud;

    printf("\n---INVERTIR CADENA---\n");
    printf("Ingrese la cadena: ");
    if (fgets(cadena, MAX, stdin) == NULL) return 1;
    cadena[strcspn(cadena, "\n")] = '\0';
    longitud = strlen(cadena);

    printf("\n\nCadena original: %s\n", cadena);
    invertirCadena(cadena, 0, longitud - 1);
    printf("\n\nCadena invertida: %s\n", cadena);

    return  0;
}