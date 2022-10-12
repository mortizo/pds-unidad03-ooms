/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p61.state;

/**
 *
 * @author Mauricio Ortiz Ochoa
 */
public class MatriculaContext {
    
    private MatriculaState currentState;

    public MatriculaState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(MatriculaState currentState) {
        this.currentState = currentState;
    }

    public MatriculaContext(MatriculaState currentState) {
        this.currentState = currentState;
    }
    
}
