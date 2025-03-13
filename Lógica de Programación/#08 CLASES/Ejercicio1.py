'''
1️⃣ Clase Coche con Métodos para Acelerar y Frenar
Consigna:
Crea una clase llamada Coche que tenga los siguientes atributos y métodos:
✅ Atributos: marca, modelo, velocidad_actual (inicialmente 0).
✅ Métodos:

acelerar(cantidad: int): Aumenta la velocidad en la cantidad dada.
frenar(cantidad: int): Reduce la velocidad, sin bajar de 0.
mostrar_info(): Imprime la información del coche.
'''

class Coche:
    def __init__(self, marca: str, modelo: str):
        self.marca = marca
        self.modelo = modelo
        self.velocidad_actual = 0
        
    def acelerar(self, cantidad: int):
        self.velocidad_actual += cantidad
        print(f"El coche ha acelerado. La velocidad actual es: {self.velocidad_actual}")

    def frenar(self, cantidad: int):
        self.velocidad_actual = max(0, self.velocidad_actual - cantidad)
        print(f"El coche ha frenado. La velocidad actual es: {self.velocidad_actual}")
    
    def mostrar_info(self):
        print(f"Marca: {self.marca} | Modelo: {self.modelo} | Velocidad Actual: {self.velocidad_actual} km/h")


mi_coche = Coche("Fiat", "Toro")
mi_coche.acelerar(30)
mi_coche.frenar(10)
mi_coche.mostrar_info()
