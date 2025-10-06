/*Ejercicio 1: Calculadora básica
Crea un programa que pida dos números y un operador (+, -, *, /, %) y muestre el resultado 
correspondiente. Usa estructuras condicionales if o switch para decidir la operación.*/
import java.util.Scanner;

public class Ejercicio11 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n1, n2, operador;
        System.out.println("Ingrese el primer numero: ");
        n1 = input.nextInt();
        System.out.println("Ingrese el segundo numero: ");
        n2 = input.nextInt();
        System.out.println("Ingrese una opcion: ");
        System.out.println("1. Suma");
        System.out.println("2. Resta");
        System.out.println("3. Multiplicacion");
        System.out.println("4. Division");
        operador = input.nextInt();

        switch (operador) {
            case 1:
                int suma = n1 + n2;
                System.out.println("El resultado de la suma es: " + suma);
                break;
            case 2:
                int resta = n1 - n2;
                System.out.println("El resultado de la resta es: " + resta);
                break;
            case 3:
                int multiplicacion = n1 * n2;
                System.out.println("El resultado de la multiplicacion es: " + multiplicacion);
                break;
            case 4:
                float division = (float) n1 / (float) n2;
                System.out.println("El resultado de la division es: " + division);
                break;
            default:
                System.out.println("Opcion invalida");
        }

        input.close();
    }
}