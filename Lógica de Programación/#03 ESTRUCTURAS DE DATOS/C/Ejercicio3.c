/*Ejercicio 3: Estructura struct
Define una estructura llamada Alumno con campos: id, nombre y edad.
Declara un array de 3 alumnos.
Inserta datos en cada registro.
Actualiza la edad de un alumno dado su id.
Elimina un alumno desplazando los registros.
Ordena la lista de alumnos por edad e imprime los resultados.*/
#include <stdio.h>
#include <stdlib.h>
#include <string.h> 
#define MAX_ALUMNOS 3
#define MAX_NOMBRE 50

struct Alumno {
    int id;
    char nombre[MAX_NOMBRE];
    int edad;
};

//FIRMAS
int compararAlumnosPorEdad(const void *a, const void *b);
void imprimirAlumnos(const struct Alumno lista[], int size, const char *titulo);

//Funciones
int compararAlumnosPorEdad(const void *a, const void *b) {
    const struct Alumno *alumnoA = (const struct Alumno *)a;
    const struct Alumno *alumnoB = (const struct Alumno *)b;

    return (alumnoA->edad - alumnoB->edad);
}

void imprimirAlumnos(const struct Alumno lista[], int size, const char *titulo) {
    printf("\n--- %s (%d alumnos) ---\n", titulo, size);
    printf("ID | Nombre\t\t| Edad\n");
    printf("---|-----------------------|-----\n");
    for (int i = 0; i < size; i++) {
        printf("%-2d | %-20s| %d\n", lista[i].id, lista[i].nombre, lista[i].edad);
    }
}

int main() {
    struct Alumno lista[MAX_ALUMNOS];
    int i;
    int tam_actual = MAX_ALUMNOS;

    printf("\nInicializando lista de alumnos.\n");
    lista[0].id = 101;
    strcpy(lista[0].nombre, "Ana Lopez");
    lista[0].edad = 25;
    
    lista[1].id = 102;
    strcpy(lista[1].nombre, "Beto Ruiz");
    lista[1].edad = 21;
    
    lista[2].id = 103;
    strcpy(lista[2].nombre, "Carlos Sanz");
    lista[2].edad = 30;

    imprimirAlumnos(lista, tam_actual, "Lista Inicial");

    int id_buscar = 102;
    int nuevaedad = 22;

    for (i = 0; i < tam_actual; i++) {
        if (lista[i].id == id_buscar) {
            lista[i].edad = nuevaedad;
            printf("\nActualizada la edad del alumno con ID %d y edad %d.\n", id_buscar, nuevaedad);
            break;
        }
    }
    imprimirAlumnos(lista, tam_actual, "Despues de la Actualizacion");

    int id_eliminar = 103;
    int pos_eliminar = -1;

    for (i = 0; i < tam_actual; i++) {
        if (lista[i].id == id_eliminar) {
            pos_eliminar = i;
            break;
        }
    }

    if (pos_eliminar != -1) {
        printf("\nEliminando el alumno con ID %d (Posicion %d).\n", id_eliminar, pos_eliminar);
        for (i = pos_eliminar; i < tam_actual - 1; i++) {
            lista[i] = lista[i + 1];
        }
        tam_actual--;
    }
    imprimirAlumnos(lista, tam_actual, "Despues de la Eliminacion");

    qsort(lista, tam_actual, sizeof(struct Alumno), compararAlumnosPorEdad);
    imprimirAlumnos(lista, tam_actual, "Lista Ordenada por Edad");
}