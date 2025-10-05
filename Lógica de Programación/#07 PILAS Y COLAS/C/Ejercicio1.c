/*Ejercicio 1: Validar paréntesis con pila
Implementa un programa que, usando una pila, 
determine si una expresión matemática tiene los paréntesis bien balanceados ( (), {}, [] ).*/
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#define MAX_EXPRESION 100

typedef struct Nodo {
    char dato;
    struct Nodo *siguiente;
} Nodo;

Nodo *pila_tope = NULL; //Puntero principal de la pila (el tope)

void pila_push(char c) { //Inserta un carácter en el tope de la pila
    Nodo *nuevo = (Nodo*)malloc(sizeof(Nodo));
    if (nuevo == NULL) {
        printf("Error de memoria.\n");
        exit(EXIT_FAILURE);
    }
    nuevo->dato = c;
    nuevo->siguiente = pila_tope;
    pila_tope = nuevo;
}

//Extrae y devuelve el carácter del tope de la pila
char pila_pop() {
    if (pila_tope == NULL) {
        return '\0'; //Indicador de pila vacía
    }
    
    Nodo *temp = pila_tope;
    char c = temp->dato;
    pila_tope = pila_tope->siguiente;
    free(temp);
    return c;
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

//Determina si la expresión tiene los paréntesis balanceados
bool validar_parentesis(const char *expresion) {
    for (int i = 0; expresion[i] != '\0'; i++) {     //Recorrer la cadena carácter por carácter
        char caracter = expresion[i];
        char tope_pila;

        //Encontrar un paréntesis de apertura
        if (caracter == '(' || caracter == '[' || caracter == '{') {
            pila_push(caracter); // Lo apilamos
        } else if (caracter == ')' || caracter == ']' || caracter == '}') { //Encontrar un paréntesis de cierre
            
            if (pila_esta_vacia()) {
                pila_liberar();
                return false; 
            }

            tope_pila = pila_pop(); //Extraemos el último de apertura
            
            if (caracter == ')' && tope_pila != '(') {
                pila_liberar();
                return false;
            }
            if (caracter == ']' && tope_pila != '[') {
                pila_liberar();
                return false;
            }
            if (caracter == '}' && tope_pila != '{') {
                pila_liberar();
                return false;
            }
        }
    }

    //Al finalizar el recorrido, la pila debe estar vacía. Si quedan paréntesis de apertura, la expresión no está balanceada.
    bool balanceado = pila_esta_vacia();
    pila_liberar();
    
    return balanceado;
}

int main() {
    char expresion[MAX_EXPRESION];
    bool resultado;

    printf("--- VALIDACION DE PARENTESIS CON PILA ---\n");
    printf("Ingrese la expresion matematica (max %d caracteres):\n", MAX_EXPRESION);
    
    if (fgets(expresion, MAX_EXPRESION, stdin) == NULL) {
        return 1;
    }
    expresion[strcspn(expresion, "\n")] = '\0';
    
    resultado = validar_parentesis(expresion);

    printf("\nExpresion a evaluar: \"%s\"\n", expresion);
    if (resultado) {
        printf("RESULTADO: ¡Balanceado correctamente! (OK)\n");
    } else {
        printf("RESULTADO: Error de balanceo. (FALLO)\n");
    }

    return 0;
}