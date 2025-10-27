package p2;

public class Cocinero implements Runnable {
    private Pedido p;

    public Cocinero(Pedido p) {
        this.p = p;
    }

    @Override
    public void run() {
        while (true) {
            
            System.out.println("Cocinero: Esperando Cliente");
            p.esperaClienteCocinero();

            System.out.println("Cocinero: Le sirvo al cliente la comida");
            try {
                Thread.sleep(4000);
            } catch (Exception e) {
                // TODO: handle exception
            }
            p.liberarAtencionCocinero();
            System.out.println("Cocinero: Termine de atender");
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
}
