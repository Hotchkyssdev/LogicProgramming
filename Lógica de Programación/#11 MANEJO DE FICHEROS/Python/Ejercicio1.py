'''
1️⃣ Crear un archivo de contacto con opción de búsqueda por nombre
Consigna:
Crea un programa que permita:
✅ Agregar contactos a un archivo .txt con el formato: Nombre, Teléfono, Email
✅ Buscar un contacto por nombre y mostrar sus datos
✅ El programa debe evitar duplicados y manejar errores de formato
'''

import os
nombre_fichero = "contactos.txt"

if not os.path.exists(nombre_fichero):
    open(nombre_fichero, "w").close()

def validar_contacto(nombre, telefono, email):
    if not nombre or not telefono or not email:
        print("Los campos no pueden estar vacíos.")
        return
    if not telefono.isdigit():
        print("El teléfono debe contener solo dígitos.")
        return
    if "@" not in email or "." not in email.split("@")[-1]:
        print("El email no es válido.")
        return
    return True

def contacto_duplicado(nombre):
    with open(nombre_fichero, "r") as fichero:
        for line in fichero.readlines():
            if line.split(", ")[0].lower() == nombre.lower():
                return True
    return False

def agregar_contacto():
    nombre = input("Nombre: ")
    telefono = input("Teléfono: ")
    email = input("Email: ")
    if not validar_contacto(nombre, telefono, email):
        return
    if contacto_duplicado(nombre):
        print("El contacto ya existe.")
        return
    with open(nombre_fichero, "a") as fichero:
        fichero.write(f"{nombre}, {telefono}, {email}\n")
    print("Contacto agregado exitosamente.")

def buscar_contacto():
    nombre = input("Nombre a buscar: ").strip()
    encontrado = False
    with open(nombre_fichero, "r") as fichero:
        for linea in fichero:
            if linea.lower().startswith(nombre.lower()):
                print(f"Contacto encontrado:\n",{linea.strip()})
                encontrado = True
                break
    if not encontrado:
        print("Contacto no encontrado.")

while True:
    print("\nMENÚ DE CONTACTOS\n")
    print("1. Agregar contacto")
    print("2. Buscar contacto")
    print("3. Salir")
    opcion = input("Seleccione una opción: ")

    match opcion:
        case "1":
            agregar_contacto()
        case "2":
            buscar_contacto()
        case "3":
            print("Saliendo del programa")
            os.remove(nombre_fichero)
            break;
        case _:
            print("Opción no válida. Intente de nuevo.")
            continue