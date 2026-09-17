package p69.template;

/** Empleado temporal: 12 por hora, sin bono ni descuento. */
public class Temporal extends Empleado {
    public Temporal(int horasTrabajadas) {
        super(horasTrabajadas);
    }

    @Override
    public double calcularBasico() {
        return getHorasTrabajadas() * 12.0;
    }

    @Override
    public double calcularExtra() {
        return 0.0;
    }

    @Override
    public double calcularDescuento() {
        return 0.0;
    }
}
