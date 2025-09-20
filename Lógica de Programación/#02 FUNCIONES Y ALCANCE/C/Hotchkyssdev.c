//FUNCIONES Y ALCANCE
#include <stdio.h>
#include <stdarg.h>

//Funciones definidas por el usuario
//Simple
void funcion1() {
    printf("Hola desde la funcion 1\n");
}

//Con retorno
int funcion2() {
    return 42;
}

//Con un argumento
void funcion3(int x) {
    printf("El valor de la funcion3 es: %d\n", x);
}

//Con Argumentos y Retorno
int funcion4(int a, int b) {
    return a + b;
}

//Con retorno de varios valores
void funcion5(int a, int b, int *suma, int *producto) {
    *suma = a + b;
    *producto = a * b;
}

//Con un número variable de argumentos
int funcion6(int count, ...) {
    va_list args;
    int sum = 0;
    va_start(args, count);
    for (int i = 0; i < count; i++) {
        sum += va_arg(args, int);
    }
    va_end(args);
    return sum;
}

//Con un número variable de argumentos con palabra clave
int funcion7(const char *operation, int count, ...) {
    va_list args;
    int result = (operation[0] == 's') ? 0 : 1; 
    va_start(args, count);
    for (int i = 0; i < count; i++) {
        int value = va_arg(args, int);
        if (operation[0] == 's') {
            result += value;
        } else if (operation[0] == 'p') {
            result *= value;
        }
    }
    va_end(args);
    return result;
}

/*DIFICULTAD EXTRA: FIZZ BUZZ

Crea una función que reciba dos parámetros de tipo cadena de texto y retorne un número.
 * - La función imprime todos los números del 1 al 100. Teniendo en cuenta que:
 *   - Si el número es múltiplo de 3, muestra la cadena de texto del primer parámetro.
 *   - Si el número es múltiplo de 5, muestra la cadena de texto del segundo parámetro.
 *   - Si el número es múltiplo de 3 y de 5, muestra las dos cadenas de texto concatenadas.
 *   - La función retorna el número de veces que se ha impreso el número en lugar de los textos.
*/

int fizzBuzz(const char *string1, const char *string2) {
    int contador = 0;
    int i = 1;
    for (i = 1; i <= 100; i++) {
        if (i % 3 == 0  && i % 5 == 0) {
            printf("%s%s\n", string1, string2);
        } else if (i % 3 == 0) {
            printf("%s\n", string1);
        } else if (i % 5 == 0) {
            printf("%s\n", string2);
        } else {
            printf("%d\n", i);
            contador++;
        }
    }

    return contador;
}

int main() {
    funcion1();
    printf("Retorno de funcion2: %d\n", funcion2());
    funcion3(10);
    printf("Retorno de funcion4: %d\n", funcion4(5, 7));
    
    int suma, producto;
    funcion5(3, 4, &suma, &producto);
    printf("La funcion 5 devuelve Suma: %d, Producto: %d\n", suma, producto);
    
    printf("La funcion 6 devuelve Suma variable (1,2,3): %d\n", funcion6(3, 1, 2, 3));
    printf("La funcion 7 devuelve Producto variable (2,3,4): %d\n\n", funcion7("p", 3, 2, 3, 4));
    
    int contador = fizzBuzz("Fizz", "Buzz");
    printf("\nNumeros impresos: %d\n", contador);

    return 0;
}
