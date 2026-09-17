package p69.strategy;

import java.math.BigDecimal;
import java.util.Objects;

/** ConcreteStrategy. Posgrado: 15 % desde tres cuotas; con una o dos no hay descuento. */
public class MatriculaPosGrado implements MatriculaStrategy {
    @Override
    public BigDecimal calcularDescuentoProntoPago(DatosMatricula datos) {
        Objects.requireNonNull(datos, "Los datos son obligatorios");
        return datos.descuento(datos.getCuotasPagadas() >= 3 ? new BigDecimal("0.15") : BigDecimal.ZERO);
    }
}
