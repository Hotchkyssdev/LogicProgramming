public class Hotchkyssdev2 {

    // Simple
    static void funcion1() {
        System.out.println("Hola desde la funcion 1");
    }

    // Con retorno
    static int funcion2() {
        return 42;
    }

    // Con un argumento
    static void funcion3(int x) {
        System.out.println("El valor de la funcion3 es: " + x);
    }

    // Con argumentos y retorno
    static int funcion4(int a, int b) {
        return a + b;
    }

    // Con retorno de varios valores (usamos un array para simular punteros)
    static int[] funcion5(int a, int b) {
        int suma = a + b;
        int producto = a * b;
        return new int[]{suma, producto};
    }

    // Con un número variable de argumentos
    static int funcion6(int... args) {
        int sum = 0;
        for (int value : args) {
            sum += value;
        }
        return sum;
    }

    // Con palabra clave para operación
    static int funcion7(String operation, int... args) {
        int result = operation.startsWith("s") ? 0 : 1;
        for (int value : args) {
            if (operation.startsWith("s")) {
                result += value;
            } else if (operation.startsWith("p")) {
                result *= value;
            }
        }
        return result;
    }

    // FizzBuzz con conteo
    static int fizzBuzz(String string1, String string2) {
        int contador = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println(string1 + string2);
            } else if (i % 3 == 0) {
                System.out.println(string1);
            } else if (i % 5 == 0) {
                System.out.println(string2);
            } else {
                System.out.println(i);
                contador++;
            }
        }
        return contador;
    }

    public static void main(String[] args) {
        funcion1();
        System.out.println("Retorno de funcion2: " + funcion2());
        funcion3(10);
        System.out.println("Retorno de funcion4: " + funcion4(5, 7));

        int[] resultado = funcion5(3, 4);
        System.out.println("La funcion 5 devuelve Suma: " + resultado[0] + ", Producto: " + resultado[1]);

        System.out.println("La funcion 6 devuelve Suma variable (1,2,3): " + funcion6(1, 2, 3));
        System.out.println("La funcion 7 devuelve Producto variable (2,3,4): " + funcion7("p", 2, 3, 4));
        System.out.println();

        int contador = fizzBuzz("Fizz", "Buzz");
        System.out.println("\nNumeros impresos: " + contador);
    }
}