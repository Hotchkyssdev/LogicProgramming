import java.util.Scanner;

public class Hotchkyssdev4 {
    public static void main(String[] args) {
        String strOriginal = "Curso de Programacion en Java.";
        String strCheck = "Java";
        String strAux = " Curso Extra";

        System.out.println("--- OPERACIONES CON CADENAS DE CARACTERES EN JAVA ---");
        System.out.println("Cadena Original: \"" + strOriginal + "\"");
        
        System.out.println("\n==== PROPIEDADES Y ACCESO ====\n");
        
        int longitud = strOriginal.length(); 
        System.out.println("1. Longitud: " + longitud);

        System.out.println("2. Primer caracter: " + strOriginal.charAt(0));
        System.out.println("2. Ultimo caracter: " + strOriginal.charAt(longitud - 1));
        
        System.out.print("3. Recorrido: ");
        for (int i = 0; i < longitud; i++) {
            System.out.print(strOriginal.charAt(i));
        }
        System.out.println();

        System.out.println("\n==== MODIFICACION Y CONSTRUCCION ====\n");
        
        String strDestino = strOriginal + strAux;
        System.out.println("4. Concatenacion: \"" + strDestino + "\"");
        
        String strReplace = strOriginal.replace('o', '#').replace('O', '#');
        System.out.println("5. Reemplazo ('o' por '#'): \"" + strReplace + "\"");

        String strCase = "cAdEnA dE pRuEbA";
        System.out.println("6. Mayusculas: " + strCase.toUpperCase());
        System.out.println("6. Minusculas: " + strCase.toLowerCase());

        System.out.println("\n==== BUSQUEDA Y VERIFICACION ====\n");
        
        String subcadena = strOriginal.substring(9, 21);
        System.out.println("7. Subcadena (substring): \"" + subcadena + "\"");

        int index = strOriginal.indexOf(strCheck);
        System.out.println("8. '" + strCheck + "' encontrado en indice: " + index);
        
        boolean comp = strCheck.equals("Java");
        System.out.println("9. 'Java' es igual a 'Java': " + comp);
        
        System.out.println("10. Empieza con 'Cur'? " + strOriginal.startsWith("Cur"));
        System.out.println("10. Termina con '.'? " + strOriginal.endsWith("."));

        double valor = 42.5;
        System.out.println("11. Interpolacion: El resultado es " + valor);

        //EXTRA
        Scanner input = new Scanner(System.in);
        String palabra1, palabra2;

        System.out.println("\n\n--- DIFICULTAD EXTRA: ANALISIS DE PROPIEDADES DE PALABRAS ---");
        
        System.out.print("Ingrese la primer palabra: ");
        palabra1 = input.nextLine().trim();

        System.out.print("Ingrese la segunda palabra: ");
        palabra2 = input.nextLine().trim();
        
        System.out.println("\nPalabra 1: " + palabra1);
        System.out.println("Palabra 2: " + palabra2);
        
        System.out.println("\nCOMPROBACION DE PALINDROMOS");
        System.out.println("'" + palabra1 + "' es palindromo: " + (esPalindromo(palabra1) ? "SI" : "NO"));
        System.out.println("'" + palabra2 + "' es palindromo: " + (esPalindromo(palabra2) ? "SI" : "NO"));

        System.out.println("\nCOMPROBACION DE ANAGRAMAS (Palabra 1 VS Palabra 2)");
        System.out.println("Son anagramas: " + (sonAnagramas(palabra1, palabra2) ? "SI" : "NO"));

        System.out.println("\nCOMPROBACION DE ISOGRAMAS");
        System.out.println("'" + palabra1 + "' es isograma: " + (esIsograma(palabra1) ? "SI" : "NO"));
        System.out.println("'" + palabra2 + "' es isograma: " + (esIsograma(palabra2) ? "SI" : "NO"));
        
        input.close();
    }

    //Limpia la cadena (solo minúsculas y letras), crucial para las comprobaciones.

    private static String limpiar(String s) {
        String limpia = s.toLowerCase(); 
        StringBuilder sb = new StringBuilder(); 
        for (int i = 0; i < limpia.length(); i++) {
            char c = limpia.charAt(i);
            //Verifica si es una letra minúscula ('a' a 'z')
            if (c >= 'a' && c <= 'z') {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static boolean esPalindromo(String palabra) {
        String limpia = limpiar(palabra);
        if (limpia.length() < 2) {
            return false;
        }
        
        String invertida = new StringBuilder(limpia).reverse().toString();
        
        return limpia.equals(invertida);
    }

    public static boolean sonAnagramas(String p1, String p2) {
        String limpia1 = limpiar(p1);
        String limpia2 = limpiar(p2);

        int len1 = limpia1.length();
        int len2 = limpia2.length();

        if (len1 != len2 || len1 == 0) {
            return false;
        }

        char[] arreglo1 = limpia1.toCharArray();
        char[] arreglo2 = limpia2.toCharArray();

        //Se llama a la funcion ordenarBurbuja
        ordenarBurbuja(arreglo1);
        ordenarBurbuja(arreglo2);

        //Comprobación si los arrays ordenados son iguales
        for (int i = 0; i < len1; i++) {
            if (arreglo1[i] != arreglo2[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean esIsograma(String palabra) {
        String limpia = limpiar(palabra);
        int len = limpia.length();
        
        if (len < 2) {
            return false;
        }

        //Bucle anidado para comparación manual sin estructuras auxiliares 
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (limpia.charAt(i) == limpia.charAt(j)) {
                    return false; //Repetición encontrada
                }
            }
        }
        return true;
    }
    
    //Ordenamiento por BubbleSort
    private static void ordenarBurbuja(char[] arreglo) {
        int n = arreglo.length;
        char temp;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arreglo[j] > arreglo[j + 1]) {
                    temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                }
            }
        }
    }
}