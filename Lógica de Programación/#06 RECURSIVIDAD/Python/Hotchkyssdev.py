'''
RECURSIVIDAD
'''

def cuentaatras(numero: int):
    if numero >= 0:
        print(numero)
        cuentaatras(numero - 1)

cuentaatras(100)
print("")

'''
DIFICULTAD EXTRA
DIFICULTAD EXTRA (opcional):
 * Utiliza el concepto de recursividad para:
 * - Calcular el factorial de un número concreto (la función recibe ese número).
 * - Calcular el valor de un elemento concreto (según su posición) en la 
 *   sucesión de Fibonacci (la función recibe la posición).
'''

def factorial(numero: int) -> int:
    if numero < 0:
        print("Los números negativos no son válidos.")
        return 0
    elif numero == 0:
        return 1
    else:
        return numero * factorial(numero - 1)

print(factorial(5))
print("")

def fibonacci(numero: int) -> int:
    if numero <= 0:
        print("La posición tiene que ser mayor que cero.")
        return 0
    elif numero == 1:
        return 0
    elif numero == 2:
        return 1
    else:
        return fibonacci(numero - 1) + fibonacci(numero - 2)

print(fibonacci(10))
print("")