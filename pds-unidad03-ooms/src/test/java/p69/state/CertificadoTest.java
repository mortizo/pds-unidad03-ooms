package p69.state;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CertificadoTest {
    @Test
    void iniciaConGeneracionPermitidaYConsultasBloqueadas() {
        CertificadoContext contexto = new CertificadoContext();
        assertEquals("Documento generado; pendiente de tramite.", contexto.crearCertificado());
        assertEquals("Visualizacion no disponible: el certificado esta iniciado.",
                contexto.visualizarDocumento());
        assertEquals("Descarga no disponible: el certificado esta iniciado.",
                contexto.descargarDocumento());
    }

    @Test
    void enTramiteMuestraMarcaDeAguaYDescargaProvisional() {
        CertificadoContext contexto = new CertificadoContext();
        contexto.setEstadoCertificado(new EnTramite());
        assertEquals("El documento ya fue generado y esta en tramite.", contexto.crearCertificado());
        assertEquals("Visualizando documento con marca de agua.", contexto.visualizarDocumento());
        assertEquals("Descargando version provisional del documento.", contexto.descargarDocumento());
    }

    @Test
    void firmadoPermiteDocumentoFinal() {
        CertificadoContext contexto = new CertificadoContext();
        contexto.setEstadoCertificado(new Firmado());
        assertEquals("El documento ya esta firmado; no se regenera.", contexto.crearCertificado());
        assertEquals("Visualizando documento final firmado.", contexto.visualizarDocumento());
        assertEquals("Descargando documento final firmado.", contexto.descargarDocumento());
    }

    @Test
    void mismoContextoCambiaComportamientoAlCambiarEstado() {
        CertificadoContext contexto = new CertificadoContext();
        assertTrue(contexto.descargarDocumento().startsWith("Descarga no disponible"));
        contexto.setEstadoCertificado(new EnTramite());
        assertTrue(contexto.descargarDocumento().contains("provisional"));
        contexto.setEstadoCertificado(new Firmado());
        assertTrue(contexto.descargarDocumento().contains("final firmado"));
    }

    @Test
    void delegaCadaOperacionEnElEstado() {
        int[] llamadas = {0, 0, 0};
        CertificadoContext contexto = new CertificadoContext();
        contexto.setEstadoCertificado(new CertificadoState() {
            @Override
            public String visualizarDocumento() { llamadas[0]++; return "vista"; }
            @Override
            public String generarDocumento() { llamadas[1]++; return "generado"; }
            @Override
            public String descargarDocumento() { llamadas[2]++; return "descarga"; }
        });
        assertEquals("generado", contexto.crearCertificado());
        assertEquals("vista", contexto.visualizarDocumento());
        assertEquals("descarga", contexto.descargarDocumento());
        assertArrayEquals(new int[]{1, 1, 1}, llamadas);
    }

    @Test
    void rechazaEstadoNuloSinPerderElAnterior() {
        CertificadoContext contexto = new CertificadoContext();
        contexto.setEstadoCertificado(new Firmado());
        assertThrows(NullPointerException.class, () -> contexto.setEstadoCertificado(null));
        assertEquals("Descargando documento final firmado.", contexto.descargarDocumento());
    }

    @Test
    void operacionesNoProvocanTransicionesImplicitas() {
        CertificadoContext contexto = new CertificadoContext();
        contexto.crearCertificado();
        contexto.crearCertificado();
        assertEquals("Visualizacion no disponible: el certificado esta iniciado.",
                contexto.visualizarDocumento());
        contexto.setEstadoCertificado(new EnTramite());
        contexto.crearCertificado();
        contexto.descargarDocumento();
        assertEquals("Visualizando documento con marca de agua.", contexto.visualizarDocumento());
    }
}
