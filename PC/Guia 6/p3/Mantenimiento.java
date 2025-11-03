public class Mantenimiento implements Runnable {
    private Sala sala;

    public Mantenimiento(Sala sala) {
        this.sala = sala;
    }

    @Override
    public void run() {
        sala.entrarMantenimiento();
        System.out.println(" Entro mantenimiento");

        try {
            Thread.sleep(4000);
        } catch (Exception e) {
            // TODO: handle exception
        }
        System.out.println("Sale Mantenimiento");
        sala.salirMantenimiento();
    }

}
