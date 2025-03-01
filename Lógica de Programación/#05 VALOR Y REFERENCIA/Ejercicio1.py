'''
1️⃣ Modificación de Parámetros por Valor y Referencia
Consigna:
Crea una función llamada modificar_datos que reciba dos parámetros:
✅ Un número entero (int) pasado por valor y lo modifique dentro de la función.
✅ Una lista (list) pasada por referencia y le agregue un nuevo elemento.
✅ Imprime el valor del número y la lista antes y después de llamar a la función.
'''
def modificar_datos(entero: int, lista: list) -> tuple:
    entero = 20
    lista.append(4)
    print(f"Número dentro de la función: {entero}")
    print(f"Lista dentro de la función: {lista}")
    return entero, lista

num = 10
lista = [1, 2, 3]
print(f"Número antes de la función: {num}")
print(f"Lista antes de la función: {lista}")
nuevo_num, nueva_lista = modificar_datos(num, lista)
print(f"Número después de la función: {num}")
print(f"Lista después de la función: {lista}")