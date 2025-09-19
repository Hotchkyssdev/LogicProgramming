'''
2️⃣ Simulación de una Línea de Atención al Cliente con una Cola (Queue)
Consigna:
Crea un programa que simule una fila de atención en un centro de llamadas.
✅ Usa una cola (queue) para manejar a los clientes en orden FIFO.
✅ El usuario puede agregar un cliente (agregar nombre).
✅ El usuario puede atender un cliente (atender).
✅ Mostrar la fila después de cada operación.
'''

def atencion_cliente():
    cola = []
    while True:
        accion = input("Ingrese una acción (agregar nombre / atender / salir): ").strip().lower()
        if accion == "salir":
            print("Cerrando sistema de atención al cliente.")
            break
        elif accion.startswith("agregar"):
            nombre = accion.split(" ", 1)[-1]
            cola.append(nombre)
            print(f"Cliente {nombre} agregado correctamente a la cola.")
        elif accion == "atender":
            if cola:
                print(f"Atendiendo a {cola.pop(0)}")
            else:
                print("No hay clientes en espera.")
        else:
            print("Comando no válido. Use 'agregar nombre', 'atender' o 'salir'.")
        
        print(f"Fila de atención: {cola}")

atencion_cliente()
