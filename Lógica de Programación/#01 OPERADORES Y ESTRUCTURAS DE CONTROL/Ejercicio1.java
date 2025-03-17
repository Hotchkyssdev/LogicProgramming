/*1️⃣ Calculadora de Operaciones Básicas
Consigna:
Escribe un programa en Java que solicite al usuario dos números enteros y una operación matemática (+, -, *, /, //, %, **). 
Luego, el programa debe calcular el resultado de la operación e imprimirlo en la consola. */

import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el primer número: ");
        int n1 = scanner.nextInt();
        System.out.println("Ingrese el segundo número: ");
        int n2 = scanner.nextInt();
        int resultado = 0;
        System.out.println("1. Suma");
        System.out.println("2. Resta");
        System.out.println("3. Multiplicacion");
        System.out.println("4. Division");
        System.out.println("5. Modulo");
        System.out.println("6. Division Entera");
        System.out.println("7. Exponente");
        System.out.println("Ingrese una opcion: ");
        int opcion = scanner.nextInt();
        switch (opcion) {
            case 1:
                resultado = n1 + n2;
                System.out.println("El resultado de la operacion es: " + resultado);
                break;
            case 2:
                resultado = n1 - n2;
                System.out.println("El resultado de la operacion es: " + resultado);
                break;
            case 3:
                resultado = n1 * n2;
                System.out.println("El resultado de la operacion es: " + resultado);
                break;
            case 4:
                resultado = n1 / n2;
                System.out.println("El resultado de la operacion es: " + resultado);
                break;
            case 5:
                resultado = n1 % n2;
                System.out.println("El resultado de la operacion es: " + resultado);
                break;
            case 6:
                resultado = n1 / n2;
                System.out.println("El resultado de la operacion es: " + resultado);
                break;
            case 7:
                resultado = (int) Math.pow(n1, n2);
                System.out.println("El resultado de la operacion es: " + resultado);
                break;
            default:
                System.out.println("Opcion invalida.");
                break;     
        }
        scanner.close();
    }
}