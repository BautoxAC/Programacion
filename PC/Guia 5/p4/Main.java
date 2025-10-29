
public class Main {
    public static void main(String[] args) {
        Tren tren = new Tren();
        ControlTren c = new ControlTren(tren);
        VendedorTickets v = new VendedorTickets(tren);
        Thread[] hilos = new Thread[45];
        Pasajero[] p = new Pasajero[45];
        Thread hv = new Thread(v);
        Thread hc = new Thread(c);
        for (int i = 0; i < hilos.length; i++) {
            p[i] = new Pasajero(tren);
            hilos[i] = new Thread( p[i]);
        }
        for (int i = 0; i < p.length; i++) {
            hilos[i].start();
        }
        hv.start();
        hc.start();
    }
}

