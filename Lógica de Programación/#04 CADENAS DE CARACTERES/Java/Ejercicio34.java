/*Ejercicio 3: Comparar y Concatenar
Solicita dos cadenas de texto al usuario, compara si son iguales y, 
si no lo son, concaténalas y muestra el resultado.*/
import java.util.Scanner;

public class Ejercicio34 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String cadena1;
        String cadena2;

        System.out.print("Ingrese la primer cadena: ");
        cadena1 = input.nextLine();

        System.out.print("Ingrese la segunda cadena: ");
        cadena2 = input.nextLine();

        if (cadena1.equalsIgnoreCase(cadena2)) {
            System.out.println("\nLas cadenas son iguales.");
        } else {
            System.out.println("\nLa concatenacion de las cadenas es: " + cadena1 + " " + cadena2 +  ".");
        }

        input.close();
    }
}