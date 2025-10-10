/*Ejercicio 3: Verificar Palíndromo con Pila y Cola
Usa simultáneamente una pila y una cola para determinar si una palabra o frase es palíndroma (se lee igual al derecho y al revés).*/
import java.util.Scanner;

public class Ejercicio37 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- VERIFICADOR DE PALINDROMOS CON PILA Y COLA ---");
        System.out.print("Ingrese una palabra o frase: ");
        String frase = scanner.nextLine();

        //Limpiar la frase
        String fraseLimpia = frase.toLowerCase().replaceAll("[^a-z0-9]", "");

        //Apilar y encolar cada carácter
        PilaChar pila = new PilaChar();
        ColaChar cola = new ColaChar();
        for (char c : fraseLimpia.toCharArray()) {
            pila.apilar(c);
            cola.encolar(c);
        }

        //Comparar al desapilar y desencolar
        boolean esPalindromo = true;
        while (!pila.estaVacia() && !cola.estaVacia()) {
            char desdePila = pila.desapilar();   //Sale el último carácter
            char desdeCola = cola.desencolar(); //Sale el primer carácter

            if (desdePila != desdeCola) {
                esPalindromo = false;
                break;
            }
        }

        //Mostrar resultado
        System.out.println("\nFrase original: \"" + frase + "\"");
        if (esPalindromo && !fraseLimpia.isEmpty()) {
            System.out.println("Resultado: SI es un palindromo.");
        } else {
            System.out.println("Resultado: NO es un palindromo.");
        }
        
        scanner.close();
    }
}

class NodoChar {
    public char dato;
    public NodoChar siguiente;

    public NodoChar(char dato) { 
        this.dato = dato; 
    }
}

class PilaChar {
    private NodoChar tope;

    public void apilar(char c) {
        NodoChar nuevo = new NodoChar(c);
        nuevo.siguiente = tope;
        tope = nuevo;
    }

    public char desapilar() {
        if (tope == null) {
            return '\0';
        }
        char dato = tope.dato;
        tope = tope.siguiente;

        return dato;
    }

    public boolean estaVacia() { 
        return tope == null; 
    }
}

class ColaChar {
    private NodoChar frente, fin;

    public void encolar(char c) {
        NodoChar nuevo = new NodoChar(c);
        if (fin == null) {
            frente = fin = nuevo;
        } else {
            fin.siguiente = nuevo;
            fin = nuevo;
        }
    }

    public char desencolar() {
        if (frente == null) {
            return '\0';
        }

        char dato = frente.dato;
        frente = frente.siguiente;

        if (frente == null) {
            fin = null;
        }

        return dato;
    }

    public boolean estaVacia() { 
        return frente == null; 
    }
}