'''
1️⃣ Contador de Vocales y Consonantes
Consigna:
Crea un programa en Python que solicite al usuario una palabra o frase y cuente:
✅ Cantidad de vocales (a, e, i, o, u).
✅ Cantidad de consonantes.
✅ Cantidad de espacios en blanco (si la entrada es una frase).
'''

def palabra():
    palabra = str(input("Ingrese una cadena de texto: ")).lower()
    contVocal = 0
    contConsonante = 0
    saltos = 0
    for caracter in palabra:
        if caracter in "aeiou":
            contVocal = contVocal + 1
        elif caracter.isalpha():
            contConsonante = contConsonante + 1
        elif caracter.isspace():
            saltos = saltos + 1
    
    print(f"Cantidad de vocales: {contVocal}")
    print(f"Cantidad de consonantes: {contConsonante}")
    print(f"Cantidad de espacios en blanco: {saltos}")


palabra()