'''
3️⃣ Personalización de un Mensaje de Bienvenida
Consigna:
Escribe un programa en Python que solicite al usuario su nombre y su edad mediante la función input(). 
Luego, el programa debe imprimir un mensaje de bienvenida personalizado en la consola, 
que incluya el nombre y la edad ingresados.
'''

nombre = input("Ingrese su nombre: ")
edad = int(input("Ingrese su edad: "))
print(type(nombre))
print(type(edad))
print(f"¡Hola, {nombre} ! Bienvenido a Python. Tienes {edad} años.")
