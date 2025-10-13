/* IMPORTANTE: Sólo debes subir el fichero de código como parte del ejercicio.
 *
 * EJERCICIO:
 * Desarrolla un programa capaz de crear un archivo que se llame como
 * tu usuario de GitHub y tenga la extensión .txt.
 * Añade varias líneas en ese fichero:
 * - Tu nombre.
 * - Edad.
 * - Lenguaje de programación favorito.
 * Imprime el contenido.
 * Borra el fichero.
 *
 * DIFICULTAD EXTRA (opcional):
 * Desarrolla un programa de gestión de ventas que almacena sus datos en un 
 * archivo .txt.
 * - Cada producto se guarda en una línea del archivo de la siguiente manera:
 *   [nombre_producto], [cantidad_vendida], [precio].
 * - Siguiendo ese formato, y mediante terminal, debe permitir añadir, consultar,
 *   actualizar, eliminar productos y salir.
 * - También debe poseer opciones para calcular la venta total y por producto.
 * - La opción salir borra el .txt.
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hotchkyssdev11 {
    public static void main(String[] args) {
        System.out.println("--- FICHEROS ---");
        String nombreFicheroBasico = "hotchkyssdev.txt";
        File ficheroBasico = new File(nombreFicheroBasico);

        //Escribir en el fichero 
        try (FileWriter fw = new FileWriter(ficheroBasico, false)) { 
            fw.write("Gersom Tomas Hotchkyss\n");
            fw.write("19\n");
            fw.write("Java\n");
            System.out.println("Archivo basico creado y escrito con exito.");
        } catch (IOException e) {
            System.err.println("ERROR al escribir el archivo basico: " + e.getMessage());
        }

        //Leer el fichero
        try (Scanner fileScanner = new Scanner(ficheroBasico)) { 
            System.out.println("\nContenido de " + nombreFicheroBasico + ":");
            while (fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine());
            }
        } catch (IOException e) {
            System.err.println("ERROR al leer el archivo basico: " + e.getMessage());
        }

        //Eliminar el fichero
        if (ficheroBasico.delete()) {
            System.out.println("\nArchivo basico eliminado con exito.");
        } else {
            System.out.println("\nERROR: No se pudo eliminar el archivo basico.");
        }

        //EXTRA
        System.out.println("\n--- EXTRA: GESTION DE VENTAS ---");
        String nombreFicheroTienda = "Tienda.txt";
        File ficheroTienda = new File(nombreFicheroTienda);
        Scanner scanner = new Scanner(System.in); 

        //Crear el archivo si no existe 
        try {
            if (ficheroTienda.createNewFile()) {
                System.out.println("Archivo Tienda.txt creado.");
            } else {
                System.out.println("Archivo Tienda.txt ya existe.");
            }
        } catch (IOException e) {
            System.err.println("ERROR al crear el archivo: " + e.getMessage());
        }

        while (true) {
            System.out.println("\n\n==================================");
            System.out.println("1. Ingresar nuevo producto");
            System.out.println("2. Consultar producto por nombre");
            System.out.println("3. Actualizar producto");
            System.out.println("4. Eliminar producto");
            System.out.println("5. Mostrar todos los productos");
            System.out.println("6. Calcular venta total");
            System.out.println("7. Calcular venta por producto");
            System.out.println("8. Salir (Elimina el archivo)");
            System.out.println("==================================");
            System.out.print("Seleccione una opcion: ");
            String opcion = scanner.nextLine();

            try {
                switch (opcion) {
                    case "1": 
                        System.out.print("Nombre: ");
                        String nombreAdd = scanner.nextLine().trim();
                        System.out.print("Cantidad: ");
                        String cantidadAdd = scanner.nextLine().trim();
                        System.out.print("Precio: ");
                        String precioAdd = scanner.nextLine().trim();

                        try (FileWriter fw = new FileWriter(ficheroTienda, true)) { //true para append
                            fw.write(nombreAdd + ", " + cantidadAdd + ", " + precioAdd + "\n");
                            System.out.println("Producto añadido.");
                        }
                        break;
                    case "2": 
                        System.out.print("Nombre a consultar: ");
                        String nombreConsultar = scanner.nextLine().trim();
                        boolean encontrado = false;

                        try (Scanner fileScanner = new Scanner(ficheroTienda)) {
                            while (fileScanner.hasNextLine()) {
                                String line = fileScanner.nextLine();
                                String[] partes = line.split(",\\s*");  //Dividir la línea por ", "
                                
                                if (partes.length >= 1 && partes[0].trim().equals(nombreConsultar)) {
                                    System.out.println("\nProducto encontrado: " + line);
                                    encontrado = true;
                                    break;
                                }
                            }
                        }
                        if (!encontrado) {
                            System.out.println("Producto '" + nombreConsultar + "' no encontrado.");
                        }
                        break;
                    case "3": 
                        System.out.print("Nombre del producto a actualizar: ");
                        String nombreUpdate = scanner.nextLine().trim();
                        System.out.print("Nueva cantidad: ");
                        String nuevaCantidad = scanner.nextLine().trim();
                        System.out.print("Nuevo precio: ");
                        String nuevoPrecio = scanner.nextLine().trim();
                        
                        List<String> lineasActualizadas = new ArrayList<>();
                        boolean updated = false;

                        //Leer todas las líneas
                        try (Scanner fileScanner = new Scanner(ficheroTienda)) {
                            while (fileScanner.hasNextLine()) {
                                String line = fileScanner.nextLine();
                                String[] partes = line.split(",\\s*");
                                
                                if (partes.length >= 1 && partes[0].trim().equals(nombreUpdate)) {
                                    //Reemplazar la línea
                                    lineasActualizadas.add(nombreUpdate + ", " + nuevaCantidad + ", " + nuevoPrecio);
                                    updated = true;
                                } else {
                                    lineasActualizadas.add(line);
                                }
                            }
                        }

                        //Reescribir el archivo con las líneas actualizadas
                        if (updated) {
                            try (FileWriter fw = new FileWriter(ficheroTienda, false)) { //false para sobreescribir
                                for (String linea : lineasActualizadas) {
                                    fw.write(linea + "\n");
                                }
                                System.out.println("Producto '" + nombreUpdate + "' actualizado.");
                            }
                        } else {
                            System.out.println("Producto '" + nombreUpdate + "' no encontrado para actualizar.");
                        }
                        break;
                    case "4": 
                        System.out.print("Nombre del producto a eliminar: ");
                        String nombreEliminar = scanner.nextLine().trim();
                        
                        List<String> lineasRestantes = new ArrayList<>();
                        boolean deleted = false;
                        
                        //Leer todas las líneas, excluyendo el producto a eliminar
                        try (Scanner fileScanner = new Scanner(ficheroTienda)) {
                            while (fileScanner.hasNextLine()) {
                                String line = fileScanner.nextLine();
                                String[] partes = line.split(",\\s*");
                                
                                if (partes.length >= 1 && partes[0].trim().equals(nombreEliminar)) {
                                    deleted = true; //No añado la línea a lineasRestantes
                                } else {
                                    lineasRestantes.add(line);
                                }
                            }
                        }

                        //Reescribir el archivo solo con las líneas restantes
                        if (deleted) {
                            try (FileWriter fw = new FileWriter(ficheroTienda, false)) { //false para sobreescribir
                                for (String linea : lineasRestantes) {
                                    fw.write(linea + "\n");
                                }
                                System.out.println("Producto '" + nombreEliminar + "' eliminado.");
                            }
                        } else {
                            System.out.println("Producto '" + nombreEliminar + "' no encontrado para eliminar.");
                        }
                        break;
                    case "5": 
                        System.out.println("\n--- LISTA COMPLETA DE PRODUCTOS ---");
                        try (Scanner fileScanner = new Scanner(ficheroTienda)) {
                            while (fileScanner.hasNextLine()) {
                                System.out.println(fileScanner.nextLine());
                            }
                        }
                        break;
                    case "6": 
                        double ventaTotal = 0.0;
                        try (Scanner fileScanner = new Scanner(ficheroTienda)) {
                            while (fileScanner.hasNextLine()) {
                                String line = fileScanner.nextLine();
                                String[] partes = line.split(",\\s*");
                                if (partes.length == 3) {
                                    try {
                                        int cantidad = Integer.parseInt(partes[1].trim());
                                        //Reemplaza "," por "." si el precio usa coma decimal
                                        double precio = Double.parseDouble(partes[2].trim().replace(",", ".")); 
                                        ventaTotal += cantidad * precio;
                                    } catch (NumberFormatException e) {
                                        System.err.println("Advertencia: Formato de número inválido en la linea: " + line);
                                    }
                                }
                            }
                        }
                        System.out.printf("Venta total: %.2f\n", ventaTotal);
                        break;
                    case "7": 
                        System.out.print("Nombre del producto para calcular venta: ");
                        String nombreCalc = scanner.nextLine().trim();
                        double ventaProducto = 0.0;

                        try (Scanner fileScanner = new Scanner(ficheroTienda)) {
                            while (fileScanner.hasNextLine()) {
                                String line = fileScanner.nextLine();
                                String[] partes = line.split(",\\s*");
                                
                                if (partes.length == 3 && partes[0].trim().equals(nombreCalc)) {
                                    try {
                                        int cantidad = Integer.parseInt(partes[1].trim());
                                        double precio = Double.parseDouble(partes[2].trim().replace(",", "."));
                                        ventaProducto += cantidad * precio;
                                    } catch (NumberFormatException e) {
                                        System.err.println("Advertencia: Formato de numero invalido en la linea: " + line);
                                    }
                                }
                            }
                        }
                        System.out.printf("Venta total de %s: %.2f\n", nombreCalc, ventaProducto);
                        break;
                    case "8": 
                        System.out.println("Saliendo del programa...");
                        scanner.close(); //Cerrar el scanner de entrada
                        if (ficheroTienda.delete()) {
                            System.out.println("Archivo Tienda.txt eliminado con exito.");
                        } else {
                            System.out.println("Advertencia: No se pudo eliminar el archivo Tienda.txt.");
                        }
                        return; //Sale del método main y termina el programa

                    default:
                        System.out.println("Opcion no valida. Intente de nuevo.");
                        break;
                }
            } catch (IOException e) {
                System.err.println("Se produjo un error de archivo: " + e.getMessage());
            }
        }
    }
}