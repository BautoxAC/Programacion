public class Visitante implements Runnable {
    private Sala sala;
    public Visitante(Sala sala){
        this.sala = sala;
    }

    @Override
    public void run() {
        sala.entrarVisitante();
        try {
            Thread.sleep(4000);
        } catch (Exception e) {
            // TODO: handle exception
        }
        sala.salirVisitante();
    }
}
