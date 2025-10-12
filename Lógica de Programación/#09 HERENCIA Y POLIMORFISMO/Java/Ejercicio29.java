/*Ejercicio 2: Jerarquía de Vehículos
Define una clase Vehiculo con atributos marca y modelo.
Crea las subclases Auto y Moto que sobrescriban un método acelerar().
Muestra cómo el mismo método se comporta distinto según el tipo de vehículo.*/

public class Ejercicio29 {
    public static void main(String[] args) {
        Auto auto1 = new Auto("Fiat", "Toro", 0);
        Moto moto1 = new Moto("Kawasaki", "Z 500 SE", 0);

        auto1.acelerar(30);
        System.out.println();
        moto1.acelerar(40);
        System.out.println();
        auto1.acelerar(40);
        System.out.println();
        moto1.acelerar(50);
    }
}

class Vehiculo {
    private String marca;
    private String modelo;
    protected int velocidad;

    public String getMarca() {
        return this.marca;
    }

    public String getModelo() {
        return this.modelo;
    }

    public int getVelocidad() {
        return this.velocidad;
    }

    public Vehiculo(String marca, String modelo, int velocidad) {
        this.marca = marca;
        this.modelo  = modelo;
        this.velocidad = velocidad;
    }
}

class Auto extends Vehiculo {

    public Auto(String marca, String modelo, int velocidad) {
        super(marca, modelo, velocidad);
    }

    public void acelerar(int aumento) {
        this.velocidad += aumento;

        System.out.println("El auto " + this.getMarca() + " " + this.getModelo() + " esta acelerando. Velocidad actual: " + this.velocidad + " km/h.");
    }
}

class Moto extends Vehiculo {

    public Moto(String marca, String modelo, int velocidad) {
        super(marca, modelo, velocidad);
    }

    public void acelerar(int aumento) {
        this.velocidad += aumento;

        System.out.println("La moto " + this.getMarca() + " " + this.getModelo() + " esta acelerando. Velocidad actual: " + this.velocidad + " km/h.");
    }
} 