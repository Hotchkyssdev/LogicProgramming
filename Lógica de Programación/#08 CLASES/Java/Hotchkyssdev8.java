/* EJERCICIO:
 * Explora el concepto de clase y crea un ejemplo que implemente un inicializador,
 * atributos y una función que los imprima (teniendo en cuenta las posibilidades
 * de tu lenguaje).
 * Una vez implementada, créala, establece sus parámetros, modifícalos e imprímelos
 * utilizando su función.
 *
 * DIFICULTAD EXTRA (opcional):
 * Implementa dos clases que representen las estructuras de Pila y Cola (estudiadas
 * en el ejercicio número 7 de la ruta de estudio)
 * - Deben poder inicializarse y disponer de operaciones para añadir, eliminar,
 *   retornar el número de elementos e imprimir todo su contenido.
 */
import java.util.ArrayList;
import java.util.List;

public class Hotchkyssdev8 {
    public static void main(String[] args) {
        List<String> lenguajes = new ArrayList<>();
        lenguajes.add("Python");
        lenguajes.add("C");
        lenguajes.add("Java");

        Programador mi_Programador = new Programador("Gersom Tomas", 19, lenguajes);
        mi_Programador.imprimir();

        mi_Programador.apellido = "Hotchkyss";
        mi_Programador.imprimir();

        mi_Programador.edad = 20;
        mi_Programador.imprimir();
        System.out.println("");

        //EXTRA
        System.out.println("\n---EXTRA (Pila)---");
        ejecutarDemoPila();
        System.out.println("");

        System.out.println("\n---EXTRA (Cola)---");
        ejecutarDemoCola();
    }

    public static void ejecutarDemoPila() {
        Pila mi_pila = new Pila();
        mi_pila.push("A");
        mi_pila.push("B");
        mi_pila.push("C");
        System.out.println(mi_pila.contador());
        mi_pila.printPila();
        mi_pila.pop();
        System.out.println(mi_pila.contador());
        System.out.println(mi_pila.pop());
        System.out.println(mi_pila.pop());
        System.out.println(mi_pila.pop());
        System.out.println(mi_pila.pop());
        System.out.println(mi_pila.pop());
        System.out.println(mi_pila.contador());
    }

    public static void ejecutarDemoCola() {
        Cola mi_cola = new Cola();
        mi_cola.enqueue("A");
        mi_cola.enqueue("B");
        mi_cola.enqueue("C");
        System.out.println(mi_cola.contador());
        mi_cola.printCola();
        mi_cola.dequeue();
        System.out.println(mi_cola.contador());
        System.out.println(mi_cola.dequeue());
        System.out.println(mi_cola.dequeue());
        System.out.println(mi_cola.dequeue());
        System.out.println(mi_cola.dequeue());
        System.out.println(mi_cola.dequeue());
        System.out.println(mi_cola.contador());
    }
}

class Programador {
    protected String nombre;
    protected int edad;
    protected List<String> lenguaje;
    protected String apellido = null;

    public Programador(String nombre, int edad, List<String> lenguaje) {
        this.nombre = nombre;
        this.edad = edad;
        this.lenguaje = lenguaje;
    }

    public void imprimir() {
        System.out.println(String.format(
            "Nombre: %s | Apellidos: %s | Edad: %d | Lenguajes: %s",
            this.nombre, 
            this.apellido, 
            this.edad, 
            this.lenguaje.toString() // Convierte la lista a una representación de cadena
        ));
    }
}

class Pila {
    private List<String> pila;

    public Pila() {
        this.pila  = new ArrayList<>();
    }

    public void push(String item) {
        this.pila.add(item);
    } 

    public String pop() {
        if (contador() == 0) {
            return null;
        }

        return this.pila.remove(this.pila.size() - 1);
    }

    public int contador() {
        return this.pila.size(); 
    }  

    public void printPila() {
        for (int i = this.pila.size() - 1; i >= 0; i--) {
            System.out.println(this.pila.get(i));
        }
    }
}

class Cola {
    private List<String> cola;

    public Cola() {
        this.cola = new ArrayList<>();
    }

    public void enqueue(String item) {
        this.cola.add(item);
    }

    public String dequeue() {
        if (contador() == 0) {
            return null;
        }

        return this.cola.remove(0);
    }

    public int contador() {
        return this.cola.size();
    }

    public void printCola() {
        for (String item : this.cola) {
            System.out.println(item);
        }
    }
}