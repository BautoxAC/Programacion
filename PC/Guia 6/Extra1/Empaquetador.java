package Extra1;

public class Empaquetador implements Runnable {
    private Mesa mesa;
    private Almacen almacen;

    public Empaquetador(Mesa mesa, Almacen almacen) {
        this.mesa = mesa;
        this.almacen = almacen;
    }

    @Override
    public void run() {
        while (true) {
            mesa.esperaSacarCaja();
            System.out.println("cambiando la caja");
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                // TODO: handle exception
            }
            System.out.println("Caja cambiada");
            char tipoCaja = mesa.cambiarCaja();
            System.out.println("Poniendo caja");
            almacen.ponerCaja(tipoCaja);
        }
    }

}
