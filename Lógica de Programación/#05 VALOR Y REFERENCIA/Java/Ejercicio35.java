/*Ejercicio 3: Suma Acumulada
Implementa una función que reciba una variable por referencia y le sume una cantidad introducida por el usuario, 
mostrando el valor antes y después de la llamada.*/
import java.util.Scanner;

public class Ejercicio35 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int variable;
        System.out.print("Ingrese un numero entero: ");
        variable = input.nextInt();

        Entero variableContenedor = new Entero(variable);

        System.out.println("Valor antes de la funcion: " +  variableContenedor.valor);
        sumaVariableReferencia(variableContenedor, input);
        System.out.println("Valor despues de la funcion: " + variableContenedor.valor);

        input.close();
    }

    private static void sumaVariableReferencia(Entero variableContenedor, Scanner input) {
        int suma;
        System.out.print("Ingrese un numero para sumarle a la variable: ");
        suma = input.nextInt();
        variableContenedor.valor = variableContenedor.valor + suma;
        System.out.println("El valor de la variable dentro de la funcion es: " + variableContenedor.valor);
    }
}

class Entero {
    public int valor;

    public Entero(int valor) {
        this.valor = valor;
    }
}