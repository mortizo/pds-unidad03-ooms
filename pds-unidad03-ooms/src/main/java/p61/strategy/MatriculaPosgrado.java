/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p61.strategy;

/**
 *
 * @author Mauricio Ortiz Ochoa
 */
public class MatriculaPosgrado  implements MatriculaStrategy{

    @Override
    public String calcularDescuentoProntoPago() {
        return "Descuento de pronto pago es del 15% si se realizan al menos 3 cuotas. "
                + "Pero si es 1 o 2 cuotas no existe descuento de pronto pago."; 
    }
    
}
