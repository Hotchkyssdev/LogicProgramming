'''
3️⃣ Comparador de Cadenas (Sensibilidad a Mayúsculas y Minúsculas)
Consigna:
Crea un programa en Python que solicite dos cadenas de texto y verifique:
✅ Si son iguales con y sin diferenciar mayúsculas.
✅ Si una está contenida dentro de la otra.
'''
def cadenas():
    cadena1 = str(input("Ingrese la primer cadena: "))
    cadena2 = str(input("Ingrese la primer cadena: "))

    igualMAYUS = cadena1 == cadena2
    igualMINUS = cadena1.lower() == cadena2.lower()
    contenida = cadena2.lower() in cadena1.lower()

    print(f"¿Las cadenas son iguales (distinguiendo mayúsculas)?: {igualMAYUS}")
    print(f"¿Las cadenas son iguales (sin distinguir mayúsculas)?: {igualMINUS}")
    print(f"¿La cadena {cadena2} esta contenida en {cadena1}?: {contenida}")

cadenas()
