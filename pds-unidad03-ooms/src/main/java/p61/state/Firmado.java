/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p61.state;

/**
 *
 * @author morti
 */
public class Firmado implements CertificadoState{

    @Override
    public String visualizarDocumento() {
        return this.generarDocumento()+"\n"+"Certificado se puede visualizar";
    }

    @Override
    public String generarDocumento() {
        return "Certificado generado y firmado no se puede modificar";    
    }

    @Override
    public String descargarDocumento() {
        
        return this.generarDocumento()+"\n"+" El certificado se puede descargar";    
    }
    
}
