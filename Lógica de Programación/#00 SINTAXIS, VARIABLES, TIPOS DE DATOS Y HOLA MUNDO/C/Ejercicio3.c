#include <stdio.h>

int main() {
    int n1, n2;
    int suma, resta, multiplicacion;
    float division;
    printf("Ingrese el primer numero: ");
    scanf("%d", &n1);
    printf("Ingrese el segundo numero: ");
    scanf("%d", &n2);

    suma = n1 + n2;
    resta = n1 - n2;
    multiplicacion = n1 * n2;
    division = (float)n1 / n2;

    printf("Suma: %d\n", suma);
    printf("Resta: %d\n", resta);
    printf("Multiplicacion: %d\n", multiplicacion);
    printf("Division: %.2f\n", division);
    return 0;
}