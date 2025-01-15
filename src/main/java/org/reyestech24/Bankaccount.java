package org.reyestech24;

public class Bankaccount {
    //estos  son nuestros atributos protegidos
    protected float saldo;
    protected int numeroConsignaciones;
    protected int numeroRetiros;
    protected float tasaAnual;
    protected float comisionMensual;

    public Bankaccount(float saldo, float tasaAnual) {
        this.saldo = saldo;
        this.tasaAnual = tasaAnual;
        this.numeroConsignaciones = 0;
        this.numeroRetiros = 0;
        this.comisionMensual = 0;
    }

    //consignar una cantidad de dinero en la cuenta actualizando su saldo
    public void consignar(float cantidad) {
        if (cantidad <= 0) {
            System.out.println("La cantidad a consignar debe ser positiva");
            return;
        }
        saldo += cantidad;
        numeroConsignaciones++;
        System.out.println("Consignacion exitosa. Saldo actual:" + saldo);

    }

    //Retirar una cantidad de dinero en la cuenta actualizando su saldo. El valor a
    //retirar no debe superar el saldo
    public void retirar(float cantidad){
        if (cantidad <= 0){
            System.out.println("La cantidad a retirar debe ser positiva");
            return;
        }
        if (saldo < cantidad){
            System.out.println("Fondos insuficientes para realizar el retiro");
            return;
        }
        saldo -= cantidad;
        numeroRetiros++;
        System.out.println("Retiro exitoso. Saldo actual:" + saldo);
    }

    //Calcular el interes mensual de la cuenta y actualiza el saldo correspondiente
}