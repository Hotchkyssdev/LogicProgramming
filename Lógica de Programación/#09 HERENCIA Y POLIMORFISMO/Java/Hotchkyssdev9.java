/* EJERCICIO:
 * Explora el concepto de herencia según tu lenguaje. Crea un ejemplo que
 * implemente una superclase Animal y un par de subclases Perro y Gato,
 * junto con una función que sirva para imprimir el sonido que emite cada Animal.
 *
 * DIFICULTAD EXTRA (opcional):
 * Implementa la jerarquía de una empresa de desarrollo formada por Empleados que
 * pueden ser Gerentes, Gerentes de Proyectos o Programadores.
 * Cada empleado tiene un identificador y un nombre.
 * Dependiendo de su labor, tienen propiedades y funciones exclusivas de su
 * actividad, y almacenan los empleados a su cargo.
 */
import java.util.ArrayList;
import java.util.List;

public class Hotchkyssdev9 {
    public static void main(String[] args) {
        Animal mi_animal = new Animal("Animal");
        mi_animal.sonido();

        Animal mi_perro = new Perro("Milo");
        mi_perro.sonido();

        Animal mi_gato = new Gato("Micho");
        mi_gato.sonido();
        System.out.println("");
        
        //EXTRA
        Manager mi_Manager = new Manager(1, "Hotchkyssdev");
        ProyectManager mi_ProyectManager = new ProyectManager(2, "Hotchkyss", "Proyecto 1");
        ProyectManager mi_ProyectManager2 = new ProyectManager(3, "Gersom", "Proyecto 2");
        Programador mi_Programador = new Programador(4, "Portillo", "Java");
        Programador mi_Programador2 = new Programador(5, "Alfonsi", "PHP");
        Programador mi_Programador3 = new Programador(6, "Armando", "SQL");
        Programador mi_Programador4 = new Programador(7, "Marcos", "Python");
        
        mi_Manager.agregarSubordinado(mi_ProyectManager);
        mi_Manager.agregarSubordinado(mi_ProyectManager2);

        mi_ProyectManager.agregarSubordinado(mi_Programador);
        mi_ProyectManager.agregarSubordinado(mi_Programador2);
        mi_ProyectManager2.agregarSubordinado(mi_Programador3);
        mi_ProyectManager2.agregarSubordinado(mi_Programador4);

        mi_Programador.agregarSubordinado(mi_Programador2);

        mi_Programador.codigo();
        mi_ProyectManager.coordinarProyecto();
        mi_Manager.coordinarProyectos();
        mi_Manager.imprimirSubordinados();
        mi_ProyectManager.imprimirSubordinados();
        mi_Programador.imprimirSubordinados();
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

//EXTRA
class Empleado {
    private int id;
    private String nombre;
    protected List<Empleado> empleados;
    
    public int getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public Empleado() {

    }

    public Empleado(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.empleados = new ArrayList<>();
    }

    public void agregarSubordinado(Empleado empleado) {
        this.empleados.add(empleado);
        System.out.println(this.nombre + " ha agregado a " + empleado.getNombre());
    }

    public void imprimirSubordinados() {
        System.out.println("\n--- Subordinados de " + this.nombre + " ---");
        if (this.empleados.isEmpty()) {
            System.out.println("No tiene empleados a cargo.");
            return;
        } 
        for (Empleado empleado : this.empleados) {
            System.out.println(empleado.getNombre());
        }
    }
}

class Manager extends Empleado {
    public Manager(int id, String nombre) {
        super(id, nombre);
    }

    public void coordinarProyectos() {
        System.out.println(this.getNombre() + " esta coordinando todos los proyectos.");
    }
}

class ProyectManager extends Empleado {
    private String proyecto;

    public String getProyecto() {
        return this.proyecto;
    }

    public ProyectManager(int id, String nombre, String proyecto) {
        super(id, nombre);
        this.proyecto = proyecto;
    }

    public void coordinarProyecto() {
        System.out.println(this.getNombre() + " esta coordinando su proyecto: " + this.proyecto + ".");
    }
}

class Programador extends Empleado {
    private String lenguaje;

    public String getLenguaje() {
        return this.lenguaje;
    }

    public Programador(int id, String nombre, String lenguaje) {
        super(id, nombre);
        this.lenguaje = lenguaje;
    }

    public void codigo() {
        System.out.println(this.getNombre() + " esta programando en: " + this.lenguaje + ".");
    }

    public void agregarSubordinado(Empleado empleado) {
        System.out.println("Un programador no tiene empleados a cargo. " + empleado.getNombre() + " no se agregara.");
    }

    public void imprimirSubordinados() {
        System.out.println("\n--- Subordinados de " + this.getNombre() + " ---");
        System.out.println("Un programador no tiene empleados a cargo.");
    }
}