package p69.strategy;

import java.math.BigDecimal;
import java.math.RoundingMode;

/** ConcreteStrategy. Grado: 10 % independientemente del numero de cuotas pagadas. */
public class MatriculaGrado implements MatriculaStrategy {
    @Override
    public BigDecimal calcularDescuentoProntoPago(BigDecimal valorCuota, int cuotasPagadas, int ciclo) {
        MatriculaStrategy.validarDatos(valorCuota, cuotasPagadas, ciclo);
        return valorCuota.multiply(new BigDecimal("0.10")).setScale(2, RoundingMode.HALF_UP);
    }
}
