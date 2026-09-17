package p69.strategy;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

/** Datos de una cuota de una asignatura; no representan el total de la matricula. */
public final class DatosMatricula {
    private final BigDecimal valorCuota;
    private final int cuotasPagadas;
    private final int ciclo;

    public DatosMatricula(BigDecimal valorCuota, int cuotasPagadas, int ciclo) {
        Objects.requireNonNull(valorCuota, "El valor de la cuota es obligatorio");
        if (valorCuota.signum() < 0 || cuotasPagadas < 1 || ciclo < 1) {
            throw new IllegalArgumentException("La cuota no puede ser negativa; cuotas y ciclo deben ser positivos");
        }
        this.valorCuota = valorCuota;
        this.cuotasPagadas = cuotasPagadas;
        this.ciclo = ciclo;
    }

    public BigDecimal getValorCuota() { return valorCuota; }
    public int getCuotasPagadas() { return cuotasPagadas; }
    public int getCiclo() { return ciclo; }

    /** Importe del descuento por cuota, redondeado a centavos. */
    BigDecimal descuento(BigDecimal tasa) {
        return valorCuota.multiply(tasa).setScale(2, RoundingMode.HALF_UP);
    }
}
