package org.reyestech24;

public class CuentaBancaria {
    //estos  son nuestros atributos protegidos
    protected float saldo;
    protected int numeroConsignaciones;
    protected int numeroRetiros;
    protected float tasaAnual;
    protected float comisionMensual;

    public CuentaBancaria(float saldo, float tasaAnual) {
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

    //Calcular el interés mensual de la cuenta y actualiza el saldo correspondiente
    public void calcularInteresMensual (){
        float interesMensual = (tasaAnual / 12) / 100 * saldo;
        saldo += interesMensual;
        System.out.println("Interés mensual aplicado. Saldo actual:" + saldo);
    }

    //Extracto mensual: actualiza el saldo
    public void extractoMensual (){
        restarComisionMensual();
        calcularInteresMensual();
    }

    //Creando metodo para restar comision
    private void restarComisionMensual() {
        saldo -= comisionMensual;
        if (saldo < 0) saldo = 0;
        System.out.println("Comision mensual restada. Saldo actual:" + saldo);
    }

    //Imprimir retorno los valores de los atributos
    public  String imprimir(){
        return "saldo: " + saldo + "\n" +
                "Numero de Consignaciones: " + numeroConsignaciones + "\n" +
                "Numero de Retiros: " + numeroRetiros + "\n" +
                "Tasa Anual: " + tasaAnual + "\n" +
                "Comisión Mensual: " + comisionMensual + "\n";
    }

    public float getSaldo() {
        return saldo;
    }

    public int getNumeroConsignaciones() {
        return numeroConsignaciones;
    }

    public int getNumeroRetiros() {
        return numeroRetiros;
    }

    public float getTasaAnual() {
        return tasaAnual;
    }

    public float getComisionMensual() {
        return comisionMensual;
    }

    public void setTasaAnual(float tasaAnual) {
        this.tasaAnual = tasaAnual;
    }

    public void setComisionMensual(float comisionMensual) {
        this.comisionMensual = comisionMensual;
    }
}