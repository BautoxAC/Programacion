public class Mostrador {
    private Cola cintaMostrador;
    private int contador;

    public Mostrador() {

        cintaMostrador = new Cola();
        contador = 0;
    }

    public synchronized void crearPastel(int peso) {
        try {
            while (!cintaMostrador.poner(peso)) {
                wait();
            }
            notify();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public synchronized int tomarPastel() {
        int peso = 0;
        try {
            while (cintaMostrador.esVacia()) {
                wait();
            }
            peso = (int) cintaMostrador.obtenerFrente();
            cintaMostrador.sacar();
            notify();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return peso;
    }
}
