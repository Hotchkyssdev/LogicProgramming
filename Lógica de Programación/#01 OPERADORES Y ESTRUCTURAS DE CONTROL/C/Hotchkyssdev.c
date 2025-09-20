//OPERADORES Y ESTRUCTURAS DE CONTROL
#include <stdio.h>

int main() {
    //Operadores Aritméticos
    int a = 10, b = 3;
    printf("\n");
    printf("Suma: %d\n", a + b);           
    printf("Resta: %d\n", a - b);          
    printf("Multiplicacion: %d\n", a * b);  
    printf("Division: %d\n", a / b);        
    printf("Modulo: %d\n", a % b);          

    //Operadores Lógicos
    int x = 5, y = 10;
    printf("\n");
    printf("AND: %d\n", (x < 10) && (y > 5));
    printf("OR: %d\n", (x < 10) || (y < 5));
    printf("NOT: %d\n", !(x < 10));

    //Operadores de Comparación
    printf("\n");
    printf("Igual a (a == b): %d\n", (a == b));
    printf("No igual a (a != b): %d\n", (a != b));
    printf("Mayor que (a > b): %d\n", (a > b));
    printf("Menor que (a < b): %d\n", (a < b));
    printf("Mayor o igual que (a >= b): %d\n", (a >= b));
    printf("Menor o igual que (a <= b): %d\n", (a <= b));

    //Operadores de Asignación
    int c = 5;
    printf("\n");
    printf("Asignacion c = 5: %d\n", c);
    c += 2;
    printf("Asignacion suma c += 2: %d\n", c);
    c -= 2;
    printf("Asignacion resta c -= 2: %d\n", c);
    c *= 2;
    printf("Asignacion multiplicacion c *= 2: %d\n", c);
    c /= 2;
    printf("Asignacion division c /= 2: %d\n", c);
    c %= 2;
    printf("Asignacion modulo c MOD= 2: %d\n", c);

    //Operadores de Identidad
    int *ptr = &a;
    printf("\n");
    printf("Direccion de a: %p\n", (void*)&a);
    printf("Valor apuntado por ptr: %d\n", *ptr);
    printf("Direccion almacenada en ptr: %p\n", (void*)ptr);
    printf("Direccion de ptr: %p\n", (void*)&ptr);

    //Operadores de Bits
    int m = 5, n = 3;
    printf("\n");
    printf("AND a nivel de bits: %d\n", m & n);
    printf("OR a nivel de bits: %d\n", m | n);
    printf("XOR a nivel de bits: %d\n", m ^ n);
    printf("NOT a nivel de bits: %d\n", ~m);
    printf("Desplazamiento a la izquierda: %d\n", m << 1);
    printf("Desplazamiento a la derecha: %d\n", m >> 1);
    
    //Estructuras de Control - Condicionales
    int num = 7;
    printf("\n");
    if (num > 0) {
        printf("El numero es positivo\n");
    } else if (num < 0) {
        printf("El numero es negativo\n");
    } else {
        printf("El numero es cero\n");
    }

    switch (num) {
        case 1:
            printf("El numero es uno\n");
            break;
        case 2:
            printf("El numero es dos\n");
            break;
        case 3:
            printf("El numero es tres\n");
            break;
        default:
            printf("El numero no es uno, dos ni tres\n");
            break;
    }

    //Estructuras de Control - Bucles
    printf("\n");
    printf("Bucle for:\n");
    for (int i = 0; i < 5; i++) {
        printf("%d ", i);
    }
    printf("\n");
    printf("Bucle while:\n");
    int j = 0;  
    while (j < 5) {
        printf("%d ", j);
        j++;
    }
    printf("\n");
    printf("Bucle do-while:\n");
    int k = 0;
    do {
        printf("%d ", k);
        k++;
    } while (k < 5);
    printf("\n");
    
    /*Desafio Extra:
    Crea un programa que imprima por consola todos los números comprendidos entre 10 y 55 (incluidos) 
    pares, y que no son ni el 16 ni múltiplos de 3.*/
    printf("\n");
    for (int numExtra = 10; numExtra <= 55; numExtra++) {
        if (numExtra % 2 == 0 && numExtra != 16 && numExtra % 3 != 0) {
            printf("%d ", numExtra);
        }
    }
    printf("\n");

    return 0;
}