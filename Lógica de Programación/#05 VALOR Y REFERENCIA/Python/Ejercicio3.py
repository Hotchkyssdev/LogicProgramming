'''
3️⃣ Intercambio de Valores con Diccionarios (Referencia)
Consigna:
Crea una función intercambiar_claves que reciba un diccionario con dos claves ("A" y "B") e intercambie sus valores.
✅ La función debe modificar el diccionario original.
'''

def intercambio_claves(diccionario: dict) -> tuple:
    if "A" in diccionario and "B" in diccionario:
        diccionario["A"], diccionario["B"] = diccionario["B"], diccionario["A"]
    return diccionario

diccionario = {
    "A": input("Ingrese el valor para la clave A: "),
    "B": input("Ingrese el valor para la clave B: ")
}
print(f"Diccionario Original: {diccionario}")

nuevo_diccionario = intercambio_claves(diccionario)
print(f"Diccionario después del intercambio: {nuevo_diccionario}")