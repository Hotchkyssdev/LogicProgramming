/* Ejercicio 1: Array de enteros
Declara un array de 10 enteros.
Inserta valores manualmente.
Actualiza el valor de la posición 5.
Elimina el valor de la posición 3 desplazando los siguientes.
Ordena el array de menor a mayor e imprime el resultado.*/
#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h> 
#define CAPACIDAD 10

//FIRMAS
void leerArreglo(int arreglo[], int tam);

void leerArreglo(int arreglo[], int tamano) {
    int i;
    printf("Contenido del arreglo (%d elementos): \n", tamano);
    for (i = 0; i < tamano; i++) {
        printf("%d ", arreglo[i]);
    }
    printf("\n");
}

int main() {
    int arregloInicial[] = {44, 32, 5, 10, 20, 15, 7, 2, 9, 1};
    int tamano_inicial = sizeof(arregloInicial) / sizeof(arregloInicial[0]);
    int array[CAPACIDAD];
    int tam = tamano_inicial;
    memcpy(array, arregloInicial, tamano_inicial * sizeof(int));
    printf("--- EJERCICIO DE MANIPULACION DE ARRAY ---\n");
    printf("\nArray Inicializado:\n");
    leerArreglo(array, tam);
    int pos_actualizar = 4; 
    int nuevo_valor = 99;
    if (pos_actualizar < tam) {
        array[pos_actualizar] = nuevo_valor;
        printf("\nActualizacion: Posicion 5 (indice %d) -> %d.\n", pos_actualizar, nuevo_valor);
        leerArreglo(array, tam);
    }
    int pos_eliminar = 2; 
    if (pos_eliminar >= 0 && pos_eliminar < tam) {
        printf("\nEliminacion: Posicion 3 (indice %d).\n", pos_eliminar);
        // Desplazar elementos a la izquierda
        for (int i = pos_eliminar; i < tam - 1; i++) {
            array[i] = array[i + 1];
        }
        tam--; // Reducir el tamaño actual
        leerArreglo(array, tam);
    } else {
        printf("Error: La posicion de eliminacion es invalida.\n");
    }

    printf("\nOrdenando el Array (Bubble Sort):\n");
    int j, temp;
    
    for (int i = 0; i < tam - 1; i++) {
        for (j = 0; j < tam - i - 1; j++) {
            if (array[j] > array[j + 1]) {
                // Intercambio (swap)
                temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
            }
        }
    }
    
    printf("Resultado Ordenado:\n");
    leerArreglo(array, tam);

    return 0;
}