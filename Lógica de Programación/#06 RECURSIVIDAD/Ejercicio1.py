'''
1️⃣ Suma de los Primeros N Números Naturales
Consigna:
Crea una función recursiva llamada suma_numeros(n: int) -> int que reciba un número n y retorne la suma de los primeros n números naturales.
✅ Caso base: Si n == 1, la función debe retornar 1.
✅ Caso recursivo: n + suma_numeros(n - 1).
'''

def suma_numeros(n: int) -> int:
    if n < 1:
        print("El número debe ser mayor a 0.")
        return n
    elif n == 1:
        return 1
    else:
        return n + suma_numeros(n - 1)

num = int(input("Ingrese un número entero mayor a 0: "))
print("La suma de los primeros", num, "números es: ", suma_numeros(num))
