'''
3️⃣ Contar Dígitos de un Número de Forma Recursiva
Consigna:
Crea una función recursiva llamada contar_digitos(numero: int) -> int que reciba un número y retorne la cantidad de dígitos que tiene.
✅ Caso base: Si el número es menor que 10, retorna 1.
✅ Caso recursivo: 1 + contar_digitos(numero // 10).
'''

def contar_digitos(numero: int) -> int:
    if numero < 10:
        return 1
    else:
        return 1 + contar_digitos(numero // 10)

n = int(input("Ingrese un número para retornar la cantidad de dígitos: "))
print("La cantidad de dígitos del número ingresado es:", contar_digitos(n))
