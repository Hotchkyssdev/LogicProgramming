'''
2️⃣ Conversión de Tipos de Datos
Consigna:
Crea un programa en Python que defina una variable de tipo entero y otra de tipo decimal. 
Luego, realiza las siguientes conversiones:
✅ Convierte el entero en decimal y muéstralo en pantalla.
✅ Convierte el decimal en entero y muéstralo en pantalla.
✅ Convierte ambos valores en cadenas de texto y muéstralos en pantalla.

El programa debe imprimir cada conversión con un mensaje descriptivo.
'''

entero = 18
decimal = 2.79

aux = entero
entero = decimal
decimal = aux

print("La variable entero ahora es: ", entero)
print("La variable decimal ahora es: ", decimal)

entero = str(entero)
decimal = str(decimal)

print(type(entero))
print(type(decimal))
print(f"La variable ahora es: {type(entero)}", entero)
print(f"La variable ahora es: {type(decimal)}", decimal)