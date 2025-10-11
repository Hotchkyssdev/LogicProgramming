/*Ejercicio 1: Clase Persona
Crea una clase Persona con atributos nombre, edad y dni.
Incluye un constructor, métodos mostrarDatos() y esMayorDeEdad().
Crea varios objetos y muestra su información.*/

public class Ejercicio18 {
    public static void main(String[] args) {
        Persona mi_Persona = new Persona("Gersom Tomas", 19, 123456789);
        Persona mi_Persona2 = new Persona("Guille Portillo", 19, 987654321);
        Persona mi_Persona3 = new Persona("Mateo Pelizardi", 19, 523542134);

        mi_Persona.mostrarDatos();
        System.out.println("");
        mi_Persona2.mostrarDatos();
        System.out.println("");
        mi_Persona3.mostrarDatos();
    }
}

class Persona {
    private String nombre;
    private int edad;
    private int dni;

    public Persona() {

    }

    public Persona(String nombre, int edad, int dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public void mostrarDatos() {
        System.out.println("Nombre: " + nombre + " | Edad: " + edad + " | DNI: " + dni);
    }

    public void esMayorDeEdad() {
        if (edad >= 18) {
            System.out.println("La persona " + nombre + " es mayor de edad.");
        } else {
            System.out.println("La persona " + nombre + " NO es mayor de edad.");
        }
    }
}