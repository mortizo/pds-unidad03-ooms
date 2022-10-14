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

    @Override
    public String visualizarDocumento() {
        return this.generarDocumento()+"\n"+"Certificado se puede visualizar con marca de agua...";
    }

    @Override
    public String generarDocumento() {
        return "Certificado generado dinámicamente a la fecha actual..."; 
    }

    @Override
    public String descargarDocumento() {
        
        return this.generarDocumento()+"\n"+" El certificado se puede descargar con marca de agua";    
    }
    
}
