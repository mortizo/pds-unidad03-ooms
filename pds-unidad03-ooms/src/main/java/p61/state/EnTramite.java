/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p61.state;

/**
 *
 * @author morti
 */
public class EnTramite implements CertificadoState{
    
    private CertificadoContext certificado;

    public EnTramite(CertificadoContext certificado) {
        this.certificado = certificado;
    }
    
    

    @Override
    public String visualizarDocumento() {
        return " 2. Certificado se puede visualizar con marca de agua...";
    }

    @Override
    public String generarDocumento() {
        return " 2. Certificado generado dinámicamente a la fecha actual..."; 
    }

    @Override
    public String descargarDocumento() {
        
        return " 2. El certificado se puede descargar con marca de agua";    
    }

    @Override
    public void cambiarEstado() {
        this.certificado.setEstadoCertificado(new Firmado(this.certificado));
    }
    
}
