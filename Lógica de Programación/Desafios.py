'''
Semana 0: Hola Mundo
'''
print("Hola Mundo")
print("")
'''
Semana 1:

Desafio Extra:

Crea un programa que imprima por consola todos los números comprendidos entre 10 y 55 (incluidos) 
pares, y que no son ni el 16 ni múltiplos de 3.
'''
for number in range(10,56):
    if number % 2 == 0 and number != 16 and number % 3 != 0:
        print(number)

print("")

'''
Semana 2:

DIFICULTAD EXTRA: FIZZ BUZZ

Crea una función que reciba dos parámetros de tipo cadena de texto y retorne un número.
 * - La función imprime todos los números del 1 al 100. Teniendo en cuenta que:
 *   - Si el número es múltiplo de 3, muestra la cadena de texto del primer parámetro.
 *   - Si el número es múltiplo de 5, muestra la cadena de texto del segundo parámetro.
 *   - Si el número es múltiplo de 3 y de 5, muestra las dos cadenas de texto concatenadas.
 *   - La función retorna el número de veces que se ha impreso el número en lugar de los textos.
'''
def fizzbuzz(str1, str2):
    cont = 0
    for number in range(1, 101):
        if number % 3 == 0 and number % 5 == 0:
            print(str1, str2)
        elif number % 3 == 0:
            print(str1)
        elif number % 5 == 0:
            print(str2)
        else:
            print(number)
            cont = cont + 1
    return cont

print("La cantidad de números que devuelve la función es: ", fizzbuzz("Fizz", "Buzz"))
print("")

'''
Semana 3: 

DIFICULTAD EXTRA

Crea una agenda de contactos por terminal.
 * - Debes implementar funcionalidades de búsqueda, inserción, actualización
 *   y eliminación de contactos.
 * - Cada contacto debe tener un nombre y un número de teléfono.
 * - El programa solicita en primer lugar cuál es la operación que se quiere realizar,
 *   y a continuación los datos necesarios para llevarla a cabo.
 * - El programa no puede dejar introducir números de teléfono no númericos y con más
 *   de 11 dígitos (o el número de dígitos que quieras).
 * - También se debe proponer una operación de finalización del programa.
'''

def agenda():

    agenda = {}
    def insertar_contacto():
        telefono = input("Ingrese el número de teléfono: ")
        if telefono.isdigit() and len(telefono) > 0 and len(telefono) <= 11:
            agenda[nombre] = telefono
        else:
            print("Error: Tiene que ser menor a 12 números.")

    while True:
        print("")
        print("1. Buscar Contacto")
        print("2. Insertar Contacto")
        print("3. Actualizar Contacto")
        print("4. Eliminar Contacto")
        print("5. Salir")
        opcion = input("\nSelecciona una opción: ")

        match opcion:
            case "1":
                nombre = input("Ingrese el nombre del contacto a buscar: ")
                if nombre in agenda:
                    print(f"El número de teléfono de {nombre} es {agenda[nombre]}.")
                else:
                    print(f"El contacto {nombre} no existe.")
            case "2":
                nombre = input("Ingrese el nombre del nuevo contacto: ")
                insertar_contacto()
            case "3":
                nombre = input("Ingrese el nombre del contacto que esta por actualizar: ")
                if nombre in agenda:
                    insertar_contacto()
                else:
                    print(f"El contacto {nombre} no existe.")
            case "4":
                nombre = input("Ingrese el nombre del contacto a eliminar: ")
                if nombre in agenda:
                    del agenda[nombre]
                else:
                    print(f"El contacto {nombre} no existe.")
            case "5":
                print("Programa Finalizado.")
                break
            case _:
                print("Error: debe ser una opción entre 1 y 5.")

agenda()