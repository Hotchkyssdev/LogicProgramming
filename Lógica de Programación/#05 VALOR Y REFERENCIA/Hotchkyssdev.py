'''
VALOR Y REFERENCIA
'''

#Tipos de datos por valor
mi_entero = 10
mi_entero_2 = mi_entero
#mi_entero_2 = 20
#mi_entero = 30
print(mi_entero)
print(mi_entero_2)
print("")

#Tipos de datos por referencia (Los que no son PRIMITIVOS)
mi_lista = [10, 20]
mi_lista_2 = mi_lista
mi_lista_2.append(30)
print(mi_lista)
print(mi_lista_2)
print("")

#Funciones con datos por valor
mi_entero_3 = 10
def funcion_entero(entero: int):
    entero = 20
    print(entero)


funcion_entero(mi_entero_3)
print(mi_entero_3)
print("")

#Funciones con datos por referencia
def funcion_lista(lista: list):
    lista.append(30)
    mi_lista_4 = lista
    mi_lista_4.append(40)
    print(lista)
    print(mi_lista_4)

mi_lista_3 = [10, 20]
funcion_lista(mi_lista_3)
print(mi_lista_3)
print("")

'''
DIFICULTAD EXTRA:

DIFICULTAD EXTRA (opcional):
 * Crea dos programas que reciban dos parámetros (cada uno) definidos como
 * variables anteriormente.
 * - Cada programa recibe, en un caso, dos parámetros por valor, y en otro caso, por referencia.
 *   Estos parámetros los intercambia entre ellos en su interior, los retorna, y su retorno
 *   se asigna a dos variables diferentes a las originales. A continuación, imprime
 *   el valor de las variables originales y las nuevas, comprobando que se ha invertido
 *   su valor en las segundas.
 *   Comprueba también que se ha conservado el valor original en las primeras.
'''

#Por Valor

def intercambio_valor(valorA: int, valorB: int) -> tuple:
    temporal = valorA
    valorA = valorB
    valorB = temporal
    return valorA, valorB

int1 = 10
int2 = 20
int3, int4 = intercambio_valor(int1, int2)
print(f"{int1}, {int2}")
print(f"{int3}, {int4}")
print("")

#Por Referencia

def intercambio_referencia(valorA: list, valorB: list) -> tuple:
    temporal = valorA
    valorA = valorB
    valorB = temporal
    return valorA, valorB

lista1 = [10, 20]
lista2 = [30, 40]
lista3, lista4 = intercambio_referencia(lista1, lista2)
print(f"{lista1}, {lista2}")
print(f"{lista3}, {lista4}")
print("")