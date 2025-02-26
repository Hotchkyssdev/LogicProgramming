'''
3️⃣ Contador de Palabras con una Función que Retorna Múltiples Valores
Consigna:
Crea una función llamada analizar_texto que reciba una cadena de texto como parámetro y retorne tres valores:
1️⃣ El número total de palabras en la cadena.
2️⃣ El número total de caracteres (sin contar espacios).
3️⃣ La palabra más larga encontrada en la cadena.
'''

def analizar_texto(texto: str) -> tuple:
    palabras = texto.split()
    nPalabras = len(palabras)
    nCaracteres = sum(len(palabra) for palabra in palabras)
    palabraLarga = max(palabras, key = len) if palabras else ""
    return nPalabras, nCaracteres, palabraLarga

texto = input("Ingrese un texto: ")

nPalabras, nCaracteres, palabraLarga = analizar_texto(texto)

print(f"El número total de palabras en la cadena es: {nPalabras}")
print(f"El número total de caracteres en la cadena es: {nCaracteres}")
print(f"La palabra más larga en la cadena es: {palabraLarga}")
