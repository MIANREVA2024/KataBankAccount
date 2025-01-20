package org.reyestech24;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class CuentaBancariaTest {
    private CuentaBancaria cuentaBancaria;

   @BeforeEach
   void inicio(){
       //Given: Saldo inicial de 10000 y tasa de 4% anual
       cuentaBancaria = new CuentaBancaria(10000, 4);
   }

    @Test
    void testConsignarCantidadPositiva() {
        //Given: una cuenta inicial con saldo de 10000
        float cantidad = 2000;

        //When: consignamos una cantidad positiva
        cuentaBancaria.consignar(cantidad);

        //Then: Aca es donde el saldo debe aumentar en 2000 y el numero de consignaciones debe incrementar
        assertEquals(12000, cuentaBancaria.getSaldo(), "El saldo deberia ser 12000 despues de consignar");
        assertEquals(1,cuentaBancaria.getNumeroConsignaciones(), "El numero de consignaciones deberia ser 1");
    }

    @Test
    void testConsignarCantidadNegativa(){
         //Given: una cuenta inicial con saldo de 10000
        float cantidad = -500;

        //When: cuando intentamos consignar una cantidad negativa
        cuentaBancaria.consignar(cantidad);

        //Then: El saldo y numero de consignaciones no debe de cambiar
        assertEquals(10000, cuentaBancaria.getSaldo(),"El saldo no debe de cambiar");
        assertEquals(0, cuentaBancaria.getNumeroConsignaciones(),"El numero de consignaciones no deberia de cambiar");
    }

    @Test
    void testRetirarCantidadNegativa(){
        //Given: una cuenta con saldo inicial de 10000
        float cantidad = -5000;

        //When: Intentamos retirar mas dinero de lo que hay disponible
        cuentaBancaria.retirar(cantidad);

        //Then: El retiro y numero de consignaciones no debe de cambiar

        assertEquals(10000,cuentaBancaria.getSaldo(),"El saldo no debe de cambiar");
        assertEquals(0,cuentaBancaria.getNumeroRetiros(),"El numero de retiros no debe de cambiar");

    }

    @Test
    void testRetirarCantidadDentroDelSaldo() {
       //Given: una cuenta con saldo inicial  de 10000
        float cantidad = 3000;

        //When: Retiramos una cantidad menor que el saldo.
        cuentaBancaria.retirar(cantidad);

        //Then: Aca el saldo mostrara una disminucion de 3000 y el numero de retiros  debe aumentar
        assertEquals(7000,cuentaBancaria.getSaldo(), "El saldo deberia ser 7000");
        assertEquals(1,cuentaBancaria.getNumeroRetiros(),"El numero de retiros deberia ser 1");
    }

    @Test
    void testRetirarCantidadMayorAlSaldo(){
       //Given: una cuenta con saldo inicial de 10000
        float cantidad = 15000;

        //When: Intentamos retirar mas dinero de lo que hay disponible
        cuentaBancaria.retirar(cantidad);

        //Then: El retiro y numero de consignaciones no debe de cambiar

        assertEquals(10000,cuentaBancaria.getSaldo(),"El saldo no debe de cambiar");
        assertEquals(0,cuentaBancaria.getNumeroRetiros(),"El numero de retiros no debe de cambiar");

    }

    @Test
    void testCalcularInteresMensual() {
       //Given: Saldo inicial de 10000 y tasa de 4% anual

        float saldoNuevo = 10000 + (10000 * (4 / 12.0f) / 100);
        //float interesMensual = (tasaAnual / 12) / 100 * saldo;

        //When: Se calcula el interes mensual
        cuentaBancaria.calcularInteresMensual();

        //Then: El saldo debe incluir el interes mensual
        assertEquals(saldoNuevo, cuentaBancaria.getSaldo(),0.01,"El saldo debe de incluir el interes mensual calculado");
    }

    @Test
    void testExtractoMensual() {
       //Given: cuenta inicial de 10000 y una comision mensual de 100 y una taza anual de 4%
        cuentaBancaria.setComisionMensual(500);
        float saldoNuevo = (10000 - 500) + ((10000 - 500) * (4 / 12.0f) / 100);

        //When: Se genera el extracto mensual
        cuentaBancaria.extractoMensual();

        //Then: El saldo debe mostrar la deduccion de la comision y el interes mensual que se aplico.
        assertEquals(saldoNuevo, cuentaBancaria.getSaldo(), 0.01, "El saldo debe mostrar la comision y el interes mensual");
    }
    /*
    @Test
    void restarComisionMensual() {
    }
     */

    @Test
    void testImprimirEstadoDeCuenta() {
        //Given: una cuenta con saldo inicial de 10000 y tasa de 4% anual

        //When: Se imprime el estado de cuenta
        String estado = cuentaBancaria.imprimir();

        //Then: El estado debe tener toda la informacion
        assertTrue(estado.contains("Saldo: 10000"),"El estado deberia mostrar el saldo correcto");
        assertTrue(estado.contains("Tasa anual: 4.0%"),"El estado deberia mostrar la tasa anualcorrecta");
    }
}