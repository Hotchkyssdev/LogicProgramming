/* 
1️⃣ Identificación de Tipos de Datos
Consigna:
Escribe un programa en Java que defina variables con diferentes tipos de datos primitivos: 
cadena de texto, número entero, número decimal, booleano, short, long, double, byte
y otro tipo adicional (puede ser una lista, una tupla, un diccionario, etc.). 
Luego, el programa debe imprimir en pantalla el tipo de cada variable 
utilizando la función .getClass().getSimpleName().
*/

public class Ejercicio1 {
    public static void main(String[] args) {
        byte MiByte = 1;
        short MiShort = 230;
        int MiEntero = 35000;
        long MiLong = 2000000000;
        float MiFloat = 3.14F;
        double MiDouble = 1.797693134;    
        char MiCaracter = 'G';
        String MiCadena = "Gersom Tomas";
        boolean MiBooleano = false;
        int[] MiArray = {1,2,3,4,5};
        System.out.println(((Object) MiByte).getClass().getSimpleName());
        System.out.println(((Object) MiShort).getClass().getSimpleName());
        System.out.println(((Object) MiEntero).getClass().getSimpleName());
        System.out.println(((Object) MiLong).getClass().getSimpleName());
        System.out.println(((Object) MiFloat).getClass().getSimpleName());
        System.out.println(((Object) MiDouble).getClass().getSimpleName());
        System.out.println(((Object) MiCaracter).getClass().getSimpleName());
        System.out.println(((Object) MiCadena).getClass().getSimpleName());
        System.out.println(((Object) MiBooleano).getClass().getSimpleName());
        System.out.println(((Object) MiArray).getClass().getSimpleName());
    }
}
