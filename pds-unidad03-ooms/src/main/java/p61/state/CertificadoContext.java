package p61.state;

/**
 *
 * @author Mauricio Ortiz Ochoa
 */
public class CertificadoContext {

    private CertificadoState estadoCertificado;

    public CertificadoContext() {
        this.estadoCertificado = new Iniciado(this);
    }

    public CertificadoState getEstadoCertificado() {
        return estadoCertificado;
    }

    public void setEstadoCertificado(CertificadoState estadoCertificado) {
        this.estadoCertificado = estadoCertificado;
    }

    
}
