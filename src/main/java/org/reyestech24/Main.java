package org.reyestech24;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //crearemos la cuenta para realizar las pruebas con un saldo de 1000 y tasa anual de 5%
        CuentaBancaria cuenta = new CuentaBancaria(1000, 5);

        //Probaremos nuestros metodos

        cuenta.consignar(500);
        cuenta.retirar(200);
        cuenta.calcularInteresMensual();
        cuenta.setComisionMensual(50);
        cuenta.extractoMensual();
        System.out.println(cuenta.imprimir());

    }
}