package p69.template;

/** Reglas didacticas de la diapositiva, no una liquidacion laboral real. */
public class Fijo extends Empleado {
    public Fijo(int horasTrabajadas) {
        super(horasTrabajadas);
    }

    @Override
    public double calcularBasico() {
        return getHorasTrabajadas() * 10.0;
    }

    @Override
    public double calcularExtra() {
        return 5.0;
    }

    @Override
    public double calcularDescuento() {
        // El 9 % se aplica solo al basico, no al bono.
        return getHorasTrabajadas() * 10.0 * 0.09;
    }
}
