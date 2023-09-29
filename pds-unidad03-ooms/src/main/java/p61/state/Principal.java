/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p61.state;

/**
 *
 * @author UPS
 */
public class Principal {
    public static void main(String[] args) {
        var certificado = new CertificadoContext();
        System.out.println(certificado.getEstadoCertificado().descargarDocumento());
        System.out.println(certificado.getEstadoCertificado().generarDocumento());
        System.out.println(certificado.getEstadoCertificado().visualizarDocumento());
        certificado.getEstadoCertificado().cambiarEstado();
        System.out.println(certificado.getEstadoCertificado().descargarDocumento());
        System.out.println(certificado.getEstadoCertificado().generarDocumento());
        System.out.println(certificado.getEstadoCertificado().visualizarDocumento());        
        certificado.getEstadoCertificado().cambiarEstado();
        System.out.println(certificado.getEstadoCertificado().descargarDocumento());
        System.out.println(certificado.getEstadoCertificado().generarDocumento());
        System.out.println(certificado.getEstadoCertificado().visualizarDocumento());
        certificado.getEstadoCertificado().cambiarEstado();
        System.out.println(certificado.getEstadoCertificado().descargarDocumento());
        System.out.println(certificado.getEstadoCertificado().generarDocumento());
        System.out.println(certificado.getEstadoCertificado().visualizarDocumento());
        
        
    }
}
