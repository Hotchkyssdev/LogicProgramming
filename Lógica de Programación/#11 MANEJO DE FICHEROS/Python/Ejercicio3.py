'''
3️⃣ Inventario de biblioteca (libros)
Consigna:
Crea un programa que gestione un inventario de libros en un archivo .txt.
✅ Cada línea debe tener: Título, Autor, Año
✅ El sistema debe permitir:

Agregar libros

Buscar libros por título

Eliminar libros por título

Mostrar todos los libros
'''
import os
nombre_fichero = "libros.txt"
if not os.path.exists(nombre_fichero):
    open(nombre_fichero, "w").close()

def agregar_libro():
    nombre = input("Nombre: ")
    autor = input("Autor: ")
    año = input("Año: ")
    if not nombre or not autor or not año:
        raise ValueError("Los campos no pueden estar vacíos.")
    if not año.isdigit():
        raise ValueError("El año debe contener solo dígitos.")
    with open(nombre_fichero, "a") as fichero:
        fichero.write(f"{nombre}, {autor}, {año}\n")
    print("Libro agregado correctamente.")

def buscar_libro():
    nombre = input("Nombre: ")
    encontrado = False
    with open(nombre_fichero, "r") as fichero:
        for linea in fichero:
            if linea.split(", ")[0].lower() == nombre.lower():
                print(linea.strip())
                encontrado = True
                break
    if not encontrado:
        print("Libro no encontrado.")

def eliminar_libro():
    nombre = input("Nombre: ")
    eliminado = False
    with open(nombre_fichero, "r") as fichero:
        lineas = fichero.readlines()
    with open(nombre_fichero, "w") as fichero:
        for linea in lineas:
            if not linea.lower().startswith(nombre.lower()):
                fichero.write(linea)
            else:
                eliminado = True
    if eliminado:
        print("Libro eliminado con éxito.")
    else:
        print("Libro no encontrado.")

def mostrar_libros():
    print("\nInventario actual de Libros: \n")
    with open(nombre_fichero, "r") as fichero:
        contenido = fichero.read()
        if contenido:
            print(contenido.strip())
        else:
            print("No hay libros en el inventario.")

while True:
    print("\nGESTOR DE BIBLIOTECA\n")
    print("1. Agregar libro")
    print("2. Buscar libro")
    print("3. Eliminar libro")
    print("4. Mostrar todos los libros")
    print("5. Salir")
    opcion = input("Seleccione una opción: ")

    match opcion:
        case "1":
            agregar_libro()
        case "2":
            buscar_libro()
        case "3":
            eliminar_libro()
        case "4":
            mostrar_libros()
        case "5":
            print("Saliendo del programa.")
            os.remove(nombre_fichero)
            break
        case _:
            print("Opción no válida. Intente nuevamente.")
            continue