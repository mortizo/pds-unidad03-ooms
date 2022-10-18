/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p61.observer;

/**
 *
 * @author Mauricio Ortiz Ochoa
 */
public class ServicioCliente implements PagoFactura{

    private boolean seguimientoIniciado;
    
    @Override
    public void updatePago(boolean estadoPago) {
        this.seguimientoIniciado=estadoPago;
    }

    @Override
    public String toString() {
        return "ServicioCliente{" + "seguimientoIniciado=" + seguimientoIniciado + '}';
    }
    
    
    
}
