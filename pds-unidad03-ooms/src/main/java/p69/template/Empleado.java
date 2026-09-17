package p69.template;

/** Clase abstracta del UML: fija la secuencia del calculo del sueldo. */
public abstract class Empleado {
    private final int horasTrabajadas;

    protected Empleado(int horasTrabajadas) {
        if (horasTrabajadas < 0) {
            throw new IllegalArgumentException("Las horas trabajadas no pueden ser negativas");
        }
        this.horasTrabajadas = horasTrabajadas;
    }

    protected int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    /** Template Method: las subclases no pueden cambiar este orden. */
    public final double calcularSueldo() {
        double basico = calcularBasico();
        double extra = calcularExtra();
        double descuento = calcularDescuento();
        return basico + extra - descuento;
    }

    public abstract double calcularBasico();
    public abstract double calcularExtra();
    public abstract double calcularDescuento();
}
