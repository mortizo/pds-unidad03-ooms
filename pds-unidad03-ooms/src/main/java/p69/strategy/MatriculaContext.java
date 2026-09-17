package p69.strategy;

import java.math.BigDecimal;
import java.util.Objects;

/** Context: delega en una estrategia intercambiable; no decide las politicas. */
public class MatriculaContext {
    private MatriculaStrategy estrategia;

    public MatriculaContext(MatriculaStrategy estrategia) {
        setEstrategia(estrategia);
    }

    public void setEstrategia(MatriculaStrategy estrategia) {
        this.estrategia = Objects.requireNonNull(estrategia, "La estrategia es obligatoria");
    }

    public BigDecimal ejecutarEstrategia(BigDecimal valorCuota, int cuotasPagadas, int ciclo) {
        MatriculaStrategy.validarDatos(valorCuota, cuotasPagadas, ciclo);
        return estrategia.calcularDescuentoProntoPago(valorCuota, cuotasPagadas, ciclo);
    }
}
