public class Mostrador {
    private Cola pasteles;
    private int contador;

    public Mostrador() {
        
        pasteles = new Cola();
        contador = 0;
    }

    public synchronized void crearPastel(int peso) {
        try {
            while (!pasteles.poner(peso)) {
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
            while (contador == 0) {
                wait();
            }
            peso = (int)pasteles.obtenerFrente();
            pasteles.sacar();
            notify();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return peso;
    }
}
