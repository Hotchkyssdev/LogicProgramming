/*Ejercicio 2: Simular una cola de atención
Crea un programa que utilice una cola para simular el turno de atención en una oficina. 
El usuario podrá: agregar cliente, atender cliente, y mostrar la cola actual.*/
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define MAX_NOMBRE 50

typedef struct NodoCliente {
    char nombre[MAX_NOMBRE];
    struct NodoCliente *siguiente;
} NodoCliente;

typedef struct Cola {
    NodoCliente *frente;
    NodoCliente *final;
} Cola;

void cola_iniciar(Cola *c) {
    c->frente = NULL;
    c->final = NULL;
}

void agregar_cliente(Cola *c, const char *nombre) {
    NodoCliente *nuevo = (NodoCliente*)malloc(sizeof(NodoCliente));
    if (nuevo == NULL) {
        printf("Error: Memoria insuficiente al agregar cliente.\n");
        exit(EXIT_FAILURE);
    }
    strncpy(nuevo->nombre, nombre, MAX_NOMBRE - 1);  //Copiar el nombre del cliente
    nuevo->nombre[MAX_NOMBRE - 1] = '\0';
    nuevo->siguiente = NULL;

    if (c->final == NULL) { //Si la cola esta vacia
        c->frente = nuevo;
        c->final = nuevo;
    } else { //Si la cola tiene elementos
        c->final->siguiente = nuevo;
        c->final = nuevo;
    }
    printf("-> Cliente \"%s\" agregado a la cola.\n", nombre);
}

int atender_cliente(Cola *c, char *nombre_atendido) {
    if (c->frente == NULL) {
        return 0; //Cola vacía
    }
    NodoCliente *cliente_atendido = c->frente;  //El cliente a atender es el del frente
    strncpy(nombre_atendido, cliente_atendido->nombre, MAX_NOMBRE); //Copiar el nombre para mostrarlo
    c->frente = c->frente->siguiente; //Mover el frente al siguiente cliente
    
    if (c->frente == NULL) {
        c->final = NULL;
    }
    free(cliente_atendido);

    return 1; 
}

void mostrar_cola(Cola *c) {
    NodoCliente *actual = c->frente;
    int turno = 1;

    printf("\n--- COLA DE ATENCION ACTUAL ---\n");
    if (actual == NULL) {
        printf("La cola esta vacia. No hay clientes esperando.\n");
        return;
    }
    
    while (actual != NULL) {
        printf("Turno %d: %s\n", turno++, actual->nombre);
        actual = actual->siguiente;
    }
    printf("------------------------------\n");
}

void cola_liberar(Cola *c) {
    NodoCliente *actual = c->frente;
    NodoCliente *siguiente;
    while (actual != NULL) {
        siguiente = actual->siguiente;
        free(actual);
        actual = siguiente;
    }
    c->frente = NULL;
    c->final = NULL;
    printf("Memoria de la cola liberada.\n");
}

void mostrar_menu() {
    printf("\n--- OFICINA DE ATENCION ---\n");
    printf("1. Agregar cliente (Entrar a la cola)\n");
    printf("2. Atender cliente (Salir de la cola)\n");
    printf("3. Mostrar cola actual\n");
    printf("0. Salir\n");
    printf("Seleccione una opcion: ");
}

int main() {
    Cola mi_cola;
    cola_iniciar(&mi_cola);

    int opcion;
    char nombre_cliente[MAX_NOMBRE];
    char nombre_atendido[MAX_NOMBRE];

    do {
        mostrar_menu();
        
        if (scanf("%d", &opcion) != 1) {
            while(getchar() != '\n'); //Limpiar buffer en caso de entrada no numérica
            opcion = -1;
            continue;
        }
        getchar(); //Consumir el salto de línea pendiente después de scanf 

        switch (opcion) {
            case 1:
                printf("Nombre del nuevo cliente: ");
                if (fgets(nombre_cliente, MAX_NOMBRE, stdin) == NULL) break;
                nombre_cliente[strcspn(nombre_cliente, "\n")] = '\0';
                agregar_cliente(&mi_cola, nombre_cliente);
                break;

            case 2:
                if (atender_cliente(&mi_cola, nombre_atendido)) {
                    printf("<< ATENDIDO: El cliente \"%s\" ha sido atendido. (FIFO)\n", nombre_atendido);
                } else {
                    printf(">> No hay clientes en la cola para atender.\n");
                }
                break;

            case 3:
                mostrar_cola(&mi_cola);
                break;

            case 0:
                printf("Saliendo de la simulacion.\n");
                break;
                
            default:
                printf("Opcion no valida. Intente de nuevo.\n");
                break;
        }

    } while (opcion != 0);
    cola_liberar(&mi_cola);

    return 0;
}