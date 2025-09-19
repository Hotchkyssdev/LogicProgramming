'''
Operadores
'''

#Operadores Aritméticos
print("")
print(f"Suma: 10 + 3 = {10 + 3}") #Interpolación (Codigo dentro de una cadena de texto)
print(f"Resta: 10 - 3 = {10 - 3}")
print(f"Multiplicación: 10 * 3 = {10 * 3}")
print(f"División: 12 / 5 = {12 / 5}")
print(f"Módulo: 11 % 2 = {11 % 2}")
print(f"División Entera: 12 // 5 = {12 // 5}")
print(f"Exponente: 10 ** 3 = {10 ** 3}")
print("")

#Operadores Lógicos
print(f"AND &&: 10 + 3 == 13  and 5 - 1 == 4 {10 + 3 == 13  and 5 - 1 == 4}")
print(f"OR ||: 10 + 3 == 13  or 5 - 1 == 3 {10 + 3 == 13  or 5 - 1 == 3}")
print(f"NOT !: not 10 + 3 == 14 {not 10 + 3 == 14}")
print("")

#Operadores de Comparación
print(f"Mayor: 10 > 3 es {10 > 3}")
print(f"Menor: 10 < 3 es {10 < 3}")
print(f"Igualdad: 12 == 6 es {12 == 6}")
print(f"Desigualdad: 12 != 6 es {12 != 6}")
print(f"Mayor o Igual a: 10 >= 3 es {10 >= 3}")
print(f"Menor o igual a: 10 <= 3 es {10 <= 3}")
print("")

#Operadores de Asignación
my_num = 18 #Asignación
print(my_num)
my_num += 1 #Suma y Asignación
print(my_num)
my_num -= 1 #Resta y Asignación
print(my_num)
my_num *= 2 #Multiplicación y Asignación
print(my_num)
my_num /= 2 #División y Asignación
print(my_num)
my_num %= 2 #Módulo y Asignación
print(my_num)
my_num //= 3 #División Entera y Asignación
print(my_num)
my_num **= 3 #Exponente y Asignación
print(my_num)
print("")

#Operadores de Identidad
my_new_num = my_num
print(f"my_num is my_new_num es {my_num is my_new_num}")
print(f"my_num is not my_new_num es {my_num is not my_new_num}")
print("")

#Operadores de Pertenencia
print(f"'a' in 'tomas' {'a' in 'tomas'}")
print(f"'g' not in 'tomas' {'g' not in 'tomas'}")
print("")

#Operadores de Bits
a = 10 # 1010
b = 3 # 0011
print(f"AND: 10 & 3 = {10 & 3}") #0010
print(f"OR: 10 | 3 = {10 | 3}") #1011
print(f"XOR: 10 ^ 3 = {10 ^ 3}") #1001
print(f"NOT: ~10 = {~10}") 
print(f"Desplazamiento a la derecha: 10 >> 2 = {10 >> 2}") #0010
print(f"Desplazamiento a la izquierda: 10 << 2 = {10 << 2}") #101000
print("")

'''
Estructuras de Control (Condicionales y Repetitivas)
'''

#Condicionales
my_string = "Hotchkyss"
if my_string == "Tomás":
    print("my_string es 'Tomás'")
elif my_string == 'Hotchkyss':
    print("my_string es 'Hotchkyss'")
else:
    print("my_string no es 'Tomás' ni 'Hotchkyss'")
print("")

#Repetitivas
for i in range(11):
    print(i)

print("")

i = 0

while i <= 10:
    print(i) 
    i += 1

print("")

#Manejo de Excepciones
try:
    print(10 / 0)
except:
    print("Se ha producido un error")
finally:
    print("El manejo de excepciones ha finalizado")
print("")

'''
Desafio Extra:

Crea un programa que imprima por consola todos los números comprendidos entre 10 y 55 (incluidos) 
pares, y que no son ni el 16 ni múltiplos de 3.
'''

for number in range(10, 56):
    if number % 2 == 0 and number != 16 and number % 3 != 0:
        print(number)

print("")