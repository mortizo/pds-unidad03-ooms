package p69.observer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FacturaTest {
    @Test
    void iniciaNoPagadaYSinAccionesEjecutadas() {
        Factura factura = new Factura();
        ServicioCliente servicio = new ServicioCliente();
        Despacho despacho = new Despacho();
        Contabilidad contabilidad = new Contabilidad();
        factura.attach(servicio);
        factura.attach(despacho);
        factura.attach(contabilidad);

        assertFalse(factura.isFacturaPagada());
        assertFalse(servicio.isSeguimientoIniciado());
        assertFalse(despacho.isDespachoIniciado());
        assertFalse(contabilidad.isPagoMayorizado());
    }

    @Test
    void notificaATodosCuandoLaFacturaSePaga() {
        Factura factura = new Factura();
        ServicioCliente servicio = new ServicioCliente();
        Despacho despacho = new Despacho();
        Contabilidad contabilidad = new Contabilidad();
        factura.attach(servicio);
        factura.attach(despacho);
        factura.attach(contabilidad);

        factura.setFacturaPagada(true);

        assertTrue(servicio.isSeguimientoIniciado());
        assertTrue(despacho.isDespachoIniciado());
        assertTrue(contabilidad.isPagoMayorizado());
    }

    @Test
    void propagaTambienLaReversionDelPago() {
        Factura factura = new Factura();
        ServicioCliente servicio = new ServicioCliente();
        Despacho despacho = new Despacho();
        Contabilidad contabilidad = new Contabilidad();
        factura.attach(servicio);
        factura.attach(despacho);
        factura.attach(contabilidad);
        factura.setFacturaPagada(true);

        factura.setFacturaPagada(false);

        assertFalse(servicio.isSeguimientoIniciado());
        assertFalse(despacho.isDespachoIniciado());
        assertFalse(contabilidad.isPagoMayorizado());
    }

    @Test
    void observadorDesuscritoYaNoRecibeCambios() {
        Factura factura = new Factura();
        Contabilidad contabilidad = new Contabilidad();
        factura.attach(contabilidad);
        factura.setFacturaPagada(true);
        factura.detach(contabilidad);

        factura.setFacturaPagada(false);

        assertTrue(contabilidad.isPagoMayorizado());
    }

    @Test
    void noRegistraDosVecesElMismoObservador() {
        Factura factura = new Factura();
        int[] actualizaciones = {0};
        PagoFactura observador = pagada -> actualizaciones[0]++;
        factura.attach(observador);
        factura.attach(observador);

        factura.setFacturaPagada(true);

        assertEquals(1, actualizaciones[0]);
    }

    @Test
    void noNotificaSiElEstadoNoCambio() {
        Factura factura = new Factura();
        int[] actualizaciones = {0};
        factura.attach(pagada -> actualizaciones[0]++);

        factura.setFacturaPagada(false);
        factura.setFacturaPagada(true);
        factura.setFacturaPagada(true);

        assertEquals(1, actualizaciones[0]);
    }

    @Test
    void permiteDesuscribirseDuranteLaNotificacion() {
        Factura factura = new Factura();
        int[] actualizaciones = {0};
        PagoFactura observador = pagada -> actualizaciones[0]++;
        PagoFactura seDesuscribe = new PagoFactura() {
            @Override
            public void updatePago(boolean pagada) {
                actualizaciones[0]++;
                factura.detach(this);
            }
        };
        factura.attach(seDesuscribe);
        factura.attach(observador);

        assertDoesNotThrow(() -> factura.setFacturaPagada(true));
        factura.setFacturaPagada(false);

        assertEquals(3, actualizaciones[0]);
    }

    @Test
    void rechazaObservadorNulo() {
        Factura factura = new Factura();
        assertThrows(NullPointerException.class, () -> factura.attach(null));
    }
}
