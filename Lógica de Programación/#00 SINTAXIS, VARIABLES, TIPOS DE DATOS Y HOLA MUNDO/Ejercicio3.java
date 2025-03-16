/* 
3️⃣ Personalización de un Mensaje de Bienvenida
Consigna:
Escribe un programa en Java que solicite al usuario su nombre y su edad mediante la función Scanner(). 
Luego, el programa debe imprimir un mensaje de bienvenida personalizado en la consola, 
que incluya el nombre y la edad ingresados.
*/

import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese su nombre: ");
        String nombre = input.nextLine();
        System.out.println("Ingrese su edad: ");
        int edad = input.nextInt();
        System.out.println("¡Bienvenido/a, " + nombre + "! Tienes " + edad + " años.");
        input.close();
    }
}
