package p2;

public class ControlFerry implements Runnable {
    private Ferry ferry;

    public ControlFerry(Ferry ferry) {
        this.ferry = ferry;
    }

    public void run() {
        while (true) {
            ferry.arrancaFerryDespues(3000);
            ferry.esperaFerryArranque();
            System.out.println("Arranca el recorrido del ferry");
            try {
                Thread.sleep(5000);
            } catch (Exception e) {
                // TODO: handle exception
            }
            System.out.println("Finaliza el recorrido");
            ferry.terminoElRecorrido();
        }

    }
}
