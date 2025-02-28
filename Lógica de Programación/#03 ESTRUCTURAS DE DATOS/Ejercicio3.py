'''
3️⃣ Diccionario de Traducción de Palabras
Consigna:
Crea un diccionario (dict) de traducción de palabras en español a inglés. El programa debe:
✅ Permitir al usuario ingresar una palabra en español.
✅ Buscar su traducción en inglés dentro del diccionario.
✅ Si la palabra no está registrada, mostrar un mensaje de advertencia.
'''

def traduccion():
    palabras = {
        "perro": "dog",
        "gato": "cat",
        "casa": "house",
        "rojo": "red",
        "verde": "green",
        "azul": "blue",
        "libro": "book",
        "agua": "water",
        "comida": "food",
        "coche": "car"
    }

    while True:
        palabra = str(input("Ingrese una palabra para traducir al ingles ('salir' para finalizar): "))

        if palabra == 'salir':
            break

        traduccion = palabras.get(palabra, None)

        if traduccion:
            print(f"La palabra {palabra} traducida al ingles es: {traduccion}")
        else:
            print(f"La palabra {palabra} no se encuentra en el diccionario para su traducción.")

    print("Programa finalizado.")

traduccion()