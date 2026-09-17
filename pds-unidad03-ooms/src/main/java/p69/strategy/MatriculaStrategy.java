package p69.strategy;

import java.math.BigDecimal;

/** Strategy: contrato comun para las politicas de descuento. */
public interface MatriculaStrategy {
    BigDecimal calcularDescuentoProntoPago(BigDecimal valorCuota, int cuotasPagadas, int ciclo);
    
    /** Validacion comun, sin agregar clases al modelo. */
    static void validarDatos(BigDecimal valorCuota, int cuotasPagadas, int ciclo) {
        java.util.Objects.requireNonNull(valorCuota, "El valor de la cuota es obligatorio");
        if (valorCuota.signum() < 0 || cuotasPagadas < 1 || ciclo < 1) {
            throw new IllegalArgumentException(
                    "La cuota no puede ser negativa; cuotas y ciclo deben ser positivos");
        }
    }
}
