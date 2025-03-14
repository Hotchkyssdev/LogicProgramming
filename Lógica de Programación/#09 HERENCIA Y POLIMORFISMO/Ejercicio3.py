'''
3️⃣ Clases Instrumento con Herencia de Guitarra y Piano
Consigna:
Crea una clase base Instrumento con los siguientes atributos y métodos:
✅ Atributos: nombre, tipo (Cuerda, Percusión, Viento).
✅ Métodos:

tocar(): Método genérico que será sobrescrito en las clases hijas.
✅ Clases hijas:

Guitarra: Hereda de Instrumento y sobrescribe tocar() con "Rasgueando la guitarra".
Piano: Hereda de Instrumento y sobrescribe tocar() con "Tocando las teclas del piano".
'''

class Instrumento:

    def __init__(self, nombre: str, tipo: str):
        self.nombre = nombre
        self.tipo = tipo

    def tocar(self):
        pass

class Guitarra(Instrumento):

    def tocar(self):
        print("Rasgueando la guitarra.")

class Piano(Instrumento):

    def tocar(self):
        print("Tocando las teclas del piano.")

def imprimir_tocar(instrumento: Instrumento):
    instrumento.tocar()

MiGuitarra = Guitarra("Gibson", "Cuerda")
MiGuitarra.tocar()
print("")
MiPiano = Piano("Yamaha", "Cuerda")
MiPiano.tocar()