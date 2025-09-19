'''
1️⃣ Gestión de una Lista de Compras
Consigna:
Crea un programa en Python que implemente una lista de compras, permitiendo al usuario:
✅ Agregar productos a la lista.
✅ Eliminar productos si ya no son necesarios.
✅ Ver la lista ordenada antes de salir.
'''

def lista():
    lista = []
    producto = str(input("Ingrese un producto para añadir a la lista ('salir' para finalizar el programa): "))
    while True:
        if producto.lower() != 'salir':
            lista.append(producto)
        else:
            if lista:
                opcion = str(input("Antes de mostrar la lista, ¿Desea eliminar algún producto? ('si' para eliminar, 'no' para seguir): ")).lower()
                while opcion == 'si':
                    producto = str(input("Ingrese el producto que quiera eliminar: "))
                    if producto in lista:
                        lista.remove(producto)
                        opcion = str(input("¿Desea eliminar otro producto? ('si' para eliminar, 'no' para seguir): "))
                    else:
                        print(f"El producto {producto} no esta en la lista.")
                        opcion = str(input("¿Desea eliminar otro producto? ('si' para eliminar, 'no' para seguir): "))
            if lista:
                print(f"La lista de productos es: {lista}")
            else:
                print("La lista esta vacía.")

lista()