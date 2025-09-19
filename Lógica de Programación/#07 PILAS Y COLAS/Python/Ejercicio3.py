'''
3️⃣ Implementar una Función deshacer() con Pila para Texto
Consigna:
Crea un programa donde el usuario pueda escribir texto, y si escribe "deshacer", debe borrar la última palabra ingresada.
✅ Usa una pila (stack) para almacenar las palabras escritas.
✅ Si el usuario escribe "salir", muestra el texto final.
'''

def editar_texto():
    pila = []
    while True:
        entrada = input("Ingrese texto o 'deshacer' para borrar la última palabra ('salir' para terminar): ").strip()
        if entrada.lower() == "salir":
            break
        elif entrada.lower() == "deshacer":
            if pila:
                print(f"Deshaciendo: {pila.pop()}")
            else:
                print("No hay nada que deshacer.")
        else:
            pila.append(entrada)
        
        print(f"Texto Actual: {' '.join(pila)}")
    print(f"Texto Final: {' '.join(pila)}")

editar_texto()