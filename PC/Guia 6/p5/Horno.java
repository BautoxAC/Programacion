public class Horno implements Runnable {
    private Mostrador mostrador;
    private int peso;

    public Horno(Mostrador mostrador, int peso) {
        this.mostrador = mostrador;
        this.peso = peso;
    }

    @Override
    public void run() {
        while (true) {
            mostrador.crearPastel(peso);
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }

}