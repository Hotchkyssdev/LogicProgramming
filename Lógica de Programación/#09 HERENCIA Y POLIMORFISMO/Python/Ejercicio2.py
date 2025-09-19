'''
2️⃣ Clases Empleado con Herencia de Gerente y Desarrollador
Consigna:
Crea una clase base Empleado con los siguientes atributos y métodos:
✅ Atributos: nombre, salario.
✅ Métodos:

mostrar_info(): Muestra la información del empleado.
✅ Clases hijas:

Gerente: Hereda de Empleado y agrega un atributo departamento con un método asignar_proyecto().
Desarrollador: Hereda de Empleado y agrega un atributo lenguaje con un método programar().
'''

class Empleado:

    def __init__(self, nombre: str, salario: float):
        self.nombre = nombre
        self.salario = salario

    def mostrar_info(self):
        print(f"Nombre: {self.nombre} | Salario: {self.salario:.2f}")

class Gerente(Empleado):

    def __init__(self, nombre: str, salario: float, departamento: str):
        super().__init__(nombre, salario)
        self.departamento = departamento

    def asignar_proyecto(self, proyecto: str):
        print(f"{self.nombre} ha sido asignado al proyecto '{proyecto}' en el departamento de {self.departamento}.")
        
class Desarrollador(Empleado):

    def __init__(self, nombre: str, salario: float, lenguaje: str):
        super().__init__(nombre, salario)
        self.lenguaje = lenguaje

    def programar(self):
        print(f"{self.nombre} está programando en {self.lenguaje}.")

gerente = Gerente("Tomás", 5000, "Desarrollo")
gerente.mostrar_info()
gerente.asignar_proyecto("Proyecto IA")
print("")
dev1 = Desarrollador("Guillermo", 4000, "Java")
dev2 = Desarrollador("Alfonsi", 3800, "Python")
dev1.mostrar_info()
dev1.programar()
print("")
dev2.mostrar_info()
dev2.programar()