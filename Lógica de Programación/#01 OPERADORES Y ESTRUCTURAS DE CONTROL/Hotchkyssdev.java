//OPERADORES Y ESTRUCTURAS DE CONTROL

public class Hotchkyssdev {
    public static void main(String[] args) {
        //Operadores Aritméticos
        System.out.println("\nOperadores Aritmeticos:");
        System.out.println("Suma: 10 + 3 = " + (10 + 3));
        System.out.println("Resta: 10 - 3 = " + (10 - 3));
        System.out.println("Multiplicacion: 10 * 3 = " + (10 * 3));
        System.out.println("Division: 12 / 5 = " + (12.0 / 5)); // División precisa
        System.out.println("Modulo: 11 % 2 = " + (11 % 2));
        System.out.println("Division Entera: 12 / 5 = " + (12 / 5));
        System.out.println("Exponente: 10^3 = " + Math.pow(10, 3)); // Exponentes con Math.pow()
        System.out.println("");
        
        //Operadores Lógicos
        System.out.printf("AND &&: 10 + 3 == 13 && 5 - 1 == 4 %b%n", (10 + 3 == 13 && 5 - 1 == 4));
        System.out.printf("OR ||: 10 + 3 == 13 || 5 - 1 == 3 %b%n", (10 + 3 == 13 || 5 - 1 == 3));
        System.out.printf("NOT !: ! (10 + 3 == 14) %b%n", !(10 + 3 == 14));
        System.out.println("");

        // Operadores de Comparación
        System.out.printf("Mayor: 10 > 3 es %b%n", 10 > 3);
        System.out.printf("Menor: 10 < 3 es %b%n", 10 < 3);
        System.out.printf("Igualdad: 12 == 6 es %b%n", 12 == 6);
        System.out.printf("Desigualdad: 12 != 6 es %b%n", 12 != 6);
        System.out.printf("Mayor o Igual a: 10 >= 3 es %b%n", 10 >= 3);
        System.out.printf("Menor o igual a: 10 <= 3 es %b%n", 10 <= 3);
        System.out.println("");
        
         // Operadores de Asignación
         int myNum = 18; // Asignación
         System.out.println(myNum);
         myNum += 1; // Suma y Asignación
         System.out.println(myNum);
         myNum -= 1; // Resta y Asignación
         System.out.println(myNum);
         myNum *= 2; // Multiplicación y Asignación
         System.out.println(myNum);
         myNum /= 2; // División y Asignación
         System.out.println(myNum);
         myNum %= 2; // Módulo y Asignación
         System.out.println(myNum);
         myNum /= 3; // División Entera y Asignación
         System.out.println(myNum);
         myNum = (int) Math.pow(myNum, 3); // Exponente y Asignación
         System.out.println(myNum);
         System.out.println("");
 
         // Operadores de Identidad
         int myNewNum = myNum;
         System.out.printf("myNum == myNewNum es %b%n", myNum == myNewNum);
         System.out.printf("myNum != myNewNum es %b%n", myNum != myNewNum);
         System.out.println("");
 
         // Operadores de Pertenencia
         System.out.printf("'a' in 'tomas' es %b%n", "tomas".contains("a"));
         System.out.printf("'g' not in 'tomas' es %b%n", !"tomas".contains("g"));
         System.out.println("");
 
         // Operadores de Bits
         int a = 10; // 1010
         int b = 3;  // 0011
         System.out.printf("AND: 10 & 3 = %d%n", (a & b)); // 0010
         System.out.printf("OR: 10 | 3 = %d%n", (a | b));  // 1011
         System.out.printf("XOR: 10 ^ 3 = %d%n", (a ^ b)); // 1001
         System.out.printf("NOT: ~10 = %d%n", ~a);
         System.out.printf("Desplazamiento a la derecha: 10 >> 2 = %d%n", (a >> 2)); // 0010
         System.out.printf("Desplazamiento a la izquierda: 10 << 2 = %d%n", (a << 2)); // 101000
         System.out.println("");
 
         /*
         Estructuras de Control (Condicionales y Repetitivas)
         */
         String myString = "Hotchkyss";
         if (myString == ("Tomás")) {
             System.out.println("myString es 'Tomás'");
         } else if (myString == ("Hotchkyss")) {
             System.out.println("myString es 'Hotchkyss'");
         } else {
             System.out.println("myString no es 'Tomás' ni 'Hotchkyss'");
         }
         System.out.println("");
 
         for (int i = 0; i <= 10; i++) {
             System.out.println(i);
         }
         System.out.println("");
 
         int i = 0;
         while (i <= 10) {
             System.out.println(i);
             i++;
         }
         System.out.println("");
 
         // Manejo de Excepciones
         try {
             System.out.println(10 / 0);
         } catch (ArithmeticException e) {
             System.out.println("Se ha producido un error");
         } finally {
             System.out.println("El manejo de excepciones ha finalizado");
         }
         System.out.println("");
 
         /*
         Desafío Extra:
         Crear un programa que imprima por consola todos los números comprendidos entre 10 y 55 (incluidos) 
         pares, y que no son ni el 16 ni múltiplos de 3.
         */
         for (int number = 10; number <= 55; number++) {
             if (number % 2 == 0 && number != 16 && number % 3 != 0) {
                 System.out.println(number);
             }
         }
    }
}

