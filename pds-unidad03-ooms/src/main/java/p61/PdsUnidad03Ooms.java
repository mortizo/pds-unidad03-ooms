/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package p61;


import p61.state.CertificadoContext;
import p61.state.Iniciado;
import p61.template.Fijo;

/**
 *
 * @author Mauricio Ortiz Ochoa
 */
public class PdsUnidad03Ooms {

    public static void main(String[] args) {
        template();
        state();
    }

    public static void template() {
        System.out.println("Template");

        var fijo = new Fijo();
        fijo.setHorasTrabajadas(160);
        System.out.println(fijo.calcularSueldo());

    }

    public static void state() {
        System.out.println("State");

        var certificadoContext= new CertificadoContext(new Iniciado());
        certificadoContext.crearCertificado();

    }

}
