/*URL OFICIAL:
 * https://www.oracle.com/java/
 */

//Esto es un comentario de una línea

/*Esto
 * es un comentario
 * multilinea
 */

public class Hotchkyssdev {
    public static void main(String[] args) {
        //Variable
        String mivariable = "Tomás";
        mivariable = "Hotchkyssdev";
        System.out.println(mivariable);
        System.out.println("");
        //Constante
        final double PI = 3.1416;
        System.out.println(PI);
        System.out.println("");
        //Tipos de Datos Primitivos
        int numEntero = 19;
        double numReal = 19.25;
        float numEnorme = 3.402823538F;
        short numCorto = 1;
        char caracter = 'T';
        String cadena = "River Plate";
        boolean miBooleano = true;
        byte miByte = 0;
        long miLong = 9000000000000000000L;
        miBooleano = false;
        // Imprimir los tipos de las variables
        System.out.println("Tipo de numEntero: " + ((Object) numEntero).getClass().getSimpleName());
        System.out.println("Tipo de numReal: " + ((Object) numReal).getClass().getSimpleName());
        System.out.println("Tipo de numEnorme: " + ((Object) numEnorme).getClass().getSimpleName());
        System.out.println("Tipo de numCorto: " + ((Object) numCorto).getClass().getSimpleName());
        System.out.println("Tipo de caracter: " + ((Object) caracter).getClass().getSimpleName());
        System.out.println("Tipo de cadena: " + ((Object) cadena).getClass().getSimpleName());
        System.out.println("Tipo de miBooleano: " + ((Object) miBooleano).getClass().getSimpleName());
        System.out.println("Tipo de miByte: " + ((Object) miByte).getClass().getSimpleName());
        System.out.println("Tipo de miLong: " + ((Object) miLong).getClass().getSimpleName());
        System.out.println("");
        //Imprimir Hola Mundo
        System.out.println("¡Hola, Java! Aquí " + mivariable);
    }
}