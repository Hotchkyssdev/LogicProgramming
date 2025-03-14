'''
1️⃣ Clase Vehiculo con Herencia de Coche y Moto
Consigna:
Crea una clase base Vehiculo con los siguientes atributos y métodos:
✅ Atributos: marca, modelo, velocidad_actual (inicialmente 0).
✅ Métodos:

acelerar(cantidad: int): Aumenta la velocidad.
frenar(cantidad: int): Reduce la velocidad, sin bajar de 0.
mostrar_info(): Muestra la información del vehículo.
✅ Clases hijas:

Coche: Hereda de Vehiculo y agrega el atributo puertas (cantidad de puertas).
Moto: Hereda de Vehiculo y agrega el atributo tipo ("Deportiva", "Chopper", etc.).
'''

class Vehiculo:

    def __init__(self, marca: str, modelo: str):
        self.marca = marca
        self.modelo = modelo
        self.velocidad_actual = 0

    def acelerar(self, cantidad: int):
        self.velocidad_actual += cantidad
        print(f"El vehiculo ha acelerado. La velocidad actual es {self.velocidad_actual} km/h.")

    def frenar(self, cantidad: int):
        self.velocidad_actual = max(0, self.velocidad_actual - cantidad)
        print(f"El vehiculo ha frenado. La velocidad actual es {self.velocidad_actual} km/h.")

    def mostrar_info(self):
        print(f"Marca: {self.marca} | Modelo: {self.modelo} | Velocidad Actual: {self.velocidad_actual} km/h")

class Coche(Vehiculo):

    def __init__(self, marca: str, modelo: str, puertas: int):
        super().__init__(marca, modelo)
        self.puertas = puertas

class Moto(Vehiculo):

    def __init__(self, marca: str, modelo: str, tipo: str):
        super().__init__(marca, modelo)
        self.tipo = tipo

mi_coche = Coche("Toyota", "Corolla", 4)
mi_coche.acelerar(50)
mi_coche.mostrar_info()

mi_moto = Moto("Yamaha", "R1", "Deportiva")
mi_moto.acelerar(80)
mi_moto.mostrar_info()