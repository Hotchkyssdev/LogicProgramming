/*Ejercicio 1: División Segura
Crea un programa que solicite dos números enteros y realice la división del primero entre el segundo.
Maneja la excepción que ocurre si el divisor es cero e informa al usuario sin detener el programa.*/
import java.util.Scanner;

public class Ejercicio110 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n1, n2;
        System.out.print("Ingrese el numerador: ");
        n1 = input.nextInt();
        System.out.print("\nIngrese el denominador: ");
        n2 = input.nextInt();

        try {
            int resultado = n1 / n2;
            System.out.println("Resultado: " + resultado);
        } catch (ArithmeticException e) {
            System.out.println("Error: No se puede dividir entre cero");
        } 

        System.out.println("\nPrograma finalizado correctamente.");
        input.close();
    }
}