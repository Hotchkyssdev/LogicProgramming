/*
 * EJERCICIO:
 * Muestra ejemplos de todas las operaciones que puedes realizar con cadenas de caracteres
 * en tu lenguaje. Algunas de esas operaciones podrían ser (busca todas las que puedas):
 * - Acceso a caracteres específicos, subcadenas, longitud, concatenación, repetición,
 *   recorrido, conversión a mayúsculas y minúsculas, reemplazo, división, unión,
 *   interpolación, verificación...
 *
 * DIFICULTAD EXTRA (opcional):
 * Crea un programa que analice dos palabras diferentes y realice comprobaciones
 * para descubrir si son:
 * - Palíndromos
 * - Anagramas
 * - Isogramas
 */
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>
#include <ctype.h>
#define MAX_SIZE 100

//FIRMAS
int comparar_caracteres(const void *a, const void *b);
void limpiar_cadena(char *cadena);
void Palindromo(const char palabra[]);
void Anagrama(char palabra[], char palabra2[]);
void Isograma(const char palabra[]);

int main() {
    char str_original[MAX_SIZE] = "Curso de Programacion en C.";
    char str_aux[MAX_SIZE] = " Ejercicio Strings.";
    char str_check[MAX_SIZE] = "Hola Mundo";
    char str_destino[MAX_SIZE * 2]; 
    int longitud;
    printf("\n--- OPERACIONES CON CADENAS DE CARACTERES EN C ---\n");
    printf("Cadena Original: \"%s\"\n", str_original);
    printf("\n====PROPIEDADES Y ACCESO====\n");
    longitud = strlen(str_original);
    printf("1. Longitud (strlen): %d caracteres\n", longitud);
    printf("2. Acceso: Primer caracter: %c, Quinto caracter: %c, Ultimo caracter: %c\n",str_original[0], str_original[4], str_original[longitud - 1]);
    printf("3. Recorrido: ");
    for (int i = 0; str_original[i] != '\0'; i++) {
        printf("%c", str_original[i]);
    }
    printf("\n");

    printf("\n====MODIFICACION Y CONSTRUCCION====\n");
    strcpy(str_destino, str_original); //Hago la copia del original para mantenerlo intacto en str_destino
    strcat(str_destino, str_aux); //Hago la concatenacion
    printf("4. Concatenacion (strcat): \"%s\"\n", str_destino);
    
    char str_replace[MAX_SIZE];
    strcpy(str_replace, str_original);
    for (int i = 0; str_replace[i] != '\0'; i++) {
        if (str_replace[i] == 'o' || str_replace[i] == 'O') {
            str_replace[i] = '#';
        }
    }
    printf("5. Reemplazo ('o' por '#'): \"%s\"\n", str_replace);

    char str_case[MAX_SIZE];
    strcpy(str_case, "cadenA de Prueba.");
    printf("6. Mayusculas (toupper): ");
    for (int i = 0; str_case[i] != '\0'; i++) {
        str_case[i] = (char)toupper((unsigned char)str_case[i]);
    }
    printf("%s\n", str_case);
    
    printf("6. Minusculas (tolower): ");
    for (int i = 0; str_case[i] != '\0'; i++) {
        str_case[i] = (char)tolower((unsigned char)str_case[i]);
    }
    printf("%s\n", str_case);

    printf("\n====BUSQUEDA Y VERIFICACION====\n");
    int comp_igual = strcmp(str_check, "Hola Mundo"); //Devuelve 0 si las cadenas son iguales
    int comp_difer = strcmp(str_check, "hola mundo");
    printf("7. Verificacion (strcmp): 'Hola Mundo' == 'Hola Mundo'? %s (Resultado: %d)\n", (comp_igual == 0 ? "SI" : "NO"), comp_igual);
    printf("7. Verificacion (strcmp): 'Hola Mundo' == 'hola mundo'? %s (Resultado: %d)\n", (comp_difer == 0 ? "SI" : "NO"), comp_difer);

    char *sub_ptr = strstr(str_original, "Programacion"); //Búsqueda de Subcadena)
    if (sub_ptr != NULL) {
        printf("8. Subcadena (strstr): 'Programacion' encontrada. Resto de la cadena: \"%s\"\n", sub_ptr);
    } else {
        printf("8. Subcadena (strstr): No encontrada.\n");
    }

    char *char_ptr = strchr(str_original, 'P'); //Búsqueda de Carácter (strchr)
    if (char_ptr != NULL) {
        printf("9. Caracter (strchr): 'P' encontrado en la posicion %d\n", char_ptr - str_original);
    }

    printf("\n====AVANZADAS (Subcadenas y Division)====\n");
    //La subcadena "Programacion" (inicia en índice 9, longitud 12)
    char subcadena[13]; // 12 caracteres + \0
    strncpy(subcadena, &str_original[9], 12);
    subcadena[12] = '\0'; //Aseguro el terminador nulo
    printf("10. Subcadena (strncpy): \"%s\"\n", subcadena);

    char str_division[MAX_SIZE]; //División/Tokenización (strtok)
    strcpy(str_division, "uno,dos,tres,cuatro");
    char *token;
    printf("11. Division (strtok): Tokens por coma:\n");
    token = strtok(str_division, ","); //Primera llamada
    while (token != NULL) {
        printf("  - %s\n", token);
        token = strtok(NULL, ","); //Llamadas subsecuentes con NULL
    }

    printf("\n12. Interpolacion (printf/sprintf): El resultado es %.2f\n", 42.5);

    //EXTRA
    char palabra[MAX_SIZE];
    char palabra2[MAX_SIZE];

    printf("\n\n--- ANALISIS DE PROPIEDADES DE PALABRAS ---\n");
    printf("Ingrese la primer palabra: ");
    if (fgets(palabra, MAX_SIZE, stdin) == NULL) return 1;
    palabra[strcspn(palabra, "\n")] = '\0';

    printf("\nIngrese la segunda palabra: ");
    if (fgets(palabra2, MAX_SIZE, stdin) == NULL) return 1;
    palabra2[strcspn(palabra2, "\n")] = '\0';

    if (strlen(palabra) == 0 || strlen(palabra2) == 0) {
        printf("Error: Las dos palabras ingresadas deben ser validas.\n");
        return 1;
    }

    printf("\nCOMPROBACION DE PALINDROMOS\n");
    Palindromo(palabra);
    Palindromo(palabra2);

    printf("\nCOMPROBACION DE ANAGRAMAS (Palabra 1 VS Palabra 2)\n");
    Anagrama(palabra, palabra2);

    printf("\nCOMPROBACION DE ISOGRAMAS\n");
    Isograma(palabra);
    Isograma(palabra2);

    return 0;
}

int comparar_caracteres(const void *a, const void *b) {
    return (*(char *)a - *(char *)b);
}

void limpiar_cadena(char *cadena)  {
    int i, j;
    int len = strlen(cadena);

    for (i = 0, j = 0; i < len; i++) {
        if (isalpha((unsigned char)cadena[i])) {
            cadena[j++]  = (char)tolower((unsigned char)cadena[i]);
        }
    }
    cadena[j] = '\0';
}

void Palindromo(const char palabra[]) {
    int i;
    char limpia[MAX_SIZE];
    strcpy(limpia, palabra);
    limpiar_cadena(limpia);
    int len = strlen(limpia);
    bool es_palindromo = true;

    for (i = 0; i < len / 2; i++) {
        if(limpia[i] != limpia[len - 1 - i]) {
            es_palindromo = false;
            break;
        }
    }

    if (es_palindromo && len > 0) {
        printf("Palindromo: SI, la palabra %s es un palindromo.\n", palabra);
    } else {
        printf("Palindromo: NO, la palabra %s no es un palindromo.\n", palabra);
    }
}

void Anagrama(char palabra[], char palabra2[]) {
    char limpia1[MAX_SIZE];
    char limpia2[MAX_SIZE];
    strcpy(limpia1, palabra);
    strcpy(limpia2, palabra2);
    limpiar_cadena(limpia1);
    limpiar_cadena(limpia2);
    int len1 = strlen(limpia1);
    int len2 = strlen(limpia2);

    if (len1 != len2 || len1 == 0) {
        printf("ANAGRAMA: NO, tienen distinta longitud o estan vacias.\n");
        return;
    }

    qsort(limpia1, len1, sizeof(char), comparar_caracteres);
    qsort(limpia2, len2, sizeof(char), comparar_caracteres);

    if (strcmp(limpia1, limpia2) == 0) {
        printf("ANAGRAMA: SI, ambas palabras contienen exactamente las mismas letras.\n");
    } else {
        printf("ANAGRAMA: NO, ambas palabras no contienen las mismas letras.\n");
    }
}

void Isograma(const char palabra[]) {
    char limpia[MAX_SIZE];
    strcpy(limpia, palabra);
    limpiar_cadena(limpia);
    int len = strlen(limpia);
    
    if (len <= 1) {
        printf("ISOGRAMA: NO, necesita más de una letra.\n");
        return;
    }

    qsort(limpia, len, sizeof(char), comparar_caracteres);
    bool es_isograma = true;

    for (int i = 0; i < len - 1; i++) {
        if(limpia[i] == limpia[i +  1]) {
            es_isograma = false;
            break;
        }
    }

    if (es_isograma) {
        printf("ISOGRAMA: SI, ninguna letra se repite en '%s'.\n", palabra);
    } else {
        printf("ISOGRAMA: NO, alguna letra se repite en '%s'.\n", palabra);
    }
}