/*Ejercicio 2: Clasificación de números
Solicita un número entero al usuario y determina:
Si es positivo, negativo o cero.
Si es par o impar.
Utiliza operadores lógicos y condicionales.*/
import java.util.Scanner;

public class Ejercicio21 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n;
        System.out.println("Ingrese el numero: ");
        n = input.nextInt();

        if (n == 0) {
            System.out.println("El numero es cero.");
        } else {
            if (n > 0) {
                System.out.println("El numero es positivo.");
            } else {
                System.out.println("El numero es negativo.");
            }
        }

        if (n % 2 == 0) {
            System.out.println("El numero es par.");
        } else {
            System.out.println("El numero es impar.");
        }

        input.close();
    }
}