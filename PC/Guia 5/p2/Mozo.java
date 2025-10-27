package p2;

public class Mozo implements Runnable {

    private Pedido p;

    public Mozo(Pedido p) {
        this.p = p;
    }

    @Override
    public void run() {
        while (true) {
            
            System.out.println("Mozo: Esperando Cliente");
            p.esperaClienteMozo();

            System.out.println("Mozo: Le sirvo al cliente la bebida");
            try {
                Thread.sleep(4000);
            } catch (Exception e) {
                // TODO: handle exception
            }
            p.liberarAtencionMozo();
            System.out.println("Mozo: Termine de atender");
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }

}
