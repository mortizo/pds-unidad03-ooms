package p69.strategy;

import java.math.BigDecimal;

/** Cliente: selecciona y cambia las estrategias sobre el mismo contexto. */
public class Principal {
    public static void main(String[] args) {
        MatriculaContext contexto = new MatriculaContext(new MatriculaGrado());
        mostrar("Grado, 1 cuota", contexto, 1, 2);
        contexto.setEstrategia(new MatriculaPosGrado());
        mostrar("Posgrado, 2 cuotas", contexto, 2, 1);
        mostrar("Posgrado, 3 cuotas", contexto, 3, 1);
        contexto.setEstrategia(new MatriculaTecnologia());
        mostrar("Tecnologia, primer ciclo", contexto, 1, 1);
        mostrar("Tecnologia, segundo ciclo", contexto, 1, 2);
    }

    private static void mostrar(String caso, MatriculaContext contexto, int cuotas, int ciclo) {
        DatosMatricula datos = new DatosMatricula(new BigDecimal("100.00"), cuotas, ciclo);
        BigDecimal descuento = contexto.ejecutarEstrategia(datos);
        System.out.println(caso + " | Cuota: " + datos.getValorCuota()
                + " | Descuento por cuota: " + descuento
                + " | Neto por cuota: " + datos.getValorCuota().subtract(descuento));
    }
}
