'''
1️⃣ Función para Calcular el Área de un Rectángulo
Consigna:
Crea una función llamada calcular_area_rectangulo que reciba dos parámetros: la base y la altura de un rectángulo. 
La función debe:
🔹 Calcular el área del rectángulo.
🔹 Retornar el resultado.
🔹 Solicitar los valores al usuario y mostrar el área en pantalla.
'''

def calculararea(base, altura) -> float:
    return base * altura

base = float(input("Ingrese la base del rectángulo: "))
altura = float(input("Ingrese la altura del rectángulo: "))
area = calculararea(base, altura)

print(f"El área del rectángulo es: {area}")
