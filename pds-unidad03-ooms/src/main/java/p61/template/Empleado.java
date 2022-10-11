/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p61.template;

/**
 *
 * @author Mauricio Ortiz Ochoa
 */
public abstract class Empleado {

    private int horasTrabajadas;

    public double calcularSueldo() {
        return this.calcularBasico()+this.calcularExtra()-this.calcularDescuento();
    }

    public abstract double calcularBasico();

    public abstract double calcularExtra();

    public abstract double calcularDescuento();

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(int horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

}
