/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p61.state;

/**
 *
 * @author Mauricio Ortiz Ochoa
 */
public class PagoPendiente implements MatriculaState{

    @Override
    public String validar() {
        return "Solamente pude acceder a los ambientes virtuales...";
    }
    
}
