/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p61.observer;

/**
 *
 * @author Mauricio Ortiz Ochoa
 */
public class Factura extends Sujeto {
    
    private boolean facturaPagada;

    @Override
       public void attach(PagoFactura pagoFactura){
        this.getPagoFacturaList().add(pagoFactura);
    }
    
    @Override
    public void detach(PagoFactura pagoFactura){
        this.getPagoFacturaList().remove(pagoFactura);
    }

    @Override
    public void notificar() {
        for (var pagoFactura : this.getPagoFacturaList()) {
            if (pagoFactura instanceof ServicioCliente) {
                pagoFactura.updatePago(this.facturaPagada);
            }
        }
    }

    public boolean isFacturaPagada() {
        return facturaPagada;
    }

    public void setFacturaPagada(boolean facturaPagada) {
        this.facturaPagada = facturaPagada;
    }

   
    
    
    
}
