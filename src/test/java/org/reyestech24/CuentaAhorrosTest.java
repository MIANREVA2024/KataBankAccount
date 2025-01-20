package org.reyestech24;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class CuentaAhorrosTest {
    private CuentaAhorros cuentaAhorros;

    @BeforeEach
    void inicio() {
        //Given: debe inicializar con los atributos saldo inicial  y tasa anual
        cuentaAhorros = new CuentaAhorros(12000, 5);
    }

    @Test
    void testCuentaActivaAlCrear() {
        boolean activa = cuentaAhorros.estaActiva();
        assertTrue(activa, "La cuenta debe estar activa con saldo inicial >= 10000");
    }

    @Test
    void testConsignarEnCuentaActiva() {

        cuentaAhorros.consignar(3000);

        assertEquals(15000, cuentaAhorros.getSaldo(), "El saldo deberia ssr 15000");
    }

    @Test
    void testRetirarEnCuentaActiva() {

        //When: se retirara 5000
        cuentaAhorros.retirar(5000);

        //Then: el saldo debe disminuir
        assertEquals(7000, cuentaAhorros.getSaldo(), "El saldo deberia ser 7000");
    }

    }