package p69.state;

/** Estado concreto EnTramite. Todas las operaciones son simuladas. */
public class EnTramite implements CertificadoState {
    @Override
    public String visualizarDocumento() {
        return "Visualizando documento con marca de agua.";
    }

    @Override
    public String generarDocumento() {
        return "El documento ya fue generado y esta en tramite.";
    }

    @Override
    public String descargarDocumento() {
        return "Descargando version provisional del documento.";
    }
}
