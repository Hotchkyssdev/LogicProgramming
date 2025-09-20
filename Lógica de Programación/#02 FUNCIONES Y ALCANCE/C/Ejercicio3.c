#include <stdio.h>

int sumEnteros (int num, int num2) {
    return num + num2;
}

int restaEnteros (int num, int num2) {
    return num - num2;
}

int multiplicaEnteros (int num, int num2) {
    return num * num2;
}

float divideEnteros (int num, int num2) {
    return (float)num / (float)num2;
}

int main() {
    int n1, n2;
    printf("Ingrese el primer numero: ");
    scanf("%d", &n1);
    printf("Ingrese el segundo numero: ");
    scanf("%d", &n2);

    printf("Suma: %d\n", sumEnteros(n1, n2));
    printf("Resta: %d\n", restaEnteros(n1, n2));
    printf("Multiplicacion: %d\n", multiplicaEnteros(n1, n2));
    if (n2 != 0) {
        printf("Division: %.2f\n", divideEnteros(n1, n2));
    } else {
        printf("Division: Error, division por cero.\n");
    }

    return 0;
}