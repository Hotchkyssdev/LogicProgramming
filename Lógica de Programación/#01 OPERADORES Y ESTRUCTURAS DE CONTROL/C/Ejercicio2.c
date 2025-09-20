#include <stdio.h>

int main() {
    int n1, n2;
    int opcion;
    printf("Ingrese el primer numero: ");
    scanf("%d", &n1);
    printf("Ingrese el segundo numero: ");
    scanf("%d", &n2);

    printf("\nMENU DE OPCIONES\n");
    printf("1. Sumar\n");
    printf("2. Restar\n");
    printf("3. Multiplicar\n");
    printf("4. Dividir\n");
    printf("Seleccione una opcion (1-4): ");
    scanf("%d", &opcion);

    switch (opcion) {
        case 1:
            printf("Resultado: %d\n", n1 + n2);
            break;
        case 2:
            printf("Resultado: %d\n", n1 - n2);
            break;
        case 3:
            printf("Resultado: %d\n", n1 * n2);
            break;
        case 4:
            if (n2 != 0) {
                printf("Resultado: %.2f\n", (float)n1 / n2);
            } else {
                printf("Error: Division por cero no es permitida.\n");
            }
            break;
        default:
            printf("Opcion invalida. Por favor seleccione una opcion entre 1 y 4.\n");
    }
    
    return 0;
}