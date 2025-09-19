'''
ESTRUCTURAS DE DATOS
'''
#Listas
print("")
mi_lista = ["Hotchkyss", "Gersom", "Portillo de Uria", "Alfonsi"]
print(mi_lista)
mi_lista.append("Pelizardi") #Inserción
mi_lista.append("Pelizardi") #Inserción
print(mi_lista)
mi_lista.remove("Hotchkyss") #Eliminación
print(mi_lista)
print(mi_lista[1]) # Acceso
mi_lista[1] = "Gastón" #Actualización
print(mi_lista)
mi_lista.sort() #Ordenación
print(mi_lista)
print(type(mi_lista))
print("")

#Tuplas
mi_tupla = ("Hotchkyss", "Gersom", "@hotchkyssdev", "18")
print(mi_tupla[1]) #Acceso
print(mi_tupla[3]) 
mi_tupla = tuple(sorted(mi_tupla)) #Ordenación
print(mi_tupla)
print(type(mi_tupla))
print("")

#Sets
mi_set = {"Hotchkyss", "Gersom", "@hotchkyssdev", "18"}
print(mi_set)
mi_set.add("gersomtomasosky@gmail.com") #Inserción
mi_set.add("gersomtomasosky@gmail.com") 
print(mi_set)
mi_set.remove("Gersom") #Eliminación
print(mi_set)
mi_set = set(sorted(mi_set)) #No se puede ordenar
print(mi_set)
print(type(mi_set))
print("")

#Diccionarios
mi_dict: dict = {
    "Apellido":"Hotchkyss", 
    "Nombre":"Gersom", 
    "Alias":"@hotchkyssdev", 
    "Edad":"18"
}
mi_dict["Email"] = "gersomtomasosky@gmail.com" #Inserción
print(mi_dict)
del mi_dict["Apellido"] #Eliminación
print(mi_dict)
print(mi_dict["Nombre"]) #Acceso
mi_dict["Edad"] = "19" #Actualización
print(mi_dict)
mi_dict = dict(sorted(mi_dict.items())) #Ordenación
print(mi_dict)
print(type(mi_dict))
print("")

'''
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
        telefono = input("Introduzca el teléfono del contacto: ")
        if telefono.isdigit() and len(telefono) > 0 and len(telefono) <= 11:
            agenda[nombre] = telefono
        else:
            print("Debes introducir un número de telefono con menos de 12 dígitos.")
    
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
                pass
            case "2":
                nombre = input("Introduzca el nombre del contacto: ")
                insertar_contacto()
            case "3":
                nombre = input("Ingrese el nombre del contacto a actualizar: ")
                if nombre in agenda:
                    insertar_contacto()
                else:
                    print(f"El contacto {nombre} no existe.")
                pass
            case "4":
                nombre = input("Ingrese el nombre del contacto a eliminar: ")
                if nombre in agenda:
                    del agenda[nombre]
                else:
                    print(f"El contacto {nombre} no existe.")
                pass
            case "5":
                print("Saliendo de la agenda.")
                break
            case _:
                print("Usted escribio una opción invalida. Elige una del 1 al 5")

agenda()
