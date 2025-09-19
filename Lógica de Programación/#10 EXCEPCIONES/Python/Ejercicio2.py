'''
2️⃣ División Segura entre Dos Números
Consigna:
Crea una función que solicite dos números y realice la división entre ellos.
✅ Si el usuario intenta dividir entre 0, captura la excepción y muestra un mensaje.
✅ Si el usuario ingresa un valor no numérico, captura la excepción y muestra un mensaje.
✅ Repite la solicitud hasta que se ingresen valores correctos.
'''

def division_segura():
    while True:
        try:
            numerador = float(input("Ingrese el numerador: "))
            denominador = float(input("Ingrese el denominador: "))
            resultado = numerador / denominador
            print(f"Resultado: {resultado}")
            return resultado
        except ZeroDivisionError:
            print("Error: No se puede dividir por cero.")
        except ValueError:
            print("Error: El número debe ser válido.")

division_segura()