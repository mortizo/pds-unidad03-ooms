/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p61.strategy;

/**
 *
 * @author morti
 */
public class MatriculaGrado implements MatriculaStrategy{

    @Override
    public String calcularDescuentoProntoPago() {
        return "Descuento de pronto pago es del 10% del valor total de la cuota,"
                + " independientemente del número de cuotas pagadas.";
    }
    
}
