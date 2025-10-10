/*Ejercicio 1: Factorial
Crea una función recursiva que calcule el factorial de un número entero positivo ingresado por el usuario.*/
import java.util.Scanner;

public class Ejercicio16 {
    public static int factorial(int numero)  {
        if (numero <  0) {
            System.out.println("Los numeros negativos no son validos.");
            return 0;
        } else if (numero == 0) {
            return 1;
        } else {
            return numero *  factorial(numero - 1);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numero;
        System.out.println("\n---FACTORIAL---\n");
        System.out.print("Ingrese el numero para hacer factorial: ");
        numero = input.nextInt();
        System.out.println("\nEl resultado del factorial de " + numero + " es: "  + factorial(numero));
        input.close();
    } 
}