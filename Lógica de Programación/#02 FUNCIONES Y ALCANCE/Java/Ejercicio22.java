/*Ejercicio 2: Conversión de temperatura
Implementa una función que convierta grados Celsius a Fahrenheit. El valor en Celsius 
se ingresa desde el main(), se pasa como parámetro y se imprime el resultado retornado.*/
import java.util.Scanner;

public class Ejercicio22 {

    static float convertirTemperatura(float temperatura) {
        float fahrenheit = (temperatura * 9/5) + 32;
        return fahrenheit;
    }

    public static void main(String[] args) {
        float celsius;
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese una temperatura en celsius: ");
        celsius = input.nextFloat();
        System.out.println();
        System.out.println("La temperatura en fahrenheit es: " + convertirTemperatura(celsius));
        input.close();
    }    
}