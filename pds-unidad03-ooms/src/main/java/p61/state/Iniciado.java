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

    @Override
    public String visualizarDocumento() {
        return "El certificado no se puede visualizar...";
    }

    @Override
    public String generarDocumento() {
        return "Certificado generado dinámicamente a la fecha actual...";    
    }

    @Override
    public String descargarDocumento() {
        return "El certificado no se puede descargar...";    
    }
    
}
