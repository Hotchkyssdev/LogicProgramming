'''
HERENCIA Y POLIMORFISMO
'''

#SuperClase
class Animal:

    def __init__(self, nombre: str):
        self.nombre = nombre

    def sonido(self):
        pass

#SubClases
class Perro(Animal):
    
    def sonido(self):
        print("Guau!")

class Gato(Animal):

    def sonido(self):
        print("Miau!")

def imprimir_sonido(animal: Animal):
    animal.sonido()

mi_animal = Animal("Animal")
imprimir_sonido(mi_animal)
mi_perro = Perro("Perro")
imprimir_sonido(mi_perro)
mi_gato = Gato("Gato")
imprimir_sonido(mi_gato)

'''
DIFICULTAD EXTRA (opcional):
Implementa la jerarquía de una empresa de desarrollo formada por Empleados que
 * pueden ser Gerentes, Gerentes de Proyectos o Programadores.
 * Cada empleado tiene un identificador y un nombre.
 * Dependiendo de su labor, tienen propiedades y funciones exclusivas de su
 * actividad, y almacenan los empleados a su cargo.
'''

class Empleado:
    def __init__(self, id: int, nombre: str):
        self.id = id
        self.nombre = nombre
        self.empleados = []

    def añadir(self, empleado):
        self.empleados.append(empleado)
    
    def imprimir_empleados(self):
        for empleado in self.empleados:
            print(empleado.nombre)

class Manager(Empleado):

    def coordinar_proyectos(self):
        print(f"{self.nombre} está coordinado con todos los proyectos de la empresa.")

class ProyectManager(Empleado):

    def __init__(self, id: int, nombre: str, proyecto: str):
        super().__init__(id, nombre)
        self.proyecto = proyecto

    def coordinar_proyecto(self):
        print(f"{self.nombre} está coordinando su proyecto.")


class Programador(Empleado):

    def __init__(self, id: int, nombre: str, lenguaje: str):
        super().__init__(id, nombre)
        self.lenguaje = lenguaje

    def codigo(self):
        print(f"{self.nombre} está programando en {self.lenguaje}")
    
    def añadir(self, empleado: Empleado):
        print(f"Un programador no tiene empleados a cargo. {empleado.nombre} no se añadira.")

mi_manager = Manager(1, "HotchkyssDev")
mi_project_manager = ProyectManager(2, "Hotchkyss", "Proyecto 1")
mi_project_manager2 = ProyectManager(3, "Gersom", "Proyecto 2")
mi_programador = Programador(4, "Portillo", "Java")
mi_programador2 = Programador(5, "Alfonsi", "PHP")
mi_programador3 = Programador(6, "Armando", "SQL")
mi_programador4 = Programador(7, "Marcos", "Python")

mi_manager.añadir(mi_project_manager)
mi_manager.añadir(mi_project_manager2)

mi_project_manager.añadir(mi_programador)
mi_project_manager.añadir(mi_programador2)
mi_project_manager2.añadir(mi_programador3)
mi_project_manager2.añadir(mi_programador4)

mi_programador.añadir(mi_programador2)

mi_programador.codigo()
mi_project_manager.coordinar_proyecto()
mi_manager.coordinar_proyectos()
mi_manager.imprimir_empleados()
mi_project_manager.imprimir_empleados()
mi_programador.imprimir_empleados()
