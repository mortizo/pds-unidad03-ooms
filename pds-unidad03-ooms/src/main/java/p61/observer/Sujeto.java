/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p61.observer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mauricio Ortiz Ochoa
 */
public abstract class Sujeto {
    private List<PagoFactura> pagoFacturaList = new ArrayList<PagoFactura>();
    
    public abstract void attach(PagoFactura pagoFactura);
    
    public abstract void detach(PagoFactura pagoFactura);
    
    public abstract void notificar();


    public List<PagoFactura> getPagoFacturaList() {
        return pagoFacturaList;
    }

    public void setPagoFacturaList(List<PagoFactura> pagoFacturaList) {
        this.pagoFacturaList = pagoFacturaList;
    }
    
    
    
}
