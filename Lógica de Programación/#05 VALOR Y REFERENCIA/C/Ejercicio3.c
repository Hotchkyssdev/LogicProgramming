/*Ejercicio 3: Modificar una cadena
Haz un programa con dos funciones:
    Una que reciba una cadena por valor e intente modificar un carácter.
    Otra que reciba la cadena por referencia y sí modifique correctamente el carácter.*/
#include <stdio.h>
#include <string.h>
#define MAX_CADENA 100

//FIRMAS
void cadenaValor(const char cadenavalor[]);
void cadenaReferencia(char cadenareferencia[]);

void cadenaValor(const char cadenavalor[]) {
    printf("\n--- Funcion Por Valor: Intentando Modificar ---\n");
    printf("El primer caracter es: '%c'.\n", cadenavalor[0]);
    printf("El intento de modificacion fue PROHIBIDO por el compilador ('const').\n");
}

void cadenaReferencia(char cadenareferencia[]) {
    printf("\n--- Funcion Por Referencia: Modificacion Exitosa ---\n");
    
    if (strlen(cadenareferencia) > 0) {
        char original = cadenareferencia[0];
        cadenareferencia[0] = '#'; //Puedo modificar ya que no esta la palabra reservada 'const'
        printf("El caracter fue modificado de '%c' a '%c'.\n", original, cadenareferencia[0]);
    } else {
        printf("Cadena vacia. No se modifico nada.\n");
    }
}

int main() {
    char cadenavalor[MAX_CADENA];
    char cadenareferencia[MAX_CADENA];

    printf("Ingrese la cadena que sera pasada por valor: ");
    if (fgets(cadenavalor, MAX_CADENA, stdin) == NULL) return 1;
    cadenavalor[strcspn(cadenavalor, "\n")] = '\0';
    
    cadenaValor(cadenavalor);
    printf("ESTADO FINAL (Valor): %s\n", cadenavalor);
    printf("Conclusion: Permanece sin cambios.\n\n");

    printf("\nIngrese la cadena que sera pasada por referencia: ");
    if (fgets(cadenareferencia, MAX_CADENA, stdin) == NULL) return 1;
    cadenareferencia[strcspn(cadenareferencia, "\n")] = '\0';
    
    cadenaReferencia(cadenareferencia);
    printf("ESTADO FINAL (Referencia): %s\n", cadenareferencia);
    printf("Conclusion: El primer caracter fue modificado con exito.\n");

    return 0;
}