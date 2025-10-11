/*Ejercicio 3: Clase CuentaBancaria
Implementa una clase CuentaBancaria con atributos titular y saldo.
Crea métodos para depositar(), retirar() y mostrarSaldo().
Evita que el saldo se vuelva negativo.*/

public class Ejercicio38 {
    public static void main(String[] args) {
        CuentaBancaria mi_cuenta = new CuentaBancaria("Gersom Tomas", 1000);

        mi_cuenta.mostrarSaldo();
        mi_cuenta.depositar(2000);
        mi_cuenta.mostrarSaldo();
        mi_cuenta.retirar(1000);
        mi_cuenta.mostrarSaldo();

        System.out.println("\nIntento retirar mas de lo que tengo en la cuenta (2100).");
        mi_cuenta.retirar(2100);
    }
}

class CuentaBancaria {
    private String titular;
    private double saldo;

    public CuentaBancaria() {

    }

    public CuentaBancaria(String titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;
    }

    public String depositar(double nuevoSaldo) {
        this.saldo += nuevoSaldo;
        return "El nuevo saldo es: " + this.saldo;
    }

    public String retirar(double retirar) {
        this.saldo -= retirar;
        if (this.saldo < 0) {
            System.out.println("ERROR: No se puede quedar en numeros negativos su saldo.");
        }

        return this.titular + " " + this.saldo;
    }

    public void mostrarSaldo() {
        System.out.println("Titular: " +  this.titular + " | Saldo: " + this.saldo);
    }
}