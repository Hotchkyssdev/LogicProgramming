'''
2️⃣ Función con Argumento Predeterminado para Conversión de Moneda
Consigna:
Escribe una función llamada convertir_dolares_a_pesos que convierta un monto en dólares a pesos. 
La función debe:
🔹 Recibir un parámetro obligatorio: monto en dólares.
🔹 Recibir un parámetro opcional tasa_cambio, con un valor predeterminado de 900 (simulando una tasa de cambio fija).
🔹 Retornar el monto convertido a pesos y mostrarlo en pantalla.
'''

def convertirUSSaARS(monto, cambio = 900) -> float:
    return monto * cambio

monto = int(input("Ingrese el monto en dólares: "))
opcion = str(input("¿Desea elegir el tipo de cambio? (s/n): "))

if opcion.lower() == "s":
    cambio = float(input("Ingrese el tipo de cambio: "))
    total = convertirUSSaARS(monto, cambio)
else:
    total = convertirUSSaARS(monto)

print(f"El monto en pesos es: {total}")
