/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package p61.state;

/**
 *
 * @author morti
 */
public interface CertificadoState {
   
    void cambiarEstado();
    
    String visualizarDocumento();

    String generarDocumento();

    String descargarDocumento();

}
