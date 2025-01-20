package org.reyestech24;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class CuentaCorrienteTest {
    private CuentaCorriente cuentaCorriente;

    @BeforeEach
    void inicio() {
        // Given: Una cuenta corriente con saldo inicial y tasa anual
         cuentaCorriente= new CuentaCorriente(500, 5);
    }

    @Test
    void testRetiroDentroDeSaldo() {
        // Given: Una cuenta con saldo de 500

        // When: Se retiran 300
        cuentaCorriente.retirar(300);

        // Then: El saldo debe ser 200
        assertEquals(200, cuentaCorriente.getSaldo(), "El saldo debería ser 200 después de retirar 300");
    }

}