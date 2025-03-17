public class Desafios {
    //Semana 0: Hola Mundo
    public static void main(String[] args) {
        System.out.println("Hola Mundo.");
        System.out.println("");
        desafio1();
    }
    /*Semana 1: 
    Desafio Extra: 
    Crea un programa que imprima por consola todos los números comprendidos entre 10 y 55 (incluidos) 
    pares, y que no son ni el 16 ni múltiplos de 3. */
    public static void desafio1() {
        for (int i = 10; i <= 55; i++) {
            if (i % 2 == 0 && i != 16 && i % 3 != 0) {
                System.out.println(i);
            }
        }
    }
}