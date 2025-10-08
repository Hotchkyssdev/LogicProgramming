/*Ejercicio 2: Estructura de Alumno
Define una estructura (struct) llamada Alumno con nombre, edad y promedio.
Crea un arreglo de alumnos, muestra sus datos y calcula el promedio general del grupo.*/
class Alumno {
    String nombre;
    int edad;
    double promedio;

    public Alumno(String nombre, int edad, double promedio) {
        this.nombre = nombre;
        this.edad = edad;
        this.promedio = promedio;
    }

    public void mostrarDatos() {
        System.out.printf("| %-20s | %-4d | %-8.2f |\n", nombre, edad, promedio);
    }
}

public class Ejercicio23 {
    public static void main(String[] args) {
        Alumno[] grupoAlumnos = new Alumno[3];

        grupoAlumnos[0] = new Alumno("Gersom Hotchkyss", 19, 9.12);
        grupoAlumnos[1] = new Alumno("Guille Portillo", 19, 7.55);
        grupoAlumnos[2] = new Alumno("Nacho Fernandez", 20, 7.33);

        System.out.println("--- DATOS DEL GRUPO DE ALUMNOS ---");
        System.out.println("-------------------------------------------------");
        System.out.printf("| %-20s | %-4s | %-8s |\n", "NOMBRE", "EDAD", "PROMEDIO");
        System.out.println("-------------------------------------------------");

        for (Alumno alumno : grupoAlumnos) {
            alumno.mostrarDatos();
        }
        System.out.println("-------------------------------------------------");

        calcularPromedioGrupo(grupoAlumnos);
    }

    public static void calcularPromedioGrupo(Alumno[] alumnos) {
        double sumaPromedios = 0;
        double promedioGeneral;
        if (alumnos.length == 0) {
            System.out.println("No hay alumnos en el grupo para calcular el promedio.");
            return;
        }

        for (Alumno alumno : alumnos) {
            sumaPromedios += alumno.promedio;
        }
        promedioGeneral = sumaPromedios / alumnos.length;

        System.out.println("\n--- CÁLCULO GENERAL ---");
        System.out.printf("Suma total de promedios: %.2f\n", sumaPromedios);
        System.out.printf("Cantidad de alumnos: %d\n", alumnos.length);
        System.out.printf("PROMEDIO GENERAL DEL GRUPO: %.2f\n", promedioGeneral);
    }
}