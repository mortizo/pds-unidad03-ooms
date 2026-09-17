package p69.strategy;

import java.math.BigDecimal;

/** Strategy: contrato comun para las politicas de descuento. */
public interface MatriculaStrategy {
    BigDecimal calcularDescuentoProntoPago(DatosMatricula datos);
}
