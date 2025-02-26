'''
1️⃣ Calculadora de Operaciones Básicas
Consigna:
Escribe un programa en Python que solicite al usuario dos números enteros y una operación matemática (+, -, *, /, //, %, **). 
Luego, el programa debe calcular el resultado de la operación e imprimirlo en la consola.
'''

N1 = int(input("Ingrese un número: "))
N2 = int(input("Ingrese otro número: "))
resultado = 0

print("1. Suma")
print("2. Resta")
print("3. Multiplicación")
print("4. División")
print("5. Módulo")
print("6. División Entera")
print("7. Exponente")

opcion = int(input("Ingrese una opción: "))

match opcion:
    case 1:
        resultado = N1 + N2
        print("El resultado de la operación es: ", resultado)
    case 2:
        resultado = N1 - N2
        print("El resultado de la operación es: ", resultado)
    case 3:
        resultado = N1 * N2
        print("El resultado de la operación es: ", resultado)
    case 4:
        resultado = N1 / N2
        print("El resultado de la operación es: ", resultado)
    case 5:
        resultado = N1 % N2
        print("El resultado de la operación es: ", resultado)
    case 6:
        resultado = N1 // N2
        print("El resultado de la operación es: ", resultado)
    case 7:
        resultado = N1 ** N2
        print("El resultado de la operación es: ", resultado)
    case _:
        print("Opción Inválida")