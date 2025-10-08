/*Ejercicio 2: Modificación de Arreglo
Escribe una función que reciba un arreglo de enteros y modifique sus elementos dentro de la función.
Explica por qué los cambios se mantienen (o no) según el tipo de paso.*/

public class Ejercicio25 {
    public static void main(String[] args) {
        int[] arregloValor = {10, 21, 32, 54, 23, 65, 12, 76, 17, 78};
        int[] arregloReferencia = {76, 31, 54, 16, 87, 19, 11, 75, 89, 95};

        System.out.println("ARREGLO QUE SE PASARA POR VALOR");
        imprimirArreglo(arregloValor);
        arrayValor(arregloValor);

        System.out.println("ARREGLO DESPUES DE LA FUNCION");
        imprimirArreglo(arregloValor);

        System.out.println("\nARREGLO QUE SE PASARA POR REFERENCIA");
        imprimirArreglo(arregloReferencia);
        arrayReferencia(arregloReferencia);

        System.out.println("ARREGLO DESPUES DE LA FUNCION");
        imprimirArreglo(arregloReferencia);
        System.out.println("\n------------------------------------------------------");
    }

    private static void arrayValor(int arregloValor[]) {
        int i;
        for (i = 0; i < arregloValor.length; i++) {
            arregloValor[i] += 2;
        }
    }

    private static void arrayReferencia(int arregloReferencia[]) {
        int i;
        for (i = 0; i < arregloReferencia.length; i++) {
            arregloReferencia[i] += 5;
        }
    }

    private static void imprimirArreglo(int arr[]) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}