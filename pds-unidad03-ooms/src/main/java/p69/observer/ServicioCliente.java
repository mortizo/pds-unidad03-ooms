package p69.observer;

/** ConcreteObserver: inicia o cancela el seguimiento del pedido. */
public class ServicioCliente implements PagoFactura {
    private boolean seguimientoIniciado;

    @Override
    public void updatePago(boolean estadoPago) {
        seguimientoIniciado = estadoPago;
    }

    public boolean isSeguimientoIniciado() {
        return seguimientoIniciado;
    }

    @Override
    public String toString() {
        return "ServicioCliente{seguimientoIniciado=" + seguimientoIniciado + '}';
    }
}
