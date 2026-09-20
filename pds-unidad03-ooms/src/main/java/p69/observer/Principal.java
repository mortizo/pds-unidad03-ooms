package p69.observer;

/** Demostracion por consola, sin MVC ni integraciones externas. */
public class Principal {
    public static void main(String[] args) {
        Factura factura = new Factura();
        ServicioCliente servicioCliente = new ServicioCliente();
        Despacho despacho = new Despacho();
        Contabilidad contabilidad = new Contabilidad();

        factura.attach(servicioCliente);
        factura.attach(despacho);
        factura.attach(contabilidad);

        System.out.println("Factura creada, pagada: " + factura.isFacturaPagada());
        mostrar(servicioCliente, despacho, contabilidad);

        System.out.println("\nLa factura cambia a pagada:");
        factura.setFacturaPagada(true);
        mostrar(servicioCliente, despacho, contabilidad);

        System.out.println("\nContabilidad se desuscribe y el pago se revierte:");
        factura.detach(contabilidad);
        factura.setFacturaPagada(false);
        mostrar(servicioCliente, despacho, contabilidad);
    }

    private static void mostrar(ServicioCliente servicioCliente,
            Despacho despacho, Contabilidad contabilidad) {
        System.out.println(servicioCliente);
        System.out.println(despacho);
        System.out.println(contabilidad);
    }
}
