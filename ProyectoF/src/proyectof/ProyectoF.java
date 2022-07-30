
package proyectof;
import java.util.Scanner;
public class ProyectoF {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        CajaRegistradora caja = new CajaRegistradora();
        
        System.out.println ("BIENVENIDOS A LA POLLERIA LOS CARRYS");
        System.out.println("¿Cual es su nombre?");
        caja.setNombreCliente(s.nextLine());
        System.out.println("¿Eres nuevo cliente?([1]si / [2]no)");
        int valor=s.nextInt();
        caja.descCliente(valor);
        
        
        int resp;
        do {            
            System.out.println("¿Que plato desea ordenar?");
            caja.menuPlato();
            System.out.println("Ingrese el plato (Solo numeros 1 al 6):");
            caja.agregarPlato(s.nextInt());
            caja.AcumulaPlato();
            System.out.println("¿Desea agregar algun otro plato?([1]si / [2]no)");
            resp = s.nextInt();
        } while (resp==1);
        
        System.out.println("¿Desea una bebida?([1]si / [2]no)");
        resp = s.nextInt();
        if(resp == 1){
            while(resp == 1){
                System.out.println("¿Que bebida desea ordenar?");
                caja.menuBebida();
                System.out.println("Ingrese el plato (Solo numeros 1 al 5):");
                caja.agregarBebida(s.nextInt());
                caja.AcumulaBebida();
                System.out.println("¿Desea agregar algun otra bebida?([1]si / [2]no)");
                resp = s.nextInt();
            }
        }else if(resp == 2){
            caja.setPedidoBebida("Sin bebida");
            caja.setImporteBebida(0.00);
        }
        
        System.out.println("------------------------------------");
        System.out.println("Su pedido:");
        caja.vistaPrevia();
        System.out.println("¿Que desea hacer?");
        System.out.println("[1]Quitar   [2]Continuar");
        resp = s.nextInt();
        while(resp == 1){
            if(resp == 1){
                System.out.println("¿Que desea quitar?");
                caja.vistaPrevia();
                System.out.println("Digite el numero de la posicion:");
                caja.listaQuitar(s.nextInt());
                System.out.println("----------------------------");
                System.out.println("Su pedido:");
                caja.vistaPrevia();
                System.out.println("Que desea hacer:");
                System.out.println("[1]Quitar   [2]Continuar");
                resp = s.nextInt();
            }
        }
        double montoAc = 0;
        montoAc = caja.getAcumulaPlato() + caja.getAcumulaBebida() - caja.getRetiroImporte();
        
        if(montoAc >= 70){
            caja.obsequio();
            caja.escogerObs(s.nextInt());
        }else{
            System.out.println("No accede a obsequio");
        }
        System.out.println("------------------");
        System.out.println("PROCESANDO BOLETA.....");
        try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
         
            }
        System.out.println("####################################");
        caja.Boleta();
        System.out.println("Gracias por su compra Señor(a) " + caja.getNombreCliente());      
    }
}
    

