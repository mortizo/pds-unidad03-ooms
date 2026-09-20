package p69.state;

/** Cliente de consola: mismas operaciones sobre el mismo contexto. */
public class Principal {
    public static void main(String[] args) {
        CertificadoContext certificado = new CertificadoContext();
        mostrar("Iniciado", certificado);
        certificado.setEstadoCertificado(new EnTramite());
        mostrar("En tramite", certificado);
        certificado.setEstadoCertificado(new Firmado());
        mostrar("Firmado", certificado);
    }

    private static void mostrar(String estado, CertificadoContext certificado) {
        System.out.println("\n=== " + estado + " (simulacion) ===");
        System.out.println(certificado.crearCertificado());
        System.out.println(certificado.visualizarDocumento());
        System.out.println(certificado.descargarDocumento());
    }
}
