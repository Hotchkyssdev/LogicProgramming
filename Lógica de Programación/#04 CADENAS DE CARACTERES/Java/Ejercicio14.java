/*Ejercicio 1: Contador de Vocales y Consonantes
Escribe un programa que solicite una cadena al usuario y muestre cuántas vocales y consonantes contiene.*/
import java.util.Scanner;

public class Ejercicio14 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String cadena;
        char letra;
        int longitud;
        int vocales = 0, consonantes = 0;
        System.out.print("Ingrese una cadena: ");
        cadena = input.nextLine();
        longitud = cadena.length();

        for (int i = 0; i < longitud; i++) {
            letra = cadena.charAt(i);

            if (esVocal(letra)) {
                vocales++;
            }  else {
                consonantes++;
            }
        }

        System.out.println("\n--- RESULTADOS ---");
        System.out.println("Cadena original: \"" + cadena + "\"");
        System.out.println("Total de letras analizadas: " + cadena.length());
        System.out.println("Vocales encontradas: " + vocales);
        System.out.println("Consonantes encontradas: " + consonantes);
        input.close();
    }

    private static boolean esVocal(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}