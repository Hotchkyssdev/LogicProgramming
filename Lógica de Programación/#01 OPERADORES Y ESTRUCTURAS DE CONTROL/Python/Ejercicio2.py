'''
2️⃣ Verificador de Rango y Paridad
Consigna:
Crea un programa en Python que solicite al usuario un número entero y verifique si:
🔹 Está en el rango de 10 a 50.
🔹 Es par o impar.
'''

N1 = int(input("Ingrese un número: "))

if N1 >= 10 and N1 <= 50:
    print(f"El número {N1} está dentro del rango.")
    if N1 % 2 == 0:
        print("Es par.")
    else:
        print("No es par.")
else:
    print(f"El número {N1} no está dentro del rango.")
    if N1 % 2 == 0:
        print("Es par.")
    else:
        print("No es par.")
