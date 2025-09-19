'''
CADENAS DE CARACTERES
'''

cadena1 = "Hola"
cadena2 = "Python"
print("")

#Concatenación
print(cadena1 + ", " + cadena2)
print("")

#Repetición
print(cadena1 * 3)
print("")

#Indexación
print(cadena1[0] + cadena1[1] + cadena1[2] + cadena1[3])
print("")

#Longitud
print(len(cadena2))
print("")

#Slicing (Porción)
print(cadena2[2:6])
print(cadena2[2:])
print(cadena2[0:2])
print(cadena2[:2])
print("")

#Búsqueda
print("a" in cadena1)
print("e" not in cadena1)
print("e" in cadena1)
print("")

#Reemplazo
print(cadena1.replace("o", "a"))
print("")

#División
print(cadena2.split("t"))
print("")

#Mayúsculas y Minúsculas y Primera Letra en Mayúsculas
print(cadena1.upper())
print(cadena1.lower())
print("hotchkyss gersom".title())
print("hotchkyss gersom".capitalize())
print("")

#Eliminación de espacios al principio y al final
print(" hotchkyss gersom ".strip())
print("")

#Búsqueda al principio y al final
print(cadena1.startswith("Ho"))
print(cadena1.startswith("Py"))
print(cadena1.endswith("la"))
print(cadena1.endswith("thon!"))
print("")

#Búsqueda de Posición
cadena3 = "Hotchkyss Gersom @hotchkyssdev"
print(cadena3.find("hotchkyss"))
print(cadena3.find("Hotchkyss"))
print(cadena3.find("G"))
print(cadena3.lower().find("g"))
print("")

#Búsqueda de Ocurrencias
print(cadena3.lower().count("g"))
print("")

#Formateo
print("Saludo: {}, lenguaje: {}!".format(cadena1, cadena2))
print("")

#Interpolación
print(f"Saludo: {cadena1}, lenguaje: {cadena2}!")
print("")

#Transformación en lista de caracteres
print(list(cadena3))
print("")

#Transformación de lista en cadena
lista = [cadena1, ", ", cadena2, "!"]
print("".join(lista))
print("")

#Transformaciones numéricas
cadena4 = "123456"
cadena4 = int(cadena4)
print(cadena4)

cadena5 = "123456.123"
cadena5 = float(cadena5)
print(cadena5)
print("")

#Comprobaciones varias
cadena4 = "123456"
print(cadena1.isalnum())
print(cadena1.isalpha())
print(cadena4.isalpha())
print(cadena4.isnumeric())
print("")

'''
DIFICULTAD EXTRA (opcional):
 * Crea un programa que analice dos palabras diferentes y realice comprobaciones
 * para descubrir si son:
 * - Palíndromos
 * - Anagramas
 * - Isogramas
'''

def analizar(palabra1: str, palabra2: str):

    #Palíndromos
    print(f"¿{palabra1} es un palíndromo?: {palabra1 == palabra1[::-1]}")
    print(f"¿{palabra2} es un palíndromo?: {palabra2 == palabra2[::-1]}")
    print("")

    #Anagramas
    print(f"¿{palabra1} es un anagrama de {palabra2}?: {sorted(palabra1) == sorted(palabra2)}")
    print("")

    #Isograma
    def isograma(palabra: str) -> bool:
        palabra_dict = dict()
        for caracter in palabra:
            palabra_dict[caracter] = palabra_dict.get(caracter, 0) + 1

        isograma = True
        valores = list(palabra_dict.values())
        isograma_len = valores[0]
        for palabra_cont in valores:
            if palabra_cont != isograma_len:
                isograma = False
                break
        return isograma
    
    print(f"¿{palabra1} es un isograma?: {len(palabra1) == len(set(palabra1))}")
    print(f"¿{palabra2} es un isograma?: {len(palabra2) == len(set(palabra2))}")
    print("")

analizar("radar", "python")
analizar("amor", "roma")
