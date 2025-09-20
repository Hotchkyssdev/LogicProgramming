//https://www.learn-c.org/es/
/*Este es un 
comentario de 
varias lineas
*/

#include <stdio.h>
#include <stdbool.h>
typedef unsigned char byte;
#define PI 3.14 //constante

int main() {
    int entero = 5;
    double doble = 5.99;
    float flotante = 5.995f;
    long largo = 150000L;
    byte byte =  255;
    char caracter = 'G';
    bool booleano = 1;
    printf("El valor de PI es: %f\n", PI);
    printf("El valor de entero es: %d\n", entero);
    printf("El valor de doble es: %lf\n", doble);
    printf("El valor de flotante es: %f\n", flotante);
    printf("El valor de largo es: %ld\n", largo);
    printf("El valor de byte es: %d\n", byte);
    printf("El valor de caracter es: %c\n", caracter);
    printf("El valor de booleano es: %d\n", booleano);
    printf("Hola, C!\n");
    return 0;
}