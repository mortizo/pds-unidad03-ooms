package p69.state;

/** State del UML. Devuelve mensajes de simulacion, no archivos reales. */
public interface CertificadoState {
    String visualizarDocumento();
    String generarDocumento();
    String descargarDocumento();
}
