/*Ejercicio 3: Operaciones básicas
Escribe un programa que declare dos números enteros, los sume, reste, multiplique y divida, 
mostrando los resultados con mensajes claros en pantalla.*/

public class Ejercicio3 {
    public static void main(String[] args) {
        int n1, n2, suma, resta, multiplicacion;
        float division;
        n1 = 10;
        n2 = 3;
        suma = n1 + n2;
        resta  = n1 - n2;
        multiplicacion = n1 * n2;
        division = (float) n1 / (float) n2;
        System.out.println("La suma de " + n1 + " y " + n2 + " es: " + suma);
        System.out.println("La resta de " + n1 + " y " + n2 + " es: " + resta);
        System.out.println("La multiplicacion de " + n1 + " y " + n2 + " es: " + multiplicacion);
        System.out.println("La division de " + n1 + " y " + n2 + " es: " + division);
    }    
}