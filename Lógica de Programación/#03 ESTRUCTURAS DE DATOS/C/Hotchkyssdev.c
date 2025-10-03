/*
 * EJERCICIO:
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

#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>
#define CAPACIDAD 50 
#define MAX_NAMES 5
#define MAX_LEN 20
char lista_nombres[MAX_NAMES][MAX_LEN];
int num_nombres = 0;
#define MAX_PRODUCTOS 5
#define MAX_NOMBRE 30

struct Producto {
    char nombre[MAX_NOMBRE];
    int codigo;
    float precio;
};

struct Producto inventario[MAX_PRODUCTOS];
int num_productos = 0;
#define MAX_ALIAS 20

union ValorDeDato {
    int id;
    char alias[MAX_ALIAS];
    float SumaDeControl;
};

//Se define un Struct que usa la unión y un indicador
struct Item {
    union ValorDeDato value; 
    int tipo;              //Indicador: 1=id, 2=alias, 3=SumaDeControl
};

//Enumeración: constantes enteras
enum EstadoPedido {
    PENDIENTE = 10,  //Valor inicial 10
    PROCESANDO,      //Se incrementa a 11
    EN_ENVIO,        //Se incrementa a 12
    ENTREGADO = 99,  //Valor fijo 
    CANCELADO = 0    //Valor fijo 
};

//Struct para simular un pedido y su estado
struct Pedido {
    int id;
    enum EstadoPedido estado_actual;
};

#define MAX_NOMBRE_P 50

//Struct gestionado por punteros
struct ProductoDinamico {
    char nombre[MAX_NOMBRE_P];
    int id;
    float precio;
};

//Puntero global 
struct ProductoDinamico *prod_ptr = NULL; 

//Prototipos de funciones
void limpiar_buffer(); 
void insertarArreglo(int arreglo[], int *tam, int capacidad);
void leerArreglo(int arreglo[], int tam);
void buscarArreglo(int arreglo[], int tam);
void eliminarArreglo(int arreglo[], int *tam);
void crear_nombre(); 
void leer_nombres(); 
void actualizar_nombre(); 
void eliminar_nombre(); 
void crear_producto();       
void leer_productos();       
void actualizar_producto();  
void eliminar_producto();
void crear_y_leer_union(struct Item *item_ptr, int tipo, const char *input_str);
void actualizar_union(struct Item *item_ptr, int nuevo_tipo, const char *nuevo_input_str);
void mostrar_union(const struct Item *item_ptr);    
void crear_pedido(struct Pedido *pedido_ptr, int id_val, enum EstadoPedido estado_inicial);
void mostrar_estado(const struct Pedido *pedido_ptr);
void actualizar_estado(struct Pedido *pedido_ptr, enum EstadoPedido nuevo_estado);
void crear_producto_dinamico(int id, float precio, const char *nombre); 
void leer_producto_dinamico();                                          
void actualizar_producto_dinamico();                                    
void eliminar_producto_dinamico();   

//EXTRA
void insertarContacto();
void buscarContacto();
void actualizarContacto();
void eliminarContacto();
void listarContactos();
void menu();    
bool es_telefono_valido(const char *telefono);

//Función para limpiar el buffer cuando se necesite
void limpiar_buffer() {
    int c;
    while ((c = getchar()) != '\n' && c != EOF);
}

//Arrays
void insertarArreglo(int arreglo[], int *tam, int capacidad) {
    int i, valor, pos;
    int n = 0;
    if (*tam >= capacidad) {
        printf("Error: El arreglo está lleno. No se puede insertar.\n");
        return;
    }
    printf("\n--- Funcion: Insertar ---\n");
    printf("Ingrese el valor a insertar: ");
    
    //Si scanf falla o lee una nueva línea que quedó pendiente
    if (scanf("%d", &valor) != 1) { 
        printf("Entrada invalida. Por favor, ingrese un numero.\n");
        limpiar_buffer(); 
        return;
    }

    //For para verificar si ya existe
    for (i = 0; i < *tam; i++) {
        if (arreglo[i] == valor) {
            printf("El valor ya existe. No se puede insertar.\n");
            limpiar_buffer(); 
            return;
        }
    }

    //Buscar posición para insertar (asumiendo que el array esta ordenado)
    for (pos = 0; pos < *tam && arreglo[pos] < valor; pos++);

    //Desplazo a la derecha
    for (i = *tam; i > pos; i--) {
        arreglo[i] = arreglo[i - 1];
    }

    arreglo[pos] = valor;
    (*tam)++; 

    printf("Arreglo con la nueva insercion: ");
    //Bubble Sort
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (arreglo[j] > arreglo[j + 1]) {
                int temp = arreglo[j];
                arreglo[j] = arreglo[j + 1];
                arreglo[j + 1] = temp;
            }
        }
    }

    leerArreglo(arreglo, *tam);
}

void leerArreglo(int arreglo[], int tamano) {
    int i;
    printf("Contenido del arreglo (%d elementos): \n", tamano);
    for (i = 0; i < tamano; i++) {
        printf("%d ", arreglo[i]);
    }
    printf("\n");
}

void buscarArreglo(int arreglo[], int tamano) {
    int i, valor;
    int encontrado = 0; 

    printf("\n--- Funcion: Buscar ---\n");
    printf("Ingrese el valor a buscar: ");
    if (scanf("%d", &valor) != 1) {
        printf("Entrada invalida. Por favor, ingrese un numero.\n");
        limpiar_buffer();
        return;
    }

    for (i = 0; i < tamano; i++) {
        if (arreglo[i] == valor) {
            printf("Valor encontrado en la posicion %d.\n", i);
            encontrado = 1;
            break;
        }
    }

    if (!encontrado) {
        printf("Valor no encontrado.\n");
    }
}

void eliminarArreglo(int arreglo[], int *tam) {
    int i, valor;
    int pos = -1;

    if (*tam == 0) {
        printf("El arreglo está vacío, no se puede eliminar.\n");
        return;
    }
    
    printf("\n--- Funcion: Eliminar ---\n");
    printf("Ingrese el valor a eliminar: ");
    if (scanf("%d", &valor) != 1) {
        printf("Entrada invalida. Por favor, ingrese un numero.\n");
        limpiar_buffer();
        return;
    }

    //Se aplica Búsqueda lineal para encontrar la posición
    for(i = 0; i < *tam; i++) {
        if (arreglo[i] == valor) {
            pos = i;
            break;
        }
    }

    if (pos == -1) {
        printf("Elemento no encontrado.\n");
    } else {
        // Desplazo elementos a la izquierda
        for (i = pos; i < *tam - 1; i++) {
            arreglo[i] = arreglo[i + 1];
        }
        (*tam)--; 

        printf("Arreglo actualizado despues de eliminacion: ");
        leerArreglo(arreglo, *tam);
    }
}

//Strings
void crear_nombre() {
    if (num_nombres >= MAX_NAMES) {
        printf("\nError: La lista de nombres está llena.\n");
        return;
    }
    printf("\n--- Funcion: Crear (Insertar String) ---\n");
    printf("Ingrese el nuevo nombre (max %d caracteres): ", MAX_LEN - 1);
    limpiar_buffer(); 
    
    //Uso de fgets para evitar overflow y leer la línea completa.
    if (fgets(lista_nombres[num_nombres], MAX_LEN, stdin) == NULL) return;
    
    lista_nombres[num_nombres][strcspn(lista_nombres[num_nombres], "\n")] = '\0';
    
    if (strlen(lista_nombres[num_nombres]) > 0) {
        num_nombres++;
        printf("Nombre insertado con exito.\n");
    } else {
        printf("Nombre vacio, no se inserto.\n");
    }
}

void leer_nombres() {
    if (num_nombres == 0) {
        printf("\nLa lista de nombres está vacia.\n");
        return;
    }
    printf("\n--- Funcion: Leer (Listar Strings) ---\n");
    //Ordenamiento de Strings usando BubbleSort
    for (int i = 0; i < num_nombres - 1; i++) {
        for (int j = 0; j < num_nombres - 1 - i; j++) {
            if (strcmp(lista_nombres[j], lista_nombres[j+1]) > 0) { 
                char temp[50]; 
                strcpy(temp, lista_nombres[j]);
                strcpy(lista_nombres[j], lista_nombres[j+1]);
                strcpy(lista_nombres[j+1], temp);
            }
        }
    }

    for (int i = 0; i < num_nombres; i++) {
        printf("%d. %s\n", i + 1, lista_nombres[i]); 
    }
}

void actualizar_nombre() {
    int pos;
    char nuevo_nombre[MAX_LEN];
    int indice; 

    if (num_nombres == 0) {
        printf("\nLa lista está vacia, no hay nada que actualizar.\n");
        return;
    }
    leer_nombres();
    printf("\n--- Funcion: Actualizar String ---\n");
    printf("Ingrese el numero del nombre a actualizar (1 a %d): ", num_nombres);
    
    if (scanf("%d", &pos) != 1 || pos < 1 || pos > num_nombres) {
        printf("Numero de posicion invalido.\n");
        limpiar_buffer();
        return;
    }
    
    indice = pos - 1;

    printf("Nombre actual: %s\n", lista_nombres[indice]);
    printf("Ingrese el nuevo valor (max %d caracteres): ", MAX_LEN - 1);
    
    limpiar_buffer();
    if (fgets(nuevo_nombre, MAX_LEN, stdin) == NULL) return;
    
    nuevo_nombre[strcspn(nuevo_nombre, "\n")] = '\0';

    //Uso de strcpy para sobrescritura del string en la posición seleccionada
    if (strlen(nuevo_nombre) > 0) {
        strcpy(lista_nombres[indice], nuevo_nombre);
        printf("Nombre actualizado con exito.\n");
    } else {
        printf("Actualizacion cancelada. Nombre vacio.\n");
    }
}

void eliminar_nombre() {
    int pos;
    int indice; 
    if (num_nombres == 0) {
        printf("\nLa lista está vacia, no hay nada que eliminar.\n");
        return;
    }
    leer_nombres();
    printf("\n--- Funcion: Eliminar String ---\n");
    printf("Ingrese el numero del nombre a eliminar (1 a %d): ", num_nombres);

    if (scanf("%d", &pos) != 1 || pos < 1 || pos > num_nombres) {
        printf("Numero de posicion invalido.\n");
        limpiar_buffer();
        return;
    }
    
    indice = pos - 1;
    printf("Eliminando: %s\n", lista_nombres[indice]);

    //Desplazo los elementos restantes a la izquierda para cubrir el hueco
    for (int i = indice; i < num_nombres - 1; i++) {
        //Copio el siguiente string al actual
        strcpy(lista_nombres[i], lista_nombres[i + 1]); 
    }
    
    //De manera opcional, "limpio" el último elemento (aunque no es estrictamente necesario)
    lista_nombres[num_nombres - 1][0] = '\0'; 

    num_nombres--;
    printf("Nombre eliminado con exito.\n");
}

//Structs
void crear_producto() {
    struct Producto nuevo_contacto;
    if (num_productos >= MAX_PRODUCTOS) {
        printf("\nError: El inventario esta lleno.\n");
        return;
    }
    printf("\n--- Funcion: Crear Producto ---\n");
    printf("Ingrese el codigo del producto (entero): ");
    if (scanf("%d", &nuevo_contacto.codigo) != 1) {
        printf("Error: Codigo invalido.\n");
        limpiar_buffer();
        return;
    }

    printf("Ingrese el nombre del producto (max %d): ", MAX_NOMBRE - 1);
    limpiar_buffer(); 
    if (fgets(nuevo_contacto.nombre, MAX_NOMBRE, stdin) == NULL) return;
    nuevo_contacto.nombre[strcspn(nuevo_contacto.nombre, "\n")] = '\0'; 
    
    printf("Ingrese el precio del producto (float): ");
    if (scanf("%f", &nuevo_contacto.precio) != 1) {
        printf("Error: Precio invalido.\n");
        limpiar_buffer();
        return;
    }
    
    //Se hace la inserción al final del array de structs
    inventario[num_productos] = nuevo_contacto; //Hace una copia toda la estructura
    num_productos++;
    printf("Producto '%s' insertado con exito.\n", nuevo_contacto.nombre);
}

void leer_productos() {
    if (num_productos == 0) {
        printf("\nEl inventario esta vacio.\n");
        return;
    }
    printf("\n--- Funcion: Leer Productos (Inventario) ---\n");
    printf("No. | Codigo | Nombre                       | Precio\n");
    printf("----|--------|------------------------------|--------\n");
    for (int i = 0; i < num_productos; i++) {
        printf("%3d | %6d | %-28s | %.2f\n", 
               i + 1, 
               inventario[i].codigo, 
               inventario[i].nombre, 
               inventario[i].precio);
    }
}

void actualizar_producto() {
    int pos;
    float nuevo_precio;

    if (num_productos == 0) {
        printf("\nEl inventario esta vacio, no hay nada que actualizar.\n");
        return;
    }
    
    leer_productos();
    printf("\n--- Funcion: Actualizar Producto ---\n");
    printf("Ingrese el numero del producto a actualizar (1 a %d): ", num_productos);
    
    if (scanf("%d", &pos) != 1 || pos < 1 || pos > num_productos) {
        printf("Numero de posicion invalido.\n");
        limpiar_buffer();
        return;
    }
    
    int indice = pos - 1; 
    
    printf("Producto actual: %s (Precio: %.2f)\n", inventario[indice].nombre, inventario[indice].precio);
    
    printf("Ingrese el nuevo precio (float): ");
    if (scanf("%f", &nuevo_precio) != 1) {
        printf("Error: Precio invalido.\n");
        limpiar_buffer();
        return;
    }
    
    //Se hace una actualización de manera directa sobre el miembro del struct
    inventario[indice].precio = nuevo_precio;
    printf("Precio de '%s' actualizado a %.2f.\n", inventario[indice].nombre, inventario[indice].precio);
}

void eliminar_producto() {
    int pos;

    if (num_productos == 0) {
        printf("\nEl inventario esta vacio, no hay nada que eliminar.\n");
        return;
    }
    
    leer_productos();
    printf("\n--- Funcion: Eliminar Producto ---\n");
    printf("Ingrese el numero del producto a eliminar (1 a %d): ", num_productos);

    if (scanf("%d", &pos) != 1 || pos < 1 || pos > num_productos) {
        printf("Numero de posicion invalido.\n");
        limpiar_buffer();
        return;
    }
    
    int indice = pos - 1; 

    printf("Eliminando: %s (Codigo: %d)\n", inventario[indice].nombre, inventario[indice].codigo);

    //Desplazo las estructuras restantes a la izquierda
    for (int i = indice; i < num_productos - 1; i++) {
        //Se copia toda la estructura siguiente a la posición actual
        inventario[i] = inventario[i + 1]; 
    }
    
    num_productos--;
    printf("Producto eliminado con exito.\n");
}

//Uniones
void crear_y_leer_union(struct Item *item_ptr, int tipo, const char *input_str) {
    item_ptr->tipo = tipo; //Se establece el indicador de tipo

    printf("\n--- Funcion: Crear/Inicializar Union ---\n");
    printf("Estableciendo el tipo %d...\n", tipo);
    switch (tipo) {
        case 1: //ID (Entero)
            item_ptr->value.id = atoi(input_str); 
            printf("  -> Valor de ID establecido a: %d\n", item_ptr->value.id);
            //Mostrar el resto de los miembros (CONTENIDO BASURA)
            printf("  -> Memoria compartida (alias) ahora es: %s\n", item_ptr->value.alias);
            break;
        case 2: //ALIAS (String)
            //Se usa strncpy para copiar la cadena al miembro de la union
            strncpy(item_ptr->value.alias, input_str, MAX_ALIAS - 1);
            item_ptr->value.alias[MAX_ALIAS - 1] = '\0';
            printf("  -> Valor de ALIAS establecido a: %s\n", item_ptr->value.alias);
            //Se muestra el resto de los miembros (CONTENIDO BASURA)
            printf("  -> Memoria compartida (id) ahora es: %d\n", item_ptr->value.id);
            break;
        case 3: //SumaDeControl (Flotante)
            item_ptr->value.SumaDeControl = atof(input_str);
            printf("  -> Valor de SumaDeControl establecido a: %.2f\n", item_ptr->value.SumaDeControl);
            break;
        default:
            printf("Tipo de dato no reconocido.\n");
            item_ptr->tipo = 0;
    }
}

void mostrar_union(const struct Item *item_ptr) {
    printf("\n--- Funcion: Leer Union ---\n");
    if (item_ptr->tipo == 0) {
        printf("Elemento no inicializado.\n");
        return;
    }

    printf("El elemento esta almacenando un valor de tipo: ");
    switch (item_ptr->tipo) {
        case 1:
            printf("ID (Entero): %d\n", item_ptr->value.id);
            break;
        case 2:
            printf("ALIAS (String): %s\n", item_ptr->value.alias);
            break;
        case 3:
            printf("SumaDeControl (Flotante): %.2f\n", item_ptr->value.SumaDeControl);
            break;
    }
}

void actualizar_union(struct Item *item_ptr, int nuevo_tipo, const char *nuevo_input_str) {
    printf("\n--- Funcion: Actualizar Union ---\n");
    printf("El valor actual (tipo %d) sera sobrescrito por el nuevo valor (tipo %d).\n", item_ptr->tipo, nuevo_tipo);
    crear_y_leer_union(item_ptr, nuevo_tipo, nuevo_input_str);
    printf("Memoria de la Union sobrescrita con exito!\n");
}

//Enums
void crear_pedido(struct Pedido *pedido_ptr, int id_val, enum EstadoPedido estado_inicial) {
    printf("\n--- Funcion: Crear/Inicializar Enum (Pedido) ---\n");
    pedido_ptr->id = id_val;
    pedido_ptr->estado_actual = estado_inicial; //Asignación de una constante enum a la variable de tipo enum
    printf("Pedido %d creado. Estado inicial (valor entero): %d\n", pedido_ptr->id, pedido_ptr->estado_actual);
}

void mostrar_estado(const struct Pedido *pedido_ptr) {
    printf("\n--- Funcion: Leer Enum (Estado del Pedido) ---\n");
    printf("Estado del Pedido ID %d: ", pedido_ptr->id);
    switch (pedido_ptr->estado_actual) {     //Basado en el valor entero del enum
        case PENDIENTE:
            printf("PENDIENTE. (Esperando Pago)\n");
            break;
        case PROCESANDO:
            printf("PROCESANDO. (En Almacen)\n");
            break;
        case EN_ENVIO:
            printf("EN ENVIO. (A la Entrega)\n");
            break;
        case ENTREGADO:
            printf("ENTREGADO. (Completado)\n");
            break;
        case CANCELADO:
            printf("CANCELADO. (Orden vacia)\n");
            break;
        default:
            printf("Estado desconocido o invalido (Valor: %d).\n", pedido_ptr->estado_actual);
            break;
    }
}

void actualizar_estado(struct Pedido *pedido_ptr, enum EstadoPedido nuevo_estado) {
    printf("\n--- Funcion: Actualizar Enum (Cambio de Estado) ---\n");
    
    enum EstadoPedido estado_anterior = pedido_ptr->estado_actual;
    
    // Actualización directa del miembro del struct
    pedido_ptr->estado_actual = nuevo_estado; 
    
    printf("El Pedido ID %d ha cambiado de estado.\n", pedido_ptr->id);
    
    // Mostramos los estados anterior y actual
    printf("  -> Estado anterior (Valor %d): ", estado_anterior);
    mostrar_estado(pedido_ptr); // Se usa la función de lectura para mostrar el estado
}

//Punteros
void crear_producto_dinamico(int id, float precio, const char *nombre) {
    if (prod_ptr != NULL) {
        printf("\nError: El producto ya existe. Ejecute eliminar_producto_dinamico() primero.\n");
        return;
    }
    
    printf("\n--- Funcion: Crear Puntero (Asignacion de Memoria) ---\n");
    
    // Asignar memoria para un único struct ProductoDinamico
    prod_ptr = (struct ProductoDinamico *)malloc(sizeof(struct ProductoDinamico));

    if (prod_ptr == NULL) {
        printf("ERROR: No se pudo asignar memoria.\n");
        return;
    }

    // Inicializar los campos usando el operador flecha (->)
    prod_ptr->id = id;
    prod_ptr->precio = precio;
    strncpy(prod_ptr->nombre, nombre, MAX_NOMBRE_P - 1);
    prod_ptr->nombre[MAX_NOMBRE_P - 1] = '\0';

    printf("Memoria asignada en la direccion: %p\n", (void *)prod_ptr);
    printf("Producto creado: %s\n", prod_ptr->nombre);
}

void leer_producto_dinamico() {
    if (prod_ptr == NULL) {
        printf("\nError: No hay producto (puntero es NULL).\n");
        return;
    }

    printf("\n--- Funcion: Leer Puntero (Desreferencia) ---\n");
    printf("Direccion de memoria: %p\n", (void *)prod_ptr);
    
    // Desreferenciación y lectura de los miembros
    printf("  ID: %d\n", prod_ptr->id);
    printf("  Nombre: %s\n", prod_ptr->nombre);
    printf("  Precio: %.2f\n", prod_ptr->precio);
}

void actualizar_producto_dinamico() {
    if (prod_ptr == NULL) {
        printf("\nError: No hay producto para actualizar.\n");
        return;
    }

    printf("\n--- Funcion: Actualizar Puntero ---\n");
    
    // Actualizamos un miembro (el precio)
    float nuevo_precio = prod_ptr->precio * 1.10;
    prod_ptr->precio = nuevo_precio; // Modificando el valor en la memoria apuntada
    
    // Actualizamos otro miembro (el nombre)
    strcat(prod_ptr->nombre, " (v2)");

    printf("Producto '%s' actualizado.\n", prod_ptr->nombre);
    printf("Nuevo precio: %.2f\n", prod_ptr->precio);
}

void eliminar_producto_dinamico() {
    if (prod_ptr == NULL) {
        printf("\nError: No hay memoria asignada para liberar.\n");
        return;
    }

    printf("\n--- Funcion: Eliminar Puntero (Liberacion de Memoria) ---\n");
    printf("Liberando la memoria en la direccion: %p\n", (void *)prod_ptr);
    
    // Liberar la memoria del heap
    free(prod_ptr); 
    
    // Establecer el puntero a NULL para evitar errores de puntero colgante
    prod_ptr = NULL; 
    
    printf("Memoria liberada. Puntero establecido a NULL.\n");
}

//MAIN
int main() {
    //Arrays
    int valores_iniciales[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13, 14, 15, 16, 17, 18, 98};
    int tam_inicial = sizeof(valores_iniciales) / sizeof(valores_iniciales[0]);
    int arreglo[CAPACIDAD]; 
    int tam = tam_inicial; 
    memcpy(arreglo, valores_iniciales, tam_inicial * sizeof(int));
    
    printf("--- Estado inicial del arreglo en main ---\n");
    leerArreglo(arreglo, tam);
    insertarArreglo(arreglo, &tam, CAPACIDAD);
    buscarArreglo(arreglo, tam);
    eliminarArreglo(arreglo, &tam);
    printf("\n--- Estado final del arreglo en main ---\n");
    leerArreglo(arreglo, tam);

    //Strings
    printf("--- DEMOSTRACION CRUD DE STRINGS ---\n");
    printf("\n---INSERTAR NOMBRES INICIALES ---\n");
    strcpy(lista_nombres[0], "Alice");
    num_nombres++;
    strcpy(lista_nombres[1], "Bob");
    num_nombres++;
    
    crear_nombre(); 
    leer_nombres(); 
    actualizar_nombre(); 
    leer_nombres();
    eliminar_nombre(); 

    printf("\n--- ESTADO FINAL DE LA LISTA ---\n");
    leer_nombres(); 

    //Structs
    printf("--- DEMOSTRACION CRUD DE STRUCTS ---\n");
    printf("\n--- INSERTAR PRODUCTOS INICIALES ---\n");

    inventario[0].codigo = 101;
    strcpy(inventario[0].nombre, "Teclado Mecanico");
    inventario[0].precio = 75.99;
    num_productos++;
    
    inventario[1].codigo = 202;
    strcpy(inventario[1].nombre, "Mouse Inalambrico");
    inventario[1].precio = 25.50;
    num_productos++;

    crear_producto(); 
    leer_productos(); 
    actualizar_producto(); 
    leer_productos();
    eliminar_producto(); 

    printf("\n--- ESTADO FINAL DEL INVENTARIO ---\n");
    leer_productos(); 

    //Uniones
    struct Item mi_dato;

    printf("\n--- DEMOSTRACION DE UNIONES EN C ---\n");
    crear_y_leer_union(&mi_dato, 1, "98765"); //Creación/Inicialización con un Entero (ID)
    mostrar_union(&mi_dato);    
    actualizar_union(&mi_dato, 2, "Sesion-A24"); //Actualización: Sobrescribir la memoria con un String (ALIAS)
    mostrar_union(&mi_dato);
    printf("\n--- Accediendo al miembro INCORRECTO ---\n"); //Demostración de Conflicto de Memoria (LECTURA ERRÓNEA)
    printf("Intentando leer el ID (miembro incorrecto): %d\n", mi_dato.value.id); //Aunque el tipo es ALIAS (string), se fuerza la lectura como entero (ID)
    printf("El valor leido es BASURA, ya que la memoria esta formateada como string.\n");    
    actualizar_union(&mi_dato, 3, "1.41421"); //Actualización a Flotante (SumaDeControl)
    mostrar_union(&mi_dato);

    //Enums
    struct Pedido mi_pedido; //Se declara el Struct que contiene el enum
    printf("\n--- DEMOSTRACION DE ENUMS EN C ---\n");
    crear_pedido(&mi_pedido, 54321, PENDIENTE);
    mostrar_estado(&mi_pedido);
    actualizar_estado(&mi_pedido, PROCESANDO); 
    actualizar_estado(&mi_pedido, EN_ENVIO);
    actualizar_estado(&mi_pedido, ENTREGADO);
    mostrar_estado(&mi_pedido);    
    printf("\n--- DEMOSTRACION ALTERNATIVA (CANCELADO) ---\n");  //Estado alternativo (CANCELADO)
    actualizar_estado(&mi_pedido, CANCELADO);
    mostrar_estado(&mi_pedido);

    //Punteros
    printf("\n--- DEMOSTRACION DE PUNTEROS Y MEMORIA DINAMICA ---\n");    
    crear_producto_dinamico(1, 50.00, "Webcam HD"); //Asigna memoria e inicializa el struct    
    leer_producto_dinamico(); //Muestra el contenido a traves del puntero    
    actualizar_producto_dinamico(); //Modifica los valores en la memoria apuntada
    leer_producto_dinamico();
    eliminar_producto_dinamico(); //Libera la memoria
    printf("\n--- Intento de lectura despues de free() ---\n"); //Intento fallido de leer despues de la liberacion
    leer_producto_dinamico(); 

    //Ejercicio Extra
    int opcion;
    bool salir = false;
    strcpy(agenda[0].nombre, "Hotchkyss Gersom");
    strcpy(agenda[0].telefono, "123456789");
    num_contactos = 1;

    strcpy(agenda[1].nombre, "Portillo Guillermo");
    strcpy(agenda[1].telefono, "987654321");
    num_contactos = 2;

    do {
        mostrar_menu();
        limpiar_buffer(); 
        if (scanf("%d", &opcion) != 1) {
            printf("Entrada invalida. Por favor, ingrese un numero.\n");
            continue;
        }

        switch (opcion) {
            case 1:
                insertar_contacto();
                break;
            case 2:
                buscar_contacto();
                break;
            case 3:
                actualizar_contacto();
                break;
            case 4:
                eliminar_contacto();
                break;
            case 5:
                listar_contactos();
                break;
            case 0:
                printf("\nAgenda cerrada. ¡Hasta pronto!\n");
                salir = true;
                break;
            default:
                printf("\nOpcion no valida. Intente de nuevo.\n");
                break;
        }
    } while (!salir);

    return 0;
}

//EXTRA
#define MAX_CONTACTOS 100
#define MAX_NOMBRE 50
#define MAX_TELEFONO_DIGITOS 11
#define MAX_TELEFONO (MAX_TELEFONO_DIGITOS + 1)

struct Contacto {
    char nombre[MAX_NOMBRE];
    char telefono[MAX_TELEFONO];
};

struct Contacto agenda[MAX_CONTACTOS];
int num_contactos = 0;

bool es_telefono_valido(const char *telefono) {
    size_t len = strlen(telefono);

    if (len == 0 || len > MAX_TELEFONO_DIGITOS) {
        return false;
    }

    for (size_t i = 0; i < len; i++) {
        if (telefono[i] < '0' || telefono[i] > '9') {
            return false;
        }
    }
    return true;
}

void menu() {
    printf("\n\n--- AGENDA DE CONTACTOS ---\n");
    printf("1. Insertar Contacto\n");
    printf("2. Buscar Contacto\n");
    printf("3. Actualizar Contacto\n");
    printf("4. Eliminar Contacto\n");
    printf("5. Listar Todos los Contactos\n");
    printf("0. Finalizar Programa\n");
    printf("Seleccione una operacion: ");
}

void insertarContacto() {
    if (num_contactos >= MAX_CONTACTOS) {
        printf("\nError: Agenda llena. No se puede añadir mas contactos.\n");
        return;
    }

    struct Contacto nuevo;
    char temp_telefono[MAX_TELEFONO + 5];
    printf("\n--- INSERTAR CONTACTO ---\n");
    printf("Nombre (max %d): ", MAX_NOMBRE - 1);
    limpiar_buffer();
    if (fgets(nuevo.nombre, MAX_NOMBRE, stdin) == NULL) return;
    nuevo.nombre[strcspn(nuevo.nombre, "\n")] = '\0';

    do {
        printf("Telefono (max %d digitos, solo numeros): ", MAX_TELEFONO_DIGITOS);
        if (fgets(temp_telefono, sizeof(temp_telefono), stdin) == NULL) return;
        temp_telefono[strcspn(temp_telefono, "\n")] = '\0';

        if(!es_telefono_valido(temp_telefono)) {
            printf("Telefono invalido. Use solo numeros y maximo %d digitos.\n", MAX_TELEFONO_DIGITOS);
        } else {
            strcpy(nuevo.telefono, temp_telefono);
            break;
        }
    } while (true);

    agenda[num_contactos] = nuevo;
    num_contactos++;
    printf("Contacto 's' insertado con exito.\n", nuevo.nombre);
}

void buscarContacto() {
    char nombre_buscado[MAX_NOMBRE];
    int encontrados = 0;

    if (num_contactos == 0) {
        printf("\nLa agenda esta vacia.\n");
        return;
    }

    printf("\n--- BUSCAR CONTACTO ---\n");
    printf("Ingrese nombre o parte del nombre a buscar: ");
    limpiar_buffer();
    if (fgets(nombre_buscado, MAX_NOMBRE, stdin) == NULL) return;
    nombre_buscado[strcspn(nombre_buscado, "\n")] = '\0';

    printf("Resultados:\n");
    for (int i = 0; i < num_contactos; i++) {
        if (strstr(agenda[i].nombre, nombre_buscado) != NULL) {
            printf("Posicion [%d]. Nombre: %s, Telefono: %s\n", i, agenda[i].nombre, agenda[i].telefono);
            encontrados++;
        }
    }

    if (encontrados == 0) {
        printf("No se encontraron contactos que coincidan con '%s'.\n", nombre_buscado);
    }
}

void actualizarContacto() {
    int pos;
    char temp_telefono[MAX_TELEFONO + 5];

    if (num_contactos == 0) {
        printf("\nLa agenda esta vacia, no hay nada que actualizar.\n");
        return;
    }

    printf("\n--- ACTUALIZAR CONTACTO ---\n");
    printf("Ingrese la posicion del contacto a actualizar (0 o %d): ",  num_contactos);
    if (scanf("%d", &pos) != 1) {
        printf("Error: Entrada invalida. Intente de nuevo.\n");
        limpiar_buffer();
        return;
    }

    if (pos < 0 || pos >= num_contactos) {
        printf("Error: Posicion fuera de rango.\n");
        return;
    }

    printf("Actualizando a: %s, Telefono actual: %s\n", agenda[pos].nombre, agenda[pos].telefono);

    do {
        printf("Nuevo Telefono (max %d digitos): ", MAX_TELEFONO_DIGITOS);
        limpiar_buffer();
        if(fgets(temp_telefono, sizeof(temp_telefono), stdin) == NULL) return;
        temp_telefono[strcspn(temp_telefono, '\n')] = '\0';

        if (!es_telefono_valido(temp_telefono)) {
            printf("Telefono invalido. Use solo numeros y maximo %d digitos.\n", MAX_TELEFONO_DIGITOS);
        } else {
            strcpy(agenda[pos].telefono, temp_telefono);
            printf("Contacto de '%s' actualizado con exito.\n", agenda[pos].nombre);
            break;
        }
    } while (true);
}

void eliminarContacto() {
    int pos;

    if (num_contactos == 0) {
        printf("\nLa agenda esta vacia, no hay nada que actualizar.\n");
        return;
    }

    printf("\n--- ELIMINAR CONTACTO ---\n");
    printf("Ingrese la posicion del contacto a eliminar (0 a %d): ", num_contactos);

    if (scanf("%d", &pos) != 1) {
        printf("Error: Entrada invalida. Intente de nuevo.\n");
        limpiar_buffer();
        return;
    }

    if (pos < 0 || pos >= num_contactos) {
        printf("Error: Posicion fuera de rango.\n");
        return;
    }

    printf("Eliminando: %s, Telefono: %s\n", agenda[pos].telefono, agenda[pos].nombre);

    //Desplazo elementos a la izquierda para "borrar"
    for (int i = pos; i < num_contactos - 1; i++) {
        agenda[i] = agenda[i + 1];
    }
    num_contactos--;
    printf("Contacto eliminado con exito.\n");
}

void listarContactos() {
    if (num_contactos == 0) {
        printf("\nLa agenda esta vacia, no hay nada que actualizar.\n");
        return;
    }
    printf("\n--- LISTA DE CONTACTOS (%d) ---\n", num_contactos);
    for (int i = 0; i < num_contactos; i++) {
        printf("[%d] Nombre: %s, Telefono: %s\n", i, agenda[i].nombre, agenda[i].telefono);
    }
}