'''
2️⃣ Crear un sistema de notas por alumno
Consigna:
Crea un archivo .txt donde cada línea representa a un estudiante con sus notas:
✅ Formato: Nombre, Nota1, Nota2, Nota3
✅ Permitir:

Agregar estudiantes

Calcular promedio por alumno

Mostrar todos los promedios
✅ Validar que las notas sean numéricas y estén entre 0 y 10
'''

import os
nombre_fichero = "notas.txt"
if not os.path.exists(nombre_fichero):
    open(nombre_fichero, "w").close()

def validar_notas(notas):
    if len(notas) != 3:
        print("Debe haber exactamente 3 notas.")
        return False
    try:
        notas = [float(nota) for nota in notas]
    except ValueError:
        print("Las notas deben ser numéricas.")
        return False
    for nota in notas:
        if nota < 0 or nota > 10:
            print("Las notas deben estar entre 0 y 10.")
            return False
    return True

def agregar_alumno(nombre, notas):
    nombre = input("Ingrese el nombre del estudiante: ")
    notas = input("Ingrese las notas separadas por comas: ").split(",")
    if not validar_notas(notas):
        return
    with open(nombre_fichero, "a") as fichero:
        fichero.write(f"{nombre}, {','.join(notas)}\n")
    print("Alumno agregado correctamente.")

def promedio_alumno():
    nombre = input("Ingrese el nombre del estudiante: ").strip()
    encontrado = False
    with open(nombre_fichero, "r") as fichero:
        for linea in fichero:
            datos = linea.strip().split(",")
            if datos[0].lower() == nombre.lower():
                notas = list(map(float, datos[1:]))
                promedio = sum(notas) / len(notas)
                print(f"El promedio de {nombre} es: {promedio:.2f}")
                encontrado = True
                break
    if not encontrado:
        print("Estudiante no encontrado.")

def mostrar_promedios():
    print("Promedio de todos los estudiantes: ")
    with open(nombre_fichero, "r") as fichero:
        for linea in fichero:
            datos = linea.strip().split(",")
            nombre = datos[0]
            notas = list(map(float, datos[1:]))
            promedio = sum(notas) / len(notas)
            print(f"{nombre}: {promedio:.2f}")

while True:
    print("\nGESTOR DE NOTAS\n")
    print("1. Agregar estudiante")
    print("2. Calcular promedio por estudiante")
    print("3. Mostrar promedios de todos los estudiantes")
    print("4. Salir")
    opcion = input("Ingrese una opcion: ")

    match opcion:
        case "1":
            agregar_alumno("", "")
        case "2":
            promedio_alumno()
        case "3":
            mostrar_promedios()
        case "4":
            print("Saliendo del programa.")
            os.remove(nombre_fichero)
            break
        case _:
            print("Opción no válida.")
            continue