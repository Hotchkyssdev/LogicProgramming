/*Ejercicio 3: Número mayor
Escribe una función que reciba tres números y devuelva el mayor de ellos.
Muestra cómo puedes reutilizar esa función desde el main() varias veces con distintos valores.*/
public class Ejercicio32 {
    static int mayor(int n1, int n2, int n3) {
        int mayor = 0;
        
        if (n1 > n2 && n1 > n3) {
            mayor = n1;
        } else if (n2 > n1 && n2 > n3) {
            mayor = n2;
        } else if (n3 > n2 && n3 > n1) {
            mayor = n3;
        } else {
            System.out.println("Uno de los valores o todos son iguales, tienen que ser distintos los tres valores.");
            return 0;
        }

        return mayor;
    }

    public static void main(String[] args) {
        int n1 = 10, n2 = 8, n3 = 6;
        System.out.println("Primer uso de la funcion mayor con los valores: " + n1 + " " + n2 + " " + n3);
        System.out.println("El mayor es: " + mayor(n1, n2, n3));
        
        System.out.println();
        n1 = 1; 
        n2 = 11; 
        n3 = 5;
        System.out.println("Segundo uso de la funcion mayor con los valores: " + n1 + " " + n2 + " " + n3);
        System.out.println("El mayor es: " + mayor(n1, n2, n3));

        System.out.println();
        n1 = 5; 
        n2 = 3; 
        n3 = 12;
        System.out.println("Tercer uso de la funcion mayor con los valores: " + n1 + " " + n2 + " " + n3);
        System.out.println("El mayor es: " + mayor(n1, n2, n3));
        
        System.out.println();
        n1 = 4; 
        n2 = 5; 
        n3 = 5;
        System.out.println("Cuarto uso de la funcion mayor con los valores: " + n1 + " " + n2 + " " + n3);
        System.out.println("El mayor es: " + mayor(n1, n2, n3));
    }
}