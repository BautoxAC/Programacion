public class Empaquetador implements Runnable {
    private Mostrador mostrador;
    private Mesa mesa;

    public Empaquetador(Mesa mesa, Mostrador mostrador) {
        this.mesa = mesa;
        this.mostrador = mostrador;
    }

    @Override
    public void run() {
        int pesoPastel = 0;
        while (true) {
            System.out.println("Empaquetador trata de toma un pastel");
            pesoPastel = mostrador.tomarPastel();
            System.out.println("Empaquetador toma un pastel");
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                // TODO: handle exception
            }
            System.out.println("Trata de soltar un pastel: " + pesoPastel);
            mesa.soltarPastel(pesoPastel);
            System.out.println("Suelta un pastel: " + pesoPastel);
        }
    }

}
