
package proyectof;
import java.util.*;

public class CajaRegistradora {
    private String NombreCliente;
    private Double decuentoCliente;
    private Double CuentaCliente;
    private String PedidoPlato;
    private String PedidoBebida;
    private Double ImportePlato;
    private Double ImporteBebida;
    private static double retiroImporte = 0;
    private static double acumulaPlato = 0;
    private static double acumulaBebida = 0;
    private final List<String> pedidos = new ArrayList<>();
    private final List<Double> saldos = new ArrayList<>();
    
    
    public CajaRegistradora() {
    }

    public void setNombreCliente(String NombreCliente) {
        this.NombreCliente = NombreCliente;
    }

    public String getNombreCliente() {
        return NombreCliente;
    }
    
    public void setPedidoBebida(String PedidoBebida) {
        this.PedidoBebida = PedidoBebida;
    }

    public void setImporteBebida(Double ImporteBebida) {
        this.ImporteBebida = ImporteBebida;
    }
    
    public List<String> getPedidos() {
        return pedidos;
    }

    public List<Double> getSaldos() {
        return saldos;
    }

    public static double getAcumulaPlato() {
        return acumulaPlato;
    }

    public static double getAcumulaBebida() {
        return acumulaBebida;
    }

    public static double getRetiroImporte() {
        return retiroImporte;
    }
    
    public void descCliente(int resp){
            if(resp == 1){
             System.out.println("!Tiene un descuento del 5% por ser nuevo cliente de nuestra pollería!");
             this.decuentoCliente = 0.05;
            }else if(resp == 2){
             System.out.println("Prosiga con su orden señor(a)");
             this.decuentoCliente = 0.00;
            }
     }
    
    public void menuPlato(){
        System.out.println("Los platos principales son los siguentes:");
        System.out.println("[1] 1 Pollo entero + papas y ensalada......S/.50");
        System.out.println("[2] 1/2 Pollo + papas y ensalada...........S/.30");
        System.out.println("[3] 1/4 Pollo + papas......................S/.18");
        System.out.println("[4] 1/8 Pollo + 1/4 de papas...............S/.10");
        System.out.println("[5] Chaufa.................................S/.12");
        System.out.println("[6] Aeropuerto.............................S/.15");
    }
    public void menuBebida(){
        System.out.println("De bebida tenemos:");
        System.out.println("[1] InkaCola 1Lt............S/.4.50");
        System.out.println("[2] CocaCola 1Lt............S/.5.00");
        System.out.println("[3] Jarra Chicha morada.....S/.4.00");
        System.out.println("[4] Jarra Limonada..........S/.3.50");
        System.out.println("[5] Jarra Maracúya..........S/.3.50");
    }
    public void obsequio(){ 
        System.out.println("Felicidades! " + this.NombreCliente + " ha obtenido un obsequio");
        System.out.println("Lista de obsequios: ");
        System.out.println("[1] Un peluche");
        System.out.println("[2] Un carrito HotWheels");
        System.out.println("[3] Una reloj pulsera");
        System.out.println("[4] Una entrada para el cine");
        System.out.println("[5] Un cupon de descuento para su proxima compra");
        System.out.println("Seleccione un obsequio (1-5):");
    }
    
    public void escogerObs(int respObs){
        switch(respObs){
                case 1: System.out.println("Su obsequio es un peluche");break;
                case 2: System.out.println("Su obsequio es un carrito HotWheels");break;
                case 3: System.out.println("Su obsequio es un reloj pulsera");break;
                case 4: System.out.println("Su obsequio es una entrada para el cine");break;
                case 5: System.out.println("Su obsequio es un cupon de descuento para su proxima compra");break;
        }
        System.out.println("Podra canjear su obsequio al presentar su boleta en caja.");
    }
    
    public void listas(String pedido,Double saldo){
        this.pedidos.add(pedido);
        this.saldos.add(saldo);   
    }
    
    public void listaQuitar(int i){
        this.pedidos.remove(i);
        this.retiroImporte += this.getSaldos().get(i);
        this.saldos.remove(i);
    }
    
    public void vistaPrevia(){
        System.out.println("Esta ordenando:");
        for (int i = 0; i < this.pedidos.size(); i++) {
            System.out.println("Posicion ["+ i +"]: " + this.getPedidos().get(i));       
        }
    }
    
    public void agregarPlato(int opcionPlato){
        switch (opcionPlato) {
            case 1 : System.out.println("Bien, has elegido 1 Pollo entero + papas y ensalada");
                     this.ImportePlato = 50.00;
                     this.PedidoPlato = "1 Pollo entero + papas y ensalada";
            break;
            case 2 : System.out.println("Bien, has elegido 1/2 Pollo + papas y ensalada");
                     this.ImportePlato = 30.00;
                     this.PedidoPlato = "1/2 Pollo + papas y ensalada";
            break;
            case 3 : System.out.println("Bien, has elegido 1/4 Pollo + papas");
                     this.ImportePlato = 18.00;
                     this.PedidoPlato = "1/4 Pollo + papas";
            break;     
            case 4 : System.out.println("Bien, has elegido 1/8 Pollo + 1/4 de papas");
                     this.ImportePlato = 10.00;
                     this.PedidoPlato = "1/8 Pollo + 1/4 de papas";
            break;
            case 5 : System.out.println("Bien, has elegido Chaufa");
                     this.ImportePlato = 12.00;
                     this.PedidoPlato = "Chaufa";
            break;
            case 6 : System.out.println("Bien, has elegido Aeropuerto");
                     this.ImportePlato = 15.00;
                     this.PedidoPlato = "Aeropuerto";
            break;
            default:
                this.ImportePlato = 0.00;
        }
        this.listas(this.PedidoPlato, this.ImportePlato);
    }
    
    public void agregarBebida(int opcionBebida){
        switch  (opcionBebida) {
            case 1: System.out.println("Bien, has elegido InkaCola 1Lt");
                    this.ImporteBebida = 4.50;
                    this.PedidoBebida = "InkaCola 1Lt";
            break; 
            case 2: System.out.println("Bien, has elegido CocaCola 1Lt");
                    this.ImporteBebida = 5.00;
                    this.PedidoBebida = "CocaCola 1Lt";
            break; 
            case 3: System.out.println("Bien, has elegido Jarra Chicha morada");
                    this.ImporteBebida = 4.00;
                    this.PedidoBebida = "Jarra Chicha morada";
            break; 
            case 4: System.out.println("Bien, has elegido Jarra Limonada");
                    this.ImporteBebida = 3.50;
                    this.PedidoBebida = "Jarra Limonada";
            break; 
            case 5: System.out.println("Bien, has elegido Jarra Maracúya");
                    this.ImporteBebida = 3.50;
                    this.PedidoBebida = "Jarra Maracúya";
            break;
            default:
                this.ImporteBebida = 0.00;            
        }
        this.listas(this.PedidoBebida, this.ImporteBebida);
    }
    
    public void AcumulaPlato(){
        CajaRegistradora.acumulaPlato += this.ImportePlato;   
    }
    
    public void AcumulaBebida(){
        CajaRegistradora.acumulaBebida += this.ImporteBebida;
    }
    
    public void Boleta(){
        double IGV;
        double importeSuma = CajaRegistradora.acumulaBebida + CajaRegistradora.acumulaPlato - this.retiroImporte;
        double descuento = importeSuma*this.decuentoCliente;
        double descuentoRed = Math.round(descuento*100.0)/100.0;
        double nuevoImporte = importeSuma - descuento;
        double nuevoImporteRed = Math.round(nuevoImporte*100.0)/100.0;
        IGV = (nuevoImporte)*0.18;
        double IGVRed = Math.round(IGV*100.0)/100.0;
        this.CuentaCliente = nuevoImporteRed + IGVRed;
        
        System.out.println("======POLLERIA LOS CARRYS======");
        System.out.println("Nombre cliente: " + this.NombreCliente);
        System.out.println("Pedido: ");
        System.out.println("Cantidad de pedidos ----------------" + this.pedidos.size());
        for (int i = 0; i < this.pedidos.size(); i++) {
            System.out.println("*"+this.getPedidos().get(i) + " --------- " + "S/."+ this.getSaldos().get(i));
        }
        System.out.println("..................................");
        System.out.println("Sub Total: S/." + importeSuma);
        System.out.println("Desc: S/." + descuentoRed);
        System.out.println("Igv : S/." + IGVRed);
        System.out.println("Importe Total: S/." + this.CuentaCliente);
    }
}
