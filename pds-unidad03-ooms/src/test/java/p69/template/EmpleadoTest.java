package p69.template;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

class EmpleadoTest {
    private static final double DELTA = 0.000001;

    @ParameterizedTest
    @CsvSource({"0,0,0,5", "1,10,0.9,14.1", "40,400,36,369", "160,1600,144,1461"})
    void calculaFijo(int horas, double basico, double descuento, double sueldo) {
        Empleado empleado = new Fijo(horas);
        assertEquals(basico, empleado.calcularBasico(), DELTA);
        assertEquals(5.0, empleado.calcularExtra(), DELTA);
        assertEquals(descuento, empleado.calcularDescuento(), DELTA);
        assertEquals(sueldo, empleado.calcularSueldo(), DELTA);
    }

    @ParameterizedTest
    @CsvSource({"0,0", "1,12", "40,480", "160,1920"})
    void calculaTemporal(int horas, double sueldo) {
        Empleado empleado = new Temporal(horas);
        assertEquals(sueldo, empleado.calcularBasico(), DELTA);
        assertEquals(0.0, empleado.calcularExtra(), DELTA);
        assertEquals(0.0, empleado.calcularDescuento(), DELTA);
        assertEquals(sueldo, empleado.calcularSueldo(), DELTA);
    }

    @Test
    void ejecutaCadaPasoUnaVezYEnOrden() {
        List<String> pasos = new ArrayList<>();
        Empleado empleado = new Empleado(1) {
            @Override
            public double calcularBasico() {
                pasos.add("basico");
                return 100;
            }
            @Override
            public double calcularExtra() {
                pasos.add("extra");
                return 20;
            }
            @Override
            public double calcularDescuento() {
                pasos.add("descuento");
                return 9;
            }
        };
        assertEquals(111.0, empleado.calcularSueldo(), DELTA);
        assertEquals(Arrays.asList("basico", "extra", "descuento"), pasos);
    }

    @Test
    void metodoPlantillaEsFinal() throws NoSuchMethodException {
        assertTrue(Modifier.isFinal(Empleado.class.getMethod("calcularSueldo").getModifiers()));
    }

    @Test
    void rechazaHorasNegativas() {
        assertThrows(IllegalArgumentException.class, () -> new Fijo(-1));
        assertThrows(IllegalArgumentException.class, () -> new Temporal(-1));
    }

    @Test
    void repetirCalculoNoAcumulaValores() {
        Empleado fijo = new Fijo(40);
        Empleado temporal = new Temporal(40);
        assertEquals(fijo.calcularSueldo(), fijo.calcularSueldo(), DELTA);
        assertEquals(temporal.calcularSueldo(), temporal.calcularSueldo(), DELTA);
    }
}
