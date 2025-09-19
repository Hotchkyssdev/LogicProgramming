'''
CLASES
'''

class Programador:

    apellido: str = None

    def __init__(self, nombre: str, edad: int, lenguaje: list):
        self.nombre = nombre
        self.edad = edad
        self.lenguaje = lenguaje

    def print(self):
        print(f"Nombre: {self.nombre} | Apellidos: {self.apellido} | Edad: {self.edad} | Lenguajes: {self.lenguaje}")        

mi_programador = Programador("Gersom Tomás", 19, ["Python", "C", "Java"])
mi_programador.print()
mi_programador.apellido = "Hotchkyss"
mi_programador.print()
mi_programador.edad = 20
mi_programador.print()
print("")

'''
DIFICULTAD EXTRA (Opcional):
Implementa dos clases que representen las estructuras de Pila y Cola (estudiadas
 * en el ejercicio número 7 de la ruta de estudio)
 * - Deben poder inicializarse y disponer de operaciones para añadir, eliminar,
 *   retornar el número de elementos e imprimir todo su contenido.
'''

#Pila/Stack (LIFO)
class Pila:

    def __init__(self):
        self.pila = []

    def push(self, item):
        self.pila.append(item)

    def pop(self):
        if self.contador() == 0:
            return None
        return self.pila.pop()
    
    def contador(self):
        return len(self.pila)
    
    def print(self):
        for item in reversed(self.pila):
            print(item)

mi_pila = Pila()
mi_pila.push("A")
mi_pila.push("B")
mi_pila.push("C")
print(mi_pila.contador())
mi_pila.print()
mi_pila.pop()
print(mi_pila.contador())
print(mi_pila.pop())
print(mi_pila.pop())
print(mi_pila.pop())
print(mi_pila.pop())
print(mi_pila.pop())
print(mi_pila.contador())
print("")

#Cola/Queue (FIFO)

class Cola:

    def __init__(self):
        self.cola = []

    def enqueue(self, item):
        self.cola.append(item)

    def dequeue(self):
        if self.contador() == 0:
            return None
        return self.cola.pop(0)

    def contador(self):
        return len(self.cola)
    
    def print(self):
        for item in self.cola:
            print(item)

mi_cola = Cola()
mi_cola.enqueue("A")
mi_cola.enqueue("B")
mi_cola.enqueue("C")
print(mi_cola.contador())
mi_cola.print()
mi_cola.dequeue()
print(mi_cola.contador())
print(mi_cola.dequeue())
print(mi_cola.dequeue())
print(mi_cola.dequeue())
print(mi_cola.dequeue())
print(mi_cola.dequeue())
print(mi_cola.contador())