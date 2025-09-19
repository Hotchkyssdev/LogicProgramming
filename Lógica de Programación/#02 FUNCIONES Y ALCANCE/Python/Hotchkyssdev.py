'''
FUNCIONES Y ALCANCE
'''

#Funciones definidas por el usuario

#Simple
def saludar():
    print("Hola Python.")

saludar()

#Con Retorno
def devolver_saludo():
    return "Hola Python."

print(devolver_saludo())
print("")

#Con un Argumento
def args_saludo(saludo, nombre):
    print(f"{saludo}, {nombre}!")

args_saludo("Hola", "Tomás")
args_saludo(nombre = "Tomás", saludo = "Hola")

print("")

#Con un argumento predeterminado
def default_arg_saludo(nombre = "Python"):
    print(f"Hola, {nombre}!")

default_arg_saludo("Tomás")
default_arg_saludo()
print("")

#Con Argumentos y Retorno
def retorno_args_saludo(saludo, nombre):
    return f"{saludo}, {nombre}!"

print(retorno_args_saludo("Hola", "Tomás")) 
print("")

#Con retorno de varios valores
def multiple_retorno_saludo():
    return "Hola", "Python"

saludo, nombre = multiple_retorno_saludo()
print(saludo)
print(nombre)
print("")

#Con un número variable de argumentos
def variable_args_saludo(*nombres):
    for nombre in nombres:
        print(f"Hola, {nombre}!")

variable_args_saludo("Python", "Gersom", "Hotchkyss", "Programadores")
print("")

#Con un número variable de argumentos con palabra clave
def variable_llave_args_saludo(**nombres):
    for llave, valor in nombres.items():
        print(f"Hola, {valor} ({llave})!")

variable_llave_args_saludo(
    lenguaje = "Python", 
    nombre = "Gersom", 
    alias = "HotchkyssDev", 
    edad = 18
)
print("")

'''
FUNCIONES DENTRO DE FUNCIONES
'''

def funcion_externa():
    def funcion_interna():
        print("Funcion interna: Hola, Python!")
    funcion_interna()

funcion_externa()
print("")

'''
FUNCIONES DEL LENGUAJE (built-in)
'''

print(len("HotchkyssDev"))
print(type(18))
print("HotchkyssDev".upper())
print("HOTCHKYSSDEV".lower())
print("")

'''
VARIABLE LOCAL Y GLOBAL
'''

variable_global = "Python"
print(variable_global)

def hola_python():
    variable_local = "Hola"
    print(f"{variable_local}, {variable_global}")

print(variable_global)
#print(variable_local) No se puede acceder desde fuera de la funcion

hola_python()
print("")

'''
DIFICULTAD EXTRA: FIZZ BUZZ

Crea una función que reciba dos parámetros de tipo cadena de texto y retorne un número.
 * - La función imprime todos los números del 1 al 100. Teniendo en cuenta que:
 *   - Si el número es múltiplo de 3, muestra la cadena de texto del primer parámetro.
 *   - Si el número es múltiplo de 5, muestra la cadena de texto del segundo parámetro.
 *   - Si el número es múltiplo de 3 y de 5, muestra las dos cadenas de texto concatenadas.
 *   - La función retorna el número de veces que se ha impreso el número en lugar de los textos.
'''

def numeros(str1, str2)-> int:
    contador = 0
    for number in range(1,101):
        if number % 3 == 0 and number % 5 == 0:
            print(str1, str2)
        elif number % 3 == 0:
            print(str1)
        elif number % 5 == 0:
            print(str2)
        else:
            print(number)
            contador = contador + 1
    return contador

print("La cantidad de números que devuelve la función es: ", numeros("Fizz", "Buzz"))
print("")

