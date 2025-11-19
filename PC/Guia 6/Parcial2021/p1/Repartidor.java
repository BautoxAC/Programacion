

public class Repartidor implements Runnable {
     private Restaurante restaurante;
    Repartidor(Restaurante restaurante){
        this.restaurante = restaurante;
    }
    @Override
    public void run() {
        while (true) {
            try {
                restaurante.empezarReparto();
                System.out.println("Repartiendo Pedido");
                Thread.sleep(3000);
                System.out.println("Termine de repartir");
                boolean deacanso =restaurante.terminarReparto();
                if (deacanso) {
                    System.out.println("Descansando");
                    Thread.sleep(4000);
                }

            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
}
