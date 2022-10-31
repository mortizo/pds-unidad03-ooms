/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p61.strategy;

/**
 *
 * @author Mauricio Ortiz Ochoa
 */
public class ContextoMatricula {
    
    public String ejecutarEstrategia(NivelCarrera nivelCarrera){
        var retorno="";
        switch (nivelCarrera) {
            case GRADO:
                var matriculaGrado = new MatriculaGrado();
                retorno=matriculaGrado.calcularDescuentoProntoPago();
                break;
            case POSGRADO:
                var matriculaPosgrado = new MatriculaPosgrado();
                retorno=matriculaPosgrado.calcularDescuentoProntoPago();
                break;
                
            default:
                throw new AssertionError();
        }
        
        return retorno;
    }
    
}
