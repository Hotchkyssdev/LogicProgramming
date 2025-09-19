'''
PILAS Y COLAS
'''
#Pila/Stack (LIFO)
pila = []
#Push
pila.append(1)
pila.append(2)
pila.append(3)
print(pila)
#Pop
pila_item = pila[len(pila) - 1]
del pila[len(pila) - 1]
print(pila_item)
print(pila.pop())
print(pila)
print("")

#Cola/Queue (FIFO)
cola = []
#Enqueue
cola.append(1)
cola.append(2)
cola.append(3)
print(cola)
#Dequeue
cola_item = cola[0]
del cola[0]
print(cola_item)
print(cola.pop(0))
print(cola) 
print("")

'''
DIFICULTAD EXTRA:
- Utilizando la implementación de pila y cadenas de texto, simula el mecanismo adelante/atrás
 *   de un navegador web. Crea un programa en el que puedas navegar a una página o indicarle
 *   que te quieres desplazar adelante o atrás, mostrando en cada caso el nombre de la web.
 *   Las palabras "adelante", "atrás" desencadenan esta acción, el resto se interpreta como
 *   el nombre de una nueva web.
- Utilizando la implementación de cola y cadenas de texto, simula el mecanismo de una
 *   impresora compartida que recibe documentos y los imprime cuando así se le indica.
 *   La palabra "imprimir" imprime un elemento de la cola, el resto de palabras se
 *   interpretan como nombres de documentos.
'''

def navegacion_web():
    pila = []
    while True:
        accion = input("Añade una url o interactúa con palabras adelante/atrás/salir: ")
        if accion == "salir":
            print("Saliendo del navegador web.")
            break
        elif accion == "adelante":
            pass
        elif accion == "atras":
            if len(pila) > 0:
                pila.pop()
        else:
            pila.append(accion)

        if len(pila) > 0:
            print(f"Has navegado a la web: {pila[len(pila) - 1]}.")
        else:
            print("Estás en la página de inicio.")

navegacion_web()

def impresora_compartida():
    cola = []
    while True:
        accion = input("Añade un documento o selecciona imprimir/salir: ")
        if accion == "salir":
            break
        elif accion == "imprimir":
            if len(cola) > 0:
                print(f"Imprimiendo: {cola.pop(0)}")
        else:
            cola.append(accion)

        print(f"Cola de impresión: {cola}")

impresora_compartida()