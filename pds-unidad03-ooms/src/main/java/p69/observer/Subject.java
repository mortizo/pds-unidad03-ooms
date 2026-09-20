package p69.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** Subject del UML: administra la coleccion de observadores. */
public abstract class Subject {
    private final List<PagoFactura> observadores = new ArrayList<>();

    public void attach(PagoFactura pagoFactura) {
        PagoFactura observador = Objects.requireNonNull(pagoFactura,
                "El observador es obligatorio");
        if (!observadores.contains(observador)) {
            observadores.add(observador);
        }
    }

    public void detach(PagoFactura pagoFactura) {
        observadores.remove(pagoFactura);
    }

    protected final List<PagoFactura> getObservadores() {
        return new ArrayList<>(observadores);
    }

    public abstract void notificar();
}
