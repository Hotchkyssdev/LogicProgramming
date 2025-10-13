/*Ejercicio 3: Excepción Personalizada
Crea una clase de excepción personalizada llamada EdadInvalidaException.
Haz que una función valide que la edad introducida esté entre 0 y 120, lanzando la excepción si no cumple la condición.
Captura la excepción e informa al usuario con un mensaje claro.*/
import java.util.Scanner;

public class Ejercicio310 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int edad;
        System.out.print("Ingrese una edad: ");
        edad = input.nextInt();
        
        try {
            validadEdad(edad);
        } catch (EdadInvalidaException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        System.out.println("\nPrograma finalizado correctamente.");
        input.close();
    }

    static void validadEdad(int edad) throws EdadInvalidaException {
        if (edad < 0 || edad > 120) {
            throw new EdadInvalidaException("Edad invalida. Debe estar entre 0 a 120 anios.");
        }
        System.out.println("Edad valida: " + edad);
    }
}

class EdadInvalidaException extends Exception {
    public EdadInvalidaException(String mensaje) {
        super(mensaje);
    }
}