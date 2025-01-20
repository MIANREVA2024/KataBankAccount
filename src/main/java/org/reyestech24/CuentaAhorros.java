package org.reyestech24;

public class CuentaAhorros extends CuentaBancaria{
    private boolean estaActiva;

    public CuentaAhorros(float saldo, float tasaAnual) {
        super(saldo, tasaAnual);
        this.estaActiva = saldo >=10000;
    }

    @Override
    public void consignar(float cantidad) {
        if (!estaActiva){
            System.out.println("La cuenta esta inactiva. No se puede consignar.");
            return;
        }
        super.consignar(cantidad);
    }

    @Override
    public void retirar(float cantidad) {
        if (!estaActiva){
            System.out.println("La cuenta esta inactiva. No se puede retirar.");
        }
        super.retirar(cantidad);
    }

    @Override
    public void extractoMensual() {
        //Aca trabajaremos cuando hay mas de 4 retiros, donde se cobrara comision
        if (numeroRetiros > 4){
            comisionMensual +=(numeroRetiros - 4) * 1000;
        }

        restarComisionMensual();
        calcularInteresMensual();
    }

    @Override
    public String imprimir() {
        return super.imprimir() + "\n" + "Estado de la cuenta:" + (estaActiva? "Activa" : "Inactiva");
    }
    public boolean estaActiva (){
        return saldo >= 10000;
    }
}
