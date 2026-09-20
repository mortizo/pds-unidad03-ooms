package p69.state;

/** Estado concreto Firmado. Todas las operaciones son simuladas. */
public class Firmado implements CertificadoState {
    @Override
    public String visualizarDocumento() {
        return "Visualizando documento final firmado.";
    }

    @Override
    public String generarDocumento() {
        return "El documento ya esta firmado; no se regenera.";
    }

    @Override
    public String descargarDocumento() {
        return "Descargando documento final firmado.";
    }
}
