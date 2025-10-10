/*Ejercicio 2: Potencia
Implementa una función recursiva que calcule el resultado de elevar un número base a un exponente entero positivo.*/
import java.util.Scanner;

public class Ejercicio26 {

    public static int potencia(int base, int exponente) {
        int resultado;
        if (exponente == 0) {
            return 1;
        } else if (exponente == 1) {
            return base;
        } else {
            resultado = base * potencia(base, (exponente - 1));
            return resultado;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int base, exponente;
        System.out.println("\n---POTENCIA---");
        System.out.print("Ingrese la base: ");
        base = input.nextInt();
        System.out.print("Ingrese el exponente: ");
        exponente = input.nextInt();
        System.out.println("\nEl resultado de la potencia con base " + base + " y exponente " + exponente + " es: " + potencia(base, exponente));
        input.close();
    }
}