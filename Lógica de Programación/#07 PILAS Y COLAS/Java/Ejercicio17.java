/*Ejercicio 1: Pila de Números
Implementa una pila que permita apilar, desapilar y mostrar números enteros.
El programa debe impedir desapilar si la pila está vacía.*/
import java.util.Scanner;

public class Ejercicio17 {
    public static void main(String[] args) {
        Pila miPila = new Pila();
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;

        do {
            System.out.println("\n--- PILA DE NUMEROS ---");
            System.out.println("1. Apilar numero");
            System.out.println("2. Desapilar numero");
            System.out.println("3. Mostrar pila");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");

            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese el numero a apilar: ");
                        miPila.apilar(scanner.nextInt());
                        break;
                    case 2:
                        int desapilado = miPila.desapilar();
                        if (desapilado != Integer.MIN_VALUE) {
                            System.out.println("<- Desapilado: " + desapilado);
                        }
                        break;
                    case 3:
                        miPila.mostrar();
                        break;
                }
            } else {
                scanner.next(); //Limpiar entrada inválida
            }
        } while (opcion != 0);
        
        scanner.close();
    }
}

class NodoPila {
    public int dato;
    public NodoPila siguiente;

    public NodoPila(int dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}

class Pila {
    private NodoPila tope;

    public Pila() {
        this.tope = null;
    }

    public boolean estaVacia() {
        return tope == null;
    }

    public void apilar(int dato) {
        NodoPila nuevo = new NodoPila(dato);
        nuevo.siguiente = tope;
        tope = nuevo;
        System.out.println("-> Apilado: " + dato);
    }

    public int desapilar() {
        if (estaVacia()) {
            System.out.println("ERROR: La pila esta vacia. No se puede desapilar.");
            return Integer.MIN_VALUE; //Valor especial para indicar error
        }
        int datoDesapilado = tope.dato;
        tope = tope.siguiente;

        return datoDesapilado;
    }

    public void mostrar() {
        NodoPila actual = tope;
        System.out.print("PILA (Tope -> Base): ");
        if (estaVacia()) {
            System.out.println("[VACIA]");
            return;
        }
        while (actual != null) {
            System.out.print(actual.dato + " | ");
            actual = actual.siguiente;
        }
        System.out.println();
    }
}