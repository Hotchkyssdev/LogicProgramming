import os

'''
MANEJO DE FICHEROS
'''

nombre_fichero = "hotchkyssdev.txt"
with open(nombre_fichero, "w") as fichero:
    fichero.write("Gersom Tomas Hotchkyss\n")
    fichero.write("19\n")
    fichero.write("Python\n")

with open(nombre_fichero, "r") as fichero:
    print(fichero.read())

os.remove(nombre_fichero)

'''
* DIFICULTAD EXTRA (opcional):
* Desarrolla un programa de gestión de ventas que almacena sus datos en un 
* archivo .txt.
* - Cada producto se guarda en una línea del archivo de la siguiente manera:
*   [nombre_producto], [cantidad_vendida], [precio].
* - Siguiendo ese formato, y mediante terminal, debe permitir añadir, consultar,
*   actualizar, eliminar productos y salir.
* - También debe poseer opciones para calcular la venta total y por producto.
* - La opción salir borra el .txt.
'''
nombre_fichero = "Tienda.txt"
open(nombre_fichero, "a")

while True:
    print("1. Añadir producto")
    print("2. Consultar productos")
    print("3. Actualizar producto")
    print("4. Eliminar producto")
    print("5. Mostrar productos")
    print("6. Calcular venta total")
    print("7. Calcular venta por producto")
    print("8. Salir")
    opcion = input("Seleccione una opción: ")

    match opcion:
        case "1":
            nombre = input("Nombre: ")
            cantidad = input("Cantidad: ")
            precio = input("Precio: ")
            with open(nombre_fichero, "a") as fichero:
                fichero.write(f"{nombre}, {cantidad}, {precio}\n")
        case "2":
            nombre = input("Nombre: ")
            with open(nombre_fichero, "r") as fichero:
                for line in fichero.readlines():
                    if line.split(", ")[0] == nombre:
                        print(line)
                        break
        case "3":
            nombre = input("Nombre: ")
            cantidad = input("Cantidad: ")
            precio = input("Precio: ")
            with open(nombre_fichero, "r") as fichero:
                lines = fichero.readlines()
            with open(nombre_fichero, "w") as fichero:
                for line in lines:
                    if line.split(", ")[0] == nombre:
                        fichero.write(f"{nombre}, {cantidad}, {precio}\n")
                    else:
                        fichero.write(line)
        case "4":
            nombre = input("Nombre: ")
            with open(nombre_fichero, "r") as fichero:
                lines = fichero.readlines()
            with open(nombre_fichero, "w") as fichero:
                for line in lines:
                    if line.split(", ")[0] != nombre:
                        fichero.write(line)
        case "5":
            with open(nombre_fichero, "r") as fichero:
                print(fichero.read())
        case "6":
            total = 0
            with open(nombre_fichero, "r") as fichero:
                for line in fichero.readlines():
                    componentes = line.split(", ")
                    cantidad = int(componentes[1])
                    precio = float(componentes[2])
                    total += cantidad * precio
            print(f"Venta total: {total}")
        case "7":
            nombre = input("Nombre: ")
            total = 0
            with open(nombre_fichero, "r") as fichero:
                for line in fichero.readlines():
                    if line.split(", ")[0] == nombre:
                        componentes = line.split(", ")
                        cantidad = int(componentes[1])
                        precio = float(componentes[2])
                        total += cantidad * precio
            print(f"Venta total de {nombre}: {total}")
        case "8":
            print("Saliendo del programa")
            os.remove(nombre_fichero)
            break;
        case _:
            print("Opción no válida. Intente de nuevo.")
            continue