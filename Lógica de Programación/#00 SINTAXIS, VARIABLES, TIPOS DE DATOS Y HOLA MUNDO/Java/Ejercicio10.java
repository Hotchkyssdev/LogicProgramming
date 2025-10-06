/*Ejercicio 1: Hola Mundo personalizado
Crea un programa que muestre en pantalla el mensaje "Hola Mundo" y 
luego solicite al usuario su nombre para imprimir "Hola, <nombre>!".*/
import java.util.Scanner;

public class Ejercicio10 {
    public static void main(String[] args) {
        String nombre;
        Scanner input = new Scanner(System.in);
        System.out.println("Hola Mundo");
        System.out.println("\nIngrese su nombre: ");
        nombre = input.nextLine();
        System.out.println("\nHola " + nombre + "!");
        input.close();
    }
}