'''
3️⃣ Validar el Acceso a un Diccionario con Manejo de Excepciones
Consigna:
Crea una función que reciba un diccionario y una clave, y devuelva su valor.
✅ Si la clave no existe, captura la excepción y muestra un mensaje de error.
✅ Si el usuario ingresa una clave vacía, muestra otro mensaje de error.
✅ Si la clave es válida, imprime el valor correspondiente.
'''

def diccionario(diccionario: dict):
    while True:
        try:
            clave = input("Ingrese una clave a buscar: ").strip()
            if not clave:
                raise ValueError("La clave que busca esta vacía.")
            valor = diccionario[clave]
            print(f"Valor Encontrado: {valor}")
            return valor
        except KeyError:
            print("Error: La clave no existe en el diccionario")
        except ValueError as e:
            print(f"Error: {e}")

dict = {"nombre": "Gersom", "edad": 19, "ciudad": "Resistencia"}
diccionario(dict)
