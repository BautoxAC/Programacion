
public class Main {
    public static void main(String[] args) {
        ControlTren c = new ControlTren();
        VendedorTickets v = new VendedorTickets();
        Thread[] hilos = new Thread[12];
        Pasajero[] p = new Pasajero[12];
        Thread ht = new Thread(t);
        for (int i = 0; i < hilos.length; i++) {
            p[i] = new Pasajero(c);
            hilos[i] = new Thread( p[i]);
        }
        for (int i = 0; i < p.length; i++) {
            hilos[i].start();
        }
        ht.start();
    }
}

