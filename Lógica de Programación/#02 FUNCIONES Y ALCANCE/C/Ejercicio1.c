#include <stdio.h>

int cuadrado(int x) {
    return x*x;
}

int main() {
    int num;
    printf("Ingrese un numero: ");
    scanf("%d", &num);
    printf("El cuadrado de %d es %d\n", num,  cuadrado(num));
    return 0;
}