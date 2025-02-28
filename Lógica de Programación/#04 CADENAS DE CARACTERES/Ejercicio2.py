'''
2️⃣ Inversión y Formateo de Texto
Consigna:
Crea un programa que solicite al usuario una frase y realice las siguientes operaciones:
✅ Invertir la frase (mostrarla al revés).
✅ Convertirla a mayúsculas y minúsculas.
✅ Mostrar solo las tres primeras y tres últimas letras.
'''

def frase():
    frase = str(input("Ingrese una frase: "))
    print(f"La frase invertida es: {frase[::-1]}")
    print(f"La frase en mayúsculas es: {frase.upper()}")
    print(f"La frase en minúsculas es: {frase.lower()}")
    if len(frase) >= 3:
        print(f"Las primeras tres letras de la frase es: {frase[:3]}")
        print(f"Las últimas tres letras de la frase es: {frase[-3:]}")
    else:
        print("La frase tiene menos de tres caracteres.")

frase()