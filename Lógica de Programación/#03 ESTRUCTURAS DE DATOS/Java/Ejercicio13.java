/*Ejercicio 1: Arreglo de Productos
Crea un programa que almacene los nombres y precios de varios productos en arreglos paralelos.
Permite al usuario insertar, actualizar, eliminar y listar productos.*/
import java.util.Scanner;

public class Ejercicio13 {
    //Inicializacion de variables y Scanner
    private static final int MAX_PRODUCTOS = 10;
    private static String[] nombres = new String[MAX_PRODUCTOS];
    private static double[] precios = new double[MAX_PRODUCTOS];
    private static int cantProductos = 0;
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            if (input.hasNextInt()) {
                opcion = input.nextInt();
                input.nextLine();
            } else {
                System.out.println("ERROR: Ingrese un número válido.");
                input.nextLine();
                opcion = -1;
                continue;
            }

            switch (opcion) {
                case 1:
                    insertarProducto();
                    break;
                case 2:
                    actualizarProducto();
                    break;
                case 3:
                    eliminarProducto();
                    break;
                case 4:
                    listarProductos();
                    break;
                case 0:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo"); 
            }
        } while (opcion != 0);

        input.close();
    }

    //Funciones
    private static void mostrarMenu() {
        System.out.println("\n---GESTION DE PRODUCTOS---\n");
        System.out.println("Espacio libre: " + (MAX_PRODUCTOS - cantProductos));
        System.out.println("1. Insertar nuevo producto");
        System.out.println("2. Actualizar precio de producto");
        System.out.println("3. Eliminar producto");
        System.out.println("4. Listar todos los productos");
        System.out.println("0. Salir");
        System.out.print("Ingrese una opción: ");
    }

    private static void insertarProducto() {
        String nombre;
        double precio;
        if (cantProductos >= MAX_PRODUCTOS) {
            System.out.println("ERROR: El inventario esta lleno (máximo " + MAX_PRODUCTOS + " productos).");
            return;
        }

        System.out.print("\nIngrese el nombre del producto: ");
        nombre = input.nextLine();

        System.out.print("Ingrese el precio del producto: ");
        if (input.hasNextDouble()) {
            precio = input.nextDouble();
            input.nextLine();
        } else {
            System.out.println("ERROR: Ingrese un valor numérico para el precio.");
            input.nextLine();
            return;
        }

        if (precio <= 0) {
            System.out.println("ERROR: El precio debe ser un valor positivo.");
            return;
        }

        nombres[cantProductos] = nombre;
        precios[cantProductos] = precio;
        cantProductos++;
        System.out.println("\nProducto: '" + nombre + "' insertado en la posición " + (cantProductos) + ".");
    }

    private static void actualizarProducto() {
        String nombreBuscado;
        int indice;
        double nuevoPrecio;
        if (cantProductos == 0) {
            System.out.println("No hay productos para actualizar.");
            return;
        }

        System.out.print("Ingrese el nombre del producto a actualizar: ");
        nombreBuscado = input.nextLine();
        indice = -1;

        for (int i = 0; i < cantProductos; i++) {
            if (nombres[i].equalsIgnoreCase(nombreBuscado)) {
                indice = i;
                break;
            }
        }

        if (indice != -1) {
            System.out.print("Ingrese nuevo precio para '" + nombres[indice] + "': ");
            if (input.hasNextDouble()) {
                nuevoPrecio = input.nextDouble();
                input.nextLine();
            } else {
                System.out.println("ERROR: Ingrese un valor numérico para el precio.");
                input.nextLine();
                return;
            }

            if (nuevoPrecio <= 0) {
                System.out.println("El precio debe ser un valor positivo.");
                return;
            }

            precios[indice] = nuevoPrecio;
            System.out.println("Precio de '" + nombres[indice] + "' actualizado a " + nuevoPrecio + ".");
        } else {
            System.out.println("Producto '" + nombreBuscado + "' no encontrado.");
        }
    }

    private static void eliminarProducto() {
        int indice;
        String nombreBuscado;
        if (cantProductos == 0) {
            System.out.println("No hay productos para eliminar.");
            return;
        }

        System.out.print("Ingrese el nombre del producto a eliminar: ");
        nombreBuscado = input.nextLine();
        indice = -1;

        for (int i = 0; i < cantProductos; i++) {
            if (nombres[i].equalsIgnoreCase(nombreBuscado)) {
                indice = i;
                break;
            }
        }

        if (indice != -1) {
            for (int i = indice; i < cantProductos - 1; i++) {
                nombres[i] = nombres[i + 1];
                precios[i] = precios[i + 1];
            }
            nombres[cantProductos - 1] = null;
            precios[cantProductos - 1] = 0.0;
 
            cantProductos--;
            System.out.println("Producto '" + nombreBuscado + "' eliminado con éxito y arreglo compactado.");
        } else {
            System.out.println("Producto '" + nombreBuscado + "' no encontrado.");
        }
    }

    private static void listarProductos() {
        if (cantProductos == 0) {
            System.out.println("No hay productos para listar.");
            return;
        }

        System.out.println("\n--- LISTA DE PRODUCTOS (" + cantProductos + " elementos) ---");
        System.out.printf("%-5s %-30s %-10s\n", "ID", "NOMBRE", "PRECIO");
        System.out.println("-------------------------------------------------");

        for (int i = 0; i < cantProductos; i++) {
            System.out.printf("%-5d %-30s $%.2f\n", (i + 1), nombres[i], precios[i]);
        }
        System.out.println("-------------------------------------------------");
    }
}