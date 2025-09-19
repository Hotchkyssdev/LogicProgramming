'''
1️⃣ Verificador de Paréntesis Balanceados usando una Pila (Stack)
Consigna:
Crea una función llamada verificar_parentesis que reciba una cadena de texto y determine si los paréntesis están balanceados.
✅ Usa una pila (stack) para almacenar los paréntesis abiertos y verificar los cerrados.
✅ Retorna True si están balanceados, False si no.
'''

def verificar_parentesis(cadena: str) -> bool:
    pila = []
    for caracter in cadena:
        if caracter == "(":
            pila.append(caracter)
        elif caracter == ")":
            if not pila:
                return False
            pila.pop()
    return len(pila) == 0

print(verificar_parentesis("(())"))   # True
print(verificar_parentesis("(()"))    # False
print(verificar_parentesis("()()"))   # True
print(verificar_parentesis(")("))     # False