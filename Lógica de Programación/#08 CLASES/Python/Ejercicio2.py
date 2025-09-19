'''
2️⃣ Clase CuentaBancaria con Depósitos y Retiros
Consigna:
Crea una clase CuentaBancaria con los siguientes atributos y métodos:
✅ Atributos: titular, saldo (inicialmente 0).
✅ Métodos:

depositar(monto: float): Aumenta el saldo en la cantidad dada.
retirar(monto: float): Reduce el saldo si hay suficiente dinero.
mostrar_saldo(): Imprime el saldo actual.
'''

class CuentaBancaria:
    def __init__(self, titular: str):
        self.titular = titular
        self.saldo = 0

    def depositar(self, monto: float):
        if monto > 0:
            self.saldo += monto
            print(f"Depósito Existoso. El nuevo saldo es: {self.saldo}")
        else:
            print("El monto a depositar debe ser positivo.")

    def retirar(self, monto: float):
        if monto > self.saldo:
            print("Error: Fondos Insuficientes.")
        elif monto > 0:
            self.saldo -= monto
            print(f"Retiro Exitoso. El nuevo saldo es: {self.saldo}")
        else:
            print("El monto a retirar debe ser positivo.")
        
    def mostrar_info(self):
        print(f"Titular: {self.titular} | Saldo: ${self.saldo:.2f}")

mi_cuenta = CuentaBancaria("Gersom Tomás Hotchkyss")
mi_cuenta.depositar(1600000)
mi_cuenta.retirar(550000)
mi_cuenta.mostrar_info()