package p69.strategy;

import java.math.BigDecimal;
import java.math.RoundingMode;

/** ConcreteStrategy. Tecnologia: 10 % solo para asignaturas del primer ciclo. */
public class MatriculaTecnologia implements MatriculaStrategy {
    @Override
    public BigDecimal calcularDescuentoProntoPago(BigDecimal valorCuota, int cuotasPagadas, int ciclo) {
        MatriculaStrategy.validarDatos(valorCuota, cuotasPagadas, ciclo);
        return valorCuota.multiply(ciclo == 1 ? new BigDecimal("0.10") : BigDecimal.ZERO).setScale(2, RoundingMode.HALF_UP);
    }
}
