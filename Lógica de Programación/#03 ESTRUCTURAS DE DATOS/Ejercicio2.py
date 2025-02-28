'''
2️⃣ Verificador de Datos en un Set
Consigna:
Crea un programa en Python que mantenga un conjunto (set) de correos electrónicos registrados. El programa debe:
✅ Solicitar al usuario un correo electrónico.
✅ Verificar si el correo ya está registrado.
✅ Si no está en el conjunto, agregarlo.
'''

def correo(sets: set = None) -> set:
    if sets is None:
        sets = set()

    while True:
        correo = str(input("Ingrese un correo electronico ('salir' para finalizar el programa): "))
        if correo.lower() == 'salir':
            break

        if '@' not in correo or '.' not in correo:
            print("Error: el correo debe tener '@' y '.'.")
            continue

        if correo in sets:
            print(f"El correo {correo} ya existe.")
        else:
            sets.add(correo)
            print(f"El correo {correo} fue agregado correctamente.")

    print(f"La lista de correos registrados: {sets}")
    return sets

correo()

