public class Investigador implements Runnable {
    private Sala sala;

    public Investigador(Sala sala) {
        this.sala = sala;
    }

    @Override
    public void run() {
        sala.entrarInvestigador();
        System.out.println(" Entro investigador-------------------------------");

        try {
            Thread.sleep(4000);
        } catch (Exception e) {
            // TODO: handle exception
        }
        System.out.println("Sale investigador");
        sala.salirInvestigador();
    }

}
