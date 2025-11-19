package Extra1;

public class Camion implements Runnable{
    private Almacen almacen;

    public Camion( Almacen almacen) {
        this.almacen = almacen;
    }

    @Override
    public void run() {
        while (true) {
            almacen.sacarCajas();

            System.out.println("Saliendo camion---------------------------");
            try {
                Thread.sleep(3000);
                
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
}
