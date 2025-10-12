/*
 * EJERCICIO:
 * Explora el concepto de manejo de excepciones según tu lenguaje.
 * Fuerza un error en tu código, captura el error, imprime dicho error
 * y evita que el programa se detenga de manera inesperada.
 * Prueba a dividir "10/0" o acceder a un índice no existente
 * de un listado para intentar provocar un error.
 *
 * DIFICULTAD EXTRA (opcional):
 * Crea una función que sea capaz de procesar parámetros, pero que también
 * pueda lanzar 3 tipos diferentes de excepciones (una de ellas tiene que
 * corresponderse con un tipo de excepción creada por nosotros de manera
 * personalizada, y debe ser lanzada de manera manual) en caso de error.
 * - Captura todas las excepciones desde el lugar donde llamas a la función.
 * - Imprime el tipo de error.
 * - Imprime si no se ha producido ningún error.
 * - Imprime que la ejecución ha finalizado.
*/

public class Hotchkyssdev10 {
    public static void main(String[] args) {
        try {
            System.out.println(10 / 0); 
            int[] numeros = {1, 2, 3, 4};
            System.out.println(numeros[4]); 
        } catch (Exception e) {
            System.out.println("Se ha producido un error: " + e.getMessage() + " (" + e.getClass().getSimpleName() + ")");
        }
        System.out.println();

        //EXTRA
        try {
            parametrosDeProcesos(new Object[]{1, 2, 3, 4});
        } catch (IndexOutOfBoundsException e) {
            System.out.println("El numero de elementos de la lista debe ser mayor que dos.");
        } catch (ArithmeticException e) {
            System.out.println("El segundo elemento de la lista no puede ser un cero.");
        } catch (StringTypeException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Se ha producido un error inesperado: " + e.getMessage());
        } finally {
            System.out.println("El programa finaliza sin detenerse.");
        }
    }

    //EXTRA
    //Función que puede lanzar diferentes tipos de excepciones
    static void parametrosDeProcesos(Object[] parametros) throws Exception {
        if (parametros.length < 3) {
            throw new IndexOutOfBoundsException();
        } else if (parametros[1] instanceof Integer && (Integer) parametros[1] == 0) {
            throw new ArithmeticException();
        } else if (parametros[2] instanceof String) {
            throw new StringTypeException("El tercer elemento no puede ser una cadena de texto.");
        }

        //Si todo está bien, se procesa de forma normal
        System.out.println(parametros[2]);
        System.out.println((Integer) parametros[0] / (Integer) parametros[1]);

        if (parametros[2] instanceof Integer)
            System.out.println((Integer) parametros[2] + 5);
        else
            System.out.println("No se puede sumar 5 al valor del tercer elemento.");
    }

    static class StringTypeException extends Exception {
        public StringTypeException(String mensaje) {
            super(mensaje);
        }
    }
}