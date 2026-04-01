package ar.unrn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


/**
 * El nombre tiene que ser el mismo que la clase que testea
 * terminando con `Test` para funcionar.
 * Este conjunto de casos es una plantilla.
 */
@DisplayName("Ejercicio 1")
class TelemetriaAppTest {

    /**
     * Este caso es una plantilla.
     */
    @Test
    @DisplayName("Division por Cero")
    void testPlantilla()
    {
        String[] lecturas = {"123","345","0","12"};
        String[] factores = {"45","22","11", "0",};
        String[] salida = {"2","15","0","ERR_DIV_ZERO"};
        String mensaje = "ERR_DIV_ZERO";
        String[] resultado = TelemetriaApp.normalizarTelemetria(lecturas,factores,4);
        Assertions.assertArrayEquals(resultado, salida);
        Assertions.assertArrayEquals(mensaje, resultado[3]);
    }
}
