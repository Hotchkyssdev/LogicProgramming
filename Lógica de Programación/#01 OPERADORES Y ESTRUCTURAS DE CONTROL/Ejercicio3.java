/*3️⃣ Contador de Números Pares y Múltiplos de 3
Consigna:
Escribe un programa en Python que recorra los números del 1 al 100 e imprima cuántos son:
✅ Pares
✅ Múltiplos de 3
✅ Ambos (pares y múltiplos de 3 al mismo tiempo) */

public class Ejercicio3 {
    public static void main(String[] args) {
        int contPar = 0;
        int contMultiplo3 = 0;
        int contAmbos = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0 && i %  3 == 0) {
                System.out.println(i);
                contPar = contPar + 1;
                contMultiplo3 = contMultiplo3 + 1;
                contAmbos = contAmbos + 1;
            } else if (i % 3 == 0) {
                System.out.println(i);
                contMultiplo3 = contMultiplo3 + 1;
            } else if (i % 2 == 0) {
                System.out.println(i);
                contPar = contPar + 1;
            }
        }
        System.out.println("Cantidad de Pares: " + contPar);
        System.out.println("Cantidad de Multiplos de 3: " + contMultiplo3);
        System.out.println("Cantidad de Pares y Multiplos de 3: " + contAmbos);
    }
}
