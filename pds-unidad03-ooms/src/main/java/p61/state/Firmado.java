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
    
    private CertificadoContext certificado;

    public Firmado(CertificadoContext certificado) {
        this.certificado = certificado;
    }
    
    

    @Override
    public String visualizarDocumento() {
        return " 3. Certificado se puede visualizar";
    }

    @Override
    public String generarDocumento() {
        return "3. Certificado generado y firmado no se puede modificar";    
    }

    @Override
    public String descargarDocumento() {
        
        return "3. El certificado se puede descargar";    
    }

   @Override
    public void cambiarEstado() {
        this.certificado.setEstadoCertificado(this);
    }
    
}
