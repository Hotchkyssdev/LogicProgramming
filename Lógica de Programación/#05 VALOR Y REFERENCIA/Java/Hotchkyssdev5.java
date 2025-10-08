/*
 * EJERCICIO:
 * - Muestra ejemplos de asignación de variables "por valor" y "por referencia", según
 *   su tipo de dato.
 * - Muestra ejemplos de funciones con variables que se les pasan "por valor" y 
 *   "por referencia", y cómo se comportan en cada caso en el momento de ser modificadas.
 * (Entender estos conceptos es algo esencial en la gran mayoría de lenguajes)
 *
 * DIFICULTAD EXTRA (opcional):
 * Crea dos programas que reciban dos parámetros (cada uno) definidos como
 * variables anteriormente.
 * - Cada programa recibe, en un caso, dos parámetros por valor, y en otro caso, por referencia.
 *   Estos parámetros los intercambia entre ellos en su interior, los retorna, y su retorno
 *   se asigna a dos variables diferentes a las originales. A continuación, imprime
 *   el valor de las variables originales y las nuevas, comprobando que se ha invertido
 *   su valor en las segundas.
 *   Comprueba también que se ha conservado el valor original en las primeras.
 */

public class Hotchkyssdev5 {

    public static void main(String[] args) {
        System.out.println("PASO POR VALOR Y POR REFERENCIA (JAVA)\n");
        System.out.println("En Java, SIEMPRE se pasa el VALOR: o el valor del dato (primitivos), o el valor de la referencia (objetos).\n");

        System.out.println("--- ASIGNACION DE VARIABLES ---\n");
        
        System.out.println("1. ASIGNACION POR VALOR (Primitivos):\n");
        int a = 10;
        int b = a; //'b' obtiene una COPIA del valor de a
        
        System.out.printf("Antes: a: %d, b: %d\n", a, b);
        a = 20; 
        System.out.printf("Despues a=20:\n");
        System.out.printf("a: %d, b: %d\n", a, b); 

        System.out.println("\n2. ASIGNACION POR REFERENCIA (Objetos):\n");
        Punto p1 = new Punto(1, 5);
        Punto p2 = p1; //'p2' obtiene una COPIA de la REFERENCIA (ambos apuntan al mismo objeto en memoria)
        
        System.out.printf("Antes: p1.x: %d, p2.x: %d\n", p1.x, p2.x);
        p1.x = 100; //Modifico el objeto a través de p1
        System.out.printf("Despues p1.x=100:\n");
        System.out.printf("p1.x: %d, p2.x: %d\n", p1.x, p2.x); //p2.x SI cambia (es el mismo objeto)
        
        System.out.println("\n--- PASO DE VARIABLES A FUNCIONES ---\n");
        
        System.out.println("3. PASO POR VALOR (Primitivos):\n");
        int datoValor = 5;
        System.out.printf("Variable original antes: %d\n", datoValor);
        
        modificarPorValor(datoValor); //Paso una copia del valor 
        
        System.out.printf("Variable original despues: %d\n", datoValor); 
        System.out.println("CONCLUSION: El valor NO cambia fuera de la funcion.");

        System.out.println("\n4. PASO DE REFERENCIA (Objetos - Simulacion):\n");
        Punto datoReferencia = new Punto(5, 10);
        System.out.printf("Objeto original antes (datoReferencia.x): %d\n", datoReferencia.x);
        
        modificarPorReferencia(datoReferencia); //Paso la COPIA de la referencia
        
        System.out.printf("Objeto original despues (datoReferencia.x): %d\n", datoReferencia.x); 
        System.out.println("CONCLUSION: El valor del objeto SI cambia (la referencia es la misma).");
        
        System.out.println("\n5. NOTA: Reasignacion de Referencia (Java SI es 'por valor de referencia'):\n");
        Punto pReferencia = new Punto(100, 200);
        System.out.printf("Antes de reasignar: pReferencia.x = %d\n", pReferencia.x);
        
        reasignarReferencia(pReferencia); //Intento cambiar a qué objeto apunta pReferencia
        
        System.out.printf("Despues de reasignar: pReferencia.x = %d\n", pReferencia.x);
        System.out.println("CONCLUSION: La variable original 'pReferencia' NO apunta al nuevo objeto creado dentro de la funcion.");
    
        //EXTRA
        System.out.println("\n\n--- DIFICULTAD EXTRA: INTERCAMBIO DE VALORES ---\n");
        
        //POR VALOR
        int var1 = 50;
        int var2 = 100;
        
        System.out.println("1. INTERCAMBIO POR VALOR (Primitivos)");
        System.out.printf("Originales (Inicio): var1: %d, var2: %d\n", var1, var2);
        
        int[] nuevosValores = programaValor(var1, var2); 
        int nueva1 = nuevosValores[0];
        int nueva2 = nuevosValores[1];
        
        System.out.printf("Nuevas Variables (Intercambiadas): nueva1: %d, nueva2: %d\n", nueva1, nueva2);
        System.out.printf("Originales (Final): var1: %d, var2: %d (Se conserva el valor original)\n", var1, var2);

        //POR REFERENCIA 
        Contenedor cont1 = new Contenedor(50);
        Contenedor cont2 = new Contenedor(100);
        
        System.out.println("\n2. INTERCAMBIO POR REFERENCIA (Objetos Contenedores)");
        System.out.printf("Originales (Inicio): cont1.valor: %d, cont2.valor: %d\n", cont1.valor, cont2.valor);
        
        programaReferencia(cont1, cont2);
        
        Contenedor nuevaRef1 = cont1; //Apunta al objeto modificado
        Contenedor nuevaRef2 = cont2; //Apunta al objeto modificado
        
        System.out.printf("Nuevas Variables (Intercambiadas): nuevaRef1.valor: %d, nuevaRef2.valor: %d\n", nuevaRef1.valor, nuevaRef2.valor);
        System.out.printf("Originales (Final): cont1.valor: %d, cont2.valor: %d (El valor se ha invertido permanentemente)\n", cont1.valor, cont2.valor);
    }

    public static void modificarPorValor(int copiaX) {
        System.out.printf("  [Funcion Por Valor] Valor original recibido: %d\n", copiaX);
        copiaX = copiaX + 50; //Modifica la COPIA local
        System.out.printf("  [Funcion Por Valor] Valor modificado internamente a: %d\n", copiaX);
    }

    public static void modificarPorReferencia(Punto punto) {
        System.out.printf("  [Funcion Por Referencia] Valor original recibido: %d\n", punto.x);
        punto.x = punto.x + 50; //Modifica el OBJETO original
        System.out.printf("  [Funcion Por Referencia] Valor modificado permanentemente a: %d\n", punto.x);
    }
    
    public static void reasignarReferencia(Punto punto) {
        //Esto cambia la referencia de la COPIA LOCAL 'punto', no la referencia original 'pReferencia' en main.
        punto = new Punto(500, 500); 
        System.out.printf("  [Funcion Reasignar] Referencia interna cambiada a %d\n", punto.x);
    }

    //EXTRA
    public static int[] programaValor(int variable1, int variable2) {
        int temp = variable1;
        variable1 = variable2;
        variable2 = temp;
        
        System.out.printf("  [Funcion Por Valor] Intercambio interno: %d, %d\n", variable1, variable2);
        
        return new int[]{variable1, variable2};
    }

    public static void programaReferencia(Contenedor variable1, Contenedor variable2) {
        int temp = variable1.valor;
        variable1.valor = variable2.valor;
        variable2.valor = temp;
        
        System.out.printf("  [Funcion Por Referencia] Intercambio PERMANENTE: %d, %d\n", variable1.valor, variable2.valor);

    }
}

//En Java todos los objetos se pasan por referencia.
class Punto {
    public int x;
    public int y;

    public Punto(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

/*Clase para el EXTRA, ya que Java no permite pasar primitivos por referencia
y modificar dos valores directamente. Usare un array o una clase para simularlo.*/
class Contenedor {
    public int valor;

    public Contenedor(int valor) {
        this.valor = valor;
    }
}