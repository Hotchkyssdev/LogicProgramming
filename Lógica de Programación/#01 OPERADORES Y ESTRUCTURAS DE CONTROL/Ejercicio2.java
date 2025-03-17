/*2️⃣ Verificador de Rango y Paridad
Consigna:
Crea un programa en Python que solicite al usuario un número entero y verifique si:
🔹 Está en el rango de 10 a 50.
🔹 Es par o impar. */

import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese un numero entero: ");
        int n1 = scanner.nextInt();
        if (n1 >= 10 && n1 <= 50) {
            System.out.println("El numero " + n1 + " esta dentro del rango.");
            if (n1 % 2 == 0) {
                System.out.println("El numero es par.");
            } else {
                System.out.println("El numero es impar.");
            }
        } else {
            System.out.println("El numero " + n1 + " no esta dentro del rango.");
            if (n1 % 2 == 0) {
                System.out.println("El numero es par.");
            } else {
                System.out.println("El numero es impar.");
            }
        }
        scanner.close();
    }
}
