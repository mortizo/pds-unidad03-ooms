/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p61.observer;

/**
 *
 * @author Mauricio Ortiz Ochoa
 */
public class Contabilidad implements PagoFactura{

    private boolean pagoMayorizado;
    
    
    @Override
    public void updatePago(boolean estadoPago) {
        this.pagoMayorizado=estadoPago;
    }

    @Override
    public String toString() {
        return "Contabilidad{" + "pagoMayorizado=" + pagoMayorizado + '}';
    }
    
    
    
    
}
