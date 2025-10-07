/*Ejercicio 1: Función de suma y alcance
Crea una función que reciba dos números enteros y retorne su suma. Declara una variable global 
y otra local dentro de la función para demostrar la diferencia de alcance (scope).*/
import java.util.Scanner;

public class Ejercicio12 {

    static int suma(int n1, int n2) {
        int suma = n1 + n2;
        return suma;
    }

    public static void main(String[] args) {
        int n1, n2;
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese un numero: ");
        n1 = input.nextInt();
        System.out.println("Ingrese otro numero: ");
        n2 = input.nextInt();
        System.out.println();
        System.out.println("El resultado de la suma es: " + suma(n1, n2));
        input.close();
    }
}