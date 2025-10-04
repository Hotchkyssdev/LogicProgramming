/*
 * EJERCICIO:
 * - Muestra ejemplos de asignación de variables "por valor" y "por referencia", según
 *   su tipo de dato.
 * - Muestra ejemplos de funciones con variables que se les pasan "por valor" y 
 *   "por referencia", y cómo se comportan en cada caso en el momento de ser modificadas.
 * (Entender estos conceptos es algo esencial en la gran mayoría de lenguajes)
 *
 * DIFICULTAD EXTRA (opcional):
 * Crea dos programas que reciban dos parámetros (cada uno) definidos como
 * variables anteriormente.
 * - Cada programa recibe, en un caso, dos parámetros por valor, y en otro caso, por referencia.
 *   Estos parámetros los intercambia entre ellos en su interior, los retorna, y su retorno
 *   se asigna a dos variables diferentes a las originales. A continuación, imprime
 *   el valor de las variables originales y las nuevas, comprobando que se ha invertido
 *   su valor en las segundas.
 *   Comprueba también que se ha conservado el valor original en las primeras.
 */
#include <stdio.h>
#include <string.h>

struct Punto {
    int x;
    int y;
};

//FIRMAS
void modificar_por_valor(int copia_x);
void modificar_por_referencia(int *puntero_x);
void modificar_cadena_por_referencia_implicita(char *cadena_ptr);
void programaValor(int variable1, int variable2);
void programaReferencia(int *variable1, int *variable2);

//Función con Paso "Por Valor", recibe una COPIA del valor de la variable entera.
void modificar_por_valor(int copia_x) {
    printf("  [Funcion Por Valor] Valor original recibido: %d\n", copia_x);
    copia_x = copia_x + 50; //Modifica COPIA local
    printf("  [Funcion Por Valor] Valor modificado internamente a: %d\n", copia_x);
}

//Función con Paso "Por Referencia" (Usando Punteros). Recibe la DIRECCIÓN de memoria de la variable original.
void modificar_por_referencia(int *puntero_x) { //*puntero_x accede al valor en la dirección de memoria
    printf("  [Funcion Por Referencia] Valor original recibido: %d\n", *puntero_x);
    *puntero_x = *puntero_x + 50; //Modifica variable ORIGINAL
    printf("  [Funcion Por Referencia] Valor modificado permanentemente a: %d\n", *puntero_x);
}

//Función para demostrar el paso implícito de cadenas (arrays)
void modificar_cadena_por_referencia_implicita(char *cadena_ptr) {
    printf("  [Funcion Cadena] Cadena antes de modificar: \"%s\"\n", cadena_ptr);
    strcat(cadena_ptr, " (MODIFICADO)"); //Modifica array original
    printf("  [Funcion Cadena] Cadena despues de modificar: \"%s\"\n", cadena_ptr);
}

int main() {
    printf("PASO POR VALOR Y POR REFERENCIA EN C \n");
    printf("\n\n---ASIGNACION DE VARIABLES---\n");
    printf("\n1. ASIGNACION POR VALOR (int):\n");
    int a = 10;
    int b = a; //'b' obtiene una COPIA del valor de 'a'
    
    printf("a: %d, b: %d\n", a, b);
    a = 20; //Modifico 'a'
    printf("Tras a = 20:\n");
    printf("a: %d, b: %d\n", a, b); //'b' sigue siendo 10 (son independientes)

    printf("\n2. ASIGNACION POR VALOR (Struct):\n");
    struct Punto p1 = {1, 5};
    struct Punto p2 = p1; //'p2' obtiene una COPIA de la estructura
    
    printf("p1.x: %d, p2.x: %d\n", p1.x, p2.x);
    p1.x = 100; //Modifico 'p1'
    printf("Tras p1.x = 100:\n");
    printf("p1.x: %d, p2.x: %d\n", p1.x, p2.x); //'p2.x' sigue siendo 1 (copia independiente)

    printf("\n3. ASIGNACION POR REFERENCIA (Punteros):\n");
    int original_ref = 50;
    int *ptr_ref; //Puntero a entero
    
    ptr_ref = &original_ref; //Asigno la REFERENCIA (dirección) de original_ref
    
    printf("original_ref: %d\n", original_ref);
    *ptr_ref = 500; //Modifico el valor a traves del puntero
    printf("Tras *ptr_ref = 500:\n");
    printf("original_ref: %d\n", original_ref); //original_ref ha cambiado

    printf("\n\n---PASO DE VARIABLES A FUNCIONES---\n");
    printf("\n4. PASO POR VALOR:\n");
    int dato_valor = 5;
    printf("Variable original antes: %d\n", dato_valor);
    
    modificar_por_valor(dato_valor); //Pasa una copia (5)
    
    printf("Variable original despues: %d\n", dato_valor); 
    printf("CONCLUSION: El valor NO cambia fuera de la funcion.\n");

    printf("\n5. PASO POR REFERENCIA (Punteros):\n");
    int dato_referencia = 5;
    printf("Variable original antes: %d\n", dato_referencia);
    
    modificar_por_referencia(&dato_referencia); //Pasa la dirección (&dato_referencia)
    
    printf("Variable original despues: %d\n", dato_referencia); 
    printf("CONCLUSION: El valor SI cambia fuera de la funcion.\n");
    
    printf("\n6. EXCEPCION: CADENAS DE CARACTERES (Arrays):\n");
    char mensaje[100] = "Hola Mundo";
    printf("Cadena original antes: \"%s\"\n", mensaje);
    
    modificar_cadena_por_referencia_implicita(mensaje); //Pasa la dirección del array
    printf("Cadena original despues: \"%s\"\n", mensaje);
    printf("CONCLUSION: Los arrays/cadenas siempre se pasan por referencia implicita en C.\n");

    //EXTRA
    int variable1 = 50;
    int variable2 = 100;
    int *variablePuntero1 = &variable1;
    int *variablePuntero2 = &variable2;

    printf("\n\nEXTRA\n");
    printf("Variable 1: %d\n", variable1);
    printf("Variable 2: %d\n", variable2);
    programaValor(variable1, variable2);
    printf("En MAIN (Variable 1: %d) y (Variable 2: %d).\n", variable1, variable2);

    printf("\n\nPuntero 1: %d\n", *variablePuntero1);
    printf("Puntero 2: %d\n", *variablePuntero2);
    programaReferencia(variablePuntero1, variablePuntero2);
    printf("En MAIN (Variable 1: %d) y (Variable 2: %d).\n\n", variable1, variable2);

    return 0;
}

//EXTRA
void programaValor(int variable1, int variable2) {
    int temp;
    temp = variable1;
    variable1 = variable2;
    variable2 = temp;
    
    printf("\n\nRESULTADO DE LA FUNCION POR VALOR.\n");
    printf("SOLO afecto a las COPIAS dentro de esta funcion.\n");
    printf("Variable 1 (local): %d\n", variable1);
    printf("Variable 2 (local): %d\n", variable2);
}

void programaReferencia(int *variablePuntero1, int *variablePuntero2) {
    int temp;
    temp = *variablePuntero1;
    *variablePuntero1 = *variablePuntero2;
    *variablePuntero2 = temp;
    
    printf("\n\nRESULTADO DE LA FUNCION POR REFERENCIA (PERMANENTE).\n");
    printf("AFECTA a la memoria original.\n");
    printf("Valor Puntero 1 (original): %d\n", *variablePuntero1);
    printf("Valor Puntero 2 (original): %d\n", *variablePuntero2);
}