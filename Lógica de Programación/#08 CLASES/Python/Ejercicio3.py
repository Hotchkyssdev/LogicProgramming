'''
3️⃣ Clase GestorTareas para Administrar una Lista de Tareas
Consigna:
Crea una clase GestorTareas que permita gestionar una lista de tareas pendientes.
✅ Atributos: tareas (una lista vacía al inicio).
✅ Métodos:

agregar_tarea(descripcion: str): Agrega una nueva tarea.
completar_tarea(): Marca la primera tarea como completada (FIFO).
mostrar_tareas(): Muestra las tareas pendientes.
'''

class GestorTareas:
    def __init__(self):
        self.tareas = []
    
    def agregar_tarea(self, descripcion: str):
        self.tareas.append(descripcion)
        print(f"Tarea Agregada: {descripcion}")

    def completar_tarea(self):
        if self.tareas:
            tarea_completada = self.tareas.pop(0)
            print(f"Tarea Completada: {tarea_completada}")
        else:
            print("No hay tareas pendientes.")

    def mostrar_tareas(self):
        if self.tareas:
            print("Tareas Pendientes: ")
            for i, tarea in enumerate(self.tareas, 1):
                print(f"{i}. {tarea}")
        else:
            print("No hay tareas en la lista.")

gestor = GestorTareas()
gestor.agregar_tarea("Aprender Python")
gestor.agregar_tarea("Hacer Ejercicio")
gestor.completar_tarea()
gestor.mostrar_tareas()
gestor.completar_tarea()
gestor.mostrar_tareas()