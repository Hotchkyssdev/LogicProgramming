'''
2️⃣ Duplicar Valores en una Lista sin Modificar la Original
Consigna:
Escribe una función llamada duplicar_lista que reciba una lista de números 
y retorne una nueva lista con todos los valores duplicados.
✅ La lista original no debe ser modificada.
'''

def duplicar_lista(lista: list) -> tuple:
    nueva_lista = [x * 2 for x in lista]
    return nueva_lista

listaOriginal = [1, 2, 3, 4]
print(f"Lista Original: {listaOriginal}")
listaDuplicada = duplicar_lista(listaOriginal)
print(f"Lista Duplicada: {listaDuplicada}")
print(f"Lista Original después de la función: {listaOriginal}")
