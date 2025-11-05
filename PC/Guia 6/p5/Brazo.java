public class Brazo implements Runnable {
    private Mesa mesa;

    public Brazo(Mesa mesa) {
        this.mesa = mesa;
    }

    @Override
    public void run() {
        while (true) {
            mesa.retirarCaja();
            System.out.println("Reponiendo la caja");
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                // TODO: handle exception
            }
            System.out.println("Caja repuesta");
            mesa.reponerCaja();

        }
    }

}
