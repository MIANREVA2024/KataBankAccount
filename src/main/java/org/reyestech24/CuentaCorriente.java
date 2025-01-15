package org.reyestech24;

public class CuentaCorriente extends CuentaBancaria{
    private float sobregiro;

    public CuentaCorriente(float saldo, float tasaAnual) {
        super(saldo, tasaAnual);
        this.sobregiro = 0;
    }

    @Override
    public void retirar(float cantidad) {
        if (saldo + sobregiro < cantidad){
            System.out.println("Fondos insuficientes para realizar el retiro");
            return;
        }
        if (saldo >= cantidad){
            super.retirar(cantidad);
            return;
        }
        sobregiro += (cantidad - saldo);
        saldo = 0;
    }

    @Override
    public void consignar(float cantidad) {
        super.consignar(cantidad);
        if (sobregiro > 0){
            if (cantidad >= sobregiro){
                sobregiro = 0;
                return;
            }
            sobregiro -= cantidad;
        }
    }

    @Override
    public void extractoMensual() {
        super.extractoMensual();
    }

    @Override
    public String imprimir() {
        return super.imprimir() + "\n" + "Sobregiro: " + sobregiro;
    }

    public float getSobregiro() {
        return sobregiro;
    }
}
