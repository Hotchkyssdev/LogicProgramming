/*Ejercicio 3: Convertir número decimal a binario con pila
Escribe un programa que convierta un número decimal a binario 
usando una pila para ir almacenando los residuos de las divisiones sucesivas entre 2.*/
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

typedef struct Nodo {
    int dato; 
    struct Nodo *siguiente;
} Nodo;

Nodo *pila_tope = NULL;

void pila_push(int residuo) {
    Nodo *nuevo = (Nodo*)malloc(sizeof(Nodo));
    if (nuevo == NULL) {
        printf("Error de memoria.\n");
        exit(EXIT_FAILURE);
    }
    nuevo->dato = residuo;
    nuevo->siguiente = pila_tope;
    pila_tope = nuevo;
}

int pila_pop() {
    if (pila_tope == NULL) {
        return -1; //Indicador de error o pila vacía
    }
    
    Nodo *temp = pila_tope;
    int residuo = temp->dato;
    pila_tope = pila_tope->siguiente;
    free(temp);
    return residuo;
}

bool pila_esta_vacia() {
    return pila_tope == NULL;
}

void pila_liberar() {
    Nodo *actual = pila_tope;
    Nodo *siguiente;
    while (actual != NULL) {
        siguiente = actual->siguiente;
        free(actual);
        actual = siguiente;
    }
    pila_tope = NULL;
}

void convertir_a_binario(int decimal) {
    if (decimal < 0) {
        printf("Error: Ingrese un numero entero positivo.\n");
        return;
    }

    if (decimal == 0) {
        printf("Resultado binario: 0\n");
        return;
    }

    int n = decimal;
    int residuo;
    
    //Generación de residuos (divisiones sucesivas)
    while (n > 0) {
        residuo = n % 2; //El residuo es el dígito binario (0 o 1)
        pila_push(residuo);
        n = n / 2;
    }

    //Construcción del número binario
    printf("Resultado binario: ");
    while (!pila_esta_vacia()) {
        residuo = pila_pop(); //Los residuos salen en el orden correcto
        printf("%d", residuo);
    }
    printf("\n");
}

int main() {
    int numero_decimal;

    printf("--- CONVERSION DECIMAL A BINARIO CON PILA ---\n");
    printf("Ingrese el numero decimal a convertir: ");
    
    if (scanf("%d", &numero_decimal) != 1) {
        printf("Entrada invalida.\n");
        return 1;
    }
    convertir_a_binario(numero_decimal);
    pila_liberar(); 

    return 0;
}