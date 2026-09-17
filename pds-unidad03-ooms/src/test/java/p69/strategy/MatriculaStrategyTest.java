package p69.strategy;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

class MatriculaStrategyTest {
    private final BigDecimal valorCuota = new BigDecimal("100.00");

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 5})
    void gradoNoDependeDeCuotas(int cuotas) {
        assertEquals(new BigDecimal("10.00"),
                new MatriculaGrado().calcularDescuentoProntoPago(valorCuota, cuotas, 2));
    }

    @ParameterizedTest
    @CsvSource({"1,0.00", "2,0.00", "3,15.00", "4,15.00"})
    void posgradoRespetaUmbral(int cuotas, String esperado) {
        assertEquals(new BigDecimal(esperado),
                new MatriculaPosGrado().calcularDescuentoProntoPago(valorCuota, cuotas, 1));
    }

    @ParameterizedTest
    @CsvSource({"1,10.00", "2,0.00", "3,0.00"})
    void tecnologiaDependeDelCiclo(int ciclo, String esperado) {
        assertEquals(new BigDecimal(esperado),
                new MatriculaTecnologia().calcularDescuentoProntoPago(valorCuota, 1, ciclo));
    }

    @Test
    void intercambiaEstrategiasEnElMismoContexto() {
        MatriculaContext contexto = new MatriculaContext(new MatriculaGrado());
        assertEquals(new BigDecimal("10.00"), contexto.ejecutarEstrategia(valorCuota, 3, 2));
        contexto.setEstrategia(new MatriculaPosGrado());
        assertEquals(new BigDecimal("15.00"), contexto.ejecutarEstrategia(valorCuota, 3, 2));
        contexto.setEstrategia(new MatriculaTecnologia());
        assertEquals(new BigDecimal("0.00"), contexto.ejecutarEstrategia(valorCuota, 3, 2));
    }

    @Test
    void admiteNuevaEstrategiaSinModificarContexto() {
        int[] llamadas = {0};
        MatriculaContext contexto = new MatriculaContext((cuota, cuotas, ciclo) -> {
            assertSame(valorCuota, cuota);
            assertEquals(3, cuotas);
            assertEquals(2, ciclo);
            llamadas[0]++;
            return new BigDecimal("7.00");
        });
        assertEquals(new BigDecimal("7.00"), contexto.ejecutarEstrategia(valorCuota, 3, 2));
        assertEquals(1, llamadas[0]);
    }

    @Test
    void redondeaMitadHaciaArribaACentavos() {
        assertEquals(new BigDecimal("1.01"), new MatriculaGrado()
                .calcularDescuentoProntoPago(new BigDecimal("10.05"), 1, 1));
    }

    @Test
    void admiteCuotaCero() {
        for (MatriculaStrategy estrategia : new MatriculaStrategy[]{
                new MatriculaGrado(), new MatriculaPosGrado(), new MatriculaTecnologia()}) {
            assertEquals(new BigDecimal("0.00"), estrategia.calcularDescuentoProntoPago(
                    BigDecimal.ZERO, 3, 1));
        }
    }

    @Test
    void rechazaDatosInvalidos() {
        for (MatriculaStrategy estrategia : new MatriculaStrategy[]{
                new MatriculaGrado(), new MatriculaPosGrado(), new MatriculaTecnologia()}) {
            assertThrows(NullPointerException.class,
                    () -> estrategia.calcularDescuentoProntoPago(null, 1, 1));
            assertThrows(IllegalArgumentException.class,
                    () -> estrategia.calcularDescuentoProntoPago(new BigDecimal("-1"), 1, 1));
            assertThrows(IllegalArgumentException.class,
                    () -> estrategia.calcularDescuentoProntoPago(BigDecimal.TEN, 0, 1));
            assertThrows(IllegalArgumentException.class,
                    () -> estrategia.calcularDescuentoProntoPago(BigDecimal.TEN, 1, 0));
        }
    }

    @Test
    void rechazaNulosSinPerderEstrategiaAnterior() {
        assertThrows(NullPointerException.class, () -> new MatriculaContext(null));
        MatriculaContext contexto = new MatriculaContext(new MatriculaGrado());
        assertThrows(NullPointerException.class, () -> contexto.setEstrategia(null));
        assertEquals(new BigDecimal("10.00"), contexto.ejecutarEstrategia(valorCuota, 1, 1));
        assertThrows(NullPointerException.class, () -> contexto.ejecutarEstrategia(null, 1, 1));
        for (MatriculaStrategy estrategia : new MatriculaStrategy[]{
                new MatriculaGrado(), new MatriculaPosGrado(), new MatriculaTecnologia()}) {
            assertThrows(NullPointerException.class,
                    () -> estrategia.calcularDescuentoProntoPago(null, 1, 1));
        }
    }
}
