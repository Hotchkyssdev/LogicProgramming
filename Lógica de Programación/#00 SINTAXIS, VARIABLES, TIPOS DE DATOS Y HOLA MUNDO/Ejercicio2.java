/* 
2️⃣ Conversión de Tipos de Datos
Consigna:
Crea un programa en Java que defina una variable de tipo entero y otra de tipo decimal. 
Luego, realiza las siguientes conversiones:
✅ Convierte el entero en decimal y muéstralo en pantalla.
✅ Convierte el decimal en entero y muéstralo en pantalla.
✅ Convierte ambos valores en cadenas de texto y muéstralos en pantalla.

El programa debe imprimir cada conversión con un mensaje descriptivo.
*/

public class Ejercicio2 {
    public static void main(String[] args) {
        int MiEntero = 10;
        float MiFloat = 3.14F;
        
        float EnteroADecimal = MiEntero;
        System.out.println("El entero convertido a decimal es: " + EnteroADecimal);

        int DecimalAEntero = (int) MiFloat;
        System.out.println("El decimal convertido a entero es: " + DecimalAEntero);

        String EnteroACadena = Integer.toString(MiEntero);
        String DecimalACadena = Double.toString(MiFloat);
        System.out.println("El entero convertido a cadena es: " + EnteroACadena);
        System.out.println("El decimal convertido a cadena es: " + DecimalACadena);
    }
}

