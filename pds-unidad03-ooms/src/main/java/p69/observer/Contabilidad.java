package p69.observer;

/** ConcreteObserver: registra o revierte la mayorizacion del pago. */
public class Contabilidad implements PagoFactura {
    private boolean pagoMayorizado;

    @Override
    public void updatePago(boolean estadoPago) {
        pagoMayorizado = estadoPago;
    }

    public boolean isPagoMayorizado() {
        return pagoMayorizado;
    }

    @Override
    public String toString() {
        return "Contabilidad{pagoMayorizado=" + pagoMayorizado + '}';
    }
}
