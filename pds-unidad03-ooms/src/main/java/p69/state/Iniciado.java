package p69.state;

/** Estado concreto Iniciado. Todas las operaciones son simuladas. */
public class Iniciado implements CertificadoState {
    @Override
    public String visualizarDocumento() {
        return "Visualizacion no disponible: el certificado esta iniciado.";
    }

    @Override
    public String generarDocumento() {
        return "Documento generado; pendiente de tramite.";
    }

    @Override
    public String descargarDocumento() {
        return "Descarga no disponible: el certificado esta iniciado.";
    }
}
