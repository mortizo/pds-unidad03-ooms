package p69.state;

import java.util.Objects;

/** Context del UML: delega el comportamiento en el estado actual. */
public class CertificadoContext {
    private CertificadoState estadoCertificado;

    public CertificadoContext() {
        estadoCertificado = new Iniciado();
    }

    /**
     * Cambio explicito para la demostracion: el UML no establece reglas de
     * transicion. Consultar o generar no cambia automaticamente el estado.
     */
    public void setEstadoCertificado(CertificadoState estadoCertificado) {
        this.estadoCertificado = Objects.requireNonNull(estadoCertificado,
                "El estado es obligatorio");
    }

    public String crearCertificado() {
        return estadoCertificado.generarDocumento();
    }

    public String visualizarDocumento() {
        return estadoCertificado.visualizarDocumento();
    }

    public String descargarDocumento() {
        return estadoCertificado.descargarDocumento();
    }
}
