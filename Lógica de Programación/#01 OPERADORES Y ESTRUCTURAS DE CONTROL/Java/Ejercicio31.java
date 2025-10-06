/*Ejercicio 3: Contador con bucles
Escribe un programa que imprima todos los números del 1 al 100, pero que:
Omita los múltiplos de 3, Y detenga el conteo al llegar a 73.
Usa bucles for o while y estructuras if / break / continue.*/

public class Ejercicio31 {
    public static void main(String[] args) {
        int i;
        for (i = 1; i <= 100; i++) {
            if (i % 3 != 0) {
                if (i == 73) {
                    break;
                }
                System.out.println(i);
            }
        }
    }    
}