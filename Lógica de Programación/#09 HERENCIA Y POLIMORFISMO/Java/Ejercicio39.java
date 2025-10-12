/*Ejercicio 3: Animales Polimórficos
Crea una clase base Animal con un método hacerSonido().
Implementa las subclases Perro, Gato y Vaca que sobrescriban ese método.
Crea un arreglo de animales y muestra cómo cada uno emite su sonido usando polimorfismo.*/
import java.util.ArrayList;
import java.util.List;

public class Ejercicio39 {
    public static void main(String[] args) {
        List<Animal> granja = new ArrayList<>();

        granja.add(new Perro("Milo"));
        granja.add(new Gato("Micho"));
        granja.add(new Vaca("Lola"));
        granja.add(new Perro("Leyla"));
        granja.add(new Gato("Karen"));
        granja.add(new Vaca("Messi"));

        System.out.println("\n--- LISTA DE ANIMALES DE LA GRANJA ---");
        for (Animal animal : granja) {
            System.out.println(animal.getNombre() + " dice: ");
            animal.sonido();
        }
    }
}

class Animal {
    private String nombre;

    public String getNombre() {
        return this.nombre;
    }

    public Animal(String nombre) {
        this.nombre = nombre;
    }
    
    public void sonido() {
        System.out.println("No hay sonido.");
    }
}

class Perro extends Animal {
    public Perro(String nombre) {
        super(nombre);
    }
    
    public void sonido() {
        System.out.println("Guau!");
    }
}

class Gato extends Animal {
    public Gato(String nombre) {
        super(nombre);
    } 

    public void sonido() {
        System.out.println("Miau!");
    }
}

class Vaca extends Animal {
    public Vaca(String nombre) {
        super(nombre);
    }

    public void sonido() {
        System.out.println("Moo!");
    }
}