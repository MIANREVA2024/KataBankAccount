package org.reyestech24;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class CuentaAhorrosTest {
    private CuentaAhorros cuentaAhorros;

   @BeforeEach
   void inicio(){
       //Given: debe inicializar con los atributos saldo y tasa anual
       cuentaAhorros = new CuentaAhorros(12000, 5);
   }

    @Test
    void consignar() {
    }

    @Test
    void retirar() {
    }

    @Test
    void extractoMensual() {
    }

    @Test
    void imprimir() {
    }

    @Test
    void estaActiva() {
    }
}