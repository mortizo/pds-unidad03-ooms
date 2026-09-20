package p69.observer;

/** ConcreteSubject: notifica cuando cambia su estado de pago. */
public class Factura extends Subject {
    private boolean facturaPagada;

    @Override
    public void attach(PagoFactura pagoFactura) {
        super.attach(pagoFactura);
    }

    @Override
    public void detach(PagoFactura pagoFactura) {
        super.detach(pagoFactura);
    }

    @Override
    public void notificar() {
        for (PagoFactura observador : getObservadores()) {
            observador.updatePago(facturaPagada);
        }
    }

    public boolean isFacturaPagada() {
        return facturaPagada;
    }

    public void setFacturaPagada(boolean facturaPagada) {
        if (this.facturaPagada != facturaPagada) {
            this.facturaPagada = facturaPagada;
            notificar();
        }
    }
}
