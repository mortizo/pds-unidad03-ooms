package p69.strategy;

import java.math.BigDecimal;
import java.util.Objects;

/** ConcreteStrategy. Tecnologia: 10 % solo para asignaturas del primer ciclo. */
public class MatriculaTecnologia implements MatriculaStrategy {
    @Override
    public BigDecimal calcularDescuentoProntoPago(DatosMatricula datos) {
        Objects.requireNonNull(datos, "Los datos son obligatorios");
        return datos.descuento(datos.getCiclo() == 1 ? new BigDecimal("0.10") : BigDecimal.ZERO);
    }
}
