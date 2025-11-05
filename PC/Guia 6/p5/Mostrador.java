public class Mostrador {
    private int[] pasteles;
    private int contador;

    public Mostrador() {
        pasteles = new int[20];
        contador = 0;
    }

    public synchronized void crearPastel(int peso) {
        try {
            while (contador == pasteles.length) {
                wait();
            }
            contador++;
            pasteles[pasteles.length-contador] = peso;
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
            peso = pasteles[contador];
            contador--;
            notify();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return peso;
    }
}
