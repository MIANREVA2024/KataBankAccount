package org.reyestech24;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //crearemos la cuenta de ahorros con saldo mayor a lo solicitado (10000) que sera 12000
        CuentaAhorros cuentaAhorros = new CuentaAhorros(12000, 5);

        //Probaremos nuestros metodos
        cuentaAhorros.consignar(500);
        cuentaAhorros.retirar(200);
        cuentaAhorros.extractoMensual();
        System.out.println(cuentaAhorros.imprimir());

        //para realizar las pruebas con un saldo de 1000 y tasa anual de 5%
        CuentaCorriente cuentaCorriente = new CuentaCorriente(500, 5);
        cuentaCorriente.retirar(600);
        cuentaCorriente.consignar(300);
        cuentaCorriente.extractoMensual();
        System.out.println(cuentaCorriente.imprimir());
        System.out.println("hola mundo");
    }
}