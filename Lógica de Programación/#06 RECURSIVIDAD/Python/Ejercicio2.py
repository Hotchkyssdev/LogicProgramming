'''
2️⃣ Potencia de un Número usando Recursividad
Consigna:
Crea una función recursiva llamada potencia(base: int, exponente: int) -> int que reciba dos números y calcule la potencia de la base elevada al exponente.
✅ Caso base: Si el exponente es 0, debe retornar 1.
✅ Caso recursivo: base * potencia(base, exponente - 1).
'''

def potencia(base: int, exponente: int) -> int:
    if exponente < 0:
        print("El exponente no puede ser un número negativo.")
        return 
    elif exponente == 0:
        return 1
    else:
        return base * potencia(base, exponente - 1)

b = int(input("Ingrese el número para la base: "))
e = int(input("Ingrese el número para el exponente: "))
print("", b, "^",e, "=", potencia(b, e))
