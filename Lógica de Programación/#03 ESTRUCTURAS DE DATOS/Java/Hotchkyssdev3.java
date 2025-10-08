/* EJERCICIO:
 * - Muestra ejemplos de creación de todas las estructuras soportadas por defecto
 *   en tu lenguaje.
 * - Utiliza operaciones de inserción, borrado, actualización y ordenación.
 *
 * DIFICULTAD EXTRA (opcional):
 * Crea una agenda de contactos por terminal.
 * - Debes implementar funcionalidades de búsqueda, inserción, actualización
 *   y eliminación de contactos.
 * - Cada contacto debe tener un nombre y un número de teléfono.
 * - El programa solicita en primer lugar cuál es la operación que se quiere realizar,
 *   y a continuación los datos necesarios para llevarla a cabo.
 * - El programa no puede dejar introducir números de teléfono no numéricos y con más
 *   de 11 dígitos (o el número de dígitos que quieras).
 * - También se debe proponer una operación de finalización del programa.
 */
import java.util.Scanner;

public class Hotchkyssdev3 {
    //Constantes y creacion de Scanner (global)
    static final int CAPACIDAD = 50;
    static final int MAX_NAMES = 5;
    static final int MAX_NOMBRE_PRODUCTO = 30;
    static final int MAX_PRODUCTOS = 5;
    static final int MAX_CONTACTOS = 100;
    static final int MAX_NOMBRE = 50;
    static final int MAX_TELEFONO_DIGITOS = 11;

    static final Scanner sc = new Scanner(System.in);

    //Arrays
    static int[] arreglo = new int[CAPACIDAD];
    static int tam = 0;

    static void insertarArreglo() {
        if (tam >= CAPACIDAD) {
            System.out.println("Error: El arreglo esta lleno. No se puede insertar.");
            return;
        }
        System.out.println("\n--- Funcion: Insertar en arreglo (ordenado) ---");
        System.out.print("Ingrese el valor a insertar: ");
        Integer valor = leerEnteroSeguro();
        if (valor == null) {
            return;
        }

        for (int i = 0; i < tam; i++) {
            if (arreglo[i] == valor) {
                System.out.println("El valor ya existe. No se puede insertar.");
                return;
            }
        }

        int pos = 0; //Encontrar posicion de insercion (mantener orden ascendente)
        while (pos < tam && arreglo[pos] < valor) {
            pos++;
        }

        for (int i = tam; i > pos; i--) { //Desplazar a la derecha
            arreglo[i] = arreglo[i - 1];
        }
        arreglo[pos] = valor;
        tam++;

        System.out.println("Insercion realizada.");
        leerArreglo();
    }

    static void leerArreglo() {
        System.out.println("Contenido del arreglo (" + tam + " elementos):");
        for (int i = 0; i < tam; i++) {
            System.out.print(arreglo[i] + " ");
        }
        System.out.println();
    }

    static void buscarArreglo() {
        if (tam == 0) {
            System.out.println("Arreglo vacio.");
            return;
        }

        System.out.println("\n--- Funcion: Buscar en arreglo ---");
        System.out.print("Ingrese el valor a buscar: ");
        Integer valor = leerEnteroSeguro();

        if (valor == null) {
            return;
        }

        boolean encontrado = false;
        for (int i = 0; i < tam; i++) {
            if (arreglo[i] == valor) {
                System.out.println("Valor encontrado en la posicion " + i + ".");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Valor no encontrado.");
        }
    }

    static void eliminarArreglo() {
        if (tam == 0) {
            System.out.println("El arreglo esta vacio, no se puede eliminar.");
            return;
        }

        System.out.println("\n--- Funcion: Eliminar en arreglo ---");
        System.out.print("Ingrese el valor a eliminar: ");
        Integer valor = leerEnteroSeguro();

        if (valor == null) {
            return;
        }

        int pos = -1;
        for (int i = 0; i < tam; i++) {
            if (arreglo[i] == valor) { 
                pos = i; 
                break; 
            }
        }

        if (pos == -1) {
            System.out.println("Elemento no encontrado.");
        } else {
            for (int i = pos; i < tam - 1; i++) {
                arreglo[i] = arreglo[i + 1];
            }
            tam--;
            System.out.println("Elemento eliminado. Arreglo actualizado:");
            leerArreglo();
        }
    }

    //Strings
    static String[] listaNombres = new String[MAX_NAMES];
    static int numNombres = 0;

    static void crearNombre() {
        if (numNombres >= MAX_NAMES) {
            System.out.println("Error: La lista de nombres esta llena.");
            return;
        }

        System.out.println("\n--- Funcion: Crear (Insertar String) ---");
        System.out.print("Ingrese el nuevo nombre (no vacio): ");
        String linea = sc.nextLine().trim();

        if (linea.isEmpty()) {
            System.out.println("Nombre vacio. No se inserto.");
            return;
        }

        listaNombres[numNombres++] = linea;
        System.out.println("Nombre insertado con exito.");
    }

    static void leerNombres() {
        if (numNombres == 0) {
            System.out.println("La lista de nombres esta vacia.");
            return;
        }

        for (int i = 0; i < numNombres - 1; i++) { //Ordenamiento mediante BubbleSort
            for (int j = 0; j < numNombres - 1 - i; j++) {
                if (listaNombres[j].compareTo(listaNombres[j + 1]) > 0) {
                    String tmp = listaNombres[j];
                    listaNombres[j] = listaNombres[j + 1];
                    listaNombres[j + 1] = tmp;
                }
            }
        }

        System.out.println("\n--- Lista de nombres (ordenada) ---");
        for (int i = 0; i < numNombres; i++) {
            System.out.println((i + 1) + ". " + listaNombres[i]);
        }
    }

    static void actualizarNombre() {
        if (numNombres == 0) {
            System.out.println("La lista esta vacia, no hay nada que actualizar.");
            return;
        }

        leerNombres();
        System.out.println("\n--- Funcion: Actualizar String ---");
        System.out.print("Ingrese el numero del nombre a actualizar (1 a " + numNombres + "): ");
        Integer pos = leerEnteroSeguro();

        if (pos == null) {
            return;
        }

        if (pos < 1 || pos > numNombres) {
            System.out.println("Numero de posicion invalido.");
            return;
        }

        int indice = pos - 1;
        System.out.println("Nombre actual: " + listaNombres[indice]);
        System.out.print("Ingrese el nuevo valor: ");
        String nuevo = sc.nextLine().trim();

        if (nuevo.isEmpty()) {
            System.out.println("Nombre vacio. Actualizacion cancelada.");
            return;
        }

        listaNombres[indice] = nuevo;
        System.out.println("Nombre actualizado con exito.");
    }

    static void eliminarNombre() {
        if (numNombres == 0) {
            System.out.println("La lista esta vacia, no hay nada que eliminar.");
            return;
        }

        leerNombres();
        System.out.println("\n--- Funcion: Eliminar String ---");
        System.out.print("Ingrese el numero del nombre a eliminar (1 a " + numNombres + "): ");
        Integer pos = leerEnteroSeguro();

        if (pos == null) {
            return;
        }

        if (pos < 1 || pos > numNombres) {
            System.out.println("Numero de posicion invalido.");
            return;
        }

        int indice = pos - 1;
        System.out.println("Eliminando: " + listaNombres[indice]);

        for (int i = indice; i < numNombres - 1; i++) {
            listaNombres[i] = listaNombres[i + 1];
        }

        listaNombres[numNombres - 1] = null;
        numNombres--;
        System.out.println("Nombre eliminado con exito.");
    }

    //STRUCTS (Producto)
    static class Producto {
        String nombre;
        int codigo;
        float precio;
        Producto() {}
    }

    static Producto[] inventario = new Producto[MAX_PRODUCTOS];
    static int numProductos = 0;

    static void crearProducto() {
        if (numProductos >= MAX_PRODUCTOS) {
            System.out.println("Error: El inventario esta lleno.");
            return;
        }

        System.out.println("\n--- Funcion: Crear Producto ---");
        System.out.print("Ingrese el codigo (entero): ");
        Integer codigo = leerEnteroSeguro();

        if (codigo == null) {
            return;
        }

        System.out.print("Ingrese el nombre del producto: ");
        String nombre = sc.nextLine().trim();

        if (nombre.isEmpty()) { 
            System.out.println("Nombre vacio. Cancelado."); 
            return; 
        }

        System.out.print("Ingrese el precio (float): ");
        Float precio = leerFloatSeguro();

        if (precio == null) {
            return;
        }

        Producto p = new Producto();
        p.codigo = codigo; 
        p.nombre = nombre; 
        p.precio = precio;
        inventario[numProductos++] = p;
        System.out.println("Producto '" + p.nombre + "' insertado con exito.");
    }

    static void leerProductos() {
        if (numProductos == 0) {
            System.out.println("El inventario esta vacio.");
            return;
        }

        System.out.println("\n--- Inventario ---");
        System.out.printf("%-4s | %-6s | %-28s | %8s\n", "No.", "Codigo", "Nombre", "Precio");
        System.out.println("--------------------------------------------------------------");

        for (int i = 0; i < numProductos; i++) {
            Producto p = inventario[i];
            System.out.printf("%-4d | %-6d | %-28s | %8.2f\n", i + 1, p.codigo, p.nombre, p.precio);
        }
    }

    static void actualizarProducto() {
        if (numProductos == 0) {
            System.out.println("Inventario vacio, nada que actualizar.");
            return;
        }

        leerProductos();
        System.out.println("\n--- Funcion: Actualizar Producto ---");
        System.out.print("Ingrese el numero del producto a actualizar (1 a " + numProductos + "): ");
        Integer pos = leerEnteroSeguro();

        if (pos == null) {
            return;
        }

        if (pos < 1 || pos > numProductos) { 
            System.out.println("Posicion invalida."); 
            return; 
        }

        int indice = pos - 1;
        Producto p = inventario[indice];
        System.out.println("Producto actual: " + p.nombre + " (Precio: " + p.precio + ")");
        System.out.print("Ingrese el nuevo precio: ");
        Float nuevoPrecio = leerFloatSeguro();

        if (nuevoPrecio == null) {
            return;
        }
        p.precio = nuevoPrecio;
        System.out.println("Precio actualizado.");
    }

    static void eliminarProducto() {
        if (numProductos == 0) { 
            System.out.println("Inventario vacio, nada que eliminar."); 
            return; 
        }

        leerProductos();
        System.out.println("\n--- Funcion: Eliminar Producto ---");
        System.out.print("Ingrese el numero del producto a eliminar (1 a " + numProductos + "): ");
        Integer pos = leerEnteroSeguro();

        if (pos == null) {
            return;
        }

        if (pos < 1 || pos > numProductos) { 
            System.out.println("Posicion invalida."); 
            return; 
        }

        int indice = pos - 1;
        System.out.println("Eliminando: " + inventario[indice].nombre + " (Codigo: " + inventario[indice].codigo + ")");
        
        for (int i = indice; i < numProductos - 1; i++) {
            inventario[i] = inventario[i + 1];
        }

        inventario[numProductos - 1] = null;
        numProductos--;
        System.out.println("Producto eliminado con exito.");
    }

    //SIMULACION DE UNA UNIoN (Tipo de Estructura que no existe por defecto en Java)
    static class ItemUnion {
        int tipo; //0 no inicializado, 1=id, 2=alias, 3=sumaControl
        Integer id;
        String alias;
        Float sumaControl;
        ItemUnion() { 
            tipo = 0; 
            id = null; 
            alias = null; 
            sumaControl = null; 
        }
    }

    static boolean esEntero(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i == 0 && c == '-') {  //Permite negativos
                continue;
            }
                
            if (c < '0' || c > '9') {
                return false;
            }
        }

        return true;
    }

    static boolean esFlotante(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }

        int puntos = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i == 0 && c == '-') {
                continue;
            }

            if (c == '.') {
                puntos++;
            } else if (c < '0' || c > '9') {
                return false;
            }
        }

        return puntos <= 1;
    }

    static void crearYLeerUnion(ItemUnion item, int tipo, String inputStr) {
        item.tipo = tipo;
        System.out.println("\n--- Crear/Inicializar Union ---");
        System.out.println("Estableciendo tipo " + tipo + " ...");

        switch (tipo) {
            case 1: //Entero (ID)
                if (esEntero(inputStr)) {
                    item.id = Integer.parseInt(inputStr);
                } else {
                    System.out.println("Entrada invalida. Se asigna 0 por defecto.");
                    item.id = 0;
                }

                item.alias = null;
                item.sumaControl = null;
                System.out.println(" -> ID = " + item.id);
                break;
            case 2: //Cadena (Alias)
                item.alias = inputStr;
                item.id = null;
                item.sumaControl = null;
                System.out.println(" -> Alias = " + item.alias);
                break;
            case 3: //Flotante (Suma de Control)
                if (esFlotante(inputStr)) {
                    item.sumaControl = Float.parseFloat(inputStr);
                } else {
                    System.out.println("Entrada invalida. Se asigna 0.0 por defecto.");
                    item.sumaControl = 0f;
                }

                item.id = null;
                item.alias = null;
                System.out.println(" -> SumaDeControl = " + item.sumaControl);
                break;
            default:
                System.out.println("Tipo no reconocido.");
                item.tipo = 0;
        }
    }

    static void mostrarUnion(ItemUnion item) {
        System.out.println("\n--- Leer Union ---");

        if (item.tipo == 0) { 
            System.out.println("Elemento no inicializado."); 
            return; 
        }

        switch (item.tipo) {
            case 1: 
                System.out.println("ID (entero): " + item.id); 
                break;
            case 2: 
                System.out.println("ALIAS (cadena): " + item.alias); 
                break;
            case 3: 
                System.out.println("SumaDeControl (float): " + item.sumaControl); 
                break;
        }
    }

    static void actualizarUnion(ItemUnion item, int nuevoTipo, String nuevoInput) {
        System.out.println("\n--- Actualizar Union ---");
        System.out.println("Sobrescribiendo tipo " + item.tipo + " por tipo " + nuevoTipo);
        crearYLeerUnion(item, nuevoTipo, nuevoInput);
        System.out.println("Memoria de la union sobrescrita.");
    }

    //ENUM
    enum EstadoPedido {
        PENDIENTE(10), PROCESANDO(11), EN_ENVIO(12), ENTREGADO(99), CANCELADO(0);
        private final int valor;

        EstadoPedido(int v) { 
            valor = v; 
        }

        public int valor() { 
            return valor; 
        }
    }

    static class Pedido {
        int id;
        EstadoPedido estado;

        Pedido(int id, EstadoPedido e) { 
            this.id = id; 
            this.estado = e; 
        }
    }

    static Pedido crearPedido(int idVal, EstadoPedido estadoInicial) {
        System.out.println("\n--- Crear Pedido ---");
        System.out.println("Pedido " + idVal + " creado con estado (int): " + estadoInicial.valor());

        return new Pedido(idVal, estadoInicial);
    }

    static void mostrarEstado(Pedido p) {
        System.out.println("\n--- Estado del Pedido ---");
        System.out.print("Pedido ID " + p.id + ": ");

        switch (p.estado) {
            case PENDIENTE: 
                System.out.println("PENDIENTE (Esperando)"); 
                break;
            case PROCESANDO: 
                System.out.println("PROCESANDO (En almacen)"); 
                break;
            case EN_ENVIO:  
                System.out.println("EN ENViO (En transito)"); 
                break;
            case ENTREGADO: 
                System.out.println("ENTREGADO (Completado)"); 
                break;
            case CANCELADO: 
                System.out.println("CANCELADO"); 
                break;
        }
    }

    static void actualizarEstado(Pedido p, EstadoPedido nuevo) {
        EstadoPedido anterior = p.estado;
        p.estado = nuevo;
        System.out.println("Pedido " + p.id + " cambiado de " + anterior + " a " + nuevo);
    }

    //Puntero (Simulacion porque en Java se lo encarga el lenguaje y no el programador)
    static class ProductoDinamico {
        String nombre;
        int id;
        float precio;

        ProductoDinamico(int id, float precio, String nombre) { 
            this.id = id; 
            this.precio = precio; 
            this.nombre = nombre; 
        }
    }

    static ProductoDinamico prodPtr = null;

    static void crearProductoDinamico(int id, float precio, String nombre) {
        if (prodPtr != null) {
            System.out.println("Error: ya existe un producto dinamico. Eliminelo antes.");
            return;
        }

        prodPtr = new ProductoDinamico(id, precio, nombre);
        System.out.println("Producto dinamico creado: " + prodPtr.nombre);
    }

    static void leerProductoDinamico() {
        if (prodPtr == null) { 
            System.out.println("No hay producto dinamico (null)."); 
            return; 
        }

        System.out.println("\n--- Leer Producto Dinamico ---");
        System.out.println("ID: " + prodPtr.id);
        System.out.println("Nombre: " + prodPtr.nombre);
        System.out.println("Precio: " + prodPtr.precio);
    }

    static void actualizarProductoDinamico() {
        if (prodPtr == null) { 
            System.out.println("No hay producto para actualizar."); 
            return; 
        }

        prodPtr.precio = prodPtr.precio * 1.10f;
        prodPtr.nombre = prodPtr.nombre + " (v2)";
        System.out.println("Producto dinamico actualizado: " + prodPtr.nombre + ", precio: " + prodPtr.precio);
    }

    static void eliminarProductoDinamico() {
        if (prodPtr == null) { 
            System.out.println("No hay producto para eliminar."); 
            return; 
        }
        prodPtr = null; //El Garbage Collector liberara la memoria
        System.out.println("Producto dinamico eliminado (referencia a null).");
    }

    //EXTRA
    static class Contacto {
        String nombre;
        String telefono;

        Contacto(String n, String t) { 
            nombre = n; 
            telefono = t; 
        }
    }

    static Contacto[] agenda = new Contacto[MAX_CONTACTOS];
    static int numContactos = 0;

    static boolean esTelefonoValido(String tel) {
        if (tel == null) {
            return false;
        }

        tel = tel.trim();
        if (tel.length() == 0 || tel.length() > MAX_TELEFONO_DIGITOS) {
            return false;
        }

        for (int i = 0; i < tel.length(); i++) {
            if (!Character.isDigit(tel.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    static void mostrarMenuAgenda() {
        System.out.println("\n--- AGENDA DE CONTACTOS ---");
        System.out.println("1. Insertar contacto");
        System.out.println("2. Buscar contacto (por nombre parcial)");
        System.out.println("3. Actualizar contacto (por indice)");
        System.out.println("4. Eliminar contacto (por indice)");
        System.out.println("5. Listar todos");
        System.out.println("0. Salir de agenda");
        System.out.print("Seleccione opcion: ");
    }

    static void insertarContacto() {
        if (numContactos >= MAX_CONTACTOS) { 
            System.out.println("Agenda llena."); 
            return; 
        }

        System.out.println("\n--- Insertar Contacto ---");
        System.out.print("Nombre: ");
        String nombre = sc.nextLine().trim();

        if (nombre.isEmpty()) { 
            System.out.println("Nombre vacio. Cancelado."); 
            return; 
        }
        String tel;

        while (true) {
            System.out.print("Telefono (solo digitos, maximo " + MAX_TELEFONO_DIGITOS + "): ");
            tel = sc.nextLine().trim();
            if (!esTelefonoValido(tel)) {
                System.out.println("Telefono invalido.");
            } else {
                break;
            }
        }

        agenda[numContactos++] = new Contacto(nombre, tel);
        System.out.println("Contacto '" + nombre + "' insertado.");
    }

    static void buscarContacto() {
        if (numContactos == 0) { 
            System.out.println("Agenda vacia."); 
            return; 
        }

        System.out.println("\n--- Buscar Contacto ---");
        System.out.print("Ingrese nombre o parte: ");
        String q = sc.nextLine().trim();
        int encontrados = 0;

        for (int i = 0; i < numContactos; i++) {
            if (agenda[i].nombre.contains(q)) {
                System.out.println("[" + i + "] " + agenda[i].nombre + " - " + agenda[i].telefono);
                encontrados++;
            }
        }

        if (encontrados == 0) {
            System.out.println("No se encontraron coincidencias.");
        }
    }

    static void actualizarContacto() {
        if (numContactos == 0) { 
            System.out.println("Agenda vacia."); 
            return; 
        }
        listarContactos();
        System.out.print("Ingrese indice del contacto a actualizar: ");
        Integer indice = leerEnteroSeguro();

        if (indice == null) {
            return;
        }

        if (indice < 0 || indice >= numContactos) { 
            System.out.println("indice fuera de rango."); 
            return; 
        }

        System.out.println("Actualizando: " + agenda[indice].nombre + " - " + agenda[indice].telefono);
        System.out.print("Nuevo nombre (enter para mantener): ");
        String nuevoNombre = sc.nextLine().trim();

        if (!nuevoNombre.isEmpty()) {
            agenda[indice].nombre = nuevoNombre;
        }

        String nuevoTel;

        while (true) {
            System.out.print("Nuevo telefono (enter para mantener): ");
            nuevoTel = sc.nextLine().trim();
            if (nuevoTel.isEmpty()) {
                break;
            }

            if (!esTelefonoValido(nuevoTel)) {
                System.out.println("Telefono invalido.");
            } else { 
                agenda[indice].telefono = nuevoTel; 
                break; 
            }
        }
        System.out.println("Contacto actualizado.");
    }

    static void eliminarContacto() {
        if (numContactos == 0) { 
            System.out.println("Agenda vacia."); 
            return; 
        }
        listarContactos();
        System.out.print("Ingrese indice del contacto a eliminar: ");
        Integer indice = leerEnteroSeguro();

        if (indice == null) {
            return;
        }

        if (indice < 0 || indice >= numContactos) { 
            System.out.println("indice fuera de rango."); 
            return; 
        }
        System.out.println("Eliminando: " + agenda[indice].nombre);

        for (int i = indice; i < numContactos - 1; i++) {
            agenda[i] = agenda[i + 1];
        }
        agenda[numContactos - 1] = null;
        numContactos--;
        System.out.println("Contacto eliminado.");
    }

    static void listarContactos() {
        if (numContactos == 0) { 
            System.out.println("Agenda vacia."); 
            return; 
        }

        System.out.println("\n--- LISTA DE CONTACTOS (" + numContactos + ") ---");
        for (int i = 0; i < numContactos; i++) {
            System.out.println("[" + i + "] " + agenda[i].nombre + " - " + agenda[i].telefono);
        }
    }

    //Lectura Segura
    static Integer leerEnteroSeguro() {
        String s = sc.nextLine().trim();
        if (s.isEmpty()) {
            System.out.println("Entrada vacia.");
            return null;
        }
        if (!esEntero(s)) {
            System.out.println("Entrada invalida (no es un numero entero).");
            return null;
        }

        return Integer.parseInt(s);
    }

    static Float leerFloatSeguro() {
        String s = sc.nextLine().trim();
        if (s.isEmpty()) {
            System.out.println("Entrada vacia.");
            return null;
        }
        if (!esFlotante(s)) {
            System.out.println("Entrada invalida (no es un numero decimal).");
            return null;
        }

        return Float.parseFloat(s);
    }

    //Menu
    static void menuPrincipal() {
        boolean salir = false;
        int[] valoresIniciales = {1,2,3,4,5,6,7,8,9,10,11,13,14,15,16,17,18,98};
        tam = Math.min(valoresIniciales.length, CAPACIDAD);
        System.arraycopy(valoresIniciales, 0, arreglo, 0, tam);

        if (MAX_NAMES >= 2) {
            listaNombres[0] = "Alice"; numNombres++;
            listaNombres[1] = "Bob"; numNombres++;
        }

        if (MAX_PRODUCTOS >= 2) {
            Producto p1 = new Producto(); p1.codigo = 101; p1.nombre = "Teclado Mecanico"; p1.precio = 75.99f; inventario[numProductos++] = p1;
            Producto p2 = new Producto(); p2.codigo = 202; p2.nombre = "Mouse Inalambrico"; p2.precio = 25.50f; inventario[numProductos++] = p2;
        }

        if (MAX_CONTACTOS >= 2) {
            agenda[0] = new Contacto("Hotchkyss Gersom", "123456789"); numContactos++;
            agenda[1] = new Contacto("Portillo Guillermo", "987654321"); numContactos++;
        }

        ItemUnion miDato = new ItemUnion();

        Pedido miPedido = crearPedido(54321, EstadoPedido.PENDIENTE);

        while (!salir) {
            System.out.println("\n=== DEMOS ESTRUCTURAS EN JAVA ===");
            System.out.println("1. Arrays (CRUD, insercion ordenada)");
            System.out.println("2. Strings (CRUD y ordenacion)");
            System.out.println("3. Productos (structs) CRUD");
            System.out.println("4. Union simulada (ItemUnion)");
            System.out.println("5. Enum y Pedido (estados)");
            System.out.println("6. Producto dinamico (simulacion puntero)");
            System.out.println("7. Agenda de contactos");
            System.out.println("0. Salir");
            System.out.print("Elige opcion: ");
            Integer opt = leerEnteroSeguro();
            if (opt == null) continue;
            switch (opt) {
                case 0: 
                    salir = true; 
                    break;
                case 1: 
                    menuArrays(); 
                    break;
                case 2: 
                    menuStrings(); 
                    break;
                case 3: 
                    menuProductos(); 
                    break;
                case 4:
                    crearYLeerUnion(miDato, 1, "98765");
                    mostrarUnion(miDato);
                    actualizarUnion(miDato, 2, "Sesion-A24");
                    mostrarUnion(miDato);
                    System.out.println("Intentando leer miembro incorrecto (ejemplo de 'basura'): id = " + miDato.id);
                    actualizarUnion(miDato, 3, "1.41421");
                    mostrarUnion(miDato);
                    break;
                case 5:
                    mostrarEstado(miPedido);
                    actualizarEstado(miPedido, EstadoPedido.PROCESANDO);
                    actualizarEstado(miPedido, EstadoPedido.EN_ENVIO);
                    actualizarEstado(miPedido, EstadoPedido.ENTREGADO);
                    mostrarEstado(miPedido);
                    actualizarEstado(miPedido, EstadoPedido.CANCELADO);
                    mostrarEstado(miPedido);
                    break;
                case 6:
                    crearProductoDinamico(1, 50.00f, "Webcam HD");
                    leerProductoDinamico();
                    actualizarProductoDinamico();
                    leerProductoDinamico();
                    eliminarProductoDinamico();
                    leerProductoDinamico();
                    break;
                case 7:
                    menuAgendaLoop();
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        }
        System.out.println("Saliendo del programa. Hasta luego!");
    }

    static void menuArrays() {
        boolean volver = false;
        while (!volver) {
            System.out.println("\n--- Menu Arrays ---");
            System.out.println("1 Insertar  2 Leer  3 Buscar  4 Eliminar  0 Volver");
            System.out.print("Elige: ");
            Integer o = leerEnteroSeguro(); 
            if (o == null) {
                continue;
            }

            switch (o) {
                case 0: 
                    volver = true; 
                    break;
                case 1: 
                    insertarArreglo(); 
                    break;
                case 2: 
                    leerArreglo(); 
                    break;
                case 3: 
                    buscarArreglo(); 
                    break;
                case 4: 
                    eliminarArreglo(); 
                    break;
                default: 
                    System.out.println("No valido.");
            }
        }
    }

    static void menuStrings() {
        boolean volver = false;
        while (!volver) {
            System.out.println("\n--- Menu Strings ---");
            System.out.println("1 Crear 2 Leer 3 Actualizar 4 Eliminar 0 Volver");
            System.out.print("Elige: ");
            Integer o = leerEnteroSeguro(); 
            if (o == null) {
                continue;
            }

            switch (o) {
                case 0: 
                    volver = true; 
                    break;
                case 1: 
                    crearNombre(); 
                    break;
                case 2: 
                    leerNombres(); 
                    break;
                case 3: 
                    actualizarNombre(); 
                    break;
                case 4: 
                    eliminarNombre(); 
                    break;
                default: 
                    System.out.println("No valido.");
            }
        }
    }

    static void menuProductos() {
        boolean volver = false;
        while (!volver) {
            System.out.println("\n--- Menu Productos ---");
            System.out.println("1 Crear 2 Leer 3 Actualizar 4 Eliminar 0 Volver");
            System.out.print("Elige: ");
            Integer o = leerEnteroSeguro(); 
            if (o == null) {
                continue;
            }

            switch (o) {
                case 0: 
                    volver = true; 
                    break;
                case 1: 
                    crearProducto(); 
                    break;
                case 2: 
                    leerProductos(); 
                    break;
                case 3: 
                    actualizarProducto(); 
                    break;
                case 4: 
                    eliminarProducto(); 
                    break;
                default: 
                    System.out.println("No valido.");
            }
        }
    }

    static void menuAgendaLoop() {
        boolean salir = false;
        while (!salir) {
            mostrarMenuAgenda();
            Integer opt = leerEnteroSeguro(); 
            if (opt == null) {
                continue;
            }

            switch (opt) {
                case 0: 
                    salir = true; 
                    break;
                case 1: 
                    insertarContacto(); 
                    break;
                case 2: 
                    buscarContacto(); 
                    break;
                case 3: 
                    actualizarContacto(); 
                    break;
                case 4: 
                    eliminarContacto(); 
                    break;
                case 5: 
                    listarContactos(); 
                    break;
                default: 
                    System.out.println("Opcion no valida.");
            }
        }
    }

    public static void main(String[] args) {
        menuPrincipal();
        sc.close();
    }
}