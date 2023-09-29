/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p61.state;

/**
 *
 * @author morti
 */
public class Iniciado implements CertificadoState{
    
    private CertificadoContext certificado;

    public Iniciado(CertificadoContext certificado) {
        this.certificado = certificado;
    }

    @Override
    public String visualizarDocumento() {
        return "1. El certificado no se puede visualizar...";
    }

    @Override
    public String generarDocumento() {
        return "1. Certificado generado dinámicamente a la fecha actual...";    
    }

    @Override
    public String descargarDocumento() {
        return "1. El certificado no se puede descargar...";    
    }

    @Override
    public void cambiarEstado() {
        this.certificado.setEstadoCertificado(new EnTramite(this.certificado));
    }
    
}
