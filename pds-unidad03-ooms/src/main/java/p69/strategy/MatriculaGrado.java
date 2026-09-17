package p69.strategy;

import java.math.BigDecimal;
import java.util.Objects;

/** ConcreteStrategy. Grado: 10 % independientemente del numero de cuotas pagadas. */
public class MatriculaGrado implements MatriculaStrategy {
    @Override
    public BigDecimal calcularDescuentoProntoPago(DatosMatricula datos) {
        Objects.requireNonNull(datos, "Los datos son obligatorios");
        return datos.descuento(new BigDecimal("0.10"));
    }
}
