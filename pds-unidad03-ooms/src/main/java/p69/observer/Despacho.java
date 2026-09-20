package p69.observer;

/** ConcreteObserver: inicia o cancela el proceso de envio. */
public class Despacho implements PagoFactura {
    private boolean despachoIniciado;

    @Override
    public void updatePago(boolean estadoPago) {
        despachoIniciado = estadoPago;
    }

    public boolean isDespachoIniciado() {
        return despachoIniciado;
    }

    @Override
    public String toString() {
        return "Despacho{despachoIniciado=" + despachoIniciado + '}';
    }
}
