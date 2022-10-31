/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p61.template;

/**
 *
 * @author morti
 */
public class Temporal extends Empleado{

    @Override
    public double calcularBasico() {
        return this.getHorasTrabajadas()*12;
    }

    @Override
    public double calcularExtra() {
        return 0;
    }

    @Override
    public double calcularDescuento() {
        return 0;
    }
    
}
