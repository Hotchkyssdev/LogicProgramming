'''
EXCEPCIONES
'''

try:
    print(10/0)
    print([1, 2, 3, 4][4])
except Exception as e:
    print(f"Se ha producido un error: {e} ({type(e).__name__})")

print("")

'''
DIFICULTAD EXTRA (opcional):
Crea una función que sea capaz de procesar parámetros, pero que también
pueda lanzar 3 tipos diferentes de excepciones (una de ellas tiene que
corresponderse con un tipo de excepción creada por nosotros de manera
personalizada, y debe ser lanzada de manera manual) en caso de error.
 * - Captura todas las excepciones desde el lugar donde llamas a la función.
 * - Imprime el tipo de error.
 * - Imprime si no se ha producido ningún error.
 * - Imprime que la ejecución ha finalizado.
'''

class StringTypeError(Exception):
    pass

def parametros_de_procesos(parametros: list):
    if len(parametros) < 3:
        raise IndexError()
    elif parametros[1] == 0:
        raise ZeroDivisionError()
    elif type(parametros[2]) == str:
        raise StringTypeError("El tercer elemento no puede ser una cadena de texto.")
    
    print(parametros[2])
    print(parametros[0] / parametros[1])
    print(parametros[2] + 5)

try:
    parametros_de_procesos([1, 2, 3, 4])
except IndexError as e:
    print("El número de elementos de la lista debe ser mayor que dos.")
except ZeroDivisionError as e:
    print("El segundo elemento de la lista no puede ser un cero.")
except StringTypeError as e:
    print(f"{e}")
except Exception as e:
    print(f"Se ha producido un error inesperado: {e}")
else:
    print("No se ha producido ningún error.")
finally:
    print("El programa finaliza sin detenerse.")
    