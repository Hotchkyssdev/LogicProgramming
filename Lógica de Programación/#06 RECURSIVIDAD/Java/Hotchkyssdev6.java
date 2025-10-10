/* EJERCICIO:
 * Entiende el concepto de cuentaAtras creando una función recursiva que imprima
 * números del 100 al 0.
 *
 * DIFICULTAD EXTRA (opcional):
 * Utiliza el concepto de recursividad para:
 * - Calcular el factorial de un número concreto (la función recibe ese número).
 * - Calcular el valor de un elemento concreto (según su posición) en la 
 *   sucesión de Fibonacci (la función recibe la posición).
 */
import java.util.Scanner;

public class Hotchkyssdev6 {

    public static void cuentaAtras(int numero) {
        if (numero >= 0) {
            System.out.println(numero);
            cuentaAtras(numero - 1);
        }
    }

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

    public static int fibonacci(int numero) {
        if (numero <= 0) {
            System.out.println("La posicion tiene que ser mayor que cero.");
            return 0;
        } else if (numero == 1) {
            return 0;
        } else if (numero == 2) {
            return 1;
        } else {
            return fibonacci(numero - 1) + fibonacci(numero - 2);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numero, posicion;
        System.out.println("\n---CUENTA ATRAS---\n");
        cuentaAtras(100);

        System.out.println("\n---FACTORIAL---\n");
        System.out.print("Ingrese el numero para hacer factorial: ");
        numero = input.nextInt();
        System.out.println("\nEl resultado del factorial de " + numero + " es: "  + factorial(numero));

        System.out.println("\n\n---SUCESION DE FIBONACCI---\n");
        System.out.print("Ingrese la posicion de la sucesion de fibonacci: ");
        posicion = input.nextInt();
        System.out.println("\nEl resultado de la sucesion de fibonacci de la posicion " + posicion + " es: " + fibonacci(posicion));
        input.close();
    } 
}