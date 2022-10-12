/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p61.state;

/**
 *
 * @author Mauricio Ortiz Ochoa
 */
public class PagoTotal implements MatriculaState{

    @Override
    public String validar() {
        return "Puede acceder a los ambientes virtuales, solicitudes En Línea y "
                + "se le puede registrar calificaciones";
    }
    
}
