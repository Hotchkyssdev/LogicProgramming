/*Ejercicio 1: Intercambio de Valores
Crea una función que reciba dos variables enteras e intercambie sus valores.
Muestra cómo cambia el resultado al usar paso por valor y paso por referencia.*/
import java.util.Scanner;

public class Ejercicio15 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a, b;

        System.out.print("Ingrese un numero entero: ");
        a = input.nextInt();

        System.out.print("Ingrese otro numero: ");
        b = input.nextInt();

        System.out.println("Antes de la funcion por valor (a: " + a + ", b: " + b  + ").");

        pasoporValor(a, b);

        Contenedor objA = new Contenedor(30);
        Contenedor objB = new Contenedor(40);

        System.out.printf("Antes de la funcion por referencia: (objA.valor = %d, objB.valor = %d).\n", objA.valor,  objB.valor);

        pasoporReferencia(objA, objB);

        input.close();
    }    

    public static int[] pasoporValor(int a, int b) {
        int temp = a;
        a = b;
        b = temp;

        System.out.println("\nPor valor en la funcion (a: " + a + ", b: " + b + ").");

        return new int[]{a, b};
    }

    public static void pasoporReferencia(Contenedor var1, Contenedor var2) {
        int temp = var1.valor;
        var1.valor = var2.valor;
        var2.valor  = temp; 

        System.out.println("\nPor referencia en la funcion (objA: " + var1.valor + ", objB: " + var2.valor + ").");
    }
}

class Contenedor {
    public int valor;

    public Contenedor(int valor) {
        this.valor = valor;
    }
}