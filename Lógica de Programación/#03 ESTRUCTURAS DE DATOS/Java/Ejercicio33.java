/*Ejercicio 3: Enumeraciones y Tipos Compuestos
Usa una enumeración (enum) para representar los días de la semana y una estructura 
que relacione cada día con una tarea.
Permite al usuario mostrar, agregar y modificar tareas según el día seleccionado.*/
import java.util.Scanner;

enum DiaSemana {
    LUNES("Lunes"),
    MARTES("Martes"),
    MIERCOLES("Miércoles"),
    JUEVES("Jueves"),
    VIERNES("Viernes"),
    SABADO("Sábado"),
    DOMINGO("Domingo");

    private final String nombre;
    private String tarea;

    DiaSemana(String nombre) {
        this.nombre = nombre;
        this.tarea = "Sin tarea asignada";
    }

    public String getNombre() {
        return nombre;
    }

    public String getTarea() {
        return tarea;
    }

    public void setTarea(String tarea) {
        this.tarea = tarea;
    }
}

public class Ejercicio33 {

    private static final DiaSemana[] agenda = DiaSemana.values();
    private static final Scanner input = new Scanner(System.in);

    public static void mostrarMenu() {
        System.out.println("\n--- AGENDA SEMANAL ---");
        System.out.println("1. Mostrar todas las tareas");
        System.out.println("2. Modificar/Agregar a tarea a un día");
        System.out.println("3. Mostrar tarea de un día específico");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opcion: ");
    }

    private static int seleccionarDia() {
        int indice;
        System.out.println("\n--- DIAS DE LA SEMANA ---");
        for (int i = 0; i < agenda.length; i++) {
            System.out.printf("%d. %s\n", (i+1), agenda[i].getNombre());
        }
        System.out.print("Ingrese el número del día: ");

        if (input.hasNextInt()) {
            indice = input.nextInt();
            input.nextLine();
            if (indice >= 1 && indice <= agenda.length) {
                return indice - 1;
            }
        }
        input.nextLine();
        System.out.println("Seleccion no válida.");
        return -1;
    }

    private static void mostrarTareas() {
        System.out.println("\n--- TAREAS DE LA SEMAMA ---");
        System.out.printf("%-10s | %s\n", "DÍA", "TAREA ASIGNADA");
        System.out.println("----------------------------------------");

        for (DiaSemana dia : agenda) {
            System.out.printf("%-10s | %s\n", dia.getNombre(), dia.getTarea());
        }
    }

    private static void modificarTarea() {
        int indice = seleccionarDia();
        String nuevaTarea;

        if (indice != -1) {
            DiaSemana dia = agenda[indice];
            System.out.printf("Tarea actual para %s: %s\n", dia.getNombre(), dia.getTarea());
            System.out.print("Ingrese la NUEVA tarea: ");
            nuevaTarea = input.nextLine();

            dia.setTarea(nuevaTarea);
            System.out.printf("Tarea de %s actualizada a: %s\n", dia.getNombre(), dia.getTarea());
        }
    }

    private static void mostrarTareaPorDia() {
        int indice = seleccionarDia();

        if (indice != -1) {
            DiaSemana dia = agenda[indice];
            System.out.printf("\n--> Tarea para %s: %s\n", dia.getNombre(), dia.getTarea());
        }
    }

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            if (input.hasNextInt()) {
                opcion = input.nextInt();
                input.nextLine();
            } else {
                System.out.println("ERROR: Ingrese número válido.");
                input.nextLine();
                opcion = -1;
                continue;
            }

            switch (opcion) {
                case 1:
                    mostrarTareas();
                    break;
                case 2:
                    modificarTarea();
                    break;
                case 3:
                    mostrarTareaPorDia();
                    break;
                case 0:
                    System.out.println("Agenda cerrada. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);

        input.close();
    }
}