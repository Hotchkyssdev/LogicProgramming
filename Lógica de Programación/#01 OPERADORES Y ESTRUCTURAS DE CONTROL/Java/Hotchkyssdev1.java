public class Hotchkyssdev1 {
    public static void main(String[] args) {
    //Operadores Aritméticos
    int a = 10, b = 3;
    System.out.println();
    System.out.println("Suma: " + (a + b));           
    System.out.println("Resta: " + (a - b));          
    System.out.println("Multiplicacion: " + (a * b));  
    System.out.println("Division: " + (a / b));        
    System.out.println("Modulo: " + (a % b));          

    //Operadores Lógicos
    int x = 5, y = 10;
    System.out.println();
    System.out.println("AND: " + ((x < 10) && (y > 5)));
    System.out.println("OR: " + ((x < 10) || (y < 5)));
    System.out.println("NOT: " + (!(x < 10)));

    //Operadores de Comparación
    System.out.println();
    System.out.println("Igual a (a == b): " + (a == b));
    System.out.println("No igual a (a != b): " + (a != b));
    System.out.println("Mayor que (a > b): " + (a > b));
    System.out.println("Menor que (a < b): " + (a < b));
    System.out.println("Mayor o igual que (a >= b): " + (a >= b));
    System.out.println("Menor o igual que (a <= b): " + (a <= b));

    //Operadores de Asignación
    int c = 5;
    System.out.println();
    System.out.println("Asignacion c = 5: " + c);
    c += 2;
    System.out.println("Asignacion suma c += 2: " + c);
    c -= 2;
    System.out.println("Asignacion resta c -= 2: " + c);
    c *= 2;
    System.out.println("Asignacion multiplicacion c *= 2: " + c);
    c /= 2;
    System.out.println("Asignacion division c /= 2: " + c);
    c %= 2;
    System.out.println("Asignacion modulo c %= 2: " + c);

    // "Operadores de Identidad" (simulación)
    // En Java no hay punteros, pero podemos mostrar referencias de objetos
    System.out.println();
    Integer refA = a;
    System.out.println("Direccion simulada de a (hashCode): " + System.identityHashCode(refA));
    System.out.println("Valor de a: " + refA);

    //Operadores de Bits
    int m = 5, n = 3;
    System.out.println();
    System.out.println("AND a nivel de bits: " + (m & n));
    System.out.println("OR a nivel de bits: " + (m | n));
    System.out.println("XOR a nivel de bits: " + (m ^ n));
    System.out.println("NOT a nivel de bits: " + ~m);
    System.out.println("Desplazamiento a la izquierda: " + (m << 1));
    System.out.println("Desplazamiento a la derecha: " + (m >> 1));

    //Estructuras de Control - Condicionales
    int num = 7;
    System.out.println();
    if (num > 0) {
        System.out.println("El numero es positivo.");
    } else if (num < 0) {
        System.out.println("El numero es negativo.");
    } else {
        System.out.println("El numero es cero.");
    }

    switch (num) {
        case 1:
            System.out.println("El numero es uno.");
            break;
        case 2:
            System.out.println("El numero es dos.");
            break;
        case 3:
            System.out.println("El numero es tres.");
            break;
        default:
            System.out.println("El numero no es uno + dos ni tres.");
            break;
    }

    //Estructuras de Control - Bucles
    System.out.println();
    System.out.println("Bucle for:\n");
    for (int i = 0; i < 5; i++) {
        System.out.println(i + " ");
    }
    System.out.println();
    System.out.println("Bucle while:\n");
    int j = 0;  
    while (j < 5) {
        System.out.println(j +  " ");
        j++;
    }
    System.out.println();
    System.out.println("Bucle do-while:\n");
    int k = 0;
    do {
        System.out.println(k + " ");
        k++;
    } while (k < 5);
    System.out.println();
    
    /*Desafio Extra:
    Crea un programa que imprima por consola todos los números comprendidos entre 10 y 55 (incluidos) 
    pares + y que no son ni el 16 ni múltiplos de 3.*/
    System.out.println();
    for (int numExtra = 10; numExtra <= 55; numExtra++) {
        if (numExtra % 2 == 0 && numExtra != 16 && numExtra % 3 != 0) {
            System.out.println(numExtra + " ");
        }
    }
    System.out.println();
    }
}