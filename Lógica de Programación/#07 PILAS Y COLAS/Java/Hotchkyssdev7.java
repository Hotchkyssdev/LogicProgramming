/* EJERCICIO:
 * Implementa los mecanismos de introducción y recuperación de elementos propios de las
 * pilas (stacks - LIFO) y las colas (queue - FIFO) utilizando una estructura de array
 * o lista (dependiendo de las posibilidades de tu lenguaje).
 *
 * DIFICULTAD EXTRA (opcional):
 * - Utilizando la implementación de pila y cadenas de texto, simula el mecanismo adelante/atrás
 *   de un navegador web. Crea un programa en el que puedas navegar a una página o indicarle
 *   que te quieres desplazar adelante o atrás, mostrando en cada caso el nombre de la web.
 *   Las palabras "adelante", "atrás" desencadenan esta acción, el resto se interpreta como
 *   el nombre de una nueva web.
 * - Utilizando la implementación de cola y cadenas de texto, simula el mecanismo de una
 *   impresora compartida que recibe documentos y los imprime cuando así se le indica.
 *   La palabra "imprimir" imprime un elemento de la cola, el resto de palabras se
 *   interpretan como nombres de documentos.
 */
import java.util.Scanner;

public class Hotchkyssdev7 {

    private static final Scanner input = new Scanner(System.in);
    private static final String PAGINA_INICIAL = "inicio.com";

    public static void demoEstructurasBasicas() {
        System.out.println("\n--- DEMOSTRACION DE ESTRUCTURAS BASICAS (Int) ---");
        
        ListaSimple ls = ListaSimple.ls_new();
        ls.ls_insert_front(10);
        ls.ls_insert_front(20);
        ls.ls_print();
        EstructuraResultado res = ls.ls_delete_front();
        if (res.exito) {
            System.out.println("Elemento borrado de LS: " + res.valor);
        }
        ls.ls_print();

        ListaDoble ld = ListaDoble.ld_new();
        ld.ld_insert_front(5);
        ld.ld_insert_front(15);
        ld.ld_print();
        res = ld.ld_delete_front();
        if (res.exito) {
            System.out.println("Elemento borrado de LD: " + res.valor);
        }
        ld.ld_print();
        
        PilaArray pa = new PilaArray();
        pa.pila_push(1);
        pa.pila_push(2);
        pa.pila_print();
        res = pa.pila_pop();
        if (res.exito) {
            System.out.println("Pop de Pila Array: " + res.valor);
        }
        pa.pila_print();

        ColaCircular cq = new ColaCircular();
        cq.cq_enqueue(10);
        cq.cq_enqueue(20);
        cq.cq_print();
        res = cq.cq_dequeue();
        if (res.exito) {
            System.out.println("Dequeue de Cola Circular: " + res.valor);
        }
        cq.cq_print();
        
        BST bst = new BST();
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(40);
        bst.printInOrder();
        bst.delete(30);
        System.out.print("[BST despues de borrar 30]: ");
        bst.bst_inorder(bst.root);
        System.out.println();
    }


    public static void main(String[] args) {
        int opcion = -1;
        String linea;

        System.out.println("\n*** TRADUCCION COMPLETA DE ESTRUCTURAS DE DATOS DE C A JAVA (SIN MANEJO DE ERRORES EXCEPCIONALES) ***");

        while (opcion != 0) {
            System.out.println("\nMENU PRINCIPAL:");
            System.out.println("1. Demostrar Estructuras Basicas (Listas, Pilas, Colas, BST)");
            System.out.println("2. Simular Navegador Web (Dificultad Extra - Pilas)");
            System.out.println("3. Simular Cola de Impresion (Dificultad Extra - Cola)");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");

            linea = input.nextLine().trim(); //Lectura de entrada
            opcion = -1; 

            //Simulación de chequeo de entrada numérica sin excepciones
            if (linea.matches("^-?\\d+$")) { 
                opcion = Integer.parseInt(linea);
            } else {
                opcion = -1; 
            }
            
            if (opcion == 1) {
                demoEstructurasBasicas();
            } else if (opcion == 2) {
                simularNavegador();
            } else if (opcion == 3) {
                simularImpresora();
            } else if (opcion == 0) {
                System.out.println("\nSaliendo del programa. ¡Adios!");
            } else {
                System.out.println("Opcion no válida. Intente de nuevo.");
                opcion = -1;
            }
        }
    }

    //EXTRA
    public static void simularNavegador() {
        PilaString historialAtras = new PilaString();
        PilaString historialAdelante = new PilaString();
        String paginaActual = PAGINA_INICIAL;
        String comando;

        System.out.println("\n--- SIMULACION DE NAVEGADOR WEB (Pilas) ---");
        System.out.println("Comandos: [URL], 'adelante', 'atras', 'menu'");
        System.out.println("Pagina actual: " + paginaActual);

        while (true) {
            System.out.print("\n> Accion: ");
            comando = input.nextLine().trim(); 

            if (comando.equalsIgnoreCase("menu")) {
                break;
            }

            if (comando.equalsIgnoreCase("atras")) {
                String paginaMovida = historialAtras.pop();
                if (paginaMovida != null) {
                    historialAdelante.push(paginaActual);
                    paginaActual = paginaMovida;
                    System.out.println("  << Navegando ATRAS a: " + paginaActual);
                } else {
                    System.out.println("  >> Historial ATRAS vacio.");
                }
            } else if (comando.equalsIgnoreCase("adelante")) {
                String paginaMovida = historialAdelante.pop();
                if (paginaMovida != null) {
                    historialAtras.push(paginaActual);
                    paginaActual = paginaMovida;
                    System.out.println("  >> Navegando ADELANTE a: " + paginaActual);
                } else {
                    System.out.println("  >> Historial ADELANTE vacío.");
                }
            } else if (!comando.isEmpty()) { 
                historialAtras.push(paginaActual);
                paginaActual = comando;
                historialAdelante.liberar(); 
                System.out.println("  >> Nueva URL visitada: " + paginaActual);
            }
            System.out.println("  [Pagina Actual: " + paginaActual + "]");
        }
        
        historialAtras.liberar();
        historialAdelante.liberar();
        System.out.println("\n>>> Memoria de navegacion liberada.");
    }

    public static void simularImpresora() {
        ColaString colaImpresion = new ColaString();
        String comando;

        System.out.println("\n--- SIMULACION DE IMPRESORA COMPARTIDA (Cola) ---");
        System.out.println("Comandos: [Nombre Documento], 'imprimir', 'menu'");
        colaImpresion.imprimir();

        while (true) {
            System.out.print("\n> Accion: ");
            comando = input.nextLine().trim();

            if (comando.equalsIgnoreCase("menu")) {
                break;
            }

            if (comando.equalsIgnoreCase("imprimir")) {
                String documentoImprimir = colaImpresion.dequeue();
                if (documentoImprimir != null) {
                    System.out.println("  >> IMPRIMIENDO: " + documentoImprimir + " (Sale el mas antiguo: FIFO)");
                } else {
                    System.out.println("  >> Cola de impresion vacia. Nada que imprimir.");
                }
            } else if (!comando.isEmpty()) { 
                colaImpresion.enqueue(comando);
                System.out.println("  >> Documento ENCOLADO: " + comando);
            }
            colaImpresion.imprimir();
        }

        colaImpresion.liberar();
        System.out.println("\n>>> Memoria de cola de impresion liberada.");
    }
}

 class EstructuraResultado {
    public boolean exito;
    public int valor;
    
    public EstructuraResultado(boolean exito, int valor) {
        this.exito = exito;
        this.valor = valor;
    }
}

final class Constantes {
    public static final int MAX_STACK = 100;
    public static final int MAX_QUEUE = 100;
    public static final int MAX_DEQUE = 100;
    public static final int MAX_VERTICES = 20;
    public static final int HASH_tamanio = 11;
}

//Nodo básico (para Listas Simples/Pilas/Colas)
class Nodo {
    public int dato;
    public Nodo siguiente;

    public Nodo(int dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}

//Nodo para Listas Dobles
class NodoDoble {
    public int dato;
    public NodoDoble siguiente;
    public NodoDoble anterior;

    public NodoDoble(int dato) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }
}

//Nodo para el Hash Table
class HashNode {
    public String clave;
    public int valor;
    public HashNode siguiente;

    public HashNode(String clave, int valor) {
        this.clave = clave;
        this.valor = valor;
        this.siguiente = null;
    }
}

//Nodo para el Binary Search Tree (BST)
class TNode {
    public int dato;
    public TNode izquierda;
    public TNode derecha;

    public TNode(int dato) {
        this.dato = dato;
        this.izquierda = null;
        this.derecha = null;
    }
}

//Nodo para estructuras de DIFICULTAD EXTRA (Strings)
class NodoString {
    public String dato;
    public NodoString siguiente;

    public NodoString(String dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}

//ESTRUCTURAS DE DATOS BASE (Int)

class ListaSimple {
    private Nodo cabeza;

    public ListaSimple() {
        this.cabeza = null;
    }
    
    public static ListaSimple ls_new() {
        return new ListaSimple();
    }

    public boolean ls_insert_front(int v) {
        Nodo nuevo = new Nodo(v);
        nuevo.siguiente = cabeza;
        cabeza = nuevo;
        return true;
    }

    public EstructuraResultado ls_delete_front() {
        if (cabeza == null) {
            return new EstructuraResultado(false, 0); 
        }
        int out = cabeza.dato;
        cabeza = cabeza.siguiente;

        return new EstructuraResultado(true, out);
    }

    public void ls_print() {
        Nodo actual = cabeza;
        System.out.print("[Lista Simple]: ");
        while (actual != null) {
            System.out.print(actual.dato + " -> ");
            actual = actual.siguiente;
        }
        System.out.println("NULL");
    }
    
    public void ls_free() {
        this.cabeza = null;
    }
}

class ListaDoble {
    private NodoDoble cabeza;

    public ListaDoble() {
        this.cabeza = null;
    }

    public static ListaDoble ld_new() {
        return new ListaDoble();
    }

    public boolean ld_insert_front(int v) {
        NodoDoble nuevo = new NodoDoble(v);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            nuevo.siguiente = cabeza;
            cabeza.anterior = nuevo;
            cabeza = nuevo;
        }

        return true;
    }
    
    public EstructuraResultado ld_delete_front() {
        if (cabeza == null) {
            return new EstructuraResultado(false, 0); 
        }
        int out = cabeza.dato;
        cabeza = cabeza.siguiente;
        if (cabeza != null) {
            cabeza.anterior = null;
        }

        //No se necesita manipular 'cola'
        return new EstructuraResultado(true, out);
    }

    public void ld_print() {
        NodoDoble actual = cabeza;
        System.out.print("[Lista Doble]: NULL <-> ");
        while (actual != null) {
            System.out.print(actual.dato + " <-> ");
            actual = actual.siguiente;
        }
        System.out.println("NULL");
    }
    
    public void ld_free() {
        this.cabeza = null;
    }
}

class ListaCircular {
    private Nodo cabeza;

    public ListaCircular() {
        this.cabeza = null;
    }

    public static ListaCircular lc_new() {
        return new ListaCircular();
    }

    public boolean lc_insert(int v) {
        Nodo nuevo = new Nodo(v);
        if (cabeza == null) {
            cabeza = nuevo;
            cabeza.siguiente = cabeza;
        } else {
            Nodo actual = cabeza;
            while (actual.siguiente != cabeza) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
            nuevo.siguiente = cabeza;
        }

        return true;
    }
    
    public boolean lc_delete(int v) {
        if (cabeza == null) return false;
        
        Nodo actual = cabeza;
        Nodo anterior = null;
        
        do {
            if (actual.dato == v) {
                if (actual == cabeza) {
                    if (cabeza.siguiente == cabeza) {
                        cabeza = null;
                    } else {
                        Nodo ultimo = cabeza;
                        while(ultimo.siguiente != cabeza) ultimo = ultimo.siguiente;
                        ultimo.siguiente = cabeza.siguiente;
                        cabeza = cabeza.siguiente;
                    }
                } else {
                    anterior.siguiente = actual.siguiente;
                }

                return true;
            }
            anterior = actual;
            actual = actual.siguiente;
        } while (actual != cabeza);
        
        return false;
    }

    public void lc_print() {
        System.out.print("[Lista Circular]: ");
        if (cabeza == null) {
            System.out.println("NULL");
            return;
        }
        Nodo actual = cabeza;

        do {
            System.out.print(actual.dato + " -> ");
            actual = actual.siguiente;
        } while (actual != cabeza);

        System.out.println("... (Circular)");
    }
    
    public void lc_free() {
        this.cabeza = null;
    }
}

class PilaArray {
    private int[] datos;
    private int tope;

    public PilaArray() {
        this.datos = new int[Constantes.MAX_STACK];
        this.tope = -1;
    }

    public boolean pila_push(int v) {
        if (tope >= Constantes.MAX_STACK - 1) {
            return false;
        }
        datos[++tope] = v;
        return true;
    }

    public EstructuraResultado pila_pop() {
        if (tope < 0) {
            return new EstructuraResultado(false, 0); 
        }
        int out = datos[tope--];

        return new EstructuraResultado(true, out);
    }

    public void pila_print() {
        System.out.print("[Pila Array] Tope -> ");
        for (int i = tope; i >= 0; i--) {
            System.out.print(datos[i] + (i == 0 ? "" : " | "));
        }
        System.out.println();
    }
}

class ColaArray {
    private int[] datos;
    private int frente;
    private int fin;

    public ColaArray() {
        this.datos = new int[Constantes.MAX_QUEUE];
        this.frente = 0;
        this.fin = -1;
    }

    public boolean cola_enqueue(int v) {
        if (fin >= Constantes.MAX_QUEUE - 1) {
            return false; 
        }
        datos[++fin] = v;
        return true;
    }

    public EstructuraResultado cola_dequeue() {
        if (fin < frente) { 
            return new EstructuraResultado(false, 0); 
        }
        int out = datos[frente++];

        return new EstructuraResultado(true, out);
    }

    public void cola_print() {
        System.out.print("[Cola Array] Frente -> ");
        for (int i = frente; i <= fin; i++) {
            System.out.print(datos[i] + (i == fin ? "" : " <- "));
        }
        System.out.println(" <- Fin");
    }
}

class ColaCircular {
    private int[] datos;
    private int frente;
    private int fin;
    private int contador;

    public ColaCircular() {
        this.datos = new int[Constantes.MAX_QUEUE];
        this.frente = 0;
        this.fin = -1;
        this.contador = 0;
    }

    public boolean cq_enqueue(int v) {
        if (contador == Constantes.MAX_QUEUE) {
            return false;
        }
        fin = (fin + 1) % Constantes.MAX_QUEUE;
        datos[fin] = v;
        contador++;

        return true;
    }

    public EstructuraResultado cq_dequeue() {
        if (contador == 0) {
            return new EstructuraResultado(false, 0); 
        }
        int out = datos[frente];
        frente = (frente + 1) % Constantes.MAX_QUEUE;
        contador--;

        return new EstructuraResultado(true, out);
    }
    
    public void cq_print() {
        System.out.print("[Cola Circular] Frente -> ");
        if (contador == 0) {
            System.out.println("[VACIA]");
            return;
        }
        for (int i = 0; i < contador; i++) {
            int indice = (frente + i) % Constantes.MAX_QUEUE;
            System.out.print(datos[indice] + (i == contador - 1 ? "" : " <- "));
        }
        System.out.println(" <- Fin");
    }
}

class Deque {
    private int[] datos;
    private int frente;
    private int fin;
    private int contador;

    public Deque() {
        this.datos = new int[Constantes.MAX_DEQUE];
        this.frente = 0;
        this.fin = Constantes.MAX_DEQUE - 1;
        this.contador = 0;
    }
    
    public boolean dq_push_front(int v) {
        if (contador == Constantes.MAX_DEQUE) return false;
        frente = (frente - 1 + Constantes.MAX_DEQUE) % Constantes.MAX_DEQUE;
        datos[frente] = v;
        contador++;

        return true;
    }

    public boolean dq_push_back(int v) {
        if (contador == Constantes.MAX_DEQUE) return false;
        fin = (fin + 1) % Constantes.MAX_DEQUE;
        datos[fin] = v;
        contador++;

        return true;
    }

    public EstructuraResultado dq_pop_front() {
        if (contador == 0) return new EstructuraResultado(false, 0);
        int out = datos[frente];
        frente = (frente + 1) % Constantes.MAX_DEQUE;
        contador--;

        return new EstructuraResultado(true, out);
    }

    public EstructuraResultado dq_pop_back() {
        if (contador == 0) return new EstructuraResultado(false, 0);
        int out = datos[fin];
        fin = (fin - 1 + Constantes.MAX_DEQUE) % Constantes.MAX_DEQUE;
        contador--;

        return new EstructuraResultado(true, out);
    }
    
    public void dq_print() {
        System.out.print("[Deque] Frente -> ");
        if (contador == 0) {
            System.out.println("[VACIA]");
            return;
        }
        for (int i = 0; i < contador; i++) {
            int indice = (frente + i) % Constantes.MAX_DEQUE;
            System.out.print(datos[indice] + (i == contador - 1 ? "" : " <-> "));
        }
        System.out.println(" <- Fin");
    }
}

class MinHeap {
    private int[] datos;
    private int tamanio;

    public MinHeap() {
        this.datos = new int[Constantes.MAX_STACK];
        this.tamanio = 0;
    }

    private void heap_swap(int i, int j) {
        int temp = datos[i];
        datos[i] = datos[j];
        datos[j] = temp;
    }

    private void heapify_up(int indice) {
        int padre = (indice - 1) / 2;
        while (indice > 0 && datos[indice] < datos[padre]) {
            heap_swap(indice, padre);
            indice = padre;
            padre = (indice - 1) / 2;
        }
    }

    private void heapify_down(int indice) {
        int izquierda = 2 * indice + 1;
        int derecha = 2 * indice + 2;
        int pequenio = indice;

        if (izquierda < tamanio && datos[izquierda] < datos[pequenio]) {
            pequenio = izquierda;
        }
        if (derecha < tamanio && datos[derecha] < datos[pequenio]) {
            pequenio = derecha;
        }

        if (pequenio != indice) {
            heap_swap(indice, pequenio);
            heapify_down(pequenio);
        }
    }

    public boolean heap_push(int v) {
        if (tamanio == Constantes.MAX_STACK) return false;
        datos[tamanio] = v;
        heapify_up(tamanio);
        tamanio++;

        return true;
    }

    public EstructuraResultado heap_pop() {
        if (tamanio == 0) {
            return new EstructuraResultado(false, 0);
        }
        int out = datos[0];
        datos[0] = datos[tamanio - 1];
        tamanio--;
        heapify_down(0);

        return new EstructuraResultado(true, out);
    }
    
    public void heap_print() {
        System.out.print("[MinHeap] Arreglo: ");
        if (tamanio == 0) {
            System.out.println("[VACIO]");
            return;
        }
        for (int i = 0; i < tamanio; i++) {
            System.out.print(datos[i] + (i == tamanio - 1 ? "" : ", "));
        }
        System.out.println();
    }
}

class BST {
    public TNode root; 

    public BST() {
        this.root = null;
    }
    
    public TNode bst_insert(TNode root, int v) {
        if (root == null) {
            return new TNode(v);
        }

        if (v < root.dato) {
            root.izquierda = bst_insert(root.izquierda, v);
        } else if (v > root.dato) {
            root.derecha = bst_insert(root.derecha, v);
        }
        return root;
    }
    
    public void insert(int v) {
        this.root = bst_insert(this.root, v);
    }

    public TNode bst_search(TNode root, int v) {
        if (root == null || root.dato == v) {
            return root;
        }
        if (v < root.dato) {
            return bst_search(root.izquierda, v);
        } else {
            return bst_search(root.derecha, v);
        }
    }

    private TNode bst_find_min(TNode root) {
        if (root == null) {
            return null;
        }

        while (root.izquierda != null) {
            root = root.izquierda;
        }

        return root;
    }
    
    public TNode bst_delete(TNode root, int v) {
        if (root == null) {
            return root;
        }

        if (v < root.dato) {
            root.izquierda = bst_delete(root.izquierda, v);
        } else if (v > root.dato) {
            root.derecha = bst_delete(root.derecha, v);
        } else {
            if (root.izquierda == null) {
                return root.derecha;
            } else if (root.derecha == null) {
                return root.izquierda;
            }

            TNode temp = bst_find_min(root.derecha);
            root.dato = temp.dato;
            root.derecha = bst_delete(root.derecha, temp.dato);
        }

        return root;
    }

    public boolean delete(int v) {
        TNode result = bst_delete(this.root, v);
        if (result == this.root && bst_search(this.root, v) == null) {
            if (this.root == null && v == 0) {
                return true;
            }

            return false;
        }
        this.root = result;
        
        return true;
    }

    public void bst_inorder(TNode root) {
        if (root != null) {
            bst_inorder(root.izquierda);
            System.out.print(root.dato + " ");
            bst_inorder(root.derecha);
        }
    }

    public void bst_preorder(TNode root) {
        if (root != null) {
            System.out.print(root.dato + " ");
            bst_preorder(root.izquierda);
            bst_preorder(root.derecha);
        }
    }

    public void bst_postorder(TNode root) {
        if (root != null) {
            bst_postorder(root.izquierda);
            bst_postorder(root.derecha);
            System.out.print(root.dato + " ");
        }
    }
    
    public void printInOrder() {
        System.out.print("[BST InOrder]: ");
        bst_inorder(this.root);
        System.out.println();
    }
    
    public void bst_free() {
        this.root = null;
    }
}

class AdjMatrix {
    private int[][] matriz;
    private int n;

    public AdjMatrix() {
        this.n = Constantes.MAX_VERTICES;
        this.matriz = new int[n][n];
    }
    
    public void am_add_edge(int u, int v, int w) {
        if (u >= 0 && u < n && v >= 0 && v < n) {
            matriz[u][v] = w;
            matriz[v][u] = w;
        }
    }

    public boolean am_is_connected(int u, int v) {
        if (u >= 0 && u < n && v >= 0 && v < n) {
            return matriz[u][v] != 0;
        }
        return false;
    }

    public void am_print() {
        System.out.println("[Matriz de Adyacencia]:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%4d", matriz[i][j]);
            }
            System.out.println();
        }
    }
}

class HashTable {
    private HashNode[] tabla;

    public HashTable() {
        this.tabla = new HashNode[Constantes.HASH_tamanio];
    }

    private int hash(String clave) {
        int hashVal = 0;
        for (int i = 0; i < clave.length(); i++) {
            hashVal = (hashVal * 31 + clave.charAt(i)) % Constantes.HASH_tamanio;
        }
        return hashVal < 0 ? hashVal + Constantes.HASH_tamanio : hashVal;
    }

    public boolean ht_insert(String clave, int valor) {
        int indice = hash(clave);
        HashNode nuevo = new HashNode(clave, valor);
        
        HashNode actual = tabla[indice];
        while(actual != null) {
            if (actual.clave.equals(clave)) {
                actual.valor = valor;
                return true;
            }
            actual = actual.siguiente;
        }

        nuevo.siguiente = tabla[indice];
        tabla[indice] = nuevo;

        return true;
    }

    public EstructuraResultado ht_search(String clave) {
        int indice = hash(clave);
        HashNode actual = tabla[indice];
        
        while (actual != null) {
            if (actual.clave.equals(clave)) {
                return new EstructuraResultado(true, actual.valor);
            }
            actual = actual.siguiente;
        }

        return new EstructuraResultado(false, 0);
    }
    
    public void ht_print() {
        System.out.println("[Tabla Hash - Encadenamiento Separado]:");
        for (int i = 0; i < Constantes.HASH_tamanio; i++) {
            System.out.printf("Bucket %2d: ", i);
            HashNode actual = tabla[i];
            while (actual != null) {
                System.out.printf("[%s: %d] -> ", actual.clave, actual.valor);
                actual = actual.siguiente;
            }
            System.out.println("NULL");
        }
    }
}

//EXTRA
class PilaString {
    private NodoString tope;

    public boolean estaVacia() {
        return tope == null;
    }

    public void push(String cadena) {
        NodoString nuevo = new NodoString(cadena);
        nuevo.siguiente = tope;
        tope = nuevo;
    }

    public String pop() {
        if (estaVacia()) {
            return null; 
        }
        String datoSalida = tope.dato;
        tope = tope.siguiente;
        return datoSalida;
    }

    public void liberar() {
        this.tope = null; 
    }
}

class ColaString {
    private NodoString frente;
    private NodoString fin;

    public boolean estaVacia() {
        return frente == null;
    }

    public void enqueue(String cadena) {
        NodoString nuevo = new NodoString(cadena);
        
        if (estaVacia()) {
            frente = nuevo;
            fin = nuevo;
        } else {
            fin.siguiente = nuevo;
            fin = nuevo;
        }
    }

    public String dequeue() {
        if (estaVacia()) {
            return null;
        }
        
        String datoSalida = frente.dato;
        frente = frente.siguiente;

        if (frente == null) {
            fin = null;
        }
        return datoSalida;
    }
    
    public void imprimir() {
        NodoString actual = frente;
        System.out.print("  [Cola]: ");
        if (estaVacia()) {
            System.out.println("[VACIA]");
            return;
        }
        while (actual != null) {
            System.out.print("[" + actual.dato + "] -> ");
            actual = actual.siguiente;
        }
        System.out.println("FINAL");
    }

    public void liberar() {
        this.frente = null;
        this.fin = null;
    }
}