/*Ejercicio 2: Cola de Turnos
Crea una cola para gestionar turnos de atención (por ejemplo, en un banco).
Permite encolar nuevos clientes, atender al primero y mostrar la cola actual.*/
import java.util.Scanner;

public class Ejercicio27 {
    public static void main(String[] args) {
        Cola miCola = new Cola();
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;

        do {
            System.out.println("\n--- COLA DE TURNOS ---");
            System.out.println("1. Agregar cliente (encolar)");
            System.out.println("2. Atender cliente");
            System.out.println("3. Mostrar cola");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");

            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine(); //Limpiar buffer
                switch (opcion) {
                    case 1:
                        System.out.print("Nombre del cliente a agregar: ");
                        miCola.encolar(scanner.nextLine());
                        break;
                    case 2:
                        String atendido = miCola.atender();
                        if (atendido != null) {
                            System.out.println("<< Atendido: " + atendido);
                        }
                        break;
                    case 3:
                        miCola.mostrar();
                        break;
                }
            } else {
                scanner.next();
            }
        } while (opcion != 0);
        
        scanner.close();
    }
}

class NodoCola {
    public String cliente;
    public NodoCola siguiente;

    public NodoCola(String cliente) {
        this.cliente = cliente;
        this.siguiente = null;
    }
}

class Cola {
    private NodoCola frente;
    private NodoCola fin;

    public Cola() {
        this.frente = null;
        this.fin = null;
    }

    public boolean estaVacia() {
        return frente == null;
    }

    public void encolar(String cliente) {
        NodoCola nuevo = new NodoCola(cliente);
        if (estaVacia()) {
            frente = nuevo;
            fin = nuevo;
        } else {
            fin.siguiente = nuevo;
            fin = nuevo;
        }
        System.out.println("-> Cliente '" + cliente + "' ha entrado a la cola.");
    }

    public String atender() {
        if (estaVacia()) {
            System.out.println("No hay clientes en la cola.");
            return null;
        }
        String clienteAtendido = frente.cliente;
        frente = frente.siguiente;
        if (frente == null) {
            fin = null;
        }

        return clienteAtendido;
    }

    public void mostrar() {
        NodoCola actual = frente;
        System.out.print("COLA (Frente -> Fin): ");
        if (estaVacia()) {
            System.out.println("[VACIA]");
            return;
        }
        while (actual != null) {
            System.out.print("[" + actual.cliente + "] -> ");
            actual = actual.siguiente;
        }
        System.out.println();
    }
}