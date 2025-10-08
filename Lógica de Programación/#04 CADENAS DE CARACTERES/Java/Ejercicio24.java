/*Ejercicio 2: Eliminación de Espacios
Crea un programa que reciba una cadena y genere otra sin espacios en blanco, mostrando ambas por pantalla.*/
import java.util.Scanner;

public class Ejercicio24 {
    public static void main(String[] args)  {
        Scanner input = new Scanner(System.in);
        String cadena;
        String cadenaSinEspacios;
        char c;
        System.out.print("Ingrese una cadena: ");
        cadena = input.nextLine();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cadena.length(); i++) {
            c = cadena.charAt(i);

            if (c != ' ') {
                sb.append(c);
            }
        }
        cadenaSinEspacios = sb.toString();

        System.out.println("\n--- RESULTADOS---");
        System.out.println("Cadena Original: " + cadena);
        System.out.println("Cadena sin espacios: " + cadenaSinEspacios);
        System.out.println("--------------------------------------------");

        input.close();
    }
}