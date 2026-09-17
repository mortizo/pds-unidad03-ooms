package p69.strategy;

import java.math.BigDecimal;
import java.math.RoundingMode;

/** ConcreteStrategy. Posgrado: 15 % desde tres cuotas; con una o dos no hay descuento. */
public class MatriculaPosGrado implements MatriculaStrategy {
    @Override
    public BigDecimal calcularDescuentoProntoPago(BigDecimal valorCuota, int cuotasPagadas, int ciclo) {
        MatriculaStrategy.validarDatos(valorCuota, cuotasPagadas, ciclo);
        return valorCuota.multiply(cuotasPagadas >= 3 ? new BigDecimal("0.15") : BigDecimal.ZERO).setScale(2, RoundingMode.HALF_UP);
    }
}
