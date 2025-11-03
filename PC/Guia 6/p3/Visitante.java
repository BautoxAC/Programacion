public class Visitante implements Runnable {
    private Sala sala;
    public Visitante(Sala sala){
        this.sala = sala;
    }

    @Override
    public void run() {
        sala.entrarVisitante();
        System.out.println("Entro visitante");
        try {
            Thread.sleep(4000);
        } catch (Exception e) {
            // TODO: handle exception
        }
        System.out.println("Sale visitante");
        sala.salirVisitante();
    }
}
