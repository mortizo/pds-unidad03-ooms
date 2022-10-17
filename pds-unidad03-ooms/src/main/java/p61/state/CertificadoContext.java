package p61.state;

/**
 *
 * @author Mauricio Ortiz Ochoa
 */
public class CertificadoContext {

    private CertificadoState estadoCertificado;

    public CertificadoContext(CertificadoState estadoCertificado) {
        this.estadoCertificado = estadoCertificado;
    }

    public void crearCertificado() {
        System.out.println("Estado 1");
        System.out.println(this.estadoCertificado.descargarDocumento());
        System.out.println("Estado 2");
        this.estadoCertificado = new EnTramite();
        System.out.println(this.estadoCertificado.descargarDocumento());
        System.out.println("Estado 3");
        this.estadoCertificado = new Firmado();
        System.out.println(this.estadoCertificado.descargarDocumento());
    }

}
