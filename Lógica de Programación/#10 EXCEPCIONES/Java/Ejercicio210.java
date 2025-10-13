/*Ejercicio 2: Conversión de Tipos
Pide al usuario ingresar un número en formato de texto.
Convierte la entrada a entero y maneja la excepción si el usuario introduce un valor no numérico.*/
import java.util.Scanner;

public class Ejercicio210 {
    public static void main(String[] args)  {
        Scanner input = new Scanner(System.in);
        String cadena;
        System.out.print("Ingrese un numero entero: ");
        cadena = input.nextLine();

        try {
            int numero = Integer.parseInt(cadena);
            System.out.println("Numero ingresado correctamente: " + numero);
        } catch (NumberFormatException e) {
            System.out.println("Error: La entrada no es un numero valido.");
        }

        System.out.println("\nPrograma finalizado correctamente.");
        input.close();
    }
}