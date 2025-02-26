'''
3️⃣ Contador de Números Pares y Múltiplos de 3
Consigna:
Escribe un programa en Python que recorra los números del 1 al 100 e imprima cuántos son:
✅ Pares
✅ Múltiplos de 3
✅ Ambos (pares y múltiplos de 3 al mismo tiempo)
'''

contPar = 0
contMultiplo3 = 0
contAmbos = 0

for i in range(1,101):
    if i % 2 == 0 and i % 3 == 0:
        print(i)
        contPar = contPar + 1
        contMultiplo3 = contMultiplo3 + 1
        contAmbos = contAmbos + 1
    elif i % 3 == 0:
        print(i)
        contMultiplo3 = contMultiplo3 + 1
    elif i % 2 == 0:
        print(i)
        contPar = contPar + 1

print("Cantidad de pares: ", contPar)
print("Cantidad de Múltiplos de 3: ", contMultiplo3)
print("Cantidad de números que son pares y múltiplos de 3: ", contAmbos)