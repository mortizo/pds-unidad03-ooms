/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package p61;


import p61.observer.Contabilidad;
import p61.observer.Factura;
import p61.observer.ServicioCliente;
import p61.state.CertificadoContext;
import p61.state.Iniciado;
import p61.strategy.ContextoMatricula;
import p61.strategy.NivelCarrera;
import p61.template.Fijo;

/**
 *
 * @author Mauricio Ortiz Ochoa
 */
public class PdsUnidad03Ooms {

    public static void main(String[] args) {
        //template();
        //state();
        strategy();
        //observer();
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
    
    public static void observer() {
        System.out.println("Observer");

        var factura1= new Factura();
        var servicioCliente1 = new ServicioCliente();
        var servicioCliente2 = new ServicioCliente();
        var contabilidad1 = new Contabilidad();
        
        factura1.attach(servicioCliente1);
        factura1.attach(servicioCliente2);
        factura1.attach(contabilidad1);
        
        factura1.setFacturaPagada(true);
        factura1.notificar();
        System.out.println("servicioCliente1 = " + servicioCliente1.toString());
        System.out.println("servicioCliente2 = " + servicioCliente2.toString());
        System.out.println("contabilidad1 = " + contabilidad1);

    }
    
    public static void strategy() {
        var contextoMatricula = new ContextoMatricula();
        System.out.println("contextoMatricula = " + contextoMatricula.ejecutarEstrategia(NivelCarrera.GRADO));
    }

}
