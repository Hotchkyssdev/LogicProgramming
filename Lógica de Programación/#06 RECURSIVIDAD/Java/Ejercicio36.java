/*Ejercicio 3: Invertir Cadena
Diseña una función recursiva que reciba una cadena de texto y la devuelva invertida.*/
import java.util.Scanner;

public class Ejercicio36 {

    public static void invertirCadena(char[] cadena, int inicio, int fin) {
        char temp;
        if (inicio >= fin) {
            return;
        }

        temp = cadena[inicio];
        cadena[inicio] = cadena[fin];
        cadena[fin] = temp;
        invertirCadena(cadena, inicio + 1, fin - 1);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String textoOriginal = "Recursividad en Java!";
        char[] arrayDeCaracteres = textoOriginal.toCharArray();

        System.out.println("\n---INVERTIR CADENA---");
        System.out.println("Cadena Original: " + textoOriginal);
        invertirCadena(arrayDeCaracteres, 0, arrayDeCaracteres.length - 1);
        String textoInvertido = new String(arrayDeCaracteres);
        System.out.println("Cadena Invertida: " + textoInvertido);
        input.close();
    }
}