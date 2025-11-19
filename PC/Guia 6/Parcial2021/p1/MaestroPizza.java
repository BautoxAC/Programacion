

public class MaestroPizza implements Runnable{
    private Restaurante restaurante;
    MaestroPizza(Restaurante restaurante){
        this.restaurante = restaurante;
    }
    @Override
    public void run() {
        while (true) {
            try {
                restaurante.empezarPedido();
                System.out.println("Haciendo pedido");
                Thread.sleep(3000);
                restaurante.terminarPedido();
                System.out.println("Termine de hacer pedido");


            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
    
}
