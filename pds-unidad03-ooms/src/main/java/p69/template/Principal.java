package p69.template;

import java.util.Locale;

/** Demostracion por consola, sin MVC. */
public class Principal {
    public static void main(String[] args) {
        System.out.println("Template Method - ejemplo didactico con 40 horas");
        mostrar("Fijo", new Fijo(40));
        mostrar("Temporal", new Temporal(40));
    }

    private static void mostrar(String tipo, Empleado empleado) {
        System.out.printf(Locale.ROOT,
                "%s | Basico: %.2f | Extra: %.2f | Descuento: %.2f | Sueldo: %.2f%n",
                tipo, empleado.calcularBasico(), empleado.calcularExtra(),
                empleado.calcularDescuento(), empleado.calcularSueldo());
    }
}
