/*Ejercicio 1: Herencia de Empleados
Crea una clase base Empleado con atributos nombre y salario.
Deriva las clases Gerente y Desarrollador, cada una con un método mostrarDatos() personalizado.
Demuestra el uso del polimorfismo al imprimir la información de diferentes tipos de empleados.*/

public class Ejercicio19 {
    public static void main(String[] args) {
        Empleado miEmpleado = new Empleado("Messi", 5000);
        Gerente miGerente = new Gerente("Juampa", 20000);
        Desarrollador miDesarrollador = new Desarrollador("Gersom", 10000);

        miEmpleado.mostrarDatos();
        System.out.println();
        miGerente.mostrarDatos();
        System.out.println();
        miDesarrollador.mostrarDatos();
    }
}

class Empleado {
    private String nombre;
    private double salario;

    public String getNombre() {
        return this.nombre;
    }

    public double getSalario() {
        return this.salario;
    }

    public Empleado(String nombre, double salario) {
        this.nombre = nombre;
        this.salario = salario;
    }

    public void mostrarDatos() {
        System.out.println("Empleado: " + this.getNombre() +  " | Salario: " + this.getSalario());
    }
}

class Gerente extends Empleado {

    public Gerente(String nombre, double salario) {
        super(nombre, salario);
    }

    public void mostrarDatos() {
        System.out.println("Gerente: " + this.getNombre() +  " | Salario: " + this.getSalario());
    }
}

class Desarrollador extends Empleado {

    public Desarrollador(String nombre, double salario) {
        super(nombre, salario);
    }

    public void mostrarDatos() {
        System.out.println("Desarrollador: " + this.getNombre() + " | Salario: " + this.getSalario());
    }
}