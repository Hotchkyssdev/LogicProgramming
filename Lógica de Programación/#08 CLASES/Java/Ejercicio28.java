/*Ejercicio 2: Clase Coche
Diseña una clase Coche con atributos marca, modelo y velocidad.
Agrega métodos para acelerar, frenar y mostrar la velocidad actual.
Simula una carrera entre dos coches.*/

public class Ejercicio28 {
    public static void main(String[] args) {
        Coche mi_Coche = new Coche("Fiat", "Toro", 0);
        Coche mi_Coche2 = new Coche("Renault", "Alaskan", 0);

        System.out.println("\n--- CARRERA ---");
        mi_Coche.mostrarDatos();
        mi_Coche2.mostrarDatos();
        System.out.println("-----------------------------");

        System.out.println("INICIA LA CARRERA:");
        System.out.println(mi_Coche.acelerar(20));
        System.out.println(mi_Coche2.acelerar(30));
        System.out.println(mi_Coche.acelerar(40));
        System.out.println(mi_Coche2.acelerar(10));

        System.out.println(mi_Coche.frenar(10)); 
        System.out.println(mi_Coche2.frenar(5));
        System.out.println(mi_Coche.acelerar(5));
        System.out.println("-----------------------------");

        System.out.println("VELOCIDADES FINALES:");
        System.out.println(mi_Coche.velocidadActual());
        System.out.println(mi_Coche2.velocidadActual());
        System.out.println("-----------------------------");

        System.out.println("\nRESULTADO");
        if (mi_Coche.getVelocidad() > mi_Coche2.getVelocidad()) {
            System.out.println("La carrera la gano: " + mi_Coche.getNombreCompleto() + " con " + mi_Coche.getVelocidad() + " km/h.");
        } else if (mi_Coche2.getVelocidad() > mi_Coche.getVelocidad()) {
            System.out.println("La carrera la gano: " + mi_Coche2.getNombreCompleto() + " con " + mi_Coche2.getVelocidad() + " km/h.");
        } else {
            System.out.println("¡Empate! Ambos coches terminaron con " + mi_Coche.getVelocidad() + " km/h.");
        }
    } 
}

class Coche {
    private String marca;
    private String modelo;
    private int velocidad;

    public int getVelocidad() {
        return this.velocidad;
    }

    public String getNombreCompleto() {
        return this.marca + " " + this.modelo;
    }

    public Coche() {

    }

    public Coche(String marca, String modelo, int velocidad) {
        this.marca = marca;
        this.modelo = modelo;
        this.velocidad = velocidad;
    }

    public String acelerar(int aumento) {
        this.velocidad += aumento;
        return this.marca + " " + this.modelo + " ACELERA en " + aumento + " km/h. Velocidad actual: " + this.velocidad + " km/h.";
    }

    public String frenar(int reduccion) {
        this.velocidad -= reduccion;
        if (this.velocidad < 0) {
            this.velocidad = 0;
        }

        return this.marca + " " + this.modelo +  " FRENA en " + reduccion + " km/h. Velocidad actual: " + this.velocidad + " km/h.";
    }

    public String velocidadActual() {
        return this.marca + " " + this.modelo +  " tiene una velocidad de: " + this.velocidad +  " km/h.";
    }

    public void mostrarDatos() {
        System.out.println("Marca: " + marca + " | Modelo: " + modelo);
    }
}