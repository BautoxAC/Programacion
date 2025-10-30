public class SillaRuedas implements Runnable{
    private Sala sala;
    public SillaRuedas(Sala sala){
        this.sala = sala;
    }

    @Override
    public void run() {
        sala.entrarSillaRueda();
        System.out.println( " Entro silla de ruedas");
        try {
            Thread.sleep(4000);
        } catch (Exception e) {
            // TODO: handle exception
        }
        sala.salirSalirSillaRuedas();
    }
}
