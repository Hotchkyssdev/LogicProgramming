#include <stdio.h> 

int main() {
    int N;
    printf("Ingrese un numero entero positivo: ");
    scanf("%d", &N);

    if (N <= 0) {
        printf("El numero debe ser positivo.\n");
        return 1;
    }  else {
        for (int i = 1; i <= N; i++) {
            if (i % 5 == 0) {
                printf("%d es multiplo de 5\n", i);
            }
        }
    }
    
    return 0;
}