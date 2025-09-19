'''
1️⃣ Validar Entrada de un Número Entero con Manejo de Excepciones
Consigna:
Crea una función que solicite al usuario un número entero.
✅ Si el usuario ingresa un valor no numérico, captura la excepción y muestra un mensaje.
✅ Si el usuario ingresa un número decimal, muestra un mensaje indicando que solo se permiten enteros.
✅ Continúa solicitando un número válido hasta que el usuario ingrese uno correcto.
'''

def solicitar_numero():
    while True:
        try:
            n = input("Ingrese un número entero: ").strip()
            if "." in n or "," in n:
                float(n)
                raise ValueError("Error: Debe ser un número entero.")
            n = int(n)
            print(f"El número entero válido es: {n}")
            return n
        except ValueError as e:
            if "entero" in str(e):
                print(f"Error: {e}")
            else:
                print("Error: Debe ingresar un número válido.")

solicitar_numero()